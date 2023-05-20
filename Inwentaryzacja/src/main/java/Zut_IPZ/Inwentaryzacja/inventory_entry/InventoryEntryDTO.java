package Zut_IPZ.Inwentaryzacja.inventory_entry;

import Zut_IPZ.Inwentaryzacja.attribute_value.AttributeValue;
import Zut_IPZ.Inwentaryzacja.attribute_value.AttributeValueDTO;
import Zut_IPZ.Inwentaryzacja.user.UserDTO;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import java.util.Date;
import java.util.Set;

import Zut_IPZ.Inwentaryzacja.item.Item;
import lombok.Getter;

@Data
public class InventoryEntryDTO {
    private Long id;
    private Item item;
    private InventoryEntryDTO parent;
    private Date addedAt;
    private float quantity;

    @JsonProperty("userId")
    private Long userId;

    private Set<AttributeValueDTO> attributeValues;


}
