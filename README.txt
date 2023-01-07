Co trzeba zrobić, żeby wystartować projekt, żeby wam działał

1. Trzeba mieć MySQL Community Server, zalecam rowniez  MySQL Workbench , graficzny interfejs do servera. Tutorial, ktory ja ogladalem, zeby sobie przypomniec jak to sie robi
https://www.youtube.com/watch?v=WuBcTJnIuzo
2. Konfigurujemy sb mySQL Server, tworzymy sobie Baze danych i importujemy tabele z pliku Kacpra.
3. Pamietamy, ze w momencie w, ktorym chcemy, zeby nasz projekt dzialal musimy miec odpalona baze danych


Propozycja
Można zrobić, teoretycznie  kolejnego brancha bez bazy danych, i uzywac Postmana, do sprawdzania czy nasze metody, ktore napisalismy dzialaja, ale 
nwm czy na dluzsza mete ma to sens.


Uwagi:
w pliku application.properties

spring.datasource.url=jdbc:mysql://localhost:3306/inventoryzut , ponieważ swoja baze danych nazwalem inventoryzut, jezeli nazwiecie ja inaczej u siebie, to nie zadziala
spring.datasource.username=root
spring.datasource.password=inventoryzut!@

username: podstawowo root, hasło takie jakie ustalicie sobie przy konfiguracji

Update, dodano endpointy:

attribute_type:
GetAllAttributeTypes() = /attribute_types GET
GetAttributeType(Long id) = /attribute_types/{id} GET

attribute:
GetAllAttributes() = /attributes GET
GetAttribute(Long id) = /attributes/{id} GET
AddAttribute(Attribute attribute) = /attributes POST
UpdateAttribute(Long id, Attribute attributeDetails) = /attributes/id PUT
DeleteAttribute(Long id) = /attributes/id DELETE

tag:
GetAllTags() = /tags GET
GetTag(Long id) = /tags/{id} GET
AddTag(Tag tag) = /tags POST
UpdateTag(Long id, Tag tag) = /tags/{id} PUT
DeleteTag(Long id) = /tags/{id} DELETE

attribute_in_tag:
GetAllAttributesInTags() = /attributes_in_tags GET
GetAttributesInTag(Long id) = /attributes_in_tags/{id} GET
AddAttributeInTag(AttributeInTag attributeInTag) /attributes_in_tags POST
DeleteAttributeInTag(AttributeInTag attributeInTag) = /attributes_in_tags DELETE

item:
GetAllItems() = /items GET
GetItem(Long id) = /items/{id} GET
AddItem(Item item) = /items POST
UpdateItem(Long id, Item itemDetails) = /items/{id} PUT
DeleteItem(Long id) = /items/{id} DELETE

tag_in_item:
GetAllTagsInItems() = /tags_in_items GET
GetTagsInItem(Long id) = /tags_in_items/{id} GET
AddTagInItem(TagInItem tagInItem) = /tags_in_items POST
DeleteTagInItem(Long id) = /tags_in_items/{id} DELETE

inventory_entry
GetAllInventoryEntries() = /inventory_entries GET
GetInventoryEntry(Long id) = /inventory_entries/{id} GET
GetUserRootInventoryEntry(Long id) = /inventory_entries/user/{id}/root GET
GetChildrenInventoryEntries(Long id) = inventory_entries/{id}/children GET
GetUserAllInventoryEntries(Long id) = inventory_entries/user/{id} GET
AddInventoryEntry(InventoryEntry inventoryEntry) = inventory_entries POST
UpdateInventoryEntry(Long id, InventoryEntry inventoryEntryDetails) = inventory_entries/{id} PUT
DeleteInventoryEntry(Long id) = inventory_entries/{id} DELETE

attribute_value
GetAllAttributesValues() = /attributes_values GET
GetInventoryEntryAllAttributesValues(Long id) = /attributes_values/inventory_entry/{id} GET
GetAttributeValue(Long id) = /attributes_values/{id} GET
AddAttributeValue(AttributeValue attributeValue) = /attributes_values POST
UpdateAttributeValue(Long id, AttributeValue attributeValueDetails) = /attributes_values/{id} PUT
DeleteAttributeValue(Long id) = /attributes_values/{id} DELETE
