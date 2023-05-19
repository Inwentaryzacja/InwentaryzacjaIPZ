package Zut_IPZ.Inwentaryzacja.tag;

import Zut_IPZ.Inwentaryzacja.attribute.Attribute;
import Zut_IPZ.Inwentaryzacja.item.Item;
import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import jakarta.persistence.*;
import lombok.*;

import java.util.HashSet;
import java.util.Set;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@RequiredArgsConstructor
@Entity
@Table(name="tag")
@JsonIdentityInfo(generator= ObjectIdGenerators.PropertyGenerator.class, property="id")
public class Tag {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private @NonNull String name;

    @ManyToMany(mappedBy="tags",cascade={CascadeType.PERSIST,CascadeType.MERGE})
    @JsonIgnore
    private Set<Item> items = new HashSet<>();

    @ManyToMany(cascade={CascadeType.PERSIST,CascadeType.MERGE})
    @JoinTable(name="tag_attribute",
            joinColumns=@JoinColumn(name="tag_id"),
            inverseJoinColumns=@JoinColumn(name="attribute_id"))
    private Set<Attribute> attributes = new HashSet<>();

    public Tag(Long id,String name, Set<Attribute> attributes){
        this.id=id;
        this.name=name;
        this.attributes=attributes;
    }
}
