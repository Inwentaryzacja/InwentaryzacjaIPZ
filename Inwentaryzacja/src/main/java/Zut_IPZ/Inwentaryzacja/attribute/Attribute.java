package Zut_IPZ.Inwentaryzacja.attribute;

import Zut_IPZ.Inwentaryzacja.attribute_type.AttributeType;
import Zut_IPZ.Inwentaryzacja.attribute_value.AttributeValue;
import Zut_IPZ.Inwentaryzacja.item.Item;
import Zut_IPZ.Inwentaryzacja.tag.Tag;
import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.*;

import java.util.HashSet;
import java.util.Set;

@Getter
@Setter
@AllArgsConstructor
@RequiredArgsConstructor
@Entity
@NoArgsConstructor
@Table(name = "attribute")
public class Attribute {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private @NonNull String name;
    @ManyToOne
    @JoinColumn(name = "type_id")
    private @NotNull AttributeType type;

    @ManyToMany(mappedBy="attributes", cascade={CascadeType.PERSIST, CascadeType.MERGE})
    @JsonIgnore
    private Set<Tag> tags = new HashSet<>();

    @OneToMany(mappedBy = "attribute", cascade={CascadeType.PERSIST, CascadeType.MERGE})
    @JsonIgnore
    private Set<AttributeValue> attributeValues = new HashSet<>();

    public Attribute(Long id, String name){
        this.id=id;
        this.name=name;
    }
}


