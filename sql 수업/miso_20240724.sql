SELECT * from hr.employees;
SELECT * from hr.departments;

select department_id , department_name , manager_id , location_id
from hr.departments; -- select column명을 통해 검색할 수 있음 -> 프로젝션
select * from hr.departments; -- 모든 column을 검색
select manager_id , department_id , 30 , '정지원' from hr.departments;
select * from hr.employees;
select employee_id, first_name, salary + 300, manager_id from hr.employees;
select employee_id, first_name, salary, salary * 12, manager_id from hr.employees;
select employee_id, first_name, salary, salary * 12 + 100, manager_id from hr.employees;
select null from dual; -- 알 수 없는 값

select employee_id, last_name, hire_date, salary, commission_pct, department_id from hr.employees;
select employee_id, last_name, hire_date, salary, commission_pct,salary*commission_pct, department_id from hr.employees;
select employee_id, first_name, last_name, salary, commission_pct,salary*12,salary*commission_pct*12 + salary*12 , department_id from hr.employees;

-- alias -- heading name 변경하기 : as year_sal처럼 column명 뒤에 이름을 적어주면 된다.
select employee_id, first_name, last_name, salary, commission_pct,salary*12,salary*commission_pct*12 + salary*12 as year_sal, department_id from hr.employees;

-- 대소문자, 공백문자를 heading name에 출력-- as "heading name" 
select employee_id, first_name, last_name, salary, commission_pct,salary*12,salary*commission_pct*12 + salary*12 as "Year Sal", department_id from hr.employees;

-- 연결연산자 || --
select last_name, job_id, employee_id, salary, last_name||job_id from hr.employees;

-- 문자열 리터널
select last_name, job_id, employee_id, salary , last_name||' is a ' || job_id from hr.employees;
select employee_id || '의 이름은' || last_name || '이고 직무는' || job_id || '입니다.' as employee from hr.employees;
select * from hr.departments;

-- Administration의 manager는 200입니다.
select department_name || '의 manager는' || manager_id || '입니다.' as manager from hr.departments;
SELECT last_name ||'의 1달 월급 = '||salary Monthly from hr.employees;
select 'Administration department''s manager_id 200' from dual;

-- department's manager_id -- 문자열 안에 ' 를 사용하기
select department_name ||  'department''s manager_id'|| manager_id from hr.departments;
select department_name ||  q'[department's manager_id]'|| manager_id from hr.departments;

-- 중복 행 제거 DISTINCT : select 바로 다음에 와야한다 select DISTINCT 중복제거할 행 from hr.employees;
select last_name , salary, job_id, department_id from hr.employees;
select DISTINCT department_id from hr.employees;

select department_id, job_id from hr.employees;
select DISTINCT department_id, job_id from hr.employees;

-- table 정보 확인 --
desc hr.employees; -- DESCRIBE
DESCRIBE hr.employees;
-- 1. 부서에서 급여가 같은 사원의 정보를 한번만 출력할 때 부서와 급여만 출력하세요
select DISTINCT salary as "급여", job_id as "부서" from hr.employees;
-- 2. 입사일이 같고 직무가 같은 사원의 정보를 한번만 출력하세요. 입사일과 직무만 출력
select DISTINCT hire_date as "입사일", job_id as "부서" from hr.employees;

-- 원하는 열(column) : projection
-- 원하는 행 : selection : where

-- 사원번호가 100인 사원 출력
select * from hr.employees;
select * from hr.employees where employee_id = 100;
select * from hr.employees where EMPLOYEE_ID = 100;

-- 성이 king인 사원을 출력
SELECT * FROM HR.EMPLOYEES WHERE LAST_NAME = 'King';
select * from hr.employees where last_name = 'KING';
select * from hr.employees where last_name = 'king';

-- 사원들 정보 중 사원번호, 이름 , 급여, 직무를 출력
-- 직무가 'FI_ACCOUNT'인 사원들만 출력하세요.
select employee_id, first_name, salary, job_id from hr.employees
where job_id = 'FI_ACCOUNT'; -- selection에서는 리터널은 대소문자가 데이터와 일치해야 한다.(대소문자 구분)

