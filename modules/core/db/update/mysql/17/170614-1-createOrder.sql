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
);
