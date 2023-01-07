package Zut_IPZ.Inwentaryzacja.attribute_value;

import Zut_IPZ.Inwentaryzacja.inventory_entry.InventoryEntry;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.NoSuchElementException;

@Service
public class AttributeValueService {
    private final AttributeValueRepository attributeValueRepository;
    @Autowired
    public AttributeValueService(AttributeValueRepository attributeValueRepository){
        this.attributeValueRepository = attributeValueRepository;
    }
    public List<AttributeValue> GetAllAttributesValues(){
        return this.attributeValueRepository.findAll();
    }
    public List<AttributeValue> GetByInventoryEntryId(Long id){
        return this.attributeValueRepository.findByInventoryEntry_Id(id);
    }
    public AttributeValue GetById(Long id){
        return (AttributeValue)this.attributeValueRepository.findById(id).orElseThrow(() -> {
            return new NoSuchElementException("Attribute value not found with id " + id);
        });
    }
    public AttributeValue AddAttributeValue(AttributeValue attributeValue){
        return this.attributeValueRepository.save(attributeValue);
    }
    public AttributeValue UpdateAttributeValue(Long id, AttributeValue attributeValueDetails){
        AttributeValue attributeValue = this.GetById(id);
        attributeValue.setAttribute(attributeValueDetails.getAttribute());
        attributeValue.setInventoryEntry(attributeValueDetails.getInventoryEntry());
        attributeValue.setValue(attributeValueDetails.getValue());
        return this.attributeValueRepository.save(attributeValue);
    }
    public void DeleteAttributeValue(Long id){
        this.attributeValueRepository.deleteById(id);
    }
}
