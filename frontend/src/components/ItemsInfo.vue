<template>
  <table>
  <tr><td>Przedmiot</td><td>Ilość</td><td>Opis</td><td>Kontener</td></tr>
  <tr><td>Telefon</td><td>1</td><td>Samsung S23</td><td>Nie</td></tr>
  <tr><td>Lodówka</td><td>1</td><td>-</td><td>Tak</td></tr>
  <tr><td>Komputer</td><td>2</td><td>Alienware</td><td>Nie</td></tr>
  <tr><td>Plecak</td><td>4</td><td>Adidas</td><td>Tak</td></tr>
  </table>
</template>

<style scoped>

table{
  width: 78%;
  text-align: center;
  color: #0082fb;
  font-family: Arial;
  font-size: 16px;
  margin-left: auto;
  margin-right: auto;
}

tr {
  height: 50px;
}

tr:nth-child(odd) {
  background-color: #d4d4d4;
}

tr:first-of-type{
  font-weight: bold;
}
</style>
