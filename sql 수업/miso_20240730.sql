-- join : 두 개의 테이블에서 데이터를 가져온다. -> 공통적인 컬럼이나 값이 있을 때 조인이 가능하다
-- 별칭을 주게되면 테이블명을 사용할 수 없다.
-- 테이블이 n개일 때 조인 조건은 n-1개 이상이다

select * from hr.employees;
select * from hr.departments;
select * from hr.locations;
-- 사원번호, 이름, 입사일, 급여, 부서번호
-- 부서번호, 부서명

-- T-SQL JOIN
select employee_id, first_name, hire_date, salary , e.department_id
, d.department_id , department_name
from hr.employees e , hr.departments d
where e.department_id = d.department_id;
-- ANSI JOIN
select employee_id, first_name, hire_date, salary , e.department_id
, d.department_id , department_name
from hr.employees e join hr.departments d
on e.department_id = d.department_id;

select * from hr.employees;
select * from hr.jobs;
-- 사원번호, 부서번호, 이름, 직무번호
-- 직무번호, 직무명
select employee_id, department_id, first_name, e.job_id
, j.job_id, job_title
from hr.employees e join hr.jobs j
on e.job_id = j.job_id;

-- 칼럼이 아닌 값이 공통적일 때
select * from hr.employees;
select * from hr.departments;
select d.department_id, department_name , d.manager_id
, employee_id, first_name, job_id, salary
from hr.employees e join hr.departments d
on d.manager_id = e.employee_id;

-- inner join 같은 데이터만을 출력 
select employee_id, first_name, hire_date, salary
, d.department_id, department_name
from hr.employees e inner join hr.departments d
on e.department_id = d.department_id;

select employee_id, department_id, first_name, e.job_id
, j.job_id, job_title
from hr.employees e inner join hr.jobs j
on e.job_id = j.job_id;
--
select * from hr.departments;
select employee_id, first_name, job_id, e.department_id
, department_name
from hr.employees e inner join hr.departments d
on e.department_id = d.department_id;

select * from hr.departments; 
select d.department_id, department_name, d.manager_id -- d.manager_id가 null이 아닌 값이 11개이므로 
, employee_id, first_name, job_id, salary             -- inner join에서 같은 값만 출력되기 때문에 11개의 데이터만 출력됨   
from hr.employees e inner join hr.departments d
on e.employee_id = d.manager_id;

-- Natural JOIN : 컬럼명이 같은 두 테이블에서 조인이 가능하다.
-- 별칭을 사용하지 않는다
select employee_id, department_id, first_name
, job_id, job_title
from hr.employees e Natural join hr.jobs j;
-- on e.job_id = j.job_id;

-- 같은 부서의 부서장을 상사로 둔 직원들의 정보와 부서명을 출력
select employee_id, first_name, job_id, salary, e.manager_id
, d.department_id, department_name, d.manager_id
from hr.employees e inner join hr.departments d
on e.department_id = d.department_id and e.manager_id = d.manager_id ;

select employee_id, first_name, job_id, salary, manager_id
, department_id, department_name, manager_id
from hr.employees  Natural join hr.departments;
-- on e.department_id = d.department_id and e.manager_id = d.manager_id ;

-- using 절 : Natural join과 마찬가지로 컬럼명이 같은 두 테이블에서 조인이 가능하다
select employee_id, first_name, job_id, salary, manager_id
, department_id, department_name,  manager_id
from hr.employees join hr.departments 
using( department_id , manager_id );

select employee_id, department_id, first_name, job_id
, job_id, job_title
from hr.employees join hr.jobs 
using (job_id);

-- 각 직원의 직원번호, 직무번호,
-- 부서번호, 부서명 
-- 이 때 20,30,50,80인 부서만 출력
-- T-SQL
select employee_id, e.job_id
, d.department_id, department_name
from hr.employees e , hr.departments d
where e.department_id = d.department_id
and d.department_id in (20,30,50,80);
-- ANSI 
select employee_id, e.job_id
, d.department_id, department_name
from hr.employees e join hr.departments d
on e.department_id = d.department_id
where d.department_id in (20,30,50,80);
-- NATURAL
select employee_id, job_id
, department_id, department_name
from hr.employees Natural join hr.departments
where department_id in (20,30,50,80);
-- USING
select employee_id, job_id
, department_id, department_name
from hr.employees join hr.departments 
using(department_id)
where department_id in (20,30,50,80);

