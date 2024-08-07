-- dml : insert, select, update, delete : crud : 데이터
-- ddl : cteate, alter, drop : 스키마 : 테이블, 뷰, index : object
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
-- 사번, 이름, 직무, 급여, 입사일, 커미션을 포함한 연봉 year_sal
-- 직무에 'REP'가 포함된 사원들만 출력
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
where department_id = 80; -- 80인부서만 보기 때문에 다른데이터를 은닉 가능하다

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

-- 각 부서의 급여의 합계, 최소 급여, 최대 급여, 급여의 평균, 부서의 사원수를 출력하세요
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

insert into vw_80 -- 뷰에서는 보이지 않지만 insert는 가능하다 (employees 테이블에 insert됨)
values (210,'지원','정','iks5567','010-3911-2498', sysdate,'PR_REP',20000,null,null,110);

select * from vw_80;
select * from employees;

delete from vw_80 -- 삭제 명령어가 실행은 되지만 보이지 않는 데이터는 삭제할 수 없다.
where employee_id = 210;

delete from vw_80 -- 사원번호가 149인 직원의 정보는 보이는 데이터이므로 삭제가 가능하다. 
where employee_id = 149;

-- 부서가 50인 사원의 사원번호, 성, 이메일, 입사일, 직무가 보이는 뷰를 만드세요 뷰명은 emp50vw
create or replace view emp50vw
as
select employee_id, last_name, email, hire_date, job_id from employees
where department_id = 50;

select * from emp50vw;

insert into emp50vw -- 보이지 않는 칼럼에만 값을 넣을 수 없다. 
values (300,'정','iks',sysdate, 'ST_MAN', 100);

update emp50vw 
set salary = 10000
where employee_id = 120;

-- 보이는 칼럼에만 값을 업데이트 할 수 있다
update emp50vw 
set email = 'asd'
where employee_id = 205;

-- insert는 뷰를 통해 보이지 않는 데이터도 테이블내에 저장이 가능하다.
-- update와 delete는 보여지는 데이터에 대해서만 가능하다.

-- 부서번호, 부서명, 사번, 이름, 급여
create or replace view dep_emp_vw -- 복합 뷰
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

update v_viewupd -- 동시에 두 개 이상의 테이블의 데이터를 수정할 수 없다.
set c2 = 10, c3 = 20
where c1 = 1;

update v_viewupd -- 복합뷰라도 하나의 테이블의 데이터를 수정하는 경우에는 수정이 된다. 삭제도 마찬가지
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
with read only; -- with read only : 읽기 전용 뷰로 dml 작업을 수행할 수 없다

-- 뷰에 보이는 것만 dml을 할 수 있도록 하기
create or replace view empvu10
as
select employee_id, last_name, email, hire_date, job_id ,department_id 
from employees
where department_id = 10
with check option; -- with check option : 보이는 칼럼의 데이터에만 dml을 할 수 있다.

insert into empvu10
values(300,'s','ema',sysdate,'job',20); -- 뷰를 생성할 때 department_id가 10인 데이터이므로 값이 insert 되지 않는다.

select * from empvu10;

create or replace view empvu10
as
select employee_id, last_name, email, hire_date, job_id ,department_id 
from employees
where department_id = 10
with check option CONSTRAINT empvu10_ck; -- with read only, with check option도 제약조건이기 때문에 제약조건의 이름을 constraint를 통해 변경할 수 있다.

-- 시퀀스 
drop table goods;
create table goods(
    goods_num VARCHAR2(20),
    goods_name VARCHAR2(100),
    goods_price number
    );


-- sequence 
--create sequence seq_num
--increment by 10 : 10씩 증가한다. 안적었을 때 기본값 : 1
--start with 10 : 시작지점, 기본값 : 1
--maxvalue 9990 : 최대지점, 기본값 :999,999
--cycle : 다시 start에 부여한 시점으로 돌아간다.
--cache; : 메모리 저장한다.


create sequence seq_num;

create sequence seq_num
start with 10 ;

create sequence seq_num -- sequence : 여러 테이블에서 증가하는 값을 해주기 위해 사용한다
increment by 10
start with 10 ;

select seq_num.nextval -- increment by로 증가값을 지정한 대로 증가한다.
from dual;

select seq_num.currval
from dual;

insert into goods (goods_num, goods_name, goods_price)
values ('miso_10000', '청바지', 1000);

insert into goods (goods_num, goods_name, goods_price)
values (concat('miso_',10000+seq_num.nextval), '냉장고', 2000);
select * from goods;

select * from goods;

desc board;
drop table board;

