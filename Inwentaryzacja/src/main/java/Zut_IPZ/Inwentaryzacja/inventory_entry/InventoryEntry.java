package Zut_IPZ.Inwentaryzacja.inventory_entry;

import Zut_IPZ.Inwentaryzacja.attribute_value.AttributeValue;
import Zut_IPZ.Inwentaryzacja.item.Item;
import Zut_IPZ.Inwentaryzacja.tag.Tag;
import Zut_IPZ.Inwentaryzacja.user.User;
import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import jakarta.persistence.*;
import lombok.*;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

@Getter
@Setter
@AllArgsConstructor
@RequiredArgsConstructor
@Entity
@NoArgsConstructor
@Table(name = "inventory_entry")
@JsonIdentityInfo(generator= ObjectIdGenerators.PropertyGenerator.class,property="id")
public class InventoryEntry {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @ManyToOne
    @JoinColumn(name = "item_id")
    private @NonNull Item item;
    @OneToOne
    @JoinColumn(name = "parent_id")
    private InventoryEntry parent;
    private @NonNull Date addedAt;
    private @NonNull float quantity;
    @ManyToOne
    @JoinColumn(name = "user_id")
    private @NonNull User user;

    @OneToMany(mappedBy = "inventoryEntry", cascade = {CascadeType.PERSIST, CascadeType.MERGE})
    private Set<AttributeValue> attributeValues = new HashSet<>();
}
