--1.'RE'가 직무에 포함되지 않으며 근속 년수가 10년 이상인 사원들을 출력하시오
--이름, 급여, 직무, 직무내용, 주소, 국가명, 우편번호순으로 
select first_name, salary, e.job_id, job_title, street_address, country_name, postal_code
from hr.employees e join hr.jobs j 
on e.job_id = j.job_id left outer join hr.departments d
on e.department_id = d.department_id left outer join hr.locations l
on d.location_id = l.location_id left outer join hr.countries c
on l.country_id = c.country_id
where e.job_id not like '%RE%' and (sysdate-hire_date)/365 >= 10;
--2.직원정보를 출력하는데 커미션이 null일 경우 0.01%의 커미션을 주기로 합의하여 이를 YEARSAL로 $표기와 함께 세자리씩 급여와 출력하고 직무내용, 주소와 출생 국가를 출력하시오
--직원번호, 이름, 성, 급여, 커미션을 포함한 연봉, 직무, 직무내용, 주소
select employee_id, first_name, last_name, salary, to_char((1+nvl(commission_pct,0.01))*12*salary,'$999,999,999') as year_sal , e.job_id, job_title, street_address, state_province
from hr.employees e join hr.jobs j 
on e.job_id = j.job_id left outer join hr.departments d
on e.department_id = d.department_id left outer join hr.locations l
on d.location_id = l.location_id; 
--3.국가와 대륙의 정보를 모두 출력하시오
--국가번호, 국가명, 지역번호, 대륙명
select c.country_id, country_name, location_id, r.region_id 
from hr.countries c join hr.regions r
on c.region_id = r.region_id join hr.locations l
on c.country_id = l.country_id;
--4.직무가 'AC_MGR'과 'ST_CLERK'사이에있는 미국에 사는 직원들의 정보를 출력하시오
--사원번호, 이름, 성, 직무, 직무내용, 부서번호, 부서명, 국가명
select employee_id, first_name, last_name, j.job_id, job_title, d.department_id, department_name, country_name
from hr.employees e join hr.jobs j
on e.job_id = j.job_id left outer join hr.departments d
on e.department_id = d.department_id left outer join hr.locations l
on d.location_id = l.location_id left outer join hr.countries c
on l.country_id = c.country_id
where e.job_id between 'AC_MGR' and 'ST_CLERK' and c.country_id = 'US';
--5.직원정보를 출력하는데 사원번호가 128에서 188사이이면서 'R'을 직무에 포함하는 직원정보와 부서 정보를 출력하시오
select * from hr.employees e join hr.departments d
on e.department_id = d.department_id
where job_id like '%R%' and
employee_id between 128 and 188 ;
--6.부서정보를 출력하는데 도시,국가코드, 국가명을 포함하여 부서정보가 없는 도시도 포함하여 출력하시오
select city, c.country_id, country_name 
from hr.departments d right outer join hr.locations l
on d.location_id = l.location_id join hr.countries c
on l.country_id = c.country_id
where d.department_id is null;
-- 7. 성, 입사일, 직무명, 직무내용, 부서번호, 부서명 출력
-- 부서가 60인 데이터를 입사일 기준으로 정렬
select last_name, hire_date, e.job_id, job_title, e.department_id, department_name
from hr.employees e join hr.jobs j
on e.job_id = j.job_id join hr.departments d
on e.department_id = d.department_id
where e.department_id = 60
order by 2;
-- 8. 50인 부서의 지역번호를 찾고
-- 그 지역 번호, 도시, 나라 번호, 나라명을 출력하시오
select d.location_id, city, c.country_id, country_name
from hr.locations l join hr.countries c
on l.country_id = c.country_id join hr.departments d
on l.location_id = d.location_id
where department_id = 50;
-- 9. '02/06/07'부터 '06/11/15' 사이에 입사한 사원의 
-- 직원번호, 성, 이름, 입사날짜, 부서번호, 부서명을 출력하시오.
-- 단, 입사일을 기준으로 내림차순으로 정렬하시오.
select employee_id, last_name, first_name, hire_date, d.department_id, department_name
from hr.employees e left outer join hr.departments d
on e.department_id = d.department_id
where hire_date between '02/06/07' and '06/11/15'
order by 4 desc;
-- 10. 직원번호, 성, 이름, 전화번호, 부서명, 지역 번호를 출력하시오
-- 전화번호 앞자리가 515 인 직원의 정보만 출력하세요
select employee_id, last_name, first_name, phone_number, department_name, location_id
from hr.employees e left outer join hr.departments d
on e.department_id = d.department_id
where phone_number like '515%';
-- 11. 이름에 'os'가 들어가는 직원의
-- 직원 번호, 이름, 직무, 직무 내용, 부서 번호, 부서명을 출력하시오
select employee_id, first_name, e.job_id, job_title, e.department_id, department_name
from hr.employees e left outer join hr.departments d
on e.department_id = d.department_id join hr.jobs j
on e.job_id = j.job_id
where lower(first_name) like '%os%';
-- 12. 50부서의 직무별 급여 합계와 평균 구하시오.
-- 직무명, 급여의 합계, 평균을 출력한다.
-- 급여의 평균을 기준으로 오름차순 정렬한다.
select job_id, sum(salary), avg(salary)
from hr.employees e join hr.departments d
on e.department_id = d.department_id
where d.department_id = 50
group by job_id
order by 3;
-- 13. 직원들의 커미션을 포함한 연봉을 null 값이 나오지 않도록 계산하시오.
-- 계산한 연봉의 별칭은 year_sal이라고 소문자로 출력되도록 한다
-- 직원번호, 성, 이름, 급여, 커미션, 계산한 연봉을 출력한다
select employee_id, last_name, first_name, salary, commission_pct,  salary*(nvl(commission_pct,0)+1)*12 as year_sal
from hr.employees;
-- 14. 'ST_CLERK' 직무를 갖는 직원의 
-- 직원번호, 성, 이름, 직무, 직원의 급여, 해당 직무의 최소/최대 급여를 출력하시오.
select employee_id, last_name, first_name, j.job_id, salary , min_salary, max_salary
from hr.employees e join hr.jobs j
on e.job_id = j.job_id
where j.job_id ='ST_CLERK' ;
-- 15. 대륙 번호(region_id)가 2인 
-- 국가명(country_name), 국가번호(country_id), 도시(city)를 출력하시오
select country_name,c.country_id,city
from hr.countries c join hr.locations l
on c.country_id = l.country_id
where region_id = 2;
-- 16. 부서명이 'IT'인 부서의 직원 정보 출력
-- 직원번호, 성, 이름, 급여, 부서명, 직무명, 직무 내용
-- 직원 번호를 기준으로 내림차순 정렬
select employee_id, last_name, first_name, salary, department_name, e.job_id, job_title
from hr.employees e join hr.departments d
on e.department_id = d.department_id join hr.jobs j
on e.job_id = j.job_id
where department_name = 'IT'
order by 1 desc; 
--17. 이름에 'HA'가 들어가는 사원의 사원 번호, 이름, 부서, 부서명, 직무명, 직무 내용을 출력하시오.
select employee_id, first_name, e.department_id, department_name, e.job_id, job_title
from hr.employees e left outer join hr.departments d
on e.department_id = d.department_id join hr.jobs j
on e.job_id = j.job_id
where upper(first_name) like '%HA%';
---18. 직무가 'ACCOUNT'를 가진 각 부서의 평균이 5000이상인 부서의 
-- 평균 급여, 합계 , 최소 , 최대를 구하시오.
select d.department_id, avg(salary), sum(salary), min(salary), max(salary)
from hr.employees e join hr.departments d
on e.department_id = d.department_id
where job_id like '%ACCOUNT%'
group by d.department_id
having avg(salary) >= 5000;
---19. 지역 번호(location_id)가 2000부터 2500인 지역의 
-- 지역번호(location_id),주소, 우편번호, 도시, 국가 번호(country_id)
-- 국가 이름(country_name) ,지역 번호(region_id), 지역 이름 출력
-- 단 지역번호를 기준 오름차순
select location_id, street_address, postal_code, city, c.country_id, country_name, r.region_id, region_name
from hr.locations l join hr.countries c
on l.country_id  = c.country_id join hr.regions r
on c.region_id = r.region_id
where location_id between 2000 and 2500 
order by 1;
--20. 최소 급여가 10000이상인 직무명과 직무 내용을 출력하시오.
-- 단 내림차순으로 정렬하시오.
select job_id, job_title 
from hr.jobs
where min_salary >= 10000
order by 1 desc;
--21. 's'가 들어가지 않는 도시의 우편번호와 주소,
-- 국가명과 지역번호(region_id)를 출력하시오.
select postal_code, street_address, country_name, region_id
from hr.locations l join hr.countries c
on l.country_id = c.country_id 
where city not like '%s%';
-- 22.05/12/15 이후에 입사한 사람은?
-- salary 순으로 내림차순
select * from hr.employees
where hire_date >= '05/12/15'
order by salary desc;
--- 23. 최소급여의 최솟값, 최대 급여의 최댓값
-- 가장 빠른 시작일(start_date)과 가장 늦은 만기일(end_date)을 구하시오.
select min(start_date), max(end_date),max(max_salary), min(min_salary) from hr.job_history jh full outer join hr.jobs j
on jh.job_id = j.job_id;
--24. 상사가 없는 사원의 부서 번호와 부서 이름, 이메일, 급여를 구하시오.
select d.department_id, department_name , email, salary from hr.employees e left outer join hr.departments d
on e.department_id = d.department_id
where e.manager_id is null;
--25. 부서 번호가 50과 80인 사람의 직원 번호, 성, 이름, 휴대폰 번호, 고용일을 구하시오.
select employee_id, last_name, first_name, phone_number, hire_date from hr.employees e join hr.departments d
on e.department_id = d.department_id
where d.department_id in (50,80);
-- 26. 부서가 있는 직원 모두 출력
select * from hr.employees e join hr.departments d
on e.department_id = d.department_id
where e.department_id is not null;
-- 27. countrys 테이블에서 번호,이름, regoin_id를 출력하면서
 --     regions 테이블에서 분류이름을 같이 출력하세요
  --    locations 테이블에서 국가번호와 도시를 출력하세요
