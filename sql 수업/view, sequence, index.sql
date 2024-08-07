-- dml : insert, select, update, delete : crud : ������
-- ddl : cteate, alter, drop : ��Ű�� : ���̺�, ��, index : object
-- tcl : commit, rollback, savepoint

drop table departments;
drop table employees;

create table departments
as
select * from hr.departments;

create table employees
as
select * from hr.employees;

-- view
-- ���, �̸�, ����, �޿�, �Ի���, Ŀ�̼��� ������ ���� year_sal
-- ������ 'REP'�� ���Ե� ����鸸 ���
select employee_id, first_name, job_id, salary, hire_date, salary*12*(1+nvl(commission_pct,0)) as year_sal
from employees
where job_id like '%REP%';

create view rep_view
as
select employee_id, first_name, job_id, salary, hire_date, salary*12*(1+nvl(commission_pct,0)) as year_sal
from employees
where job_id like '%REP%';

select * from rep_view;

create or replace view rep_view
as
select employee_id, first_name, job_id, salary, hire_date, salary*12*(1+nvl(commission_pct,0)) as year_sal
from employees
where job_id like '%REP%';

create or replace view vw_80
as
select * from employees
where department_id = 80; -- 80�κμ��� ���� ������ �ٸ������͸� ���� �����ϴ�

select * from vw_80;

create or replace view vw_emp
as
select employee_id, first_name, last_name, job_id, department_id
from employees;

select * from vw_emp;

create or replace view vw_emp
(eid, fname, lname, jid, did)
as
select employee_id , first_name, last_name, job_id, department_id
from employees;

select * from vw_emp;

-- �� �μ��� �޿��� �հ�, �ּ� �޿�, �ִ� �޿�, �޿��� ���, �μ��� ������� ����ϼ���
select department_id, sum(salary), min(salary), max(salary), avg(salary), count(*)
from employees
group by department_id;

create or replace view group_d
(did, sum_sal, min_sal, max_sal, avg_sal, count_emp)
as
select department_id, sum(salary), min(salary), max(salary), avg(salary), count(*)
from employees
group by department_id;

select * from group_d;

create or replace view vw_80
as
select * from employees
where department_id = 80;

select * from vw_80;

insert into vw_80 -- �信���� ������ ������ insert�� �����ϴ� (employees ���̺� insert��)
values (210,'����','��','iks5567','010-3911-2498', sysdate,'PR_REP',20000,null,null,110);

select * from vw_80;
select * from employees;

delete from vw_80 -- ���� ��ɾ ������ ������ ������ �ʴ� �����ʹ� ������ �� ����.
where employee_id = 210;

delete from vw_80 -- �����ȣ�� 149�� ������ ������ ���̴� �������̹Ƿ� ������ �����ϴ�. 
where employee_id = 149;

-- �μ��� 50�� ����� �����ȣ, ��, �̸���, �Ի���, ������ ���̴� �並 ���弼�� ����� emp50vw
create or replace view emp50vw
as
select employee_id, last_name, email, hire_date, job_id from employees
where department_id = 50;

select * from emp50vw;

insert into emp50vw -- ������ �ʴ� Į������ ���� ���� �� ����. 
values (300,'��','iks',sysdate, 'ST_MAN', 100);

update emp50vw 
set salary = 10000
where employee_id = 120;

-- ���̴� Į������ ���� ������Ʈ �� �� �ִ�
update emp50vw 
set email = 'asd'
where employee_id = 205;

-- insert�� �並 ���� ������ �ʴ� �����͵� ���̺��� ������ �����ϴ�.
-- update�� delete�� �������� �����Ϳ� ���ؼ��� �����ϴ�.

-- �μ���ȣ, �μ���, ���, �̸�, �޿�
create or replace view dep_emp_vw -- ���� ��
as
select e.department_id, department_name, employee_id, first_name, salary
from employees e join departments d
on e.department_id = d.department_id;

select * from dep_emp_vw;

update dep_emp_vw 
set salary = 100
where employee_id = 100;

create table viewupd1(
    c1 number,
    c2 int
    );
    
