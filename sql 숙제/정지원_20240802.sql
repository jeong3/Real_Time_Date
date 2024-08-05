---- 1. �μ���ȣ, �μ���, ������ȣ, ���� ��ȣ�� ����ϼ���
--      ���� ��ȣ us�� ��� �ϼ���
select * from hr.locations;
select department_id, department_name, l.location_id, country_id
from hr.departments d join hr.locations l
on d.location_id = l.location_id 
where country_id = upper('us');
---- 2. ������ȣ, ��, �̸�, �ּ�, ����, �μ���ȣ, ������ȣ, ��������, ���� �̸��� ���
select employee_id, last_name, first_name, street_address, e.job_id, job_title, d.location_id, country_name
from hr.employees e join hr.jobs j
on e.job_id = j.job_id join hr.departments d
on e.department_id = d.department_id join hr.locations l
on d.location_id = l.location_id join hr.countries c
on c.country_id = l.country_id;
---- 3. ������ 'ST_CLERK'�� ����� ������?
select country_id from hr.employees e left outer join hr.departments d
on e.department_id = d.department_id left outer join hr.locations l
on d.location_id = l.location_id
where job_id = 'ST_CLERK';
---- 4. ������ �μ��� ����� ������? Marketing
select employee_id,salary*(1+nvl(commission_pct,0))*12 from hr.employees e join hr.departments d
on e.department_id = d.department_id
where department_name = 'Marketing';
---- 5. ������ ���� �μ��� ������ ���Ͻÿ�.
select count(*) from hr.employees e right outer join hr.departments d
on e.department_id = d.department_id
where e.employee_id is null;
---- 6. ���� �����丮 ���̺��� �����ϰ� ���������� 5�� �̻� ���̳��� ������ ��, �̸�, �μ����� ���
select last_name, first_name, department_name from hr.employees e join hr.job_history jh
on e.employee_id = jh.employee_id join hr.departments d
on e.department_id = d.department_id
where (end_date - start_date)/365 >= 5;
---- 7 �μ��� ���� ������ ������ ���� �μ��� ����ϰ� �μ��� �̸����� ����Ͻÿ�.
select employee_id,department_name from hr.employees e full outer join hr.departments d
on e.department_id = d.department_id;
---- 8 ������ȣ, �̸�, �μ���ȣ, �μ���, ������ȣ, �ּ�, city�� ����ϴµ� CITY�� 'London'�� ����� ����Ͻÿ�.
select employee_id, first_name, e.department_id, department_name, d.location_id, street_address, city
from hr.employees  e join hr.departments d
on e.department_id = d.department_id join hr.locations l
on d.location_id = l.location_id
where city = 'London';
---- 9 ������ 'IT'�� ���� ��� �� �޿��� 3000�̻��� ����� ����Ͻÿ�.
----    ������ȣ, �����̸�, ������ȣ, ����, �޿� ���
select employee_id, first_name, e.job_id, job_title, salary
from hr.employees e join hr.jobs j
on e.job_id = j.job_id
where j.job_id like '%IT%' and salary >= 3000;
---- 10 ������ 'IT'�� ���� �ʴ� ����� �����ȣ, �̸�, �޿�, �μ���ȣ, �μ�, ������ ����Ͻÿ�.
----    ��, �޿��� ������������ ����
select employee_id, first_name, salary, e.department_id, department_name, job_id
from hr.employees e join hr.departments d
on e.department_id = d.department_id
where job_id not like '%IT%'; 
---- 11 ������ȣ�� 1700�� ����� �����ȣ, ����̸�, �μ���ȣ, �μ��̸�, ������ȣ, �ּ�, ���ø� ���Ͻÿ�.
select employee_id, first_name, d.department_id, department_name, d.location_id, street_address, city
from hr.employees e join hr.departments d
on e.department_id = d.department_id join hr.locations l
on d.location_id = l.location_id
where l.location_id = 1700;
---- 12 �μ����� �������� �ʴ� �μ��� �������� ����Ͻÿ�
select manager_id ,country_name from hr.departments d right outer join hr.locations l
on d.location_id = l.location_id join hr.countries c
on l.country_id = c.country_id
where manager_id is null;
---- 13 ���ø��� o�� ������ ������ �����ڵ尡 2 ������ ���ø�, ������, ������ȣ, �������� ����Ͻÿ�
select city, country_name, location_id, region_name
from hr.locations l join hr.countries c
on l.country_id = c.country_id join hr.regions r
on c.region_id = r.region_id
where city like '%o' and r.region_id <= 2;
---- 14 �μ����� g �� ������ �μ��� �����ڵ带 ��� ����Ͻÿ�
select department_name, country_id from hr.departments d join hr.locations l
on d.location_id = l.location_id
where department_name like '%g';
---- 15 AD �� �����ϴ� ������ ���� ��� �� ���� ������ t�� ������ ����� �̸�, ����, ���������� ����Ͻÿ�
select first_name, j.job_id, job_title from hr.employees e join hr.jobs j
on e.job_id = j.job_id 
where j.job_id like 'AD%' and j.job_title like '%t';
---- 16 �Ի����� 2004�⵵ �����̸� ���� ������ ���� ������ 4000 �̻��� ������
----     �̸�, ����, ��������, �Ի���, �μ���, �μ��� �ּҸ� ����Ͻÿ�
select first_name, salary*12*(1+(nvl(commission_pct,0))) as year_sal 
, min_salary*12*(1+(nvl(commission_pct,0))) as year_min_sal,hire_date, department_name, street_address
from hr.employees e join hr.jobs j
on e.job_id = j.job_id  join hr.departments d
on d.department_id = e.department_id left outer join hr.locations l
on l.location_id = d.location_id
where hire_date >= '2005.01.01' and min_salary*12*(1+(nvl(commission_pct,0))) >= 4000;
--17 ANSI-JOIN�� ����ؼ� �����ȣ, �̸�, �μ���ȣ, ��ġ�� ����ϴµ� ��簡 149�� ����鸸 ����Ͻÿ�.
select employee_id, first_name, d.department_id, d.location_id from hr.employees e join hr.departments d
on e.department_id = d.department_id join hr.locations l
on d.location_id = l.location_id
where e.manager_id = 149;

