create table SALES_CUSTOMER_FILE_DESCRIPTOR_LINK (
    CUSTOMER_ID varchar(32),
    FILE_DESCRIPTOR_ID varchar(32),
    primary key (CUSTOMER_ID, FILE_DESCRIPTOR_ID)
);