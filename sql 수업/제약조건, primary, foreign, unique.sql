select * from board;

insert into board(board_num, user_Id, board_name, board_subject, board_content, board_date)
values (2, 'iks5567','�����','�������ɿ����Ͽ�','���,����,��~',sysdate);

select max(board_num)+1 from board;

insert into board(board_num, user_Id, board_name, board_subject, board_content, board_date)
values ((select max(board_num)+1 from board), 'iks5567','�����','�������ɿ����Ͽ�','���,����,��~',sysdate);

select * from board;

desc board;
-- �������� : not null : null���� �ƴ� ���� �־���� �Ѵ�. / primary key : �ߺ��� ������� �ʴ´�.
-- primary key�� ���̺� ���� �ϳ��� ���� �� �ִ�.
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
values (2, 'iks5567','�����','�������ɿ����Ͽ�','���,����,��~',sysdate);

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
-- constraint_name�� ���������̴�.
-- constraint_type�� C�� not null P�� null�� �ǹ�
select * from dba_constraints
where table_name = 'BOARD';

select * from dba_cons_columns
where table_name = 'BOARD';

drop table board;
--  NUMBER constraint BOARD_NUM_PK primary key : constraint�� ���������� �̸��� ���� ������ �� �ִ�.
create table board( 
BOARD_NUM        NUMBER constraint BOARD_NUM_PK primary key    ,  -- �� ����
USER_ID          VARCHAR2(10)  , 
BOARD_NAME       VARCHAR2(15) not null  ,
BOARD_SUBJECT    VARCHAR2(30)   not NULL,
BOARD_CONTENT    VARCHAR2(1000) ,
BOARD_DATE       DATE default sysdate,
READ_COUNT       NUMBER
);

insert into board(board_num, user_Id, board_name, board_subject, board_content, board_date)
values (2, 'iks5567','�����','�������ɿ����Ͽ�','���,����,��~',sysdate);

drop table member;

create table board( 
BOARD_NUM        NUMBER     , 
USER_ID          VARCHAR2(10)  , 
BOARD_NAME       VARCHAR2(15) not null  ,
BOARD_SUBJECT    VARCHAR2(30)   not NULL,
BOARD_CONTENT    VARCHAR2(1000) ,
BOARD_DATE       DATE default sysdate,
READ_COUNT       NUMBER,
constraint BOARD_NUM_PK primary key (BOARD_NUM) -- ���̺� ����
);

-- ���̺� �����ϱ�
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
CONSTRAINT member_num_FK FOREIGN key (member_num) -- ******���̺���!!******
references member(member_num)
);
-- �ٸ� ���̺��� ������ �÷��� foreign key�� ����ؼ� �������� �ٸ� ���̺��� �̸��� references�� ���ؼ� �����´�.
desc member;
desc board;

select * from member;
select * from board;

insert into member (member_num, member_name, member_id, member_email, member_phone)
values(100,'������', 'iks5567', 'iks5567@naver.com', '010-3911-2494');

insert into board (board_num, board_name, board_subject,member_num)
values(1,'������', '����1',100);

select member_name, member_email
    , board_subject, board_date 
    from member m join board b
    on m.member_num = b.member_num;
    
select first_name, last_name, salary, hire_date 
    , d.department_id, department_name
    from hr.employees e join hr.departments d
    on e.department_id = d.department_id;

select * from hr.departments;
-- jobs�� job_id : primary key  -> employees�� job_id : foreign key
-- departments�� department_id : primary key -> employees�� department_id : foreign key


-- join�� ���� �������� ���̴�.
-- join�� ������ primary key�� foreign key�� ���踸 �����ϴ°� �ƴ϶� 
-- foreign key�� foreign key���� ���踦 ������ �� �ִ�.
-- employees�� manager_id�� departmnets�� manager_id 

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

-- ������
drop table member;
create table member(
    member_num NUMBER,
    member_name VARCHAR2(20),
    member_id VARCHAR2(50) constraint member_id_UK unique, -- unique key : primary key�� �ƴ����� �ߺ� ����� ���� �ʴ´�.
    member_email VARCHAR2(100) constraint member_email_UK unique,
    member_phone varchar2(50) constraint member_phone_UK unique,
    constraint member_num_pk primary key(member_num)
);
-- ���̺���
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
values(1,'������','iks5567','iks5567@naver.com','010-3911-2494');
insert into member 
values(2,'������','wldnjs0120','wldnjs@naver.com','010-3911-2496');
insert into member 
values(4,'������', null ,null,null);

-- primary key : ���̺� �Ѱ��� ����
-- not null (null���� ������� �ʴ´�.)
-- �ߺ� ������ ������� �ʴ´�
-- ���ڵ带 �����ϰ� �����ϱ� ���� �÷����� ���

-- foreign key : �ٸ� ���̺�(�θ� ���̺�)�� ���� ���� ���̺�(�ڽ� ���̺�)�� ���̵� Į��
-- �ٸ� ���̺�(�θ� ���̺�)�� primary key �÷��� ���̵ȴ�.
-- �ڽ� ���̺��� ���� �Ǿ� �θ����̺��� �����ȴ� <=> �θ����̺��� ���� �����Ǿ� �ڽ����̺��� ������ �� �ִ�.
-- �θ����̺� �����Ͱ� �־�� �ڽ� ���̺� �����Ͱ� ����ȴ�. 

-- unique : �÷��� �����͸� �����ϰ� �����Ѵ� (�ߺ��� ������� �ʴ´�)
-- null���� ����Ѵ�.
-- �����̺� ���� ���� Ű�� ���� �� �ִ�.













