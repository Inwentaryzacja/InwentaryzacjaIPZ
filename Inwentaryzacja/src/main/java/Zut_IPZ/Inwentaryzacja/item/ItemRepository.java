package Zut_IPZ.Inwentaryzacja.item;

import Zut_IPZ.Inwentaryzacja.user.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ItemRepository extends JpaRepository<Item, Long> {
}
