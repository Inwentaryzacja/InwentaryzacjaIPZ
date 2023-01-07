package Zut_IPZ.Inwentaryzacja.inventory_entry;

import jakarta.persistence.criteria.CriteriaBuilder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping({"/inventory_entries"})
public class InventoryEntryController {
    private final InventoryEntryService inventoryEntryService;
    @Autowired
    public InventoryEntryController(InventoryEntryService inventoryEntryService){
        this.inventoryEntryService = inventoryEntryService;
    }
    @GetMapping
    public List<InventoryEntry> GetAllInventoryEntries(){
        return this.inventoryEntryService.GetAllInventoryEntries();
    }
    @GetMapping({"/{id}"})
    public InventoryEntry GetInventoryEntry(@PathVariable Long id){
        return this.inventoryEntryService.GetInventoryEntryById(id);
    }
    @GetMapping({"/user/{id}/root"})
    public InventoryEntry GetUserRootInventoryEntry(@PathVariable Long id){
        return this.inventoryEntryService.GetUserRootInventoryEntry(id);
    }
    @GetMapping({"/{id}/children"})
    public List<InventoryEntry> GetChildrenInventoryEntries(@PathVariable Long id){
        return this.inventoryEntryService.GetChildrenInventoryEntries(id);
    }
    @GetMapping({"/user/{id}"})
    public List<InventoryEntry> GetUserAllInventoryEntries(@PathVariable Long id){
        return this.inventoryEntryService.GetUserAllInventoryEntries(id);
    }
    @PostMapping
    public InventoryEntry AddInventoryEntry(@RequestBody InventoryEntry inventoryEntry){
        return this.inventoryEntryService.AddInventoryEntry(inventoryEntry);
    }
    @PutMapping({"/{id}"})
    public InventoryEntry UpdateInventoryEntry(@PathVariable Long id, @RequestBody InventoryEntry inventoryEntryDetails){
        return this.inventoryEntryService.UpdateInventoryEntry(id, inventoryEntryDetails);
    }
    @DeleteMapping({"/{id}"})
    public void DeleteInventoryEntry(@PathVariable Long id){
        this.inventoryEntryService.DeleteInventoryEntry(id);
    }
}
