create table SALES_CUSTOMER_FILE_DESCRIPTOR_LINK (
    CUSTOMER_ID varchar(36) not null,
    FILE_DESCRIPTOR_ID varchar(36) not null,
    primary key (CUSTOMER_ID, FILE_DESCRIPTOR_ID)
);
