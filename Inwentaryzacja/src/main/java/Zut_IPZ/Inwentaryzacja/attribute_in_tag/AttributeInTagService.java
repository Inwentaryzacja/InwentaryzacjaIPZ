package Zut_IPZ.Inwentaryzacja.attribute_in_tag;

import Zut_IPZ.Inwentaryzacja.attribute.Attribute;
import Zut_IPZ.Inwentaryzacja.tag.Tag;
import Zut_IPZ.Inwentaryzacja.tag.TagRepository;
import Zut_IPZ.Inwentaryzacja.tag.TagService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.LinkedList;
import java.util.List;

@Service
public class AttributeInTagService {
    private final AttributeInTagRepository attributeInTagRepository;
    @Autowired
    public AttributeInTagService(AttributeInTagRepository attributeInTagRepository){
        this.attributeInTagRepository = attributeInTagRepository;
    }
    public List<AttributeInTag> GetAllAttributesInTags(){
        return this.attributeInTagRepository.findAll();
    }
    public List<Attribute> GetByTagId(Long id){
        List<AttributeInTag> attributeInTags = this.attributeInTagRepository.findByTag_Id(id);
        List<Attribute> attributes = new LinkedList<>();
        for (var attributeInTag : attributeInTags) {
            attributes.add(attributeInTag.getAttribute());
        }
        return attributes;
    }
    public AttributeInTag AddAttributeInTag(AttributeInTag attributeInTag){
        return this.attributeInTagRepository.save(attributeInTag);
    }
    public void DeleteAttributeInTag(AttributeInTag attributeInTag){
        this.attributeInTagRepository.delete(attributeInTag);
    }

}
