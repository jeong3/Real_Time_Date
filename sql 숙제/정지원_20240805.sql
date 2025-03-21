--1. 직원의 직원정보와 직무내역을 출력하는 직무내역이 없는
--직원도 출력하시오. job_history도 이용
select * from hr.employees e left outer join hr.job_history jh
on e.employee_id = jh.employee_id;
--2. 직무에 4번째에서 6번째까지 PRO가 있다면 it_program으로 출력
--                                 ACC가 있다면 finance_account
--                                 나머지는 business로 출력하시오.
select job_id , case substr(job_id, 4,3) when '%PRO%' then 'it_program'
                                         when '%ACC%' then 'finance_account'
                                         else 'business' end as job_id
                                         from hr.employees;
--3. 급여가 15000 이상이면 임원으로 출력
--             10000 이상이면 부장
--             7000  이상이면 과장
--             5000이상이면 대리
--             나머지는 사원으로 출력하시오.
select salary , case  when salary>=15000 then '부장'
                      when salary>=7000 then '과장'
                      when salary>=5000 then '대리'
                      else '사원' end as sal
                      from hr.employees;
--4. 부서별 급여의 평균이 5000이상인 부서만 출력하시오.
select department_id, trunc(avg(salary)) from hr.employees
group by department_id
having avg(salary)>=5000;
--5. 급여가 10000이상인 사원들중 부서별 급여 평균이 16000이상인 부서만 출력하시오
select department_id, trunc(avg(salary)) from hr.employees
where salary >=10000
group by department_id
having avg(salary)>=16000;
--6. 입사일이 2005년도  이전에 입사한 사람들 중 부서별 최대급여가 8000이상인 부서와 최대 급여를 출력하시오.
select department_id, max(salary) from hr.employees
where hire_date < '2005.01.01'
group by department_id
having max(salary)>=8000;
--7. 부서별 최대 급여가 10000이상인 부서만 출력하시오.
select department_id, max(salary) from hr.employees
group by department_id
having max(salary)>=10000;
--8. 직무에 'REP'포함하고 있지 않은 사원들중 직무별 급여의 합계가 3000을 초과하는 직무와 급여의 합계를 출력하시오.
--또한 급여의 합계를 내림차순으로 정렬하여 출력
select sum(salary), job_id from hr.employees
where job_id not like '%REP%'
group by job_id
having sum(salary) > 3000;
--9.  직원의 25-10-2020까지의 근무일수를 계산하시오.
--직원번호, 부서번호, 입사일, 근무일수
select employee_id, department_id, hire_date, (to_date('25-10-2020', 'dd-mm-yyyy')-hire_date)  from hr.employees;
--10. '01-01-2005'에 입사한 사원을 출력하시오.
--직원번호, 부서번호, 입사일, 근무일수
select employee_id, department_id, hire_date, (to_date('25-10-2020', 'dd-mm-yyyy')-hire_date)  from hr.employees
where hire_date = to_date('01-01-2005', 'dd-mm-yyyy');
select employee_id, department_id, hire_date, (sysdate-hire_date)  from hr.employees
where to_char(hire_date,'dd-mm-yyyy') = '01-01-2005';
--11. 연봉(급여*12) : 급여는 커미션까지 포함된다.
--직원의 년봉을 구하시오.
-- 직원번호, 부서번호, 급여, 년봉
select employee_id, department_id, salary, salary*12*(1+nvl(commission_pct,0)) from hr.employees;
--12.  'IT_PROG' 이면 급여를  1.10*salary
--      'ST_CLERK' 이면 급여를  1.15*salary
--      'SA_REP' 이면  급여를 1.20*salary
--       나머지 직무는 salary 로 급여를 지불하고 heading name을      "REVISED_SALARY"가 되게 하시오.
select job_id ,case job_id when 'IT_PROG' then 1.10*salary
                           when 'ST_CLERK' then 1.15*salary
                           when 'SA_REP' then 1.20*salary
                           else salary end as REVISED_SALARY
                           from hr.employees;
                           
--13 커미션을 포함한 급여의 평균을 구하시오. 커미션을 바다지 않은 직원도 포함
select salary*12*(1+nvl(commission_pct,0)) from hr.employees;
--14. 각부서별 커미션을 포함한 급여의 합계를 구하시오.
select department_id,sum(salary*(1+nvl(commission_pct,0))) from hr.employees
group by department_id;
--15. 각 부서의 직원수가 5명 이상인 부서만 출력하시오. (join아님)
select department_id,count(department_id) from hr.employees
group by department_id
having count(department_id) = 5;
--16. 각 부서에 있는 사원의 직무별 급여의 평균을 구하시오.
select job_id, avg(salary) from hr.employees
group by job_id;
--17. 사원번호, 이름 , 급여, 입사일 , 부서번호, 부서명, 직무번호, 직무명을 출력할 때 담당하지 않는 직무도 출력하고 사원이 없는 직무도 출력하시오.
select employee_id, first_name, salary, hire_date, d.department_id, department_name, j.job_id, job_title
from hr.employees e left outer join hr.departments d
on e.department_id = d.department_id full outer join hr.jobs j
on e.job_id = j.job_id;
--18. 사원테이블에서 직무에 MAN를 포함하고 급여가 10000이상인 
--사원을 사원번호와 성과 직무 그리고 급여를 출력하시오.
select job_id, salary, employee_id, first_name from hr.employees
where salary >= 10000 and job_id like '%MAN%';
--19. 직무가 SA_REP와 AD_PRES 이면서 급여가 15000을 초과하는  사원을 출력하시오.
-- 단, 성, 직무, 급여만 출력 or와 and만 사용
select  first_name, job_id, salary from hr.employees
where (job_id ='SA_REP' or job_id = 'AD_PRES') and salary > 15000;
--20. 위 예제에 in연산자를 사용하시오.
select  first_name, job_id, salary from hr.employees
where job_id in('SA_REP','AD_PRES') and salary > 15000;
--21. 부서는 내림차순으로 정렬하고 입사일도 내림차순으로 정렬
--부서번호 , 급여, 입사일, 성
select employee_id, salary, hire_date, last_name from hr.employees
order by department_id desc, 3 desc;
--22. 부서는 내림차순으로 정렬하고 입사일은 오름차순으로 정렬하여 출력
--부서번호 , 급여, 입사일, 성
select department_id, salary, hire_date, last_name from hr.employees
order by 1 desc, 3;
--23. 부서는 내림차순으로 정렬하고 입사일은 오름차순으로 정렬하여 
--급여를 내림차순으로 정렬하여 출력
--부서번호 ,  입사일, 급여, 성
select department_id, hire_date, salary, last_name from hr.employees
order by 1 desc, 2, 3 desc;
