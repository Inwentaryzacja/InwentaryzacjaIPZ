package Zut_IPZ.Inwentaryzacja.sign_up;

import Zut_IPZ.Inwentaryzacja.email.EmailService;
import Zut_IPZ.Inwentaryzacja.error.exception.UserAlreadyExistsException;
import Zut_IPZ.Inwentaryzacja.password.PasswordDTO;
import Zut_IPZ.Inwentaryzacja.password.PasswordEncodingService;
import Zut_IPZ.Inwentaryzacja.role.Role;
import Zut_IPZ.Inwentaryzacja.token.VerificationToken;
import Zut_IPZ.Inwentaryzacja.token.VerificationTokenService;
import Zut_IPZ.Inwentaryzacja.user.User;
import Zut_IPZ.Inwentaryzacja.user.UserDTO;
import Zut_IPZ.Inwentaryzacja.user.UserService;
import jakarta.mail.MessagingException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class SignUpService {
    private final VerificationTokenService verificationTokenService;
    private final UserService userService;
    private final EmailService emailService;
    private final PasswordEncodingService passwordEncodingService;
    public void signUpUser(UserDTO userDTO) throws MessagingException {
        String login = userDTO.getLogin();
        PasswordDTO passwordDTO = userDTO.getPasswordDTO();
        String email = userDTO.getEmail();
        if (userService.existsByEmail(email)) {
            throw new UserAlreadyExistsException("a user with such email already exists");
        }
        if (userService.existsByLogin(login)) {
            throw new UserAlreadyExistsException("a user with such login already exists");
        }
        String encodePassword = passwordEncodingService.encodePassword(passwordDTO.getPassword());
        User user = new User(login, encodePassword, email, 0);
        userService.saveUser(user, Role.Name.USER);
        VerificationToken token = verificationTokenService.generateVerificationToken(user);
        verificationTokenService.saveVerificationToken(token);
        emailService.sendActivationEmail("InwentaryzacjIPZ", email, "account verification", token.getToken());


    }

    public void confirmToken(String token) {
        Optional<VerificationToken> tokenOptional = verificationTokenService.getToken(token);
        if (tokenOptional.isEmpty()) {
            throw new IllegalStateException("token not found");

        }
        VerificationToken verificationToken = tokenOptional.get();
        if(verificationTokenService.isTokenExpired(verificationToken)) {
            throw new IllegalStateException("token is expired");

        }
        verificationToken.setConfirmedAt(LocalDateTime.now());
        User user = verificationToken.getUser();
        user.setVerified(1);
        userService.updateUser(user.getId(), user);
    }
}
