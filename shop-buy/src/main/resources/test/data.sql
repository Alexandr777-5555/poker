 insert into customer (ID , BIRTH_DATE , FIRST_NAME , LAST_NAME ) values (1 , '1982-06-23' , 'Alex' , 'Avd');
 insert into customer (ID , BIRTH_DATE , FIRST_NAME , LAST_NAME ) values (2 , '1987-02-02' , 'Natalia' , 'Ivanova');
 insert into customer (ID , BIRTH_DATE , FIRST_NAME , LAST_NAME ) values (3 , '1981-03-03' , 'Светлана' , 'Potapova');


 insert into product (product_id , price) values ('хлеб' , 25.03);
 insert into product (product_id , price) values ('молоко' , 33.06);
 insert into product (product_id , price) values ('яйцо' , 78);
 insert into product (product_id , price) values ('TV' , 75000);
 insert into product (product_id , price) values ('Холодильник' , 35000);
 insert into product (product_id , price) values ('3d-Tv' , 99000);
 insert into product (product_id , price) values ('Кофеварка' , 1500);
 insert into product (product_id , price) values ('Pc' , 54000);



 insert into customer_product (product_id , customer_id) values ('хлеб' , 1);
 insert into customer_product (product_id , customer_id) values ('яйцо' , 2);
 insert into customer_product (product_id , customer_id) values ('Холодильник' , 3);
 insert into customer_product (product_id , customer_id) values ('TV' , 1);



 insert into purchases (ID , BUY_DATE , CUSTOMER_ID ,product ) values (1 , '2020-03-05' , 1 ,'хлеб' );
 insert into purchases (ID , BUY_DATE , CUSTOMER_ID , product) values (2 , '2020-01-08' , 2 , 'яйцо');
 insert into purchases (ID , BUY_DATE , CUSTOMER_ID , product) values (3 , '2020-03-14' , 3 ,'Холодильник' );
 insert into purchases (ID , BUY_DATE , CUSTOMER_ID , product) values (4 , '2020-04-22' , 1 , 'TV');