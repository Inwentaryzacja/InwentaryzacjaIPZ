package Zut_IPZ.Inwentaryzacja.password;

import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class PasswordDTO {
    @NotEmpty
    @Size(min = 8, max = 20, message = "the password should be no less than 8 characters and no more than 20")
    @ValidPassword
    private  String password;
    private  String passwordConfirmation;

}

