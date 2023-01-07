package Zut_IPZ.Inwentaryzacja.attribute_in_tag;

import Zut_IPZ.Inwentaryzacja.attribute.Attribute;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping({"/attributes_in_tags"})
public class AttributeInTagController {
    private final AttributeInTagService attributeInTagService;
    @Autowired
    public AttributeInTagController(AttributeInTagService attributeInTagService){
        this.attributeInTagService = attributeInTagService;
    }
    @GetMapping
    public List<AttributeInTag> GetAllAttributesInTags(){
        return this.attributeInTagService.GetAllAttributesInTags();
    }
    @GetMapping({"/{id}"})
    public List<Attribute> GetAttributesInTag(@PathVariable Long id){
        return this.attributeInTagService.GetByTagId(id);
    }
    @PostMapping
    public AttributeInTag AddAttributeInTag(@RequestBody AttributeInTag attributeInTag){
        return this.attributeInTagService.AddAttributeInTag(attributeInTag);
    }
    @DeleteMapping
    public void DeleteAttributeInTag(@RequestBody AttributeInTag attributeInTag){
        this.attributeInTagService.DeleteAttributeInTag(attributeInTag);
    }
}
