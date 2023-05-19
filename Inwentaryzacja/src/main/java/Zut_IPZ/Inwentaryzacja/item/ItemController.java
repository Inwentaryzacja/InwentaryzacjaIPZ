package Zut_IPZ.Inwentaryzacja.item;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping({"/items"})
@CrossOrigin(origins = "http://127.0.0.1:5173")
public class ItemController {
    private final ItemService itemService;
    @Autowired
    public ItemController(ItemService itemService){
        this.itemService = itemService;
    }
    @GetMapping
    public List<Item> GetAllItems(){
        return itemService.GetAllItems();
    }
    @GetMapping({"/{id}"})
    public Item GetItem(@PathVariable Long id){
        return itemService.GetItemById(id);
    }
    @PostMapping
    public Item AddItem(@RequestBody Item item){
        return itemService.addItem(item);
    }
    @PutMapping({"/{id}"})
    public Item UpdateItem(@PathVariable Long id, @RequestBody Item itemDetails){
        return itemService.updateItem(id, itemDetails);
    }
    @DeleteMapping({"/{id}"})
    public void DeleteItem(@PathVariable Long id){
        itemService.DeleteItem(id);
    }
}
