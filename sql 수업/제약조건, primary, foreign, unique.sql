select * from board;

insert into board(board_num, user_Id, board_name, board_subject, board_content, board_date)
values (2, 'iks5567','오모먹','오늘점심에관하여','라김,국밥,음~',sysdate);

select max(board_num)+1 from board;

insert into board(board_num, user_Id, board_name, board_subject, board_content, board_date)
values ((select max(board_num)+1 from board), 'iks5567','오모먹','오늘점심에관하여','라김,국밥,음~',sysdate);

select * from board;

desc board;
-- 제약조건 : not null : null값이 아닌 값을 넣어줘야 한다. / primary key : 중복을 허용하지 않는다.
-- primary key는 테이블 내에 하나만 있을 수 있다.
drop table board;
create table board(
BOARD_NUM        NUMBER  not null primary key    ,  
USER_ID          VARCHAR2(10)  , 
BOARD_NAME       VARCHAR2(15) not null  ,
BOARD_SUBJECT    VARCHAR2(30)   not NULL,
BOARD_CONTENT    VARCHAR2(1000) ,
BOARD_DATE       DATE default sysdate,
READ_COUNT       NUMBER
);
insert into board (board_num)
values(1);
select * from board;

insert into board(board_num, user_Id, board_name, board_subject, board_content, board_date)
values (2, 'iks5567','오모먹','오늘점심에관하여','라김,국밥,음~',sysdate);

drop table board;
create table board(
BOARD_NUM        NUMBER primary key    ,  
USER_ID          VARCHAR2(10)  , 
BOARD_NAME       VARCHAR2(15) not null  ,
BOARD_SUBJECT    VARCHAR2(30)   not NULL,
BOARD_CONTENT    VARCHAR2(1000) ,
BOARD_DATE       DATE default sysdate,
READ_COUNT       NUMBER
);
desc board;
-- constraint_name은 제약조건이다.
-- constraint_type의 C는 not null P는 null을 의미
select * from dba_constraints
where table_name = 'BOARD';

select * from dba_cons_columns
where table_name = 'BOARD';

drop table board;
--  NUMBER constraint BOARD_NUM_PK primary key : constraint는 제약조건의 이름을 내가 정해줄 수 있다.
create table board( 
BOARD_NUM        NUMBER constraint BOARD_NUM_PK primary key    ,  -- 열 레벨
USER_ID          VARCHAR2(10)  , 
BOARD_NAME       VARCHAR2(15) not null  ,
BOARD_SUBJECT    VARCHAR2(30)   not NULL,
BOARD_CONTENT    VARCHAR2(1000) ,
BOARD_DATE       DATE default sysdate,
READ_COUNT       NUMBER
);

insert into board(board_num, user_Id, board_name, board_subject, board_content, board_date)
values (2, 'iks5567','오모먹','오늘점심에관하여','라김,국밥,음~',sysdate);

drop table member;

create table board( 
BOARD_NUM        NUMBER     , 
USER_ID          VARCHAR2(10)  , 
BOARD_NAME       VARCHAR2(15) not null  ,
BOARD_SUBJECT    VARCHAR2(30)   not NULL,
BOARD_CONTENT    VARCHAR2(1000) ,
BOARD_DATE       DATE default sysdate,
READ_COUNT       NUMBER,
constraint BOARD_NUM_PK primary key (BOARD_NUM) -- 테이블 레벨
);

-- 테이블 연결하기
create table member(
    member_num NUMBER,
    member_name VARCHAR2(20),
    member_id VARCHAR2(50),
    member_email VARCHAR2(100),
    member_phone varchar2(50),
    constraint member_num_pk primary key(member_num)
);
drop table board;
--references
create table board( 
BOARD_NUM        NUMBER     , 
USER_ID          VARCHAR2(10)  , 
BOARD_NAME       VARCHAR2(15) not null  ,
BOARD_SUBJECT    VARCHAR2(30)   not NULL,
BOARD_CONTENT    VARCHAR2(1000) ,
BOARD_DATE       DATE default sysdate,
READ_COUNT       NUMBER,
member_num       NUMBER,
constraint BOARD_NUM_PK primary key (BOARD_NUM),
CONSTRAINT member_num_FK FOREIGN key (member_num) -- ******테이블레벨!!******
references member(member_num)
);
-- 다른 테이블에서 가져온 컬럼은 foreign key를 사용해서 가져오고 다른 테이블의 이름을 references를 통해서 가져온다.
desc member;
desc board;

