-- 다중행 함수 : 그룹함수 : null을 포함하지 않는다 / 그룹함수는 한 행만 출력하기 때문에 여러 행을 출력하는 칼럼명을 사용할 수 없다.
-- group by 를 해준 칼럼은 출력 가능
-- 급여에서 급여를 많이 받는 직원과 제일 적은 직원, 그리고 한달 급여의 평균과 한달 동안 지급되는 급여의 금액을 출력
select max(salary), min(salary), round(avg(salary)), sum(salary) from hr.employees;

-- 전체 직원 수 -- NOT NULL이 존재하는 칼럼으로는 카운트해서 안된다.
select count(employee_id), count(last_name),count(email), count(hire_date) from hr.employees;
-- 커미션을 받는 사원의 수
select count(commission_pct) from hr.employees;
-- 부서가 있는 사원의 수
select count(department_id) from hr.employees;
-- 부서가 없는 사원의 수
select count(*) from hr.employees where department_id is null;
-- 80인 부서의 직원 수와 최대 급여와 최소 급여를 구하시오
select count(*), max(salary), min(salary) from hr.employees where department_id = 80;
-- 부서 출력
select department_id from hr.employees;
-- 부서를 한번씩만 
select DISTINCT department_id from hr.employees;
-- 부서의 수를 출력
select count(DISTINCT department_id) from hr.employees;
-- 직무가 RE를 포함한 직원 수
select count(*) from hr.employees where job_id like '%RE%';
-- 직무가 RE를 포함한 직원의 최대 급여와 최소 급여, 직원 수와 평균 급여를 출력
select count(*), max(salary), min(salary), round(avg(salary)) from hr.employees where job_id like '%RE%';

-- 제일먼저 입사한 사원과 제일 나중에 입사한 사원의 입사일 출력
select min(hire_date), max(hire_date) from hr.employees;
select max(hire_date)-min(hire_date) from hr.employees;

-- 80인 부서에서 커미션만 출력하시오.
select commission_pct from hr.employees where department_id = 80;
-- 커미션을 받는 사원 수
select count(commission_pct) from hr.employees where department_id = 80;

--  커미션을 받는 사원의 커미션의 평균을 구하시오
select avg(commission_pct), sum(commission_pct)/count(commission_pct) from hr.employees;
select nvl(commission_pct,0) from hr.employees;
-- 커미션의 전체의 평균을 구하시오
select avg(nvl(commission_pct,0)) from hr.employees;
select sum(commission_pct)/count(*) from hr.employees;

--80인 부서에서 직무가 'SA_MAN'인 사원의 수와 커미션의 평균을 구하시오
select count(*), avg(commission_pct) from hr.employees where department_id = 80 and job_id = 'SA_MAN';


-- 80인 부서의 급여 평균,합,최대,최소 를 구하시오
select avg(salary), sum(salary), max(salary), min(salary) from hr.employees where department_id = 80;
-- 90인 부서의 급여 평균,합,최대,최소 를 구하시오
select avg(salary), sum(salary), max(salary), min(salary) from hr.employees where department_id = 90;
-- 70인 부서의 급여 평균,합,최대,최소 를 구하시오
select avg(salary), sum(salary), max(salary), min(salary) from hr.employees where department_id = 70;
-- group by 부서별 
select department_id, avg(salary), sum(salary), max(salary), min(salary) from hr.employees group by department_id;
select department_id, avg(salary), sum(salary), max(salary), min(salary) from hr.employees 
where department_id in (80,90,70)
group by department_id;

--정렬
select * from hr.employees order by job_id;
-- job_id 별 사원의 급여와 평균, 합, 최대, 최소
select job_id, avg(salary), sum(salary), max(salary), min(salary), count(*) from hr.employees  
group by job_id;
-- job_id FI_ACCOUNT, PU_CLERK, IT_PROG 인 사원의 급여와 평균, 합, 최대, 최소
select job_id, avg(salary), sum(salary), max(salary), min(salary), count(*) from hr.employees
where job_id in('FI_ACCOUNT','PU_CLERK','IT_PROG') 
group by job_id;

-- 직원들의 모든 정보를 출력할 때 부서를 오름차순으로 정렬, 정렬된 같은 부서안에서 직무를 오름차순으로 정렬
select * from hr.employees order by department_id ,job_id;
-- 같은 부서 내에 다른 직무들의 급여를 평균, 합, 최대 최소
-- 같은 부서에서 같은 직무를 하는 직원의 수 출력
select department_id, job_id, avg(salary), sum(salary), max(salary), min(salary), count(*) from hr.employees 
group by department_id, job_id
order by department_id, job_id;

-- group by 절에 있는 칼럼들은 select절에 사용할 수 있다.