-- 부서번호, 부서명, 우편번호
-- 주소를 출력할 때 우편번호가 1400만 출력
-- T-SQL
select department_id, department_name 
, l.location_id, street_address
from hr.departments d , hr.locations l
where d.location_id = l.location_id
and l.location_id =1400;
-- ANSI
select department_id, department_name 
, l.location_id, street_address
from hr.departments d join hr.locations l
on d.location_id = l.location_id
and l.location_id =1400;
-- NATURAL
select department_id, department_name 
, location_id, street_address
from hr.departments Natural join hr.locations 
where location_id =1400;
-- USING
select department_id, department_name 
, location_id, street_address
from hr.departments join hr.locations 
using(location_id)
where location_id =1400;

-- 직원 번호, 이름, 급여, 직무, 입사일
-- 부서번호, 부서명을 출력  50인부서, 90인 부서는 제외
select employee_id, first_name, salary, job_id, hire_date
, d.department_id, department_name
from hr.employees e join hr.departments d
on e.department_id = d.department_id
where d.department_id not in(50,90);

-- 3중 조인
-- T-SQL
select j.job_id, job_title
, e.job_id, employee_id, first_name, e.department_id
, d.department_id , department_name
from hr.jobs j , hr.employees e , hr.departments d
where j.job_id = e.job_id and e.department_id = d.department_id;
-- ANSI
select j.job_id, job_title
, e.job_id, employee_id, first_name, e.department_id
, d.department_id , department_name
from hr.jobs j join hr.employees e 
on j.job_id = e.job_id join hr.departments d
on e.department_id = d.department_id;

--다중조인 4중
select employee_id, first_name, e.department_id , salary , e.job_id
, d.department_id , department_name, d.location_id
, l.location_id, street_address
, j.job_id , job_title
from hr.employees e join hr.departments d
on e.department_id = d.department_id join hr.locations l
on d.location_id = l.location_id join hr.jobs j
on e.job_id = j.job_id;

--5중
select j.job_id, job_title, min_salary, max_salary
,e.job_id , employee_id, first_name, salary, hire_date, e.department_id
, d.department_id, department_name, d.location_id
, l.location_id, street_address, l.country_id
, c.country_id , country_name
from hr.jobs j join hr.employees e
on j.job_id = e.job_id join hr.departments d
on e.department_id = d.department_id join hr.locations l
on d.location_id = l.location_id join hr.countries c
on l.country_id = c.country_id;

-- self join : 같은 테이블 조인하기
select * from hr.employees;
select e1.employee_id, e1.first_name, e1.salary, e1.job_id, e1.email, e1.manager_id 
,e2.first_name
from hr.employees e1 , hr.employees e2
where e1.manager_id = e2.employee_id and e1.employee_id = 105;

-- 사장(100)이 상사인 사원들 사원번호, 이름, 급여, 직무, 상사번호 를 출력
-- 사장의 급여와 입사일
select e1.employee_id, e1.first_name, e1.salary, e1.job_id, e1.manager_id 
, e2.salary, e2.hire_date
from hr.employees e1 join hr.employees e2
on e1.manager_id = e2.employee_id
where e2.employee_id = 100;

-- 비 등가 조인 : between A and B ( = 을 사용하지 않는다)
select * from hr.jobs;
select * from hr.employees;

select employee_id, salary, first_name, e.job_id
, j.job_id, job_title, min_salary, max_salary
from hr.employees e join hr.jobs j
on salary between min_salary and max_salary;

-- outer join : 직접 일치되지 않는 레코드 반환(조건에 맞지않는 행은 출력되지 않기 때문)
-- 왼쪽의 테이블에 직접 일치되지 않는 레코드 값이 있을 때 left outer join
select employee_id , first_name, salary, e.department_id
, department_name
from hr.employees e left outer join hr.departments d
on e.department_id = d.department_id;
-- 오른쪽의 테이블에 직접 일치되지 않는 레코드 값이 있을 때 right outer join
select employee_id , first_name, salary, e.department_id
, department_name
from hr.departments d right outer join hr.employees e
on e.department_id = d.department_id;

select employee_id , first_name, salary, e.department_id
, department_name
from hr.departments d full outer join hr.employees e
on e.department_id = d.department_id;

select first_name, employee_id, salary, e.department_id
, department_name
from hr.employees e , hr.departments d
where e.department_id = d.department_id(+);

select first_name, employee_id, salary, e.department_id
, department_name
from hr.employees e , hr.departments d
where e.department_id(+) = d.department_id;

select e.job_id, first_name, salary, employee_id
, j.job_id, job_title
from hr.employees e right outer join hr.jobs j
on e.job_id = j.job_id;

select e.job_id, first_name, salary, employee_id
, j.job_id, job_title
from hr.employees e , hr.jobs j
where e.job_id(+) = j.job_id;

-- 카티시안 곱 : 조인조건이 없을 때 무수히 많은 값을 출력함






