package Zut_IPZ.Inwentaryzacja.User;

import Zut_IPZ.Inwentaryzacja.Role.Role;
import Zut_IPZ.Inwentaryzacja.email.ValidEmail;
import Zut_IPZ.Inwentaryzacja.password.PasswordDTO;
import Zut_IPZ.Inwentaryzacja.password.PasswordMatches;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotEmpty;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class UserDTO {
    @NotEmpty
    private String name;
    @NotEmpty
    private String login;
    @Valid
    @PasswordMatches
    private PasswordDTO passwordDTO;
    @NotEmpty
    @ValidEmail
    private String email;
    private Role role;

}