package Zut_IPZ.Inwentaryzacja.tag;

import Zut_IPZ.Inwentaryzacja.attribute.Attribute;
import Zut_IPZ.Inwentaryzacja.attribute.AttributeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class TagService {
    private final TagRepository tagRepository;
    private final AttributeRepository attributeRepository;

    @Autowired
    public TagService(TagRepository tagRepository, AttributeRepository attributeRepository){
        this.tagRepository = tagRepository;
        this.attributeRepository = attributeRepository;
    }
    public List<Tag> GetAllTags(){
        return tagRepository.findAll();
    }
    public Tag GetById(Long id){
        return tagRepository.findById(id).orElseThrow(() -> new NoSuchElementException("Tag not found with id " + id));
    }

    public Tag addTag(Tag tag){
        Set<Attribute> attributes = new HashSet<>();
        for(Attribute attribute : tag.getAttributes()){
            Optional<Attribute> existingAttribute = attributeRepository.findByName(attribute.getName());
            if(existingAttribute.isPresent()){
                attributes.add(existingAttribute.get());
            }else{
                attributes.add(attribute);
            }
        }
        tag.setAttributes(attributes);

        return tagRepository.save(tag);
    }

    public Tag updateTag(Long id, Tag tagDetails){
        Tag tag = this.GetById(id);
        tag.setName(tagDetails.getName());

        Set<Attribute> attributes = new HashSet<>();
        for(Attribute attribute : tag.getAttributes()){
            Optional<Attribute> existingAttribute = attributeRepository.findByName(attribute.getName());
            if(existingAttribute.isPresent()){
                attributes.add(existingAttribute.get());
            }else{
                attributes.add(attribute);
            }
        }
        tag.setAttributes(attributes);

        return this.tagRepository.save(tag);
    }

    public void DeleteTag(Long id){
        Attribute attribute = attributeRepository.findById(id).orElseThrow(() -> new NoSuchElementException("Attribute not found with id " + id));

        for (Tag tag : attribute.getTags()) {
            tag.getAttributes().remove(attribute);
            tagRepository.save(tag);
        }

        attributeRepository.delete(attribute);
        tagRepository.deleteById(id);
    }
}
