package Zut_IPZ.Inwentaryzacja.attribute_type;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping({"/attribute_types"})
public class AttributeTypeController {
    private final AttributeTypeService attributeTypeService;

    @Autowired
    public AttributeTypeController(AttributeTypeService attributeTypeService){
        this.attributeTypeService = attributeTypeService;
    }

    @GetMapping
    public List<AttributeType> GetAllAttributeTypes(){
        return this.attributeTypeService.GetAllAttributeTypes();
    }

    @GetMapping({"/{id}"})
    public AttributeType GetAttributeType(@PathVariable Long id){
        return this.attributeTypeService.GetById(id);
    }
}
