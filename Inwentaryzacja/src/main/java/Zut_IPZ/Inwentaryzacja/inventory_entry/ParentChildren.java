package Zut_IPZ.Inwentaryzacja.inventory_entry;

import lombok.Getter;
import lombok.Setter;

import java.util.LinkedList;
@Getter
@Setter
public class ParentChildren{
    InventoryEntry entry;
    LinkedList<ParentChildren> children = new LinkedList<ParentChildren>();
    public ParentChildren findEntry(InventoryEntry entry, ParentChildren pc){ //entry = klucz // pc = obiekt w którym szukamy
        if(pc.entry == entry){
            return pc;
        }
        else{
            for(ParentChildren child : pc.children) {
//                if(child.entry == entry){
//                    return child;
//                }
//                else {
//                    return findEntry(child.entry);
//                }
                ParentChildren tmp = findEntry(entry, child);
                if(tmp != null){
                    return tmp;
                }
            }
        }
        return null;
    }
}
