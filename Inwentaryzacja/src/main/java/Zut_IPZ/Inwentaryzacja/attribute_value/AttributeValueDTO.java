package Zut_IPZ.Inwentaryzacja.attribute_value;

import Zut_IPZ.Inwentaryzacja.attribute.Attribute;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
public class AttributeValueDTO {
    private Long id;
    private String value;
    @JsonProperty("inventoryEntryId")
    private Long inventoryEntryId;
    private Attribute attribute;
}