select * from member;
select * from board;

insert into member (member_num, member_name, member_id, member_email, member_phone)
values(100,'정지원', 'iks5567', 'iks5567@naver.com', '010-3911-2494');

insert into board (board_num, board_name, board_subject,member_num)
values(1,'정지원', '제목1',100);

select member_name, member_email
    , board_subject, board_date 
    from member m join board b
    on m.member_num = b.member_num;
    
select first_name, last_name, salary, hire_date 
    , d.department_id, department_name
    from hr.employees e join hr.departments d
    on e.department_id = d.department_id;

select * from hr.departments;
-- jobs의 job_id : primary key  -> employees의 job_id : foreign key
-- departments의 department_id : primary key -> employees의 department_id : foreign key


-- join은 같은 값끼리의 비교이다.
-- join은 무조건 primary key와 foreign key의 관계만 연결하는게 아니라 
-- foreign key와 foreign key간의 관계를 연결할 수 있다.
-- employees의 manager_id와 departmnets의 manager_id 

drop table board;
create table board( 
BOARD_NUM        NUMBER     , 
USER_ID          VARCHAR2(10)  , 
BOARD_NAME       VARCHAR2(15) not null  ,
BOARD_SUBJECT    VARCHAR2(30)   not NULL,
BOARD_CONTENT    VARCHAR2(1000) ,
BOARD_DATE       DATE default sysdate,
READ_COUNT       NUMBER,
member_num       NUMBER constraint member_num_FK references member(member_num), 
constraint BOARD_NUM_PK primary key (BOARD_NUM)
);

-- 열레벨
drop table member;
create table member(
    member_num NUMBER,
    member_name VARCHAR2(20),
    member_id VARCHAR2(50) constraint member_id_UK unique, -- unique key : primary key는 아니지만 중복 허용을 하지 않는다.
    member_email VARCHAR2(100) constraint member_email_UK unique,
    member_phone varchar2(50) constraint member_phone_UK unique,
    constraint member_num_pk primary key(member_num)
);
-- 테이블레벨
create table member(
    member_num NUMBER,
    member_name VARCHAR2(20),
    member_id VARCHAR2(50) ,
    member_email VARCHAR2(100) , 
    member_phone varchar2(50) ,
    constraint member_num_pk primary key(member_num),
    constraint member_id_uk unique(member_id),
    constraint member_email_uk unique(member_email),
    constraint member_phone_uk unique(member_phone)
);

insert into member 
values(1,'정지원','iks5567','iks5567@naver.com','010-3911-2494');
insert into member 
values(2,'정지원','wldnjs0120','wldnjs@naver.com','010-3911-2496');
insert into member 
values(4,'정지원', null ,null,null);

-- primary key : 테이블에 한개만 가능
-- not null (null값을 허용하지 않는다.)
-- 중복 데이터 허용하지 않는다
-- 레코드를 유일하게 구별하기 위한 컬럼으로 사용

-- foreign key : 다른 테이블(부모 테이블)로 부터 현재 테이블(자식 테이블)로 전이된 칼럼
-- 다른 테이블(부모 테이블)의 primary key 컬럼이 전이된다.
-- 자식 테이블이 삭제 되야 부모테이블이 삭제된다 <=> 부모테이블이 먼저 생성되야 자식테이블을 생성할 수 있다.
-- 부모테이블에 데이터가 있어야 자식 테이블에 데이터가 저장된다. 

-- unique : 컬럼의 데이터를 유일하게 관리한다 (중복을 허용하지 않는다)
-- null값을 허용한다.
-- 한테이블에 여러 개의 키를 넣을 수 있다.













