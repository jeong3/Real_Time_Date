--1. ��, �̸� , �޿�, �μ�, �μ���, ������ȣ, �����ּҸ� ����Ͻÿ�
select last_name, first_name, salary, e.department_id
, d.department_name
, l.location_id,street_address
from hr.employees e join hr.departments d
on e.department_id = d.department_id join hr.locations l
on d.location_id = l.location_id ;
--2. �μ��� ���� ������ ������ ���� �μ��� ����ϸ� ������ �����ּҸ� ����Ͻÿ�.
select employee_id, e.department_id, d.location_id, street_address
from hr.departments d full outer join hr.employees e 
on d.department_id = e.department_id join hr.locations l
on d.location_id = l.location_id;
--3. ����, ��������, �μ���, �����ּҸ� �̸��� �Բ� ����Ͻÿ�.
select j.job_id, job_title
,d.department_name , street_address , first_name
from hr.jobs j join hr.employees e
on j.job_id = e.job_id join hr.departments d
on e.department_id = d.department_id join hr.locations l
on d.location_id = l.location_id;
--4. �̸�, ��, �μ���, ������ȣ�� �����ȣ�� 152�� ����� ����Ͻÿ�
select first_name, last_name, department_name, location_id
from hr.employees e join hr.departments d
on e.department_id = d.department_id
where e.employee_id = 152;
--5. ������ȣ, �̸�, ��, ����, ��������, �μ���, �����ȣ, ������ȣ, ������, �������� ����Ͻÿ� 
select employee_id, first_name, last_name
, j.job_id, job_title
, department_name 
, l.location_id, country_id, city, street_address
from hr.employees e join hr.jobs j
on e.job_id = j.job_id join hr.departments d
on e.department_id = d.department_id join hr.locations l
on d.location_id = l.location_id;

--6. ������ȣ, ��, �̸�, �̸���, �μ���ȣ, �μ����� ������ּ���.
select employee_id, last_name, first_name, email, d.department_id, department_name
from hr.employees e join hr.departments d
on e.department_id = d.department_id;
--7. ������ȣ, ��������, ��, �̸�, �Ի����� ����ϰ�,
----������ȣ�� 'SA_REP' �̸� �Ի����� '020816' �Ϻ��� '050921'������ ���������� ������ּ���.
select e.job_id, job_title, last_name, first_name, hire_date
from hr.jobs j join hr.employees e
on j.job_id = e.job_id
where e.job_id = 'SA_REP' and hire_date between '02.08.16' and '05.09.21';
--8. ������ȣ, ��, �̸�, �μ���ȣ, �μ����� ����ϸ� Ŀ�̼��� ���� �ʴ»���� ������ּ���.
select employee_id, last_name, first_name, e.department_id, department_name
from hr.employees e join hr.departments d
on e.department_id = d.department_id
where commission_pct is null;
--9. ������ȣ, ��, �̸�, �μ���ȣ, �μ���, ������ȣ, �ּҸ� ����ϰ� ���ð� 'Toronto'�� ��� ����� ������ּ���. 
select employee_id, last_name, first_name
, department_name
, l.location_id, street_address
from hr.employees e join hr.departments d
on e.department_id = d.department_id join hr.locations l
on d.location_id = l.location_id
where city = 'Toronto';
--10. ��������, ��, �̸�, �μ���, �ּ�, ��ű����� ����ϰ� ������ ���� ��籹���� ������ּ���.
select employee_id , last_name
, department_name
, street_address, state_province
from hr.employees e join hr.departments d
on e.department_id = d.department_id right outer join hr.locations l
on d.location_id = l.location_id ;
--11. �μ���ȣ�� 60�� ����� ��, �̸�, ��� ��ȣ, �޿�, �μ����� ����Ͻÿ�.
select last_name, first_name, employee_id, salary, department_name
from hr.employees e join hr.departments d
on e.department_id = d.department_id
where e.department_id = 60;
--12. �޿��� 4800�� ����� ��� ��ȣ,���� ��ȣ, ������, �ּұ޿�(min_salary), �ִ�޿�(max_salary)�� ����Ͻÿ�.
select employee_id, e.job_id, job_title, min_salary, max_salary
from hr.employees e join hr.jobs j
on e.job_id = j.job_id
where salary = 4800;
--13. ������ȣ�� 1700�� ����� ���� �̸�, ��ȭ��ȣ, ������� ����Ͻÿ�.
select * from hr.locations;
select last_name, first_name, phone_number, hire_date
from hr.employees e join hr.departments d
on e.department_id = d.department_id join hr.locations l
on d.location_id = l.location_id
where l.location_id = 1700;
--14. ���� �ּ� �޿��� 4000�� ������ ���� ����� ��, �̸�, �������� ����Ͻÿ�.
select last_name, first_name, job_title 
from hr.employees e join hr.jobs j 
on e.job_id = j.job_id
where salary = 4000;
--15.��� ��ȣ(REGION_ID)�� 4�� ������ ��ȣ(COUNTRY_ID) �� �̸�(COUNTRY_NAME) �� ����Ͻÿ�.(hr.countries)
select country_id , country_name from hr.countries
where region_id = 4;
--16. ���� ��ȣ�� �ּ�, �����ȣ, ���ø��� ��µǵ��� �Ͻÿ�.
---- ��, UK�� ������ �������� ����Ͻÿ�.
select location_id, street_address, postal_code, city from hr.locations
where country_id = 'UK';
--17.��� �޿��� ���� ���� ������ �ݾ��� ����Ͻÿ�.
select max(avg(salary)) from hr.employees
group by job_id;

