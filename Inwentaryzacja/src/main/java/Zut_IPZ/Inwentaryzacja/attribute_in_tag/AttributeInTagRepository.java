package Zut_IPZ.Inwentaryzacja.attribute_in_tag;

import Zut_IPZ.Inwentaryzacja.tag.Tag;
import Zut_IPZ.Inwentaryzacja.user.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface AttributeInTagRepository extends JpaRepository<AttributeInTag, Long> {
    List<AttributeInTag> findByTag_Id(Long id);
}
