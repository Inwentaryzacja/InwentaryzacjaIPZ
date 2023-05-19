package Zut_IPZ.Inwentaryzacja.tag;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping({"/tags"})
@CrossOrigin
public class TagController {
    private final TagService tagService;
    @Autowired
    public TagController(TagService tagService){
        this.tagService = tagService;
    }
    @GetMapping
    public List<Tag> GetAllTags(){
        return tagService.GetAllTags();
    }
    @GetMapping({"/{id}"})
    public Tag GetTag(@PathVariable Long id){
        return tagService.GetById(id);
    }
    @PostMapping
    public Tag AddTag(@RequestBody Tag tag){
        return tagService.addTag(tag);
    }
    @PutMapping({"/{id}"})
    public Tag UpdateTag(@PathVariable Long id, @RequestBody Tag tag){
        return tagService.updateTag(id, tag);
    }
    @DeleteMapping({"/{id}"})
    public void DeleteTag(@PathVariable Long id){
        tagService.DeleteTag(id);
    }
}
