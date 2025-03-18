Sets
  i   продукты / chair, table /
  j   поставщики сырья   / magnitogorsk, cheboksari, mahachkala /;
  
Parameters
  a(i) ограничение на число продаж продукта i в количестве
  / chair 40
    table 10 /
  b(j) ограничение на объем поставок поставщика j в центнерах
  / magnitogorsk 100 
    cheboksari 70
    mahachkala 50/
  c(j) цена единицы веса сырья от поставщика в рублях
  / magnitogorsk 20 
    cheboksari 40
    mahachkala 50/
  p(i) цена продажи единицы продукта в рублях
  / chair 6000
    table 12000/;

Table  v(i,j) количество продукта i которое можно получить из единицы веса сырья j
            magnitogorsk  cheboksari  mahachkala
  chair         14           16            7
  table          2            3            1    ;


Variables
  z целевая функция
  x(i, j) объем поставки сырья от поставщика j использованное для создания продукта i;
  
Equations
  profit    устанавливает целевую функцию
  production(i) ограничение на выпуск продукта i
  supply(j) ограничение на объем закупки сырья у поставщика j;
  
cost ..           z =e= sum(i, (sum(j, (v(i, j) * x(i, j))) * p(i))) - sum(j, (sum(i, x(i, j)) * c(j)));
production(i) ..  sum(j, v(i, j) * x(i, j)) =l= a(i);
supply(j) ..      sum(i, x(i, j)) =l= b(j);

Model production /all/;

Solve production using LP maximazing z
display z.l