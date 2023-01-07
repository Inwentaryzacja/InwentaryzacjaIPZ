package Zut_IPZ.Inwentaryzacja.attribute_value;

import Zut_IPZ.Inwentaryzacja.attribute.Attribute;
import Zut_IPZ.Inwentaryzacja.inventory_entry.InventoryEntry;
import Zut_IPZ.Inwentaryzacja.item.Item;
import jakarta.persistence.*;
import lombok.*;
@AllArgsConstructor
@NoArgsConstructor
@RequiredArgsConstructor
@Getter
@Setter
@Entity
@Table(name = "attribute_value")
public class AttributeValue {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String value;
    @ManyToOne
    @JoinColumn(name = "inventory_entry_id")
    private @NonNull InventoryEntry inventoryEntry;
    @ManyToOne
    @JoinColumn(name = "attribute_id")
    private @NonNull Attribute attribute;
}
