package Zut_IPZ.Inwentaryzacja.inventory_entry;

import Zut_IPZ.Inwentaryzacja.user.UserDTO;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import java.util.Date;
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


}
