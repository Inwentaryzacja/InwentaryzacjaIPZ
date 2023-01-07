package Zut_IPZ.Inwentaryzacja.attribute;

import Zut_IPZ.Inwentaryzacja.attribute_type.AttributeTypeController;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.w3c.dom.Attr;

import java.util.List;

@RestController
@RequestMapping({"/attributes"})
public class AttributeController {
    private final AttributeService attributeService;
    @Autowired
    public AttributeController(AttributeService attributeService){
        this.attributeService = attributeService;
    }
    @GetMapping
    public List<Attribute> GetAllAttributes(){
        return this.attributeService.GetAllAttributes();
    }
    @GetMapping({"{id}"})
    public Attribute GetAttribute(@PathVariable Long id){
        return this.attributeService.GetById(id);
    }
    @PostMapping
    public Attribute AddAttribute(@RequestBody Attribute attribute){
        return this.attributeService.AddAttribute(attribute);
    }
    @PutMapping({"{id}"})
    public Attribute UpdateAttribute(@PathVariable Long id, @RequestBody Attribute attributeDetails){
        return this.attributeService.UpdateAttribute(id, attributeDetails);
    }
    @DeleteMapping({"{id}"})
    public void DeleteAttribute(@PathVariable Long id){
        this.attributeService.DeleteAttribute(id);
    }
}
