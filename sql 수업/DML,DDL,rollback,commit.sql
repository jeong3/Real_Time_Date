-- insert 
-- hr.department의 테이블과 데이터를 department라는 이름의 테이블을 생성하면서 복사해온다.
create table departments
as
select * from hr.departments;

select * from departments;

drop table departments;

-- 위와 같은 방법으로 테이블을 생성할 때 where 거짓을 하게되면 데이터 없이 빈 테이블(칼럼)만 생성된다
create table departments
as
select * from hr.departments
where 1 = 2;

create table employees
as
select * from hr.employees
where 1 = 2;

select * from employees;

select employee_id, first_name, salary, email, department_id
from hr.employees;

INSERT INTO departments(department_id, department_name, manager_id, location_id)
VALUES (70, 'Public Relations', 100, 1700);

desc departments;
select * from departments;

INSERT INTO departments (department_id, department_name)
VALUES (30, 'Purchasing'); -- 암시적 방법

INSERT INTO departments 
VALUES (30, 'Purchasing', null, null); -- 명시적 방법

desc employees;
insert into employees(EMPLOYEE_ID,FIRST_NAME, LAST_NAME,EMAIL,PHONE_NUMBER,HIRE_DATE,JOB_ID,SALARY,COMMISSION_PCT,MANAGER_ID,DEPARTMENT_ID)
values (113,'Louis','Popp','LPOPP', '515.124.4567',SYSDATE, 'AC_ACCOUNT', 6900, NULL, 205, 110);

insert into employees(EMPLOYEE_ID,FIRST_NAME, LAST_NAME,EMAIL,PHONE_NUMBER,HIRE_DATE,JOB_ID,SALARY,COMMISSION_PCT,MANAGER_ID,DEPARTMENT_ID)
values (114, 'Den', 'Raphealy','DRAPHEAL', '515.127.4561',TO_DATE('24/08/01', 'YY/MM/DD'),'SA_REP', 11000, 0.2, 100, 60);

INSERT INTO departments (department_id, department_name)
select department_id, department_name from hr.departments
where manager_id is not null;

select * from departments;

insert into employees
select * from hr.employees
where job_id not like 'AD%';

select * from employees;

-- update : 한 개이상 행에서 열 값을 수정한다.
delete from employees;

insert into employees
select * from hr.employees;

update employees
set department_id = 80
where department_id = 60;

update employees
set department_id = 50
where employee_id = 113;

select * from employees;
commit;

update employees
SET job_id = (SELECT job_id FROM employees WHERE employee_id = 205),
    salary = (SELECT salary FROM employees WHERE employee_id = 205)
WHERE employee_id = 113;

update employees
set department_id = 100;
rollback;

select department_id from employees where employee_id = 100;

select job_id from employees where employee_id = 200;

--부서가 90인 사원의 직무를 AD_ASST로 변경
update employees
set job_id = (select job_id from employees where employee_id = 200)
where department_id = (select department_id from employees where employee_id = 100);



delete from departments;
insert into departments
select * from hr.departments;
commit;
-- delete : 삭제(롤백가능) / truncate : 삭제(롤백 불가능)
delete from departments
where department_name = 'Finance';

select * from departments
where department_name = 'Finance';

select department_id from departments
where department_name like '%Public%';

delete from departments
where department_id = (select department_id from departments
                       where department_name like '%Public%');
rollback;

truncate table departments;
select * from departments;

----------------DDL / create 테이블 생성
-- 칼럼명 타입 default 기본설정값
create table hire_date
(
    id number default 10,
    hire_date date default sysdate
);
desc hire_date2
drop table hire_date;
select * from hire_date3;
insert into hire_date2(pw)
values(30);

--deptno number(2) : 정수 2자리, 한글은 한글자당 3바이트로 dname varchar(9) : 3글자까지 넣을 수 있다.
-- varchar(크기) : 시스템 부하율은 높지만 넣은 값 외 공간은 지운다
-- char(크기) : 시스템 부하율은 낮지만 넣은 값 외의 공간이 남는다 (낭비공간이 생긴다)
create table dept(
    deptno number(2),
    dname varchar(9),
    loc VARCHAR2(13),
    create_date date default sysdate
);
desc dept;
insert into dept 
values (10,'영업부','1700', null); 
insert into dept ( deptno, dname, loc)
values (10,'영업부','1700'); 
select * from dept;

create table board
(
    board_num number,
    user_Id varchar2(10),
    board_name varchar2(15),
    board_subject varchar2(30),
    board_content varchar2(1000),
    board_date date,
    read_count number default 0
);
desc board;
insert into board(board_num, user_Id, board_name, board_subject, board_content, board_date)
values (1, 'id','보드이름','제목','컨텐츠',sysdate);

update board -- 조회수 증가
set read_count = read_count + 1 
where board_num = 1;

select * from board 
where board_num = 1;
commit;


