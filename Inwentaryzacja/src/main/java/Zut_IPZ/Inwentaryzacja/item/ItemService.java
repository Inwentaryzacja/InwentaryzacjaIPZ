package Zut_IPZ.Inwentaryzacja.item;

import Zut_IPZ.Inwentaryzacja.tag.Tag;
import Zut_IPZ.Inwentaryzacja.tag.TagRepository;
import Zut_IPZ.Inwentaryzacja.user.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class ItemService{
        private final ItemRepository itemRepository;
        private final TagRepository tagRepository;

    @Autowired
    public ItemService(ItemRepository itemRepository,TagRepository tagRepository){
        this.itemRepository=itemRepository;
        this.tagRepository=tagRepository;
    }

    public List<Item> GetAllItems(){
        return itemRepository.findAll();
    }
    public Item GetItemById(Long id){
        return itemRepository.findById(id).orElseThrow(() -> new NoSuchElementException("Item not found with id " + id));
    }

    public Item addItem(Item item){
        Set<Tag> tags = new HashSet<>();
        for(Tag tag : item.getTags()){
            Optional<Tag> existingTag = tagRepository.findByName(tag.getName());
            if(existingTag.isPresent()){
                tags.add(existingTag.get());
            }else{
                tags.add(tag);
            }
        }
        item.setTags(tags);

        return itemRepository.save(item);
    }

    public Item updateItem(Long id,Item itemDetails){
        Item item = this.GetItemById(id);
        item.setName(itemDetails.getName());
        item.setFillable(itemDetails.getFillable());
        item.setCreatedAt(itemDetails.getCreatedAt());
        item.setDescription(itemDetails.getDescription());

        Set<Tag> tags = new HashSet<>();
        for(Tag tag : itemDetails.getTags()){
            Optional<Tag> existingTag = tagRepository.findByName(tag.getName());
            if(existingTag.isPresent()){
                tags.add(existingTag.get());
            }else{
                tags.add(tag);
            }
        }
        item.setTags(tags);

        return itemRepository.save(item);
    }

    public void DeleteItem(Long id){
        itemRepository.deleteById(id);
    }
}
