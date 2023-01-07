package Zut_IPZ.Inwentaryzacja.attribute;

import Zut_IPZ.Inwentaryzacja.attribute_type.AttributeType;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@RequiredArgsConstructor
@Getter
@Setter
@Entity
@Table(name = "attribute")
public class Attribute {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private @NonNull String name;
    @ManyToOne
    @JoinColumn(name = "type_id")
    private @NotNull AttributeType type;
}
