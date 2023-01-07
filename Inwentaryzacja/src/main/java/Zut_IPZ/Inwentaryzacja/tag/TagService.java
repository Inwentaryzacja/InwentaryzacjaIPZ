package Zut_IPZ.Inwentaryzacja.tag;

import Zut_IPZ.Inwentaryzacja.user.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.NoSuchElementException;

@Service
public class TagService {
    private final TagRepository tagRepository;

    @Autowired
    public TagService(TagRepository tagRepository){
        this.tagRepository = tagRepository;
    }
    public List<Tag> GetAllTags(){
        return this.tagRepository.findAll();
    }
    public Tag GetById(Long id){
        return (Tag)this.tagRepository.findById(id).orElseThrow(() -> {
            return new NoSuchElementException("Tag not found with id " + id);
        });
    }
    public Tag AddTag(Tag tag){
        return this.tagRepository.save(tag);
    }
    public Tag UpdateTag(Long id, Tag tagDetails){
        Tag tag = this.GetById(id);
        tag.setName(tagDetails.getName());
        return this.tagRepository.save(tag);
    }
    public void DeleteTag(Long id){
        this.tagRepository.deleteById(id);
    }
}
