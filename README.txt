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