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
);
