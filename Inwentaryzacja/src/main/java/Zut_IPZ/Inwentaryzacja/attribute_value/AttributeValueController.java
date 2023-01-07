package Zut_IPZ.Inwentaryzacja.attribute_value;

import Zut_IPZ.Inwentaryzacja.inventory_entry.InventoryEntry;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping({"/attributes_values"})
public class AttributeValueController {
    private final AttributeValueService attributeValueService;
    @Autowired
    public AttributeValueController(AttributeValueService attributeValueService){
        this.attributeValueService = attributeValueService;
    }
    @GetMapping
    public List<AttributeValue> GetAllAttributesValues(){
        return this.attributeValueService.GetAllAttributesValues();
    }
    @GetMapping({"/inventory_entry/{id}"})
    public List<AttributeValue> GetInventoryEntryAllAttributesValues(@PathVariable Long id){
        return this.attributeValueService.GetByInventoryEntryId(id);
    }
    @GetMapping({"/{id}"})
    public AttributeValue GetAttributeValue(@PathVariable Long id){
        return this.attributeValueService.GetById(id);
    }
    @PostMapping
    public AttributeValue AddAttributeValue(@RequestBody AttributeValue attributeValue){
        return this.attributeValueService.AddAttributeValue(attributeValue);
    }
    @PutMapping({"/{id}"})
    public AttributeValue UpdateAttributeValue(@PathVariable Long id, @RequestBody AttributeValue attributeValueDetails){
        return this.attributeValueService.UpdateAttributeValue(id, attributeValueDetails);
    }
    @DeleteMapping({"/{id}"})
    public void DeleteAttributeValue(@PathVariable Long id){
        this.attributeValueService.DeleteAttributeValue(id);
    }
}
