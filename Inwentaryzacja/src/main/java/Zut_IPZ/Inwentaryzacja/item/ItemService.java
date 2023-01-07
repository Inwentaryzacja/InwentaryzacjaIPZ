package Zut_IPZ.Inwentaryzacja.item;

import Zut_IPZ.Inwentaryzacja.user.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.NoSuchElementException;

@Service
public class ItemService {
    private final ItemRepository itemRepository;
    @Autowired
    public ItemService(ItemRepository itemRepository){
        this.itemRepository = itemRepository;
    }
    public List<Item> GetAllItems(){
        return this.itemRepository.findAll();
    }
    public Item GetItemById(Long id){
        return (Item)this.itemRepository.findById(id).orElseThrow(() -> {
            return new NoSuchElementException("Item not found with id " + id);
        });
    }
    public Item AddItem(Item item){
        return this.itemRepository.save(item);
    }
    public Item UpdateItem(Long id, Item itemDetails){
        Item item = this.GetItemById(id);
        item.setName(itemDetails.getName());
        item.setFillable(itemDetails.getFillable());
        item.setCreatedAt(itemDetails.getCreatedAt());
        item.setDescription(itemDetails.getDescription());
        return this.itemRepository.save(item);
    }
    public void DeleteItem(Long id){
        this.itemRepository.deleteById(id);
    }
}
