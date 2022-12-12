package Zut_IPZ.Inwentaryzacja.Role;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter

@Entity
@Table(name="role")
public class Role {
    @Id
    @GeneratedValue
    private Long id;
    private String name;
}
