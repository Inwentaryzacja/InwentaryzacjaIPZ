package Zut_IPZ.Inwentaryzacja.user;

import Zut_IPZ.Inwentaryzacja.role.Role;
import Zut_IPZ.Inwentaryzacja.email.ValidEmail;
import Zut_IPZ.Inwentaryzacja.password.PasswordDTO;
import Zut_IPZ.Inwentaryzacja.password.PasswordMatches;
import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotEmpty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Data
@AllArgsConstructor
public class UserDTO {
    private Long id;
}