--18. ������ 4��°���� 6��°���� PRO�� �ִٸ� it_program���� ���
--                                 ACC�� �ִٸ� finance_account
--                                 �������� business�� ����Ͻÿ�.
select job_id, case substr(job_id,4,3) when 'PRO'  then 'it_program'
                           when 'ACC' then 'finance_account'
                           else 'business' end as jc
from hr.employees ;

--19. ������ REP�� ���ԵǾ� �ִ� ������� ��� �޿��� �ּұ޿�
--      �ִ�޿� �޿��� �հ踦 ���Ͻÿ�.
select max(salary), min(salary) , sum(max_salary)
from hr.jobs j join hr.employees e
on j.job_id = e.job_id
where j.job_id like '%REP%';
--20.  �μ��� �ִ� �޿��� 10000�̻��� �μ��� ����Ͻÿ�.
select d.department_id, max(salary) from hr.employees e join hr.departments d
on e.department_id = d.department_id join hr.jobs j
on e.job_id = j.job_id
group by d.department_id
having max(salary) > 10000;
--21. ������ 'SA'�����ϰ� ���� ���� ������� ������ �޿��� �հ谡 
--10000�� �ʰ��ϴ� ������ �޿��� �հ踦 ����Ͻÿ�.
--���� �޿��� �հ踦 ������������ �����Ͽ� ���
select job_id, sum(salary) from hr.employees
where job_id not like '%SA%'
group by job_id
having sum(salary) > 10000
order by 2 desc;
--22. �μ��� 20�̰ų� 50�� �μ��� �����ȣ�� �μ���ȣ �� �μ��� 
--�׸��� ��ġ������ ����Ͻÿ�.
select employee_id, d.department_id, department_name, location_id
from hr.employees  e join hr.departments d
on e.department_id = d.department_id 
where d.department_id in (20,50);
--23. Matos��� ���� ������ �ִ� ����� �ִ�.
--�� ����� �μ������� �����ȣ �׸��� ���� ����Ͻÿ�.
select department_id, employee_id, last_name from hr.employees
where last_name = 'Matos';
--24. Matos��� ���� ������ �ִ� ����� King��� ���� 
--      ���� ����� �ִ�.
--�� ����� �μ������� �����ȣ �׸��� ���� ����Ͻÿ�.
select department_id, employee_id, last_name from hr.employees
where last_name in ('Matos','King');
--25. King��� ���� ������ �ִ� ����� �ִ�.
--�� ����� �μ������� �����ȣ �׸��� ���� ����Ͻÿ�.
select department_id, employee_id, last_name from hr.employees
where last_name ='King';
--26. �μ����̺��� �μ���ȣ�� �μ��� �׸��� �����ڵ�� 
--      �������� ����ϴµ� �����ڵ尡 1400�� ������ ���
select department_id, department_name, l.location_id, city
from hr.departments d join hr.locations l
on d.location_id = l.location_id 
where l.location_id = 1400;
--27. ������ ������ ����� �� �μ������� �� �μ��� �ּҸ� 
--      ����Ͻÿ�.
select employee_id, first_name, d.department_id, street_address from hr.employees e join hr.departments d
on e.department_id = d.department_id left outer join hr.locations l
on d.location_id = l.location_id;

--28. ���������� ����� �� �� ������ �μ������� �� ���� 
--      ���������� ����Ͻÿ�.
--      �μ���ȣ, �μ���, ������ȣ, ��������
select e.department_id, department_name, e.job_id, job_title
from hr.employees e join hr.departments d
on e.department_id = d.department_id join hr.jobs j
on e.job_id = j.job_id;
--29. ��������� �μ������� ����� �� ����� ���� �μ��� ����ϵ�
--200�� �μ����� 260�μ��� �����ϰ� ����Ͻÿ�.
select * from hr.employees e right outer join hr.departments d
on e.department_id = d.department_id
where e.department_id not between 200 and 260;
--30. ��������� �μ������� ����� �� ����� ���� �μ��� ����ϵ�
--�����ȣ�� Ȧ���� �� �� ����Ͻÿ�.
select * from hr.employees e right outer join hr.departments d
on e.department_id = d.department_id
where mod(employee_id,2) != 0 or e.employee_id is null;

