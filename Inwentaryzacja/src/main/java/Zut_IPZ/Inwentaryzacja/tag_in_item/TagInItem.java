package Zut_IPZ.Inwentaryzacja.tag_in_item;

import Zut_IPZ.Inwentaryzacja.attribute.Attribute;
import Zut_IPZ.Inwentaryzacja.item.Item;
import Zut_IPZ.Inwentaryzacja.tag.Tag;
import jakarta.persistence.*;
import lombok.*;

@AllArgsConstructor
@RequiredArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Entity
@Table(name = "tag_in_item")
public class TagInItem {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @ManyToOne
    @JoinColumn(name = "tag_id")
    private @NonNull Tag tag;
    @ManyToOne
    @JoinColumn(name = "item_id")
    private @NonNull Item item;
}
