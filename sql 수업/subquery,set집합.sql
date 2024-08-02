-- subquery : 다른 SELECT 문의 절에 포함되는 SELECT 문 
-- 메인 쿼리문에 서브 쿼리문을 넣는다. / 서브쿼리문이 실행되고 메인쿼리문이 실행된다.
-- where절 뿐만아니라 having절에도 서브쿼리문을 사용할 수 있다
-- 평균 급여의 최대 값인 직무를 출력
select max(avg(salary)) from hr.employees
group by job_id;

select job_id, salary from hr.employees
where salary =  (select max(avg(salary)) from hr.employees
group by job_id); 

-- Abel의 급여를 출력
select salary from hr.employees
where last_name = 'Abel';
-- Abel과 같은 급여를 받는 직원들을 출력
select * from hr.employees
where salary = (select salary from hr.employees
where last_name = 'Abel');

-- 90 인부서에서 급여를 가장 많이 받는 사원의 급여를 출력하시오
select max(salary) from hr.employees
where department_id = 90;
-- 24000이상의 급여를 받는 사원 출력
select * from hr.employees
where salary >= 24000;
-- 90 인 부서에서 제일 많이 받는 사원의 급여보다 많이 받는 사원을 출력하시오
select * from hr.employees
where salary >= (select max(salary) from hr.employees
where department_id = 90);

-- 사원번호 103인 사원의 상사와 같은 상사를 둔 직원의 이름 , 사번, 부서, 상사번호를 출력
select first_name, employee_id, department_id, manager_id from hr.employees
where manager_id = (select manager_id from hr.employees where employee_id = 103);

-- 90인 부서의 평균급여 보다 더 많이 받는 사원의 성, 직무, 사번, 부서를 출력
select last_name, job_id, employee_id, department_id from hr.employees
where salary > (select avg(salary) from hr.employees where department_id = 90);

-- 성이 Rogers인 사원의 급여를 출력
select salary from hr.employees where last_name = 'Rogers'; -- 2900
-- 성이 Rogers인 사원의 직무를 출력
select job_id from hr.employees where last_name = 'Rogers'; -- ST_CLERK
-- 급여가 2900이면서 직무가 ST_CLERK인 사원의 이름, 직무, 급여, 입사일을 출력
select first_name, job_id, salary, hire_date from hr.employees
where salary = 2900
and job_id = 'ST_CLERK';
-- 성이 Rogers인 사원의 급여와 직무가 같은 사원의 이름 , 직무, 급여, 입사일을 출력
select first_name, job_id, salary, hire_date from hr.employees
where salary = (select salary from hr.employees where last_name = 'Rogers')
and job_id = (select job_id from hr.employees where last_name = 'Rogers');

-- 입사일이 제일 늦은 사원의 이름, 직무, 사번, 입사일 , 급여 출력
select first_name, job_id, employee_id, hire_date, salary from hr.employees
where hire_date = (select max(hire_date) from hr.employees);

-- 성이 Kumar 인 사원의 직무와 같고 Kumar 인 사원보다 입사일이 빠른 사원들의 성 이름 직무 입사일 부서를 출력
select last_name, first_name, job_id, hire_date, department_id from hr.employees
where job_id = (select job_id from hr.employees where last_name = 'Kumar')
and hire_date < (select hire_date from hr.employees where last_name = 'Kumar');

-- 사장보다 먼저 입사한 사원들을 출력
select * from hr.employees 
where hire_date < (select hire_date from hr.employees where employee_id = 100 );

-- 다중 행 subquery
-- 30인 부서에 있는 직무와 같은 직무에 있는 사원들을 출력
select * from hr.employees
where job_id in (select job_id from hr.employees where department_id = 30);

-- 성이 Taylor인 사원과 같은 직무를 하는 사원들의 모든 정보를 출력
select * from hr.employees
where job_id in (select job_id from hr.employees where last_name = 'Taylor');

-- 각 부서의 평균 급여를 구하시오
select department_id ,min(salary) from hr.employees
group by department_id;

--30,60,90 부서의 최소 급여를 구하시오
select min(salary) from hr.employees
where department_id in (30,60,90)
GROUP by department_id;

-- 직무가 'RE'를 포함하는 직무를 제외한 나머지 직무들을 출력
select * from hr.employees
where job_id not like '%RE%';

-- --30,60,90 부서의 최소 급여와 같고 'RE'를 포함하는 직무에 속해있지않은 사원를 출력
select * from hr.employees
where salary in (select min(salary) from hr.employees
where department_id in (30,60,90) GROUP by department_id) and job_id not like '%RE%';

