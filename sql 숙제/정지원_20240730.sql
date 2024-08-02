--1. 성, 이름 , 급여, 부서, 부서명, 지역번호, 우편주소를 출력하시오
select last_name, first_name, salary, e.department_id
, d.department_name
, l.location_id,street_address
from hr.employees e join hr.departments d
on e.department_id = d.department_id join hr.locations l
on d.location_id = l.location_id ;
--2. 부서가 없는 직원과 직원이 없는 부서를 출력하며 지역과 우편주소를 출력하시오.
select employee_id, e.department_id, d.location_id, street_address
from hr.departments d full outer join hr.employees e 
on d.department_id = e.department_id join hr.locations l
on d.location_id = l.location_id;
--3. 직무, 직무내용, 부서명, 우편주소를 이름과 함께 출력하시오.
select j.job_id, job_title
,d.department_name , street_address , first_name
from hr.jobs j join hr.employees e
on j.job_id = e.job_id join hr.departments d
on e.department_id = d.department_id join hr.locations l
on d.location_id = l.location_id;
--4. 이름, 성, 부서명, 지역번호를 사원번호가 152인 사원만 출력하시오
select first_name, last_name, department_name, location_id
from hr.employees e join hr.departments d
on e.department_id = d.department_id
where e.employee_id = 152;
--5. 직원번호, 이름, 성, 직무, 직무내용, 부서명, 우편번호, 지역번호, 지역명, 국가명을 출력하시오 
select employee_id, first_name, last_name
, j.job_id, job_title
, department_name 
, l.location_id, country_id, city, street_address
from hr.employees e join hr.jobs j
on e.job_id = j.job_id join hr.departments d
on e.department_id = d.department_id join hr.locations l
on d.location_id = l.location_id;

--6. 직원번호, 성, 이름, 이메일, 부서번호, 부서명을 출력해주세요.
select employee_id, last_name, first_name, email, d.department_id, department_name
from hr.employees e join hr.departments d
on e.department_id = d.department_id;
--7. 직무번호, 직무내용, 성, 이름, 입사일을 출력하고,
----직무번호가 'SA_REP' 이며 입사일이 '020816' 일부터 '050921'까지인 직원정보를 출력해주세요.
select e.job_id, job_title, last_name, first_name, hire_date
from hr.jobs j join hr.employees e
on j.job_id = e.job_id
where e.job_id = 'SA_REP' and hire_date between '02.08.16' and '05.09.21';
--8. 직원번호, 성, 이름, 부서번호, 부서명을 출력하며 커미션을 받지 않는사람만 출력해주세요.
select employee_id, last_name, first_name, e.department_id, department_name
from hr.employees e join hr.departments d
on e.department_id = d.department_id
where commission_pct is null;
--9. 직원번호, 성, 이름, 부서번호, 부서명, 지역번호, 주소를 출력하고 도시가 'Toronto'에 사는 사람만 출력해주세요. 
select employee_id, last_name, first_name
, department_name
, l.location_id, street_address
from hr.employees e join hr.departments d
on e.department_id = d.department_id join hr.locations l
on d.location_id = l.location_id
where city = 'Toronto';
--10. 직무내용, 성, 이름, 부서명, 주소, 출신국가를 출력하고 직원이 없는 모든국가를 출력해주세요.
select employee_id , last_name
, department_name
, street_address, state_province
from hr.employees e join hr.departments d
on e.department_id = d.department_id right outer join hr.locations l
on d.location_id = l.location_id ;
--11. 부서번호가 60인 사원의 성, 이름, 사원 번호, 급여, 부서명을 출력하시오.
select last_name, first_name, employee_id, salary, department_name
from hr.employees e join hr.departments d
on e.department_id = d.department_id
where e.department_id = 60;
--12. 급여가 4800인 사원의 사원 번호,직무 번호, 직무명, 최소급여(min_salary), 최대급여(max_salary)를 출력하시오.
select employee_id, e.job_id, job_title, min_salary, max_salary
from hr.employees e join hr.jobs j
on e.job_id = j.job_id
where salary = 4800;
--13. 지역번호가 1700인 사원의 성과 이름, 전화번호, 고용일을 출력하시오.
select * from hr.locations;
select last_name, first_name, phone_number, hire_date
from hr.employees e join hr.departments d
on e.department_id = d.department_id join hr.locations l
on d.location_id = l.location_id
where l.location_id = 1700;
--14. 직무 최소 급여가 4000인 직무를 가진 사원의 성, 이름, 직무명을 출력하시오.
select last_name, first_name, job_title 
from hr.employees e join hr.jobs j 
on e.job_id = j.job_id
where salary = 4000;
--15.대륙 번호(REGION_ID)가 4인 국가의 번호(COUNTRY_ID) 와 이름(COUNTRY_NAME) 을 출력하시오.(hr.countries)
select country_id , country_name from hr.countries
where region_id = 4;
--16. 지역 번호와 주소, 우편번호, 도시명이 출력되도록 하시오.
---- 단, UK인 국가만 나오도록 출력하시오.
select location_id, street_address, postal_code, city from hr.locations
where country_id = 'UK';
--17.평균 급여가 가장 높은 직무의 금액을 출력하시오.
select max(avg(salary)) from hr.employees
group by job_id;

