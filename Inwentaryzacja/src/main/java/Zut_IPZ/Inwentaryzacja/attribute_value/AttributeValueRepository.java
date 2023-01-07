package Zut_IPZ.Inwentaryzacja.attribute_value;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface AttributeValueRepository extends JpaRepository<AttributeValue, Long> {
    List<AttributeValue> findByInventoryEntry_Id(Long id);
}
