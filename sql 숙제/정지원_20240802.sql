---- 1. 부서번호, 부서명, 지역번호, 국가 번호를 출력하세요
--      국가 번호 us만 출력 하세요
select * from hr.locations;
select department_id, department_name, l.location_id, country_id
from hr.departments d join hr.locations l
on d.location_id = l.location_id 
where country_id = upper('us');
---- 2. 직원번호, 성, 이름, 주소, 직무, 부서번호, 지역번호, 직무내용, 나라 이름을 출력
select employee_id, last_name, first_name, street_address, e.job_id, job_title, d.location_id, country_name
from hr.employees e join hr.jobs j
on e.job_id = j.job_id join hr.departments d
on e.department_id = d.department_id join hr.locations l
on d.location_id = l.location_id join hr.countries c
on c.country_id = l.country_id;
---- 3. 직무가 'ST_CLERK'인 사람의 국적은?
select country_id from hr.employees e left outer join hr.departments d
on e.department_id = d.department_id left outer join hr.locations l
on d.location_id = l.location_id
where job_id = 'ST_CLERK';
---- 4. 마케팅 부서의 사원의 연봉은? Marketing
select employee_id,salary*(1+nvl(commission_pct,0))*12 from hr.employees e join hr.departments d
on e.department_id = d.department_id
where department_name = 'Marketing';
---- 5. 직원이 없는 부서의 개수를 구하시오.
select count(*) from hr.employees e right outer join hr.departments d
on e.department_id = d.department_id
where e.employee_id is null;
---- 6. 직무 히스토리 테이블에서 시작일과 마지막일이 5년 이상 차이나는 직원의 성, 이름, 부서명을 출력
select last_name, first_name, department_name from hr.employees e join hr.job_history jh
on e.employee_id = jh.employee_id join hr.departments d
on e.department_id = d.department_id
where (end_date - start_date)/365 >= 5;
---- 7 부서가 없는 직원과 직원이 없는 부서를 출력하고 부서의 이름까지 출력하시오.
select employee_id,department_name from hr.employees e full outer join hr.departments d
on e.department_id = d.department_id;
---- 8 직원번호, 이름, 부서번호, 부서명, 지역번호, 주소, city를 출력하는데 CITY가 'London'인 사원을 출력하시오.
select employee_id, first_name, e.department_id, department_name, d.location_id, street_address, city
from hr.employees  e join hr.departments d
on e.department_id = d.department_id join hr.locations l
on d.location_id = l.location_id
where city = 'London';
---- 9 직무에 'IT'가 들어가는 사원 중 급여가 3000이상인 사원을 출력하시오.
----    직원번호, 직원이름, 직무번호, 직무, 급여 출력
select employee_id, first_name, e.job_id, job_title, salary
from hr.employees e join hr.jobs j
on e.job_id = j.job_id
where j.job_id like '%IT%' and salary >= 3000;
---- 10 직무에 'IT'가 들어가지 않는 사원의 사원번호, 이름, 급여, 부서번호, 부서, 직무를 출력하시오.
----    단, 급여를 내림차순으로 정렬
select employee_id, first_name, salary, e.department_id, department_name, job_id
from hr.employees e join hr.departments d
on e.department_id = d.department_id
where job_id not like '%IT%'; 
---- 11 지역번호가 1700인 사원의 사원번호, 사원이름, 부서번호, 부서이름, 지역번호, 주소, 도시를 구하시오.
select employee_id, first_name, d.department_id, department_name, d.location_id, street_address, city
from hr.employees e join hr.departments d
on e.department_id = d.department_id join hr.locations l
on d.location_id = l.location_id
where l.location_id = 1700;
---- 12 부서장이 존재하지 않는 부서의 국가명을 출력하시오
select manager_id ,country_name from hr.departments d right outer join hr.locations l
on d.location_id = l.location_id join hr.countries c
on l.country_id = c.country_id
where manager_id is null;
---- 13 도시명이 o로 끝나는 도시의 지역코드가 2 이하인 도시명, 국가명, 지역번호, 지역명을 출력하시오
select city, country_name, location_id, region_name
from hr.locations l join hr.countries c
on l.country_id = c.country_id join hr.regions r
on c.region_id = r.region_id
where city like '%o' and r.region_id <= 2;
---- 14 부서명이 g 로 끝나는 부서의 국가코드를 모두 출력하시오
select department_name, country_id from hr.departments d join hr.locations l
on d.location_id = l.location_id
where department_name like '%g';
---- 15 AD 로 시작하는 직무를 가진 사원 중 직무 내용이 t로 끝나는 사원의 이름, 직무, 직무내용을 출력하시오
select first_name, j.job_id, job_title from hr.employees e join hr.jobs j
on e.job_id = j.job_id 
where j.job_id like 'AD%' and j.job_title like '%t';
---- 16 입사일이 2004년도 이후이며 현재 직무의 최저 연봉이 4000 이상인 직원의
----     이름, 연봉, 최저연봉, 입사일, 부서명, 부서의 주소를 출력하시오
select first_name, salary*12*(1+(nvl(commission_pct,0))) as year_sal 
, min_salary*12*(1+(nvl(commission_pct,0))) as year_min_sal,hire_date, department_name, street_address
from hr.employees e join hr.jobs j
on e.job_id = j.job_id  join hr.departments d
on d.department_id = e.department_id left outer join hr.locations l
on l.location_id = d.location_id
where hire_date >= '2005.01.01' and min_salary*12*(1+(nvl(commission_pct,0))) >= 4000;
--17 ANSI-JOIN을 사용해서 사원번호, 이름, 부서번호, 위치를 출력하는데 상사가 149인 사원들만 출력하시오.
select employee_id, first_name, d.department_id, d.location_id from hr.employees e join hr.departments d
on e.department_id = d.department_id join hr.locations l
on d.location_id = l.location_id
where e.manager_id = 149;

