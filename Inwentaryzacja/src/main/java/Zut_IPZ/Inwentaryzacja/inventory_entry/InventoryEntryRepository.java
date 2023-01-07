package Zut_IPZ.Inwentaryzacja.inventory_entry;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface InventoryEntryRepository extends JpaRepository<InventoryEntry, Long> {
    List<InventoryEntry> findByUser_Id(Long id);
    List<InventoryEntry> findByParentIsNullAndUser_Id(Long id);
    List<InventoryEntry> findByParent_Id(Long id);
}
