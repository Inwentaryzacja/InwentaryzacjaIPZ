package Zut_IPZ.Inwentaryzacja.tag_in_item;

import Zut_IPZ.Inwentaryzacja.tag.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.LinkedList;
import java.util.List;

@Service
public class TagInItemService {
    private final TagInItemRepository tagInItemRepository;
    @Autowired
    public TagInItemService(TagInItemRepository tagInItemRepository){
        this.tagInItemRepository = tagInItemRepository;
    }
    public List<TagInItem> GetAllTagsInItems(){
        return this.tagInItemRepository.findAll();
    }
    public List<Tag> GetByItemId(Long id){
        List<TagInItem> tagsInItem = this.tagInItemRepository.findByItem_Id(id);
        List<Tag> tags = new LinkedList<>();
        for(var tagInItem : tagsInItem){
            tags.add(tagInItem.getTag());
        }
        return tags;
    }
    public TagInItem AddTagInItem(TagInItem tagInItem){
        return this.tagInItemRepository.save(tagInItem);
    }
    public void DeleteTagInItem(Long id){
        this.tagInItemRepository.deleteById(id);
    }
}