--18. 직무에 4번째에서 6번째까지 PRO가 있다면 it_program으로 출력
--                                 ACC가 있다면 finance_account
--                                 나머지는 business로 출력하시오.
select job_id, case substr(job_id,4,3) when 'PRO'  then 'it_program'
                           when 'ACC' then 'finance_account'
                           else 'business' end as jc
from hr.employees ;

--19. 직무에 REP가 포함되어 있는 사원들의 평균 급여와 최소급여
--      최대급여 급여의 합계를 구하시오.
select max(salary), min(salary) , sum(max_salary)
from hr.jobs j join hr.employees e
on j.job_id = e.job_id
where j.job_id like '%REP%';
--20.  부서별 최대 급여가 10000이상인 부서만 출력하시오.
select d.department_id, max(salary) from hr.employees e join hr.departments d
on e.department_id = d.department_id join hr.jobs j
on e.job_id = j.job_id
group by d.department_id
having max(salary) > 10000;
--21. 직무에 'SA'포함하고 있지 않은 사원들중 직무별 급여의 합계가 
--10000을 초과하는 직무와 급여의 합계를 출력하시오.
--또한 급여의 합계를 내림차순으로 정렬하여 출력
select job_id, sum(salary) from hr.employees
where job_id not like '%SA%'
group by job_id
having sum(salary) > 10000
order by 2 desc;
--22. 부서가 20이거나 50인 부서의 사원번호와 부서번호 및 부서명 
--그리고 위치정보를 출력하시오.
select employee_id, d.department_id, department_name, location_id
from hr.employees  e join hr.departments d
on e.department_id = d.department_id 
where d.department_id in (20,50);
--23. Matos라는 성을 가지고 있는 사원이 있다.
--이 사원의 부서정보와 사원번호 그리고 성을 출력하시오.
select department_id, employee_id, last_name from hr.employees
where last_name = 'Matos';
--24. Matos라는 성을 가지고 있는 사원과 King라는 성을 
--      가진 사원이 있다.
--이 사원의 부서정보와 사원번호 그리고 성을 출력하시오.
select department_id, employee_id, last_name from hr.employees
where last_name in ('Matos','King');
--25. King라는 성을 가지고 있는 사원이 있다.
--이 사원의 부서정보와 사원번호 그리고 성을 출력하시오.
select department_id, employee_id, last_name from hr.employees
where last_name ='King';
--26. 부서테이블에서 부서번호와 부서명 그리고 지역코드와 
--      지역명을 출력하는데 지역코드가 1400인 지역만 출력
select department_id, department_name, l.location_id, city
from hr.departments d join hr.locations l
on d.location_id = l.location_id 
where l.location_id = 1400;
--27. 직원의 정보를 출력할 때 부서정보와 그 부서의 주소를 
--      출력하시오.
select employee_id, first_name, d.department_id, street_address from hr.employees e join hr.departments d
on e.department_id = d.department_id left outer join hr.locations l
on d.location_id = l.location_id;

--28. 직원정보를 출력할 때 그 직원의 부서정보와 그 직원 
--      직무내용을 출력하시오.
--      부서번호, 부서명, 직무번호, 직무내용
select e.department_id, department_name, e.job_id, job_title
from hr.employees e join hr.departments d
on e.department_id = d.department_id join hr.jobs j
on e.job_id = j.job_id;
--29. 사원정보와 부서정보를 출력할 때 사원이 없는 부서도 출력하되
--200번 부서부터 260부서를 제외하고 출력하시오.
select * from hr.employees e right outer join hr.departments d
on e.department_id = d.department_id
where e.department_id not between 200 and 260;
--30. 사원정보와 부서정보를 출력할 때 사원이 없는 부서도 출력하되
--사원번호가 홀수인 것 만 출력하시오.
select * from hr.employees e right outer join hr.departments d
on e.department_id = d.department_id
where mod(employee_id,2) != 0 or e.employee_id is null;

