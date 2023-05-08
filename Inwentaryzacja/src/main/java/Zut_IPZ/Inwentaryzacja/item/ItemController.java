package Zut_IPZ.Inwentaryzacja.item;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping({"/items"})
@CrossOrigin(origins = "http://localhost:5173")
public class ItemController {
    private final ItemService itemService;
    @Autowired
    public ItemController(ItemService itemService){
        this.itemService = itemService;
    }
    @GetMapping
    public List<Item> GetAllItems(){
        return this.itemService.GetAllItems();
    }
    @GetMapping({"/{id}"})
    public Item GetItem(@PathVariable Long id){
        return this.itemService.GetItemById(id);
    }
    @PostMapping
    public Item AddItem(@RequestBody Item item){
        return this.itemService.AddItem(item);
    }
    @PutMapping({"/{id}"})
    public Item UpdateItem(@PathVariable Long id, @RequestBody Item itemDetails){
        return this.itemService.UpdateItem(id, itemDetails);
    }
    @DeleteMapping({"/{id}"})
    public void DeleteItem(@PathVariable Long id){
        this.itemService.DeleteItem(id);
    }
}