create table viewupd2(
    c1 number,
    c3 number
);
insert into viewupd1 values(1,1);
insert into viewupd2 values(1,1);

select v1.c1,c2,c3 from viewupd1 v1 join viewupd2 v2
on v1.c1 = v2.c1;

create or replace view v_viewupd
as
select v1.c1,c2,c3 from viewupd1 v1 join viewupd2 v2
on v1.c1 = v2.c1;

select * from v_viewupd;

update v_viewupd -- ���ÿ� �� �� �̻��� ���̺��� �����͸� ������ �� ����.
set c2 = 10, c3 = 20
where c1 = 1;

update v_viewupd -- ���պ�� �ϳ��� ���̺��� �����͸� �����ϴ� ��쿡�� ������ �ȴ�. ������ ��������
set c2 = 10
where c1 = 1;

create or replace view empvu10
as
select employee_id, last_name, email, hire_date, job_id ,department_id 
from employees
where department_id = 10;

select * from empvu10;

insert into empvu10
values(300,'s','ema',sysdate,'job',10);

create or replace view empvu10
as
select employee_id, last_name, email, hire_date, job_id ,department_id 
from employees
where department_id = 10
with read only; -- with read only : �б� ���� ��� dml �۾��� ������ �� ����

-- �信 ���̴� �͸� dml�� �� �� �ֵ��� �ϱ�
create or replace view empvu10
as
select employee_id, last_name, email, hire_date, job_id ,department_id 
from employees
where department_id = 10
with check option; -- with check option : ���̴� Į���� �����Ϳ��� dml�� �� �� �ִ�.

insert into empvu10
values(300,'s','ema',sysdate,'job',20); -- �並 ������ �� department_id�� 10�� �������̹Ƿ� ���� insert ���� �ʴ´�.

select * from empvu10;

create or replace view empvu10
as
select employee_id, last_name, email, hire_date, job_id ,department_id 
from employees
where department_id = 10
with check option CONSTRAINT empvu10_ck; -- with read only, with check option�� ���������̱� ������ ���������� �̸��� constraint�� ���� ������ �� �ִ�.

-- ������ 
drop table goods;
create table goods(
    goods_num VARCHAR2(20),
    goods_name VARCHAR2(100),
    goods_price number
    );


-- sequence 
--create sequence seq_num
--increment by 10 : 10�� �����Ѵ�. �������� �� �⺻�� : 1
--start with 10 : ��������, �⺻�� : 1
--maxvalue 9990 : �ִ�����, �⺻�� :999,999
--cycle : �ٽ� start�� �ο��� �������� ���ư���.
--cache; : �޸� �����Ѵ�.


create sequence seq_num;

create sequence seq_num
start with 10 ;

create sequence seq_num -- sequence : ���� ���̺��� �����ϴ� ���� ���ֱ� ���� ����Ѵ�
increment by 10
start with 10 ;

select seq_num.nextval -- increment by�� �������� ������ ��� �����Ѵ�.
from dual;

select seq_num.currval
from dual;

insert into goods (goods_num, goods_name, goods_price)
values ('miso_10000', 'û����', 1000);

insert into goods (goods_num, goods_name, goods_price)
values (concat('miso_',10000+seq_num.nextval), '�����', 2000);
select * from goods;

select * from goods;

desc board;
drop table board;

-- ���̺� ������ �� ������ �߰� generated always as identity(start with 1 increment by 1) / ���� ���� ���� ���� �־����� ������ �⺻���� 1�� �ȴ�.
create table board(
BOARD_NUM      NUMBER generated always as identity(start with 1 increment by 1),          
BOARD_NAME     VARCHAR2(20),   
BOARD_SUBJECT  VARCHAR2(100),  
BOARD_CONTENT  VARCHAR2(2000), 
READ_COUNT     NUMBER
);

insert into board ( BOARD_NAME, BOARD_SUBJECT, BOARD_CONTENT, READ_COUNT)
values ( '�۾���', '����','����',0);

select * from board;

alter sequence seq_num -- �������� alter�� �߰�, ������ ���� start with(���� ��)�� �� �� ����.
increment by 1
maxvalue 9999;

