package Zut_IPZ.Inwentaryzacja.sign_up;

import Zut_IPZ.Inwentaryzacja.email.EmailService;
import Zut_IPZ.Inwentaryzacja.password.PasswordDTO;
import Zut_IPZ.Inwentaryzacja.password.PasswordEncodingService;
import Zut_IPZ.Inwentaryzacja.role.Role;
import Zut_IPZ.Inwentaryzacja.token.VerificationToken;
import Zut_IPZ.Inwentaryzacja.token.VerificationTokenService;
import Zut_IPZ.Inwentaryzacja.user.UserDTO;
import Zut_IPZ.Inwentaryzacja.user.UserService;
import jakarta.mail.MessagingException;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class SignUpServiceTest {

    @Mock
    private VerificationTokenService verificationTokenService;
    @Mock
    private UserService userService;
    @Mock
    private EmailService emailService;
    @Mock
    private PasswordEncodingService passwordEncodingService;
    @InjectMocks
    private SignUpService underTest;

    @Nested
    class WhenSigningUpUser {

        @BeforeEach
        void setup() {
        }
        @Test
        void correctUserDTO_SignUpUser() throws MessagingException {
            String email = "correct-email@wp.pl";
            VerificationToken token = new VerificationToken();
            PasswordDTO passwordDTO = new PasswordDTO("Correct-password8", "Correct-password8");
            UserDTO userDTO = new UserDTO("correct-login", passwordDTO, email, Role.Name.USER);
            when(passwordEncodingService.encodePassword(eq(passwordDTO.getPassword()))).thenReturn("encoded-password");
            when(verificationTokenService.generateVerificationToken(any())).thenReturn(token);

            underTest.signUpUser(userDTO);

            verify(passwordEncodingService,times(1)).encodePassword(passwordDTO.getPassword());
            verify(userService,times(1)).saveUser(any(), eq(Role.Name.USER));
            verify(verificationTokenService,times(1)).generateVerificationToken(any());
            verify(verificationTokenService,times(1)).saveVerificationToken(any(VerificationToken.class));
            verify(emailService,times(1)).sendActivationEmail(eq("InwentaryzacjIPZ"), eq(email), eq("account verification"), any());
        }
    }

    @Nested
    class WhenConfirmingToken {
        private final String TOKEN = "TOKEN";

        @BeforeEach
        void setup() {
        }
    }
}