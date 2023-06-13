package Zut_IPZ.Inwentaryzacja.sign_up;

import Zut_IPZ.Inwentaryzacja.error.exception.UserAlreadyExistsException;
import Zut_IPZ.Inwentaryzacja.password.PasswordDTO;
import Zut_IPZ.Inwentaryzacja.role.Role;
import Zut_IPZ.Inwentaryzacja.user.UserDTO;
import jakarta.mail.MessagingException;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.http.ResponseEntity;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;
import static org.springframework.http.HttpStatus.*;

@ExtendWith(MockitoExtension.class)
class SignUpControllerTest {


    @Mock
    private SignUpService signUpService;
    @InjectMocks
    private SignUpController underTest;

    @Nested
    class WhenSigningUpUser {

        @BeforeEach
        void setup() {
        }
        @Test
        void correctUserDTO_ReturnOKCode() throws MessagingException {
            PasswordDTO passwordDTO = new PasswordDTO("Correct-password8", "Correct-password8");
            UserDTO userDTO = new UserDTO("correct-login", passwordDTO, "correct-email@wp.pl", Role.Name.USER);

            ResponseEntity<String> response = underTest.signUpUser(userDTO);

            verify(signUpService,times(1)).signUpUser(userDTO);
            assertSame(response.getStatusCode(), OK);
        }

        @Test
        void emailAlreadyExist_ReturnBAD_REQUESTCode() throws MessagingException {
            PasswordDTO passwordDTO = new PasswordDTO("Correct-password8", "Correct-password8");
            UserDTO userDTO = new UserDTO("correct-login", passwordDTO, "email-already-exist@wp.pl", Role.Name.USER);

            doThrow(UserAlreadyExistsException.class).when(signUpService).signUpUser(userDTO);

            ResponseEntity<String> response = underTest.signUpUser(userDTO);
            assertSame(response.getStatusCode(), BAD_REQUEST);

        }
        @Test
        void internalErrorOccured_ReturnINTERNAL_SERVER_ERROR() throws MessagingException {
            PasswordDTO passwordDTO = new PasswordDTO("Some-password8", "Some-password8");
            UserDTO userDTO = new UserDTO("some-login", passwordDTO, "some-email@wp.pl", Role.Name.USER);

            doThrow(MessagingException.class).when(signUpService).signUpUser(userDTO);

            ResponseEntity<String> response = underTest.signUpUser(userDTO);
            assertSame(response.getStatusCode(), INTERNAL_SERVER_ERROR);

        }

    }

    @Nested
    class WhenConfirmingSignUp {
        private final String TOKEN = "TOKEN";

        @BeforeEach
        void setup() {
        }
    }
}