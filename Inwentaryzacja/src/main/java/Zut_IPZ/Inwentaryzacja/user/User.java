//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by FernFlower decompiler)
//

package Zut_IPZ.Inwentaryzacja.user;

import Zut_IPZ.Inwentaryzacja.role.Role;
import jakarta.persistence.*;
import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Entity
@Table(name = "user")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "user_sequence")
    @SequenceGenerator(name = "user_sequence", sequenceName = "user_sequence", allocationSize = 1)
    private Long id;
    private @NonNull String login;
    private @NonNull String password;
    private @NonNull String email;
    private @NonNull Integer verified;
    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "role_id")
    private @NonNull Role role;

    public User(@NonNull String login, @NonNull String password, @NonNull String email, @NonNull Integer verified) {
        this.login = login;
        this.password = password;
        this.email = email;
        this.verified = verified;
    }
}