select c.country_id, country_name, c.region_id
    , region_name, l.country_id, city
    from hr.countries c join hr.regions r
    on c.region_id = r.region_id join hr.locations l
    on c.country_id = l.country_id;
  
-- 28. 부서번호 부서명을 출력하면서
  --    부서번호가 100이내이면서 직원 번호가  200이상인것만 출력하세요
select d.department_id, department_name from hr.departments d join hr.employees e
on d.department_id = e.department_id
where d.department_id <= 100 and employee_id >= 200;
-- 29. 부서 테이블에서 부서번호,부서장, 지역번호와
  --    지역 테이블에서 도시 국가번호를 출력하면서
  --    국가 테이블에서 국가번호 국가 이름을 출력하세요.
select department_id, manager_id, d.location_id, 
city, l.country_id,
c.country_id, country_name
from hr.departments d join hr.locations l
on d.location_id = l.location_id join hr.countries c
on l.country_id = c.country_id;
-- 30. 직원번호 성 이메일 직무 직무 내용출력하면서
   --   직무번호 중 AD_PRES 이면서
   --   이메일 길이가 5인 사원만 출력하시오
   select employee_id,last_name, email, j.job_id, job_title from hr.employees e join hr.jobs j
   on e.job_id = j.job_id
   where j.job_id = 'AD_PRES' and length(email) = 5;