package Zut_IPZ.Inwentaryzacja.tag_in_item;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface TagInItemRepository extends JpaRepository<TagInItem, Long> {
    List<TagInItem> findByItem_Id(Long id);
}