-- 테이블 생성할 때 증가값 추가 generated always as identity(start with 1 increment by 1) / 시작 값과 증가 값을 넣어주지 않으면 기본값인 1로 된다.
create table board(
BOARD_NUM      NUMBER generated always as identity(start with 1 increment by 1),          
BOARD_NAME     VARCHAR2(20),   
BOARD_SUBJECT  VARCHAR2(100),  
BOARD_CONTENT  VARCHAR2(2000), 
READ_COUNT     NUMBER
);

insert into board ( BOARD_NAME, BOARD_SUBJECT, BOARD_CONTENT, READ_COUNT)
values ( '글쓴이', '제목','내용',0);

select * from board;

alter sequence seq_num -- 시퀀스를 alter로 추가, 수정할 때는 start with(시작 값)을 할 수 없다.
increment by 1
maxvalue 9999;

drop sequence seq_num;

-- seq_num.currval는 seq_num의 값을 받아올 때, seq_num.nextval는 seq_num값을 증가시킬 때 사용한다.
select seq_num.currval, seq_num.nextval
from dual;

drop table goods;
-- goods_num 을 10001부터 1씩 증가하는 값을 부여 해주면서 상품 정보를 입력하고싶다.
-- sequence는 사용하지 않는다
-- miso_10001 => miso_10002 ... 자동으로 증가 해야 한다.
insert into goods (goods_num, goods_name, goods_price)
values ( 'miso_',10000+seq_num.nextval, '냉장고', 2000);
select * from goods;

create table goods(
    goods_num number generated always as identity, 
    goods_name varchar2(100),
    goods_price number
);

select concat('miso_1000',goods_num) as goods_num, goods_name, goods_price from goods;

insert into goods1 (goods_name, goods_price)
values ('냉장고',2000);

create table goods1(
    goods_num varchar2(20) ,
    goods_name varchar2(100),
    goods_price number
);

select concat('miso_',nvl(max(substr(goods_num,6)),10000) + 1) from goods1;

select * from goods1;
delete goods1;
insert into goods1 (goods_num,goods_name, goods_price)
values ((select concat('miso_',nvl(max(substr(goods_num,6)),10000) + 1) from goods1),'냉장고',2000);

-- index
create index idx_did
on departments(department_id);

select * from departments
where department_id = 90;

select employee_id, first_name, salary, job_id, department_id from employees
where job_id like '%REP%';

create index job_idx
on employees(job_id);

-- 이름의 앞에서 두 글자가 'Oc'인 직원을 출력하시오
select * from employees
where substr(first_name,1,2) = 'Oc';

create index name_idx -- 함수기반의 인덱스
on employees(substr(first_name,1,2));

-- 각 부서의 급여의 평균이 10000인 부서와 평균급여를 출력하시오
select department_id, avg(salary) from employees
group by department_id
having avg(salary) = 10000; 

create index avgsal -- 그룹함수는 index를 만들 수 없다.
on employees(avg(salary));

select * from user_tables;
select * from user_indexes where table_name= 'EMPLOYEES';

-- 각 부서의 최대 급여에 해당하는 사원의 정보를 이름, 급여, 직무, 입사일, 최대급여, 부서를 출력하시오
select first_name, salary, job_id, hire_date,  department_id from employees;

select department_id , max(salary) from employees
group by department_id;

-- 
select first_name, salary, job_id, hire_date,  e2.department_id , max_sal
from employees e1 join (select department_id , max(salary) max_sal from employees -- 이 서브쿼리문을 inline view라고 한다.
group by department_id) e2
on e1.department_id = e2.department_id
where max_sal = 17000;

-- 사번, 이름, 급여, 부서, 각 부서의 평균 급여를 출력할 때 평균 급여보다 많이 받는 사원들을 출력
select department_id, avg(salary)
from employees
group by department_id;

select employee_id, first_name, salary
from employees e1 join (select department_id, avg(salary) as avg_sal
from employees
group by department_id) e2 
on e1.department_id = e2.department_id
where salary >= avg_sal;

-- 지역번호가 1700에 해당하는 부서의 부서명과 그 부서에서 근무하는 사원의 사원번호, 이름, 급여를 출력
select d.department_id, department_name, employee_id, first_name, salary
from employees e join departments d
on e.department_id = d.department_id
where location_id = 1700;

select d.department_id, department_name, employee_id, first_name, salary
from employees e join (select department_id, department_name from departments
                        where location_id = 1700) d
on e.department_id = d.department_id;

-- 사원의 번호, 이름, 급여, 80인 부서
select employee_id, first_name, salary 
from employees 
where department_id = 80;

select * from (select employee_id, first_name, salary 
from employees 
where department_id = 80);
    