-- yy/mm/dd
select * from hr.employees;
-- 070207에 들어온 사원을 출력
select * from hr.employees where hire_date = '07/02/07';
-- 사장(100)보다 일찍 온 사원을 출력
select * from hr.employees where employee_id = 100;
select * from hr.employees where hire_date < '03/06/17';
-- 급여가 3000달러 이상인 사원을 출력
select * from hr.employees where salary >= 3000;
-- 사원, 성, 급여, 직무를 출력하는데 급여의 열이름을 sal로 한다
-- 이때 급여가 3000이상인 사원을 출력
select employee_id, first_name, salary as sal, job_id from hr.employees
where salary >= 3000; -- where절에는 별칭을 사용할 수 없다.

 -- and || or
select first_name, salary from hr.employees where salary >= 2500 and salary <= 3000;
select first_name, salary from hr.employees where salary between 2500 and 3000;

select * from hr.employees where department_id = 50 or department_id = 70 or department_id = 90;
select * from hr.employees where department_id in (50,70,90);

-- 직원 이름이 'Vance'인 직원과 90인 부서의 직원을 출력
select * from hr.employees where first_name = 'Vance' or department_id = 90;

-- 직원 성이 'Hartstein', 'Vargas'인 사원들을 출력
select * from hr.employees where last_name in ('Hartstein', 'Vargas');

--not : ~ 아닌 in과 between 앞에 붙힌다.
select * from hr.employees where manager_id not in (100, 101, 201); --100, 101, 201이 아닌 사원 출력 (not)

select * from hr.employees where department_id not in (50,60,70);
select * from hr.employees where department_id not between 50 and 70; -- 50~70이 아닌 사원 출력 (not)

select * from hr.employees where hire_date not in ('03/06/17', '01/01/13', '07/03/17');

-- 급여가 3000미만, 10000을 초과한 직원을 구하시오
select * from hr.employees where salary not between 3000 and 10000;

-- 부서가 없는 직원을 출력
select * from hr.employees where department_id is null; 
select * from hr.employees where department_id is not null;
-- null은 값이 불명확하기 때문에  = 를 사용할 수 없다 따라서 is null 혹은 is not null을 통해 비교할 수 있다.

-- 성이 'K'로 시작하는 모든 사원 출력
select * from hr.employees where last_name like 'K%'; -- K로 시작하는 성 출력
-- 성이 'e'로 끝나는 모든 사원 출력
select * from hr.employees where last_name like '%e'; -- e로 끝나는 성 출력
-- 성이 'k'를 포함하는 모든 사원 출력 (%x% : 0개이상의 문자로 x는 맨앞과 맨뒤여도 상관 없다. 
select * from hr.employees where last_name like '%k%'; -- k를 포함하는 성 출력
select * from hr.employees where last_name like '%in%';  

-- 성에 첫글자는 아무 문자나 상관없지만 두번째 글자가 u인 사원을 출력하시오.
select * from hr.employees where last_name like '_u%'; // 언더바(_)의 개수가 앞의 글자 수
-- 3번째 글자가 s인 사원 출력
 select * from hr.employees where last_name like '__s%';
-- 뒤에서 2번째 글자가 u인 사원 출력
select * from hr.employees where last_name like '%u_'; 
-- u와 i사이에 한글자를 포함한 사원 출력
select * from hr.employees where last_name like '%u_i%'; 

select job_id from hr.employees ;

-- 직무가 AC_로 시작하는 사원 출력
select * from hr.employees where job_id like 'AC\_%' escape '\'; 
-- 문자로 _를 사용하기 위해선 'AC\_%' escape '\';이런 형태로 이스케이프를 사용해야한다

--직무가 D_P인 사원들을 출력
select * from hr.employees where job_id like '%D\_P%' escape '\';





