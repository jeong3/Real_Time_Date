create table member (
    member_num number ,
    member_name varchar2(50),
    member_id VARCHAR2(50),
    constraint member_num_pk primary key(member_num)
);
drop table member;
drop table board;
create table board(
    board_num number,
    board_writer VARCHAR2(100),
    board_subject VARCHAR2(100),
    board_contents VARCHAR2(2000),
    member_num number,
    constraint board_num_pk primary key(board_num),
    constraint member_num_fk foreign key(member_num) references member
);

insert into member(member_num, member_name, member_id)
values(1,'������', 'iks');

insert into board(board_num, board_writer, board_subject, board_contents, member_num)
values(10, '�۾���','����', '����', 1);
insert into board(board_num, board_writer, board_subject, board_contents, member_num)
values(20, '�۾���','����', '����', 1);

-- �θ� �����͸� ���� ������ �� ����.
delete from member
where member_num = 1;

delete from board
where member_num = 1;

select * from board where member_num = 1;

select * from member where member_num = 1;

 -- on delete cascade : �θ�����(member_num)�� ������ �� ���� ���� ��(���ӵ�)
create table board(
    board_num number,
    board_writer VARCHAR2(100),
    board_subject VARCHAR2(100),
    board_contents VARCHAR2(2000),
    member_num number,
    constraint board_num_pk primary key(board_num),
    constraint member_num_fk foreign key(member_num)
    references member on delete cascade 
);


create table member (
    member_num number ,
    member_name varchar2(50),
    member_id VARCHAR2(50),
    constraint member_num_pk primary key(member_num)
);

-- on delete set null : �θ�����(member_num)�� ������ �� �ڽĵ������� member_num�� null�� �ȴ�.
create table board(
    board_num number,
    board_writer VARCHAR2(100),
    board_subject VARCHAR2(100),
    board_contents VARCHAR2(2000),
    member_num number,
    constraint board_num_pk primary key(board_num),
    constraint member_num_fk foreign key(member_num)
    references member on delete set null 
);

desc board;


insert into member(member_num, member_name, member_id)
values(1,'������', 'iks');
select * from member;
insert into board(board_num, board_writer, board_subject, board_contents, member_num)
values(10, '�۾���','����', '����', 1);
insert into board(board_num, board_writer, board_subject, board_contents, member_num)
values(20, '�۾���','����', '����', 1);
select * from board;

delete from member;

-- check constraint 
create table employees_1(
    employee_id number(6),
    first_name VARCHAR2(30),
    last_name VARCHAR2(20),
    email VARCHAR2(50),
    salary number default 0,
    value1 number,
    value2 number,
    city VARCHAR2(50),
    gender char(1),
    constraint employee_id_pk primary key(employee_id),
    constraint salary_ck check(salary >=0),
    constraint val1_val2_ck check(value2 > value1),
    constraint city_ck check (city in('����','��õ','�λ�','�뱸','����')),
    constraint gender check (gender in('F','M'))
);
insert into employees_1(employee_id,first_name,last_name,email,salary)
values (1,'jw','j','iks',10000);
select * from employees_1;

insert into employees_1(employee_id,first_name,last_name,email,salary,value1,value2)
values (2,'jw','j','iks',10000,8,9);
select * from employees_1;

insert into employees_1(employee_id,first_name,last_name,email,salary,city)
values (3,'jw','j','iks',10000,'����');
select * from employees_1;

insert into employees_1(employee_id,first_name,last_name,email,salary,city,gender)
values (4,'jw','j','iks',10000,'����','M');
select * from employees_1;


--departments�� �����͸� ������ �� �÷���(�������) ������
drop table dept;
--(deptno, deptname, mngid,locid)
create table dept
(deptno, deptname, mngid,locid)
as
select * from departments; -- ��������
select * from dept;

drop table departments;
desc hr.departments;
create table departments(
    department_id number(4) not null,
    department_name VARCHAR2(30) not null,
    manager_id number(6)

);
insert into departments (department_id, department_name, manager_id)
values(100,'������', 200);
select * from departments;

--alter table ~ add (�߰��� ����) : ���̺� �߰�
alter table departments
add (location_id number(4)); -- �����Ͱ� ���̺�ȿ� �ִ� ���¸� not null�� �Ұ����ϴ�.

alter table departments
add (location_id number(4) not null); -- �����Ͱ� ���̺�ȿ� �ִ� ���¸� not null�� �Ұ����ϴ�.

select * from departments;

insert into departments (department_id, department_name, manager_id, location_id)
values(100,'������', 200, 1700 );

alter table departments -- alter : ���̺� ������ ������ �� ���
add ( manager_id number(6),
location_id number(4) not null);

-- alter : ���̺� ������ ������ �� ���
-- �� Į�� �߰�
-- ���� Į�� ���� ����
-- �� Į���� �⺻�� ����
-- Į�� ����
-- �̸� ����
-- ���� ���� �߰�
-- ���� ���� ����

insert into departments
values(1,'d',3,1700);


-- alter table ~ modify
-- ���̺� �ȿ� �����Ͱ� ���� �� ������ Ÿ���� ������ �� ����
alter table departments
modify(department_name number);

