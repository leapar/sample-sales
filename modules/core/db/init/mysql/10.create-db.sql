-- begin SALES_CUSTOMER
create table SALES_CUSTOMER (
    ID varchar(32),
    VERSION integer not null,
    CREATE_TS datetime(3),
    CREATED_BY varchar(50),
    UPDATE_TS datetime(3),
    UPDATED_BY varchar(50),
    DELETE_TS datetime(3),
    DELETED_BY varchar(50),
    --
    NAME varchar(100) not null,
    EMAIL varchar(100),
    --
    primary key (ID)
)^
-- end SALES_CUSTOMER
-- begin SALES_ORDER
create table SALES_ORDER (
    ID varchar(32),
    VERSION integer not null,
    CREATE_TS datetime(3),
    CREATED_BY varchar(50),
    UPDATE_TS datetime(3),
    UPDATED_BY varchar(50),
    DELETE_TS datetime(3),
    DELETED_BY varchar(50),
    --
    DATE_ datetime(3) not null,
    AMOUNT decimal(19, 2),
    CUSTOMER_ID varchar(32),
    --
    primary key (ID)
)^
-- end SALES_ORDER
-- begin SALES_PRODUCT
create table SALES_PRODUCT (
    ID varchar(32),
    VERSION integer not null,
    CREATE_TS datetime(3),
    CREATED_BY varchar(50),
    UPDATE_TS datetime(3),
    UPDATED_BY varchar(50),
    DELETE_TS datetime(3),
    DELETED_BY varchar(50),
    --
    NAME varchar(50) not null,
    PRICE decimal(19, 2) not null,
    --
    primary key (ID)
)^
-- end SALES_PRODUCT
-- begin SALES_ORDER_LINE
create table SALES_ORDER_LINE (
    ID varchar(32),
    VERSION integer not null,
    CREATE_TS datetime(3),
    CREATED_BY varchar(50),
    UPDATE_TS datetime(3),
    UPDATED_BY varchar(50),
    DELETE_TS datetime(3),
    DELETED_BY varchar(50),
    --
    PRODUCT_ID varchar(32) not null,
    QUANTITY decimal(19, 3) not null,
    ORDER_ID varchar(32),
    --
    primary key (ID)
)^
-- end SALES_ORDER_LINE
-- begin SALES_CUSTOMER_FILE_DESCRIPTOR_LINK
create table SALES_CUSTOMER_FILE_DESCRIPTOR_LINK (
    CUSTOMER_ID varchar(32),
    FILE_DESCRIPTOR_ID varchar(32),
    primary key (CUSTOMER_ID, FILE_DESCRIPTOR_ID)
)^
-- end SALES_CUSTOMER_FILE_DESCRIPTOR_LINK
