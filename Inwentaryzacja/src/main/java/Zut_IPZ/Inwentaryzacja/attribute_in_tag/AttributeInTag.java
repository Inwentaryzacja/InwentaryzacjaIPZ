package Zut_IPZ.Inwentaryzacja.attribute_in_tag;

import Zut_IPZ.Inwentaryzacja.attribute.Attribute;
import Zut_IPZ.Inwentaryzacja.tag.Tag;
import jakarta.persistence.*;
import lombok.*;

import java.io.Serializable;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Entity
@Table(name = "attribute_in_tag")
public class AttributeInTag {
    @EmbeddedId
    AttributeInTagKey id;
    @ManyToOne
    @MapsId("attributeId")
    @JoinColumn(name = "attribute_id")
    private @NonNull Attribute attribute;
    @ManyToOne
    @MapsId("tagId")
    @JoinColumn(name = "tag_id")
    private @NonNull Tag tag;
}
