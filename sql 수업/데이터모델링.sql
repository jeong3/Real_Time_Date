drop table publisher;
create table publisher (
    publisher_num VARCHAR2(14) not null,
    publisher_name VARCHAR2(50),
    publisher_tel VARCHAR2(30),
    publisher_addr VARCHAR2(255),
    bank_code VARCHAR2(13),
    account_num VARCHAR2(13)

);

create table contract (
    contract_num VARCHAR2(14) not null,
    publisher_num VARCHAR2(14) not null,
    contract_tel VARCHAR2(30),
    contract_date date,
    contract_text VARCHAR2(2000),
    min_rate NUMBER(4,2)
);

create table contract_book (
    contract_num VARCHAR2(14) not null,
    book_num VARCHAR2(13) not null
);

create table purchase(
    purchase_num VARCHAR2(14) not null,
    member_num VARCHAR2(14),
    purchase_date date,
    deli_addr VARCHAR2(255),
    deli_tel VARCHAR2(30),
    pay_method VARCHAR2(255),
    total_price INTEGER
);

create table purchase_book(
    purchase_num VARCHAR2(14) not null,
    book_num VARCHAR2(14) not null,
    purchase_price INTEGER,
    purchase_qty INTEGER
);

create table books(
    book_num VARCHAR2(14) not null,
    book_name VARCHAR2(50),
    book_category VARCHAR2(100),
    author VARCHAR2(50),
    book_date date
);

create table storage(
    book_num VARCHAR2(14) not null,
    inventory INTEGER
);

create table check_book(
    member_num VARCHAR2(14) not null,
    book_num VARCHAR2(14) not null,
    check_date date

);

create table members(
    member_num VARCHAR2(14) not null,
    member_name VARCHAR2(50),
    member_addr VARCHAR2(255),
    member_tel VARCHAR2(30),
    member_point integer
);

create table offer(
    purchase_num VARCHAR2(14) not null,
    delivery_num VARCHAR2(14),
    invoice VARCHAR2(14)

);

create table delivery(
    delivery_num VARCHAR2(14) not null,
    delivery_name VARCHAR2(50),
    delivery_tel VARCHAR2(30)
);

create table indirect(
    delivery_num VARCHAR2(14) not null,
    subway_num VARCHAR2(14),
    subway_loc integer
);

create table direct(
    delivery_num VARCHAR2(14) not null,
    delivery_addr VARCHAR2(255)
);

create table accounts (
    abjustment_num VARCHAR2(14) not null,
    delivery_num VARCHAR2(14),
    abjustment_prive integer,
    abjustment_date date
);

-- primary key
alter table publisher
add constraint publisher_num_pk primary key(publisher_num);

alter table contract
modify contract_num constraint contract_num_pk primary key;

alter table contract
drop constraint contract_num_pk;

alter table contract
add constraint contract_num_pk primary key(contract_num);

alter table contract_book -- 하나의 테이블에 같은 두개의 속성이 있다면 테이블레벨로만 가능하다
add constraint contract_book_pk primary key(contract_num, book_num); 

alter table purchase
add constraint purchase_num_pk primary key(purchase_num);

alter table purchase_book
add constraint purchase_book_pk primary key(purchase_num, book_num);

alter table books
add constraint book_num_pk primary key(book_num);

alter table offer
add constraint offer_pk primary key(purchase_num);

alter table members
add constraint member_num_pk primary key(member_num);

alter table storage
add constraint storage_pk primary key(book_num);

alter table delivery
add constraint delivery_pk primary key(delivery_num);

alter table accounts
add constraint abjustment_num_pk primary key(abjustment_num);

alter table check_book
add constraint check_book_pk primary key(member_num, book_num);

alter table indirect
add constraint indrect_pk primary key(delivery_num);

alter table direct
add constraint drect_pk primary key(delivery_num);

-- foreign key
alter table contract
add constraint publisher_num_fk foreign key(publisher_num)
references publisher;

alter table contract_book
add (constraint contract_num_fk foreign key(contract_num)
references contract(contract_num),
constraint book_num_fk foreign key(book_num)
references books(book_num)); 

alter table purchase
add constraint member_num_fk foreign key(member_num)
references members(member_num);

alter table purchase_book
add (constraint purchase_num_fk foreign key(purchase_num)
references purchase(purchase_num),
constraint purchase_book_num_fk foreign key(book_num)
references storage(book_num));

alter table offer
add (constraint offer_purchase_num_fk foreign key(purchase_num)
references purchase(purchase_num),
constraint offer_delivery_num_fk foreign key(delivery_num)
references delivery(delivery_num) );

alter table storage
add constraint storage_fk foreign key(book_num)
references books;

alter table check_book
add (constraint check_book_member_num_fk foreign key(member_num)
REFERENCES members);
alter table check_book
add constraint check_book_book_num_fk foreign key(book_num)
REFERENCES storage (book_num)  ;

alter table accounts
add constraint account_delivery_num_fk foreign key(delivery_num)
references delivery;

alter table indirect
add constraint indirect_delivery_num_fk foreign key(delivery_num)
references delivery;

alter table direct
add constraint direct_delivery_num_fk foreign key(delivery_num)
references delivery;


commit;












    