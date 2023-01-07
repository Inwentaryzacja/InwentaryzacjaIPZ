package Zut_IPZ.Inwentaryzacja.inventory_entry;

import Zut_IPZ.Inwentaryzacja.item.Item;
import Zut_IPZ.Inwentaryzacja.tag.Tag;
import Zut_IPZ.Inwentaryzacja.user.User;
import jakarta.persistence.*;
import lombok.*;

import java.util.Date;

@AllArgsConstructor
@NoArgsConstructor
@RequiredArgsConstructor
@Getter
@Setter
@Entity
@Table(name = "inventory_entry")
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
}