--18. �����ȣ(postal_code)�� ����ִ� �ּ�(street_address)�� ���ø�(city)�� ����Ͻÿ�.
select street_address , city from hr.locations
where postal_code is null;
--19. �μ���ȣ�� 50�� ����� �������۰� ������������ ����Ͻÿ�.
select * from hr.job_history;
select start_date , end_date
from hr.employees e join hr.job_history jh
on e.employee_id = jh.employee_id
where e.department_id = 50;
--20. ���� ��ȣ, �����, ���� ��ȣ, �������� ����Ͻÿ�
select * from hr.locations;
select * from hr.countries;

select region_id, country_name, location_id, city
from hr.locations l join hr.countries c
on l.country_id = c.country_id;


--21. �̸��� 'Daniel'���� 'Irene'�� �������
---- �����ȣ, �̸�, �޿�
---- �μ� ��ȣ, �μ����� ����Ͻÿ�
---- ��, �̸��� �������� ������������ �����Ͻÿ�.
select employee_id , first_name, salary
, e.department_id, department_name
from hr.employees e join hr.departments d
on e.department_id = d.department_id
where first_name between 'Daniel' and 'Irene'
order by 2;

--22. �μ����� ���� ���� �޿��� ����Ͻÿ�.
---- ��, �μ� ��ȣ�� �������� ������������ �����Ͻÿ�.
select department_id, max(salary) from hr.employees
group by department_id
order by 1 desc;
--23. ������ 'MA'�� ���� ��� ��
---- �޿��� 8000�� �Ѵ� ����� 
---- �����ȣ, �̸�, ��, ����
---- �μ� ��ȣ, �μ����� ����Ͻÿ�.
select employee_id, first_name, last_name, job_id
, d.department_id, department_name
from hr.employees e join hr.departments d
on e.department_id = d.department_id
where salary > 8000 and job_id like '%MA%';
--24. Ŀ�̼��� null�� ���� 0���� �ٲٰ�
---- Ŀ�̼��� ������ ������� ������ ���Ͻÿ�
---- ��� ��ȣ, �̸�, �޿�, Ŀ�̼�, ���� ���
---- ��, ������ ��Ī�� YEAR_SAL �� ǥ���Ͻÿ�
select employee_id, first_name, salary, nvl(commission_pct,0) as pct, salary*12*(nvl(commission_pct,0)+1) as year_sal from hr.employees;
--25. �μ���ȣ�� 20, 50, 80�� �μ��� �μ���ȣ�� 
---- ��� �޿�, �ִ� �޿�, �ּ� �޿�, �޿� �� ���� ����Ͻÿ�
select trunc(avg(salary)), max(salary), min(salary), sum(salary)
from hr.employees where department_id in (20,50,80);
--26. ������ �ּ� �޿��� 4000�� ������, 
---- �ش� ������ ���� ������ ��, �̸�, �޿��� ����Ͻÿ�.
select last_name, first_name, salary from hr.employees e join hr.jobs j
on e.job_id = j.job_id
where min_salary = 4000;
--27.  �μ� ��ȣ
---- �ش� �μ��� ���� ��ȣ, ��, 
---- ���� ��ȣ, �ּҸ� ����Ͻÿ�.
---- ��, �μ��� ���� ������ ����Ѵ�.
select employee_id, last_name
, l.location_id, street_address
from hr.employees e left outer join hr.departments d
on e.department_id = d.department_id left outer join hr.locations l
on d.location_id = l.location_id;
--28. ���� ��ȣ�� 150������ 173���� ������
---- �μ� ��ȣ, �μ���
---- ���� ��ȣ, ��, �̸�
---- ������ȣ, ���� ������ ����Ͻÿ�
---- ��, ���� ��ȣ�� �������� ������������ �����Ͻÿ�.
select d.department_id, department_name
,employee_id, last_name, first_name
,j.job_id, job_title
from hr.departments d join hr.employees e
on d.department_id = e.department_id join hr.jobs j
on e.job_id = j.job_id
where employee_id between 150 and 173
order by 3 desc;
--29. ������ȣ�� 2700�� �μ��� �μ���ȣ�� �ּҸ� ����Ͻÿ�
select department_id, street_address
from hr.departments d join hr.locations l
on d.location_id = l.location_id
where d.location_id = 2700;
--30. �̸��� 'AN'�� ���� ������
---- ���� ��ȣ, �̸�, �μ�, �μ����� ����Ͻÿ�
---- ��, �̸��� �ҹ���, �빮�� �������
select employee_id, first_name
, d.department_id, department_name 
from hr.employees e join hr.departments d
on e.department_id = d.department_id
where first_name like initcap('%AN%');



