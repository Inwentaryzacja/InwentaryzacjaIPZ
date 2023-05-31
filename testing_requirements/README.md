# Wymogi dotyczące tworzenia testów dla endpointów

Niniejszy plik README zawiera wymogi dotyczące tworzenia testów dla endpointów w celu zapewnienia spójności i poprawności zachowania systemu. Poniżej przedstawiamy szczegółowy opis tych wymogów.

## Wymogi

1. **Wyczyszczenie bazy danych**: Przed każdym testem należy wyczyścić bazę danych ze wszystkich tabel, włącznie ze strukturą. Następnie należy zainicjować bazę danych ponownie, korzystając z pliku `db/init.sql`.

2. **Testy dla każdego endpointa**: Dla każdego z endpointów, należy przeprowadzić następujące testy:
   - **Wykonanie poprawne**: Sprawdzenie, czy endpoint wykonuje się poprawnie. Po wywołaniu endpointa może wystąpić np. błąd SQL związany z niewłaściwą strukturą.
   - **Prawidłowe kody HTTP**: Sprawdzenie, czy endpoint zwraca prawidłowe kody HTTP dla różnych przypadków użycia. Poniżej znajduje się tabela z kodami odpowiedzi HTTP do sprawdzania.
   - **Poprawna struktura pliku JSON**: Sprawdzenie, czy plik JSON zwrócony przez endpoint ma prawidłową strukturę zgodną ze specyfikacją dla różnych przypadków użycia. Należy sprawdzić poprawność nazw pól, typów danych pól (np. typ daty na backendzie powinien być przedstawiony w JSON jako string) oraz zachowanie struktury obiektów zagnieżdżonych.
   - **Poprawność danych**: Sprawdzenie, czy dane znajdujące się w ramach poprawnej struktury dokładnie zgadzają się ze stanem oczekiwanym. Jeśli plik JSON zawiera dane dające się wyrazić rekurencyjnie lub dane reprezentujące drzewo, należy sprawdzić poprawność powyższych cech w sposób wyczerpujący, na przykład w sposób rekurencyjny.

3. **Łatwe uruchamianie testów**: Wszystkie testy muszą być łatwo uruchamiane w sposób zbiorczy, umożliwiający powtarzalne wykonywanie i zapewnienie spójności w wynikach.

4. **Modyfikacja pliku db/init.sql**: W przypadku niewłaściwej struktury SQL lub niewłaściwej ilości danych testowych do wyczerpującego sprawdzenia stanu po danej operacji, dopuszcza się modyfikację pliku `db/init.sql`.

## Kody HTTP
| Typ żądania | Scenariusz sukcesu      | Scenariusz niepowodzenia |
|-------------|------------------------|-------------------------|
| GET         | 200 OK                 | 404 Not Found           |
|             |                        | 400 Bad Request         |
|             |                        | 401 Unauthorized        |
|             |                        | 403 Forbidden           |
| POST        | 201 Created            | 400 Bad Request         |
|             |                        | 401 Unauthorized        |
|             |                        | 403 Forbidden           |
| PUT         | 200 OK                 | 400 Bad Request         |
|             |                        | 401 Unauthorized        |
|             |                        | 403 Forbidden           |
|             |                        | 404 Not Found           |
| DELETE      | 204 No Content         | 400 Bad Request         |
|             |                        | 401 Unauthorized        |
|             |                        | 403 Forbidden           |
|             |                        | 404 Not Found           |
| PATCH       | 200 OK                 | 400 Bad Request         |
|             |                        | 401 Unauthorized        |
|             |                        | 403 Forbidden           |
|             |                        | 404 Not Found           |


Spełnienie tych wymogów zapewni spójność i poprawność zachowania bazy danych i endpointów oraz samostanowi dowód poprawności systemu.