alter table departments
modify(manager_id varchar(20));

-- ���̺� �ȿ� �����Ͱ� ���� �� ������ Ÿ�� �ܿ��� ������ �� �ִ�.
alter table departments
modify(manager_id number(9,3)); 

alter table departments
modify(department_name varchar(1000));


drop table departments;

create table departments(
    department_id number(4),
    department_name varchar2(100),
    manager_id number(6),
    location_id number(4)
    );
alter table departments 
modify(department_name number); -- ���̺� �ȿ� �����Ͱ� ������ Ÿ�԰� ũ�� �� ��� ���氡��

drop table departments;

create table departments(
    department_id number(4),
    department_name varchar2(100),
    manager_id number(6)
    );
alter table departments
add(loc_id number(6) default 1700); -- Į���� �߰��� �� default���� �־��� �� �ִ�.

insert into departments(department_id, department_name, manager_id)
values(100,'������', 170);

select * from departments;

alter table departments -- ������ �ִ� Į���� default���� �־��� �� �ִ�.
modify manager_id default 120;

alter table departments -- alter table ~ rename column A(�����̸�) to B(������ �̸�) : Į���� �̸� ����
rename column loc_id to location_id;

alter table departments -- alter table ~ drop column : Į�� ���� (���Ϸθ� ����)
drop column location_id;

select * from departments;

desc departments;

alter table departments
modify department_id primary key; -- ������

-- �Ʒ��� ������� table�� �̸��� DEPARTMENTS�� ���̺��� constraints�� �� �� �ִ�.
select * from user_constraints where table_name = 'DEPARTMENTS'; -- �빮��

alter table departments
drop constraint SYS_C008480; -- constraint ����

alter table departments
modify department_id constraint department_id_pk primary key;

alter table departments
rename constraint DEPARTMENT_ID_PK to dept_id_pk;

alter table departments
drop constraint dept_id_pk;

alter table departments
add constraint dept_id_pk primary key(department_id); -- ���̺� ����

drop table board;
create table board(
    board_num number,
    board_writer VARCHAR2(30),
    board_subject VARCHAR2(100),
    board_content VARCHAR2(2000),
    read_count number,
    member_num number
);

alter table board -- alter table�� �������� �߰� - ��κ� primary key�� primary key���� foreign key�� foreign key���� �߰��Ѵ�.
add (constraint board_num_pk primary key(board_num)
, constraint member_num_fk foreign key(member_num)
references member(member_num));

create table A(
    A integer
);

create table B(
    B integer,
    A integer
);

create table C(
    C integer,
    B integer,
    A integer
);

create table D(
    D integer,
    A integer
);
alter table A
add constraint A_pk primary key(A);

insert into A(A) values(1);

alter table B
add constraint A_B_pk primary key(A,B); -- ���� �ĺ���

insert into B(A,B) values(1,1); -- a�� b�� ���� ���� ����ũ�ϴ�.
insert into B(A,B) values(1,2);

alter table C
add constraint A_B_C_pk primary key(A,B,C);

insert into C(A,B,C) values(1,1,3);
insert into C(A,B,C) values(1,2,3);
insert into C(A,B,C) values(5,5,3);

alter table D
add constraint D_pk primary key(D);

insert into D(A,D) values(1,4);
---------foreign key
alter table B
add constraint A_fk foreign key(A)
REFERENCES A(A) on delete cascade;

alter table C
add constraint A_B_fk foreign key(A,B)
REFERENCES B(A,B) on delete cascade;

alter table D
add constraint A_fk_D foreign key(A)
REFERENCES A(A) on delete set null;

select * from A;
select * from B;
select * from C;
select * from D;

delete from A;
drop table A;

select * from user_constraints where table_name = 'A';
select * from user_constraints where table_name = 'B';
select * from user_constraints where table_name = 'C';
select * from user_constraints where table_name = 'D';

-- ���̺� : �⺻ ���� �����̸� ������ �����Ǿ��ִ� (�����������̺� , �������� ��)

-- �� : �������� �κ� ������ �������� ��Ÿ���� (�������̺�)
create view emp_view_80
as
select * from employees where department_id = 80;

select * from emp_view_80;

create view emp_view_job
as
select * from employees where job_id ='SA_REP';

select * from emp_view_job;

create view empview80
as
select employee_id, salary, first_name, department_id from employees
where department_id = 80;

select * from empview80;

create view empview50
(empid, sal,email, jid)
as
select employee_id , salary, email, job_id from employees
where department_id = 50;

select * from empview50;
select * from empview50 where jid = 'SH_CLERK';
select * from empview50 where jid like '%CLERK%';

-- create or replace view ���̸� : �並 �����ϰų� ������ �� ����Ѵ�.
create or replace view empview50 
(empid, sal,email, jid, did)
as
select employee_id , salary, email, job_id, department_id from employees
where department_id = 50;

create or replace view empsal5000
as
select * from employees where salary >= 5000;

drop table departments;

create table departments
as
select * from hr.departments;

select * from employees;
-- �μ��� �ִ� ����� �μ����� �����ؼ� ���
select first_name , salary, d.department_id, department_name -- view�� join�� �����ϴ�.
from employees e join departments d
on e.department_id = d.department_id;








