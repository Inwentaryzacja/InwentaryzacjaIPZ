package Zut_IPZ.Inwentaryzacja.attribute_type;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@RequiredArgsConstructor
@Getter
@Entity
@Table(name = "attribute_type")
public class AttributeType {

    @Id
    private Long id;
    private @NonNull String name;
}
