package Zut_IPZ.Inwentaryzacja.sign_up;

import Zut_IPZ.Inwentaryzacja.error.exception.UserAlreadyExistsException;
import Zut_IPZ.Inwentaryzacja.user.UserDTO;
import jakarta.mail.MessagingException;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
public class SignUpController {
    private final SignUpService signUpService;
    @PostMapping(value = "/sign_up")
    public ResponseEntity<String> signUpUser(@RequestBody @Valid UserDTO userDTO) {
        try {
            signUpService.signUpUser(userDTO);
            return new ResponseEntity<>("user has been registered", HttpStatus.OK);
        } catch (UserAlreadyExistsException userAlreadyExistsEx) {
            return new ResponseEntity<>("user already exists", HttpStatus.BAD_REQUEST);

        } catch (MessagingException e) {
            return new ResponseEntity<>("Failed to send email during sign-up", HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
    @GetMapping(value = "/sign_up_confirm/{token}")
    public ResponseEntity<String> confirmSignUp(@PathVariable String token) {
        signUpService.confirmToken(token);
        return new ResponseEntity<>("confirmed", HttpStatus.OK);

    }
}
