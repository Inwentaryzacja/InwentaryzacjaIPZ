package Zut_IPZ.Inwentaryzacja.attribute_type;

import Zut_IPZ.Inwentaryzacja.user.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.NoSuchElementException;

@Service
public class AttributeTypeService {
    private final AttributeTypeRepository attributeTypeRepository;

    @Autowired
    public AttributeTypeService(AttributeTypeRepository attributeTypeRepository){
        this.attributeTypeRepository = attributeTypeRepository;
    }

    public List<AttributeType> GetAllAttributeTypes(){
        return this.attributeTypeRepository.findAll();
    }

    public AttributeType GetById(Long id){
        return (AttributeType)this.attributeTypeRepository.findById(id).orElseThrow(() -> {
            return new NoSuchElementException("Attribute type not found with id " + id);
        });
    }
}
