package Zut_IPZ.Inwentaryzacja.inventory_entry;

import Zut_IPZ.Inwentaryzacja.item.Item;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.TooManyListenersException;

@Service
public class InventoryEntryService {
    private final InventoryEntryRepository inventoryEntryRepository;
    @Autowired
    public InventoryEntryService(InventoryEntryRepository inventoryEntryRepository){
        this.inventoryEntryRepository = inventoryEntryRepository;
    }
    public List<InventoryEntry> GetAllInventoryEntries(){
        return this.inventoryEntryRepository.findAll();
    }
    public InventoryEntry GetInventoryEntryById(Long id){
        return (InventoryEntry) this.inventoryEntryRepository.findById(id).orElseThrow(() -> {
            return new NoSuchElementException("Inventory entry not found with id " + id);
        });
    }
    public InventoryEntry GetUserRootInventoryEntry(Long id){
        return this.inventoryEntryRepository.findByParentIsNullAndUser_Id(id).get(0);
    }
    public List<InventoryEntry> GetChildrenInventoryEntries(Long id){
        return this.inventoryEntryRepository.findByParent_Id(id);
    }
    public List<InventoryEntry> GetUserAllInventoryEntries(Long id){
        return this.inventoryEntryRepository.findByUser_Id(id);
    }
    public InventoryEntry AddInventoryEntry(InventoryEntry inventoryEntry){
        return this.inventoryEntryRepository.save(inventoryEntry);
    }
    public InventoryEntry UpdateInventoryEntry(Long id, InventoryEntry inventoryEntryDetails){
        InventoryEntry inventoryEntry = this.GetInventoryEntryById(id);
        inventoryEntry.setItem(inventoryEntryDetails.getItem());
        inventoryEntry.setUser(inventoryEntryDetails.getUser());
        inventoryEntry.setParent(inventoryEntryDetails.getParent());
        inventoryEntry.setQuantity(inventoryEntryDetails.getQuantity());
        inventoryEntry.setAddedAt(inventoryEntryDetails.getAddedAt());
        return this.inventoryEntryRepository.save(inventoryEntry);
    }
    public void DeleteInventoryEntry(Long id){
        this.inventoryEntryRepository.deleteById(id);
    }
}
