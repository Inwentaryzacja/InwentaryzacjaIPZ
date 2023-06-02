package Zut_IPZ.Inwentaryzacja.attribute;

import Zut_IPZ.Inwentaryzacja.tag.Tag;
import Zut_IPZ.Inwentaryzacja.tag.TagRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.NoSuchElementException;

@Service
public class AttributeService {
    private final AttributeRepository attributeRepository;
    private final TagRepository tagRepository;

    @Autowired
    public AttributeService(AttributeRepository attributeRepository, TagRepository tagRepository){
        this.attributeRepository = attributeRepository;
        this.tagRepository = tagRepository;
    }
    public List<Attribute> GetAllAttributes(){
        return this.attributeRepository.findAll();
    }
    public Attribute GetById(Long id){
        return (Attribute)this.attributeRepository.findById(id).orElseThrow(() -> {
            return new NoSuchElementException("Attribute not found with id " + id);
        });
    }
    public Attribute AddAttribute(Attribute attribute){
        return (Attribute) this.attributeRepository.save(attribute);
    }

    public Attribute UpdateAttribute(Long id, Attribute attributeDetails){
        Attribute attribute = this.GetById(id);
        attribute.setName(attributeDetails.getName());
        attribute.setType(attributeDetails.getType());
        return attributeRepository.save(attribute);
    }

    public void DeleteAttribute(Long id){
        Attribute attribute = attributeRepository.findById(id).orElseThrow(() -> new NoSuchElementException("Attribute not found with id " + id));

        for (Tag tag : attribute.getTags()) {
            tag.getAttributes().remove(attribute);
            tagRepository.save(tag);
        }

        attributeRepository.delete(attribute);
    }
}