--18. 우편번호(postal_code)가 비어있는 주소(street_address)와 도시명(city)을 출력하시오.
select street_address , city from hr.locations
where postal_code is null;
--19. 부서번호가 50인 사원의 직무시작과 직무종료일을 출력하시오.
select * from hr.job_history;
select start_date , end_date
from hr.employees e join hr.job_history jh
on e.employee_id = jh.employee_id
where e.department_id = 50;
--20. 나라 번호, 나라명, 지역 번호, 지역명을 출력하시오
select * from hr.locations;
select * from hr.countries;

select region_id, country_name, location_id, city
from hr.locations l join hr.countries c
on l.country_id = c.country_id;


--21. 이름이 'Daniel'부터 'Irene'인 사원들의
---- 사원번호, 이름, 급여
---- 부서 번호, 부서명을 출력하시오
---- 단, 이름을 기준으로 오름차순으로 정렬하시오.
select employee_id , first_name, salary
, e.department_id, department_name
from hr.employees e join hr.departments d
on e.department_id = d.department_id
where first_name between 'Daniel' and 'Irene'
order by 2;

--22. 부서별로 가장 높은 급여를 출력하시오.
---- 단, 부서 번호를 기준으로 내림차순으로 정렬하시오.
select department_id, max(salary) from hr.employees
group by department_id
order by 1 desc;
--23. 직무에 'MA'가 들어가는 사원 중
---- 급여가 8000이 넘는 사원의 
---- 사원번호, 이름, 성, 직무
---- 부서 번호, 부서명을 출력하시오.
select employee_id, first_name, last_name, job_id
, d.department_id, department_name
from hr.employees e join hr.departments d
on e.department_id = d.department_id
where salary > 8000 and job_id like '%MA%';
--24. 커미션이 null인 값은 0으로 바꾸고
---- 커미션을 포함한 사원들의 연봉을 구하시오
---- 사원 번호, 이름, 급여, 커미션, 연봉 출력
---- 단, 연봉의 별칭을 YEAR_SAL 로 표시하시오
select employee_id, first_name, salary, nvl(commission_pct,0) as pct, salary*12*(nvl(commission_pct,0)+1) as year_sal from hr.employees;
--25. 부서번호가 20, 50, 80인 부서의 부서번호와 
---- 평균 급여, 최대 급여, 최소 급여, 급여 총 합을 출력하시오
select trunc(avg(salary)), max(salary), min(salary), sum(salary)
from hr.employees where department_id in (20,50,80);
--26. 직무의 최소 급여가 4000인 직무명, 
---- 해당 직무를 가진 직원의 성, 이름, 급여를 출력하시오.
select last_name, first_name, salary from hr.employees e join hr.jobs j
on e.job_id = j.job_id
where min_salary = 4000;
--27.  부서 번호
---- 해당 부서의 직원 번호, 성, 
---- 지역 번호, 주소를 출력하시오.
---- 단, 부서가 없는 직원도 출력한다.
select employee_id, last_name
, l.location_id, street_address
from hr.employees e left outer join hr.departments d
on e.department_id = d.department_id left outer join hr.locations l
on d.location_id = l.location_id;
--28. 직원 번호가 150번부터 173번인 직원의
---- 부서 번호, 부서명
---- 직원 번호, 성, 이름
---- 직무번호, 직무 내용을 출력하시오
---- 단, 직원 번호를 기준으로 내림차순으로 정렬하시오.
select d.department_id, department_name
,employee_id, last_name, first_name
,j.job_id, job_title
from hr.departments d join hr.employees e
on d.department_id = e.department_id join hr.jobs j
on e.job_id = j.job_id
where employee_id between 150 and 173
order by 3 desc;
--29. 지역번호가 2700인 부서의 부서번호와 주소를 출력하시오
select department_id, street_address
from hr.departments d join hr.locations l
on d.location_id = l.location_id
where d.location_id = 2700;
--30. 이름에 'AN'이 들어가는 직원의
---- 직원 번호, 이름, 부서, 부서명을 출력하시오
---- 단, 이름은 소문자, 대문자 상관없음
select employee_id, first_name
, d.department_id, department_name 
from hr.employees e join hr.departments d
on e.department_id = d.department_id
where first_name like initcap('%AN%');



