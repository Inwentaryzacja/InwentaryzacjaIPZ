package Zut_IPZ.Inwentaryzacja.inventory_entry;

import Zut_IPZ.Inwentaryzacja.attribute_value.AttributeValue;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping({"/inventory_entries"})
@CrossOrigin(origins = "http://127.0.0.1:5173")
public class InventoryEntryController {
    private final InventoryEntryService inventoryEntryService;
    @Autowired
    private ModelMapper modelMapper;

    public InventoryEntryController(InventoryEntryService inventoryEntryService){
        this.inventoryEntryService = inventoryEntryService;
    }
    @GetMapping
    public List<InventoryEntryDTO> GetAllInventoryEntries(){
        return this.inventoryEntryService.GetAllInventoryEntries().stream()
                .map(inventory -> modelMapper.map(inventory,InventoryEntryDTO.class))
                .collect(Collectors.toList());
    }
    @GetMapping({"/{id}"})
    public ResponseEntity<InventoryEntryDTO> GetInventoryEntry(@PathVariable Long id){
        InventoryEntry inventoryEntry =  inventoryEntryService.GetInventoryEntryById(id);
        InventoryEntryDTO inventoryEntryDTO = modelMapper.map(inventoryEntry, InventoryEntryDTO.class);
        return ResponseEntity.ok().body(inventoryEntryDTO);
    }
    @GetMapping({"/user/{id}/root"})
    public ResponseEntity<InventoryEntryDTO> GetUserRootInventoryEntry(@PathVariable Long id){
        InventoryEntry inventoryEntry =  inventoryEntryService.GetUserRootInventoryEntry(id);
        InventoryEntryDTO inventoryEntryDTO = modelMapper.map(inventoryEntry, InventoryEntryDTO.class);
        return ResponseEntity.ok().body(inventoryEntryDTO);
    }
    @GetMapping({"/user/{id}/tree"})
    public ResponseEntity<ParentChildrenDTO> GetUserTreeInventoryEntry(@PathVariable Long id){
        ParentChildren parentChildren = this.inventoryEntryService.GetUserTreeInventoryEntry(id);
        ParentChildrenDTO parentChildrenDTO = modelMapper.map(parentChildren, ParentChildrenDTO.class);
        return ResponseEntity.ok().body(parentChildrenDTO);
    }
    @GetMapping({"/{id}/children"})
    public List<InventoryEntryDTO> GetChildrenInventoryEntries(@PathVariable Long id){
        return inventoryEntryService.GetChildrenInventoryEntries(id).stream()
                .map(inventory -> modelMapper.map(inventory,InventoryEntryDTO.class))
                .collect(Collectors.toList());
    }
    @GetMapping({"/user/{id}"})
    public List<InventoryEntryDTO> GetUserAllInventoryEntries(@PathVariable Long id){
        return this.inventoryEntryService.GetUserAllInventoryEntries(id).stream()
                .map(inventory -> modelMapper.map(inventory,InventoryEntryDTO.class))
                .collect(Collectors.toList());
    }
    @PostMapping
    public InventoryEntry AddInventoryEntry(@RequestBody InventoryEntry inventoryEntry){
        for (AttributeValue attributeValue : inventoryEntry.getAttributeValues()) {
            attributeValue.setInventoryEntry(inventoryEntry);
        }
        return inventoryEntryService.AddInventoryEntry(inventoryEntry);
    }
    @PutMapping({"/{id}"})
    public InventoryEntry UpdateInventoryEntry(@PathVariable Long id, @RequestBody InventoryEntry inventoryEntryDetails){
        return this.inventoryEntryService.UpdateInventoryEntry(id, inventoryEntryDetails);
    }

    @PutMapping({"/up/{id}"})
    public ResponseEntity<?> UpInventoryEntry(@PathVariable Long id){
        this.inventoryEntryService.UpInventoryEntry(id);
        return ResponseEntity.ok().build();
    }
    @DeleteMapping({"/{id}"})
    public void DeleteInventoryEntry(@PathVariable Long id){
        this.inventoryEntryService.DeleteInventoryEntry(id);
    }
}
