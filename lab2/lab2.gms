Sets
  i   продукты / chair, tablee /
  j   поставщики сырья   / magnitogorsk, cheboksari, mahachkala /;
  
Parameters
  a(i) ограничение на число продаж продукта i в количестве
  / chair 40
    tablee 10 /
  b(j) ограничение на объем поставок поставщика j в центнерах
  / magnitogorsk 100 
    cheboksari 70
    mahachkala 50/
  c(j) цена единицы веса сырья от поставщика в рублях
  / magnitogorsk 20000 
    cheboksari 30000
    mahachkala 40000/
  p(i) цена продажи единицы продукта в рублях
  / chair 6000
    tablee 12000/;

Table  v(i,j) количество продукта i которое можно получить из единицы веса сырья j
            magnitogorsk  cheboksari  mahachkala
  chair         14           16            7
  tablee          2            3            1    ;


Variables
  z целевая функция
  Integer variable x(i, j) объем поставки сырья от поставщика j использованное для создания продукта i;
  
Equations
  profit    устанавливает целевую функцию
  production(i) ограничение на выпуск продукта i
  supply(j) ограничение на объем закупки сырья у поставщика j
  positiveV(i, j) неотрицательность затрат сырья j на создание продукта i
  positiveX(i, j) неотрицательность поставки сырья j для производства продукта i
  positiveA(i) неотрицательность объема продажи продукта i
  positiveB(j) неотрицательность объема поставки сырья от поставщика j
  positiveZ неотрицательность целевой функции;
  
profit ..           z =e= sum(i, (sum(j, (v(i, j) * x(i, j))) * p(i))) - sum(j, (sum(i, x(i, j)) * c(j)));
production(i) ..    sum(j, v(i, j) * x(i, j)) =l= a(i);
supply(j) ..        sum(i, x(i, j)) =l= b(j);
positiveV(i, j) ..  v(i, j) =g= 0;
positiveX(i, j) ..  x(i, j) =g= 0;
positiveA(i) ..     a(i) =g= 0;
positiveB(j) ..     b(j) =g= 0;
positiveZ ..        z =g= 0;

Model lab2 /all/;

Solve lab2 using MIP maximazing z;
display z.l;