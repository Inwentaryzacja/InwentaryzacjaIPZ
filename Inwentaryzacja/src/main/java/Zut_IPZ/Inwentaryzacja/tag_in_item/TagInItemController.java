package Zut_IPZ.Inwentaryzacja.tag_in_item;

import Zut_IPZ.Inwentaryzacja.tag.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping({"/tags_in_items"})
public class TagInItemController {
    private final TagInItemService tagInItemService;
    @Autowired
    public TagInItemController(TagInItemService tagInItemService){
        this.tagInItemService = tagInItemService;
    }
    @GetMapping
    public List<TagInItem> GetAllTagsInItems(){
        return this.tagInItemService.GetAllTagsInItems();
    }
    @GetMapping({"/{id}"})
    public List<Tag> GetTagsInItem(@PathVariable Long id){
        return this.tagInItemService.GetByItemId(id);
    }
    @PostMapping
    public TagInItem AddTagInItem(@RequestBody TagInItem tagInItem){
        return  this.tagInItemService.AddTagInItem(tagInItem);
    }
    @DeleteMapping({"/{id}"})
    public void DeleteTagInItem(@PathVariable Long id){
        this.tagInItemService.DeleteTagInItem(id);
    }
}