-- 직원번호가 104인 직원의 직무와 같고 각 부서의 최대 급여에 해당되는 직원의 모든 정보를 출력
select * from hr.employees
where job_id = (select job_id from hr.employees where employee_id = 104)
and salary in (select max(salary) from hr.employees group by department_id);

-- 50 인 부서의 최소 급여 출력
select min(salary) from hr.employees
where department_id = 50;
-- 각 부서의 최소 급여가 2100 급여보다 많이 받는 부서의 최소 급여와 부서번호 출력
select min(salary), department_id from hr.employees
group by department_id
having min(salary) > 2100;
-- 각 부서의 최소 급여가 50 인 부서의 최소 급여보다 많이 받는 부서의 최소 급여와 부서번호 출력
select min(salary), department_id from hr.employees
group by department_id
having min(salary) > (select min(salary) from hr.employees
where department_id = 50);
-- FI_ACCOUNT 인 직무를 가진 사원들의 최소 급여보다 더 적게 받는 사원들의 정보
select  min(salary) from hr.employees
group by job_id
having min(salary) in (select min(salary) from hr.employees where job_id = 'FI_ACCOUNT');

select * from hr.employees
where salary < (select  min(salary) from hr.employees
group by job_id
having min(salary) in (select min(salary) from hr.employees where job_id = 'FI_ACCOUNT'));

-- FI_ACCOUNT 인 직무를 가진 사원의 급여 출력
select salary from hr.employees
where job_id = 'FI_ACCOUNT';
-- 
select * from hr.employees
where salary in (select salary from hr.employees
where job_id = 'FI_ACCOUNT');
-- in : = any
--  < any : 큰 값보다 작은 값
select * from hr.employees
where salary < any(select salary from hr.employees
where job_id = 'FI_ACCOUNT');
--  > any : 작은 값보다 큰 값
select * from hr.employees
where salary > any(select salary from hr.employees
where job_id = 'FI_ACCOUNT');

--  > all : 큰 값보다 더 큰 값
select * from hr.employees
where salary > all(select salary from hr.employees
where job_id = 'FI_ACCOUNT');
--  < all : 작은 값보다 더 작은 값
select * from hr.employees
where salary < all(select salary from hr.employees
where job_id = 'FI_ACCOUNT');

-- 부하직원이 있는 사원을 모두 출력
select * from hr.employees
where employee_id in (select distinct manager_id from hr.employees);

-- 부하직원이 없는 사원을 모두 출력
select * from hr.employees
where employee_id not in (select distinct manager_id from hr.employees
where manager_id is not null);

-- 집합 set연산자(union, intersect, minus)
-- 합집합 union
select salary from hr.employees where job_id = 'ST_CLERK' 
union
select salary from hr.employees where job_id = 'IT_PROG';
-- 교집합 intersect
select salary from hr.employees where job_id = 'ST_CLERK' 
INTERSECT
select salary from hr.employees where job_id = 'IT_PROG';
-- 차집합 minus
select salary from hr.employees where job_id = 'ST_CLERK' 
minus
select salary from hr.employees where job_id = 'IT_PROG';

-- 합집합의 중복된 값을 중복해서 출력
select salary from hr.employees where job_id = 'ST_CLERK'
union all
select salary from hr.employees where job_id = 'IT_PROG';

-- 테이블의 칼럼을 집합으로 사원번호와 직무를 출력
-- set연산 위에 있는 칼럼이 헤딩네임으로 된다.
-- 대응하는 데이터 타입이 같아야한다 같지 않으면 to_char(null)등 타입을 맞춰주고 null값을 넣는다.
-- 숫자 타입일 경우 일반적으로 to_number(null)보다 0을 쓴다
select employee_id, job_id from hr.employees
union
select employee_id, job_id from hr.job_history;

select employee_id, job_id from hr.employees
intersect
select employee_id, job_id from hr.job_history
order by 1;

select manager_id, hire_date, department_id
from hr.employees
union
select employee_id, start_date, department_id
from hr.job_history;

select * from  hr.locations;

select manager_id, hire_date
from hr.employees
union
select employee_id, to_date(null) 
from hr.job_history;

-- DML : CRUD insert select update delete
-- 테이블 복사
create table employees
as
select * from hr.employees;
select * from employees;
drop table employees;
create table employees
as
select * from hr.employees
where 1=2;
desc employees;

drop table employees;