drop sequence seq_num;

-- seq_num.currval�� seq_num�� ���� �޾ƿ� ��, seq_num.nextval�� seq_num���� ������ų �� ����Ѵ�.
select seq_num.currval, seq_num.nextval
from dual;

drop table goods;
-- goods_num �� 10001���� 1�� �����ϴ� ���� �ο� ���ָ鼭 ��ǰ ������ �Է��ϰ�ʹ�.
-- sequence�� ������� �ʴ´�
-- miso_10001 => miso_10002 ... �ڵ����� ���� �ؾ� �Ѵ�.
insert into goods (goods_num, goods_name, goods_price)
values ( 'miso_',10000+seq_num.nextval, '�����', 2000);
select * from goods;

create table goods(
    goods_num number generated always as identity, 
    goods_name varchar2(100),
    goods_price number
);

select concat('miso_1000',goods_num) as goods_num, goods_name, goods_price from goods;

insert into goods1 (goods_name, goods_price)
values ('�����',2000);

create table goods1(
    goods_num varchar2(20) ,
    goods_name varchar2(100),
    goods_price number
);

select concat('miso_',nvl(max(substr(goods_num,6)),10000) + 1) from goods1;

select * from goods1;
delete goods1;
insert into goods1 (goods_num,goods_name, goods_price)
values ((select concat('miso_',nvl(max(substr(goods_num,6)),10000) + 1) from goods1),'�����',2000);

-- index
create index idx_did
on departments(department_id);

select * from departments
where department_id = 90;

select employee_id, first_name, salary, job_id, department_id from employees
where job_id like '%REP%';

create index job_idx
on employees(job_id);

-- �̸��� �տ��� �� ���ڰ� 'Oc'�� ������ ����Ͻÿ�
select * from employees
where substr(first_name,1,2) = 'Oc';

create index name_idx -- �Լ������ �ε���
on employees(substr(first_name,1,2));

-- �� �μ��� �޿��� ����� 10000�� �μ��� ��ձ޿��� ����Ͻÿ�
select department_id, avg(salary) from employees
group by department_id
having avg(salary) = 10000; 

create index avgsal -- �׷��Լ��� index�� ���� �� ����.
on employees(avg(salary));

select * from user_tables;
select * from user_indexes where table_name= 'EMPLOYEES';

-- �� �μ��� �ִ� �޿��� �ش��ϴ� ����� ������ �̸�, �޿�, ����, �Ի���, �ִ�޿�, �μ��� ����Ͻÿ�
select first_name, salary, job_id, hire_date,  department_id from employees;

select department_id , max(salary) from employees
group by department_id;

-- 
select first_name, salary, job_id, hire_date,  e2.department_id , max_sal
from employees e1 join (select department_id , max(salary) max_sal from employees -- �� ������������ inline view��� �Ѵ�.
group by department_id) e2
on e1.department_id = e2.department_id
where max_sal = 17000;

-- ���, �̸�, �޿�, �μ�, �� �μ��� ��� �޿��� ����� �� ��� �޿����� ���� �޴� ������� ���
select department_id, avg(salary)
from employees
group by department_id;

select employee_id, first_name, salary
from employees e1 join (select department_id, avg(salary) as avg_sal
from employees
group by department_id) e2 
on e1.department_id = e2.department_id
where salary >= avg_sal;

-- ������ȣ�� 1700�� �ش��ϴ� �μ��� �μ���� �� �μ����� �ٹ��ϴ� ����� �����ȣ, �̸�, �޿��� ���
select d.department_id, department_name, employee_id, first_name, salary
from employees e join departments d
on e.department_id = d.department_id
where location_id = 1700;

select d.department_id, department_name, employee_id, first_name, salary
from employees e join (select department_id, department_name from departments
                        where location_id = 1700) d
on e.department_id = d.department_id;

-- ����� ��ȣ, �̸�, �޿�, 80�� �μ�
select employee_id, first_name, salary 
from employees 
where department_id = 80;

select * from (select employee_id, first_name, salary 
from employees 
where department_id = 80);
    






