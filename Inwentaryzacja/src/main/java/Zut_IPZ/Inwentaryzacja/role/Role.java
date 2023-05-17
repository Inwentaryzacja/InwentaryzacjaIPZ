package Zut_IPZ.Inwentaryzacja.role;

import jakarta.persistence.*;
import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@RequiredArgsConstructor
@Entity
@Table(name="role")
public class Role {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "role_sequence")
    @SequenceGenerator(name = "role_sequence", sequenceName = "role_sequence", allocationSize = 1)
    private Long id;
    @NonNull
    @Enumerated(EnumType.STRING)
    private Name name;

     public enum Name {
         USER,
         ADMIN
    }
}
