package Zut_IPZ.Inwentaryzacja.inventory_entry;

import lombok.Data;

import java.util.LinkedList;

@Data
public class ParentChildrenDTO {
    InventoryEntryDTO entry;
    LinkedList<ParentChildrenDTO> children = new LinkedList<ParentChildrenDTO>();
}