-- 부서별 평균 급여를 출력
select department_id, avg(salary) from hr.employees
group by department_id;
-- 이때 평균 급여가 8000을 초과한 부서와 평균급여 출력
select department_id, avg(salary) from hr.employees
group by department_id
having avg(salary) > 8000 -- having 절은 그룹함수를 조건으로 사용한다.
order by department_id;
-- 그룹 함수는 group by 다음에 실행되기 때문에 실행순서가 먼저인 where절에 사용할 수 없다.

-- 직무별 최대급여 최소급여 합 직원수 출력 직원수가 3명 이상인 직무만 출력
select job_id, max(salary), min (salary), sum(salary), count(*) from hr.employees
group by job_id
having count(*) >= 3
order by job_id;

--REP를 포함하고 있지 않은 직무들 중에서 각 직무별 최대, 최소, 급여 합을 출력 이때 급여 합이 13000이상인 것만 출력 단 합이 높은 부서부터 출력
select job_id, max(salary), min(salary), sum(salary) from hr.employees
where job_id not like '%REP%'
group by job_id
having sum(salary) >= 13000
order by 4 desc;
-- 각 부서별 부서의 급여 합, 최대, 최소, 사원의 수, 평균 / 평균은 소수점 2자리까지만 출력
select department_id, max(salary), min(salary), sum(salary), count(*) ,trunc(avg(salary),2) from hr.employees
group by department_id;
-- 부서에서 같은 직무를 하는 사원들의 최대 급여, 최소, 평균, 합, 같은 직무를 하는 사원의 수 출력
select department_id, job_id, max(salary), min(salary), avg(salary), sum(salary), count(*) from hr.employees
group by department_id, job_id
order by department_id, job_id;
-- 각 부서에서 직무가 같은 사원들 중 입사일이 같은 사원의 수를 구하시오 사원수가 2명이상만 출력 단, 80 인 부서만 출력
select department_id, job_id,hire_date, count(*) from hr.employees
where department_id = 80
group by department_id, job_id, hire_date
having count(*) >= 2
order by department_id, job_id, hire_date;
-- 평균 급여가 7000이상인 부서만 출력, 높은 곳부터 출력
select department_id, trunc(avg(salary),2) from hr.employees
group by department_id
having trunc(avg(salary),2) >= 7000
order by 2 desc;
-- 각 부서의 평균급여 중 최대 평균급여를 출력하시오
select max(avg(salary)) from hr.employees -- 중첩 그룹함수
group by department_id;

-- 조인 : 두개 이상의 테이블로부터 데이터를 가져오는 것
select * from hr.employees;
select * from hr.departments;
-- 사원번호, 이름, 급여, 직무, 부서번호, 부서명
select employee_id , first_name, salary, job_id, hr.departments.department_id, department_name 
from hr.employees, hr.departments
where hr.employees.department_id =  hr.departments.department_id;

select * from hr.employees;
select * from hr.jobs;

select employee_id, first_name, salary, department_id, 
hr.jobs.job_id, job_title 
from hr.employees,hr.jobs
where hr.employees.job_id = hr.jobs.job_id;

select * from hr.departments;
select * from hr.employees;

select employee_id, first_name, salary, job_id 
, hr.departments.department_id, department_name , hr.departments.manager_id
from hr.employees, hr.departments
where hr.employees.employee_id =  hr.departments.manager_id;

select * from hr.departments;
select * from hr.locations;

-- T-SQL join 
select department_id, department_name
, l.location_id , street_address, postal_code
from hr.departments d, hr.locations l
where d.location_id = l.location_id and department_id = 100;
    
-- ANSI join
select department_id, department_name
, l.location_id , street_address, postal_code
from hr.departments d join hr.locations l
on d.location_id = l.location_id;

select employee_id, first_name, salary, department_id, 
hr.jobs.job_id, job_title 
from hr.employees join hr.jobs
on hr.employees.job_id = hr.jobs.job_id
where employee_id = 100;

select * from hr.employees;
select * from hr.job_history;
select e.employee_id, first_name, salary , e.job_id, e.department_id
, start_date, end_date, h.job_id
from hr.employees e join hr.job_history h
on e.employee_id = h.employee_id
order by 1 ;

select * from hr.jobs;
select * from hr.job_history;
select * from hr.departments;
-- T-SQL join
select  job_title, min_salary, max_salary
, jh.job_id, start_date, end_date
, d.department_id, department_name
from hr.jobs j, hr.job_history jh, hr.departments d
where j.job_id = jh.job_id and jh.department_id = d.department_id;

-- ANSI join
select  job_title, min_salary, max_salary
, jh.job_id, start_date, end_date
, d.department_id, department_name
from hr.jobs j join hr.job_history jh 
on j.job_id = jh.job_id join hr.departments d
on jh.department_id = d.department_id;


