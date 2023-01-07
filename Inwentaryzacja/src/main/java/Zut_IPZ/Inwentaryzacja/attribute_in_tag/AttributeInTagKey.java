package Zut_IPZ.Inwentaryzacja.attribute_in_tag;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;

import java.io.Serializable;

@Embeddable
public class AttributeInTagKey implements Serializable {
    @Column(name = "attribute_id")
    Long attributeId;
    @Column(name = "tag_id")
    Long tagId;
}
