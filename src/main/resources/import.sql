insert into USERS values ( 1, CURRENT_TIMESTAMP, CURRENT_TIMESTAMP, 'test1', 28, 0, 'anjwoc@naver.com', '$2a$12$rwyNYVkFcaEakDt54l8XceCpnY9R4KZkz15eTmUO2mFfZE1oC4dKW', 'ROLE_ADMIN', 'anjwoc' );
-- insert into USERS values ( 2, CURRENT_TIMESTAMP, CURRENT_TIMESTAMP, 'test2', 20, 0, 'test1@gmail.com', '1234', 'ROLE_ADMIN', 'test1' );
-- insert into USERS values ( 3, CURRENT_TIMESTAMP, CURRENT_TIMESTAMP, 'test3', 21, 0, 'test2@gmail.com', '1234', 'ROLE_USER', 'test2' );
insert into CATEGORYS (CREATEDAT, UPDATEDAT, CATEGORYCODE, CATEGORYNAME, DEPTH, ACTIVE) values ( CURRENT_TIMESTAMP, CURRENT_TIMESTAMP,  'C0001', '상의', 1, true);
insert into CATEGORYS (CREATEDAT, UPDATEDAT, CATEGORYCODE, CATEGORYNAME, DEPTH, ACTIVE) values ( CURRENT_TIMESTAMP, CURRENT_TIMESTAMP,  'C0002', '하의', 1, true);
insert into CATEGORYS (CREATEDAT, UPDATEDAT, CATEGORYCODE, CATEGORYNAME, DEPTH, ACTIVE) values ( CURRENT_TIMESTAMP, CURRENT_TIMESTAMP,  'C0003', '아우터',1, true);
insert into CATEGORYS (CREATEDAT, UPDATEDAT, CATEGORYCODE, CATEGORYNAME, DEPTH, ACTIVE) values ( CURRENT_TIMESTAMP, CURRENT_TIMESTAMP,  'C0004', '악세사리',1, true);


insert into PRODUCTS (CREATEDAT, UPDATEDAT, PRICE, PRODUCTNAME, PRODUCTSTATUS, PURCHASECOUNT, SELLERID, STOCKQUANTITY, THUMBNAIL, TOTALCOUNT) values ( CURRENT_TIMESTAMP, CURRENT_TIMESTAMP, 1000, 'product_name1', 1, 0, 1, 10, '', 0);