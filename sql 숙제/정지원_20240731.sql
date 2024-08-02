--1. �̸��� 'AN'�� ���� �ʴ� ������
---- ���� ��ȣ, �̸�, �μ�, �μ���, ������, ���������� ����Ͻÿ�
---- ��, �̸��� �ҹ���, �빮�� �������
select employee_id, first_name, d.department_id, department_name, j.job_id, job_title
from hr.employees e join hr.departments d
on e.department_id = d.department_id join hr.jobs j
on e.job_id = j.job_id
where upper(first_name) not like upper('%AN%');
--2. ���� ���� �� �����ȣ, �̸�, ������ ����� �� ���������� ����ϰ�
---- �μ���� ������ȣ�� ����ϼ���
select employee_id, first_name, j.job_id, job_title, d.manager_id, l.location_id
from hr.employees e join hr.jobs j
on e.job_id = j.job_id join hr.departments d
on e.manager_id = d.manager_id join hr.locations l
on d.location_id = l.location_id;
--3. �������� �����ȣ, �̸� , �޿�, ����, ���������� ����Ҷ�
---- �μ� ���� ���̺��� �μ���, �μ����� ����Ͻÿ�.
select employee_id, first_name, salary, j.job_id, job_title, department_name, d.manager_id
from hr.employees e join hr.jobs j
on e.job_id = j.job_id join hr.departments d
on e.manager_id = d.manager_id;
--4.-- ����, ��, �޿�, ����, ���������� ����ϰ� 
--  -- ���� �����丮 ���̺��� �� ������ �����ϰ� �������� �� ����Ͻÿ�.
select e.employee_id,last_name, salary, j.job_id, job_title, start_date, end_date
from hr.employees e join hr.jobs j
on e.job_id = j.job_id join hr.job_history jh
on e.job_id = jh.job_id;
--5. ����, ����, �μ�, �μ��� using ����Ͽ� ����Ͻÿ�.
select employee_id, job_id, department_id, department_name
from hr.employees e join hr.departments d
using(department_id);
--6. -- countries ���̺��� ������ȣ �� ���� �̸� ����ϰ�
-- -- regions ���̺��� ������ �з���ȣ �� �з��̸��� ����Ͻÿ�
select country_id, country_name, r.region_id, region_name
from hr.countries c join hr.regions r
on c.region_id = r.region_id;
--7. ������ȣ, ��, �̸�, ����, �μ���ȣ, ������ȣ, ��������, �ּҸ� ���
select employee_id, last_name, first_name, j.job_id, d.department_id, l.location_id, job_title, street_address
from hr.employees e join hr.jobs j
on e.job_id = j.job_id join hr.departments d
on e.department_id = d.department_id join hr.locations l
on d.location_id = l.location_id;
--8. Ŀ�̼��� null�� ����� �μ����� ����Ͻÿ�
select d.department_name 
from hr.employees e join hr.departments d
on e.department_id = d.department_id
where commission_pct is null;
--9. �μ����� ��, �̸�, Ŀ�̼��� ����Ͻÿ�.
select last_name,first_name, commission_pct
from hr.employees e join hr.departments d
on e.employee_id = d.manager_id;
--10. �μ����� ���� �� �������� ��, �̸�, �̸����� ����Ͻÿ�.
select last_name, first_name, email 
from hr.employees e join hr.departments d
on e.manager_id = d.manager_id;
--
--11. ������ ���� �μ��� ansi join ������� ����Ͻÿ�.
select employee_id, d.department_id
from hr.employees e right outer join hr.departments d
on e.department_id = d.department_id
where e.department_id is null;
--
--12. �ش� ������ �����޿��� �޴� ����� ������ ����Ͻÿ�
----    ���, �̸�, ����, �޿�, �����޿�
select e.job_id, min_salary, employee_id, first_name , salary
from hr.employees e join hr.jobs j
on e.job_id = j.job_id
where salary = min_salary;
--
--13.������ȣ�� 1800�� �μ��� �����ڵ�, �����, ����ڵ�, ������� ����Ͻÿ�
select c.country_id, country_name, l.location_id, country_name
from hr.countries c join hr.locations l
on c.country_id = l.country_id 
where l.location_id = 1800;
--14. �μ����� �޿��� �ش� ������ ���� �޿� �̻��� �μ����� ������ ����Ͻÿ�
---- ���, ��, ����, �μ���, ���, �޿�, �����޿�
select employee_id, last_name, j.job_id, department_name, d.manager_id, salary, min_salary
from hr.employees e join hr.departments d
on e.employee_id = d.manager_id join hr.jobs j
on e.job_id = j.job_id
where min_salary < salary;
--15. ����� 201���� ����ڿ� ��� �� �μ���ȣ�� ���� ����� ������ ����Ͻÿ�
----    ���, �̸�, �μ���ȣ, �μ���
select employee_id, first_name, d.department_id, department_name
from hr.employees e join hr.departments d
on e.department_id = d.department_id
where employee_id = 201 or d.department_id = employee_id;
--16. ��簡 �μ����� ����� �̸��� �μ����� ����Ͻÿ�
select first_name , department_name
from hr.employees e join hr.departments d
on e.manager_id = d.manager_id;
--17. ������ �� ������ AD_VP�� ����� ���������� ����Ͻÿ�.
----    ���� �̸�, ������ȣ, ������ȣ, �������� ���
select first_name, employee_id, e.job_id, job_title
from hr.employees e join hr.jobs j
on e.job_id = j.job_id
where e.job_id = 'AD_VP';
--
--18. �μ����� ����� ������ �μ��̸��� ��������, �ְ����� ���Ͻÿ�.
----    �̸�, �μ����ȣ, �μ���ȣ, ��������, �ְ��� ���
select d.department_id, max(salary*12*(nvl(commission_pct,0)+1)),min(salary*12*(nvl(commission_pct,0)+1))
from hr.employees e join hr.departments d
on e.manager_id = d.manager_id
group by d.department_id;
--
--19. �Ի����� '03/06/17' ������ ������� �μ��� ������ȣ�� ���
----    �����ȣ, �̸�, �Ի���, �μ���ȣ, �μ���, ������ȣ ���
select employee_id, first_name, hire_date, d.department_id, department_name, location_id
from hr.employees e join hr.departments d
on e.department_id = d.department_id 
where hire_date >= '03/06/17';
--
--20. �̸��� 'Payam' ������ ������Ʈ�������� ���Ͻÿ�.
----    �����ȣ, �̸�, �μ���ȣ, �μ��̸�, ������� ���
select * from hr.job_history;
select e.employee_id, first_name, d.department_id, department_name, end_date
from hr.employees e join hr.departments d
on e.department_id = d.department_id
join hr.job_history jh on e.employee_id = jh.employee_id
where first_name = 'Payam';
--21. ����� ���� �μ��� �ּҸ� ����ϼ���.
----     �μ���ȣ, �μ��̸�, �ּ� ���
select d.department_id, department_name, street_address 
from hr.employees e right outer join hr.departments d 
on e.department_id = d.department_id join hr.locations l
on d.location_id = l.location_id
where e.department_id is null;
--22. ��簡���� �μ����� ������ּ���.
select * from hr.employees e right outer join hr.departments d
on e.manager_id = d.manager_id;
--23. ������ȣ, ��, �̸�, ������ȣ, �������� ����ϰ� �ִ�޿��� 20000�̻��� ������ ������ּ���.
select employee_id , last_name, first_name, j.job_id, job_title ,salary
from hr.employees e join hr.jobs j
on e.job_id = j.job_id 
where (max_salary) >= 20000;
--24. ������ȣ, ��, �̸�, �μ���ȣ, ������ȣ, �����ȣ�� ����ϴµ� �����ȣ�� ���� ������ ������ּ���.
select employee_id, last_name, first_name, d.department_id, l.location_id, postal_code
from hr.employees e join hr.departments d
on e.department_id = d.department_id join hr.locations l
on d.location_id = l.location_id
where postal_code is null;
--25. �μ���ȣ, �μ���, ������ȣ, ���ø� ����ϰ� �μ���ȣ�� 80�� ���ø� ������ּ���
select department_id, department_name, city
from hr.departments d join hr.locations l
on d.location_id = l.location_id
where department_id = 80;
--26. �����ȣ, ��, �̸�, �μ���ȣ, �μ����� ����ϰ� �̸��� 'james'�� ����� ���(�����Լ����)
select employee_id, last_name, first_name, d.department_id, department_name
from hr.employees e join hr.departments d
on e.department_id = d.department_id
where first_name = initcap('james');
--27. ��, �̸�, �μ���ȣ, �μ����� ����ϰ� 03����� 05����� ������������ ������ּ���.
select last_name, first_name, d.department_id, department_name
from hr.employees e join hr.departments d
on e.department_id = d.department_id
where hire_date between '03/01/01' and '05/12/31'
order by hire_date ;
--28. ������, �����ȣ, ��, �̸�, �޿��� ����ϰ� �޿��� 3000���� 5000���̸� ���ϰ� �޿��� ������������ �����ϼ���.
select job_title, employee_id, last_name, first_name, salary 
from hr.employees e join hr.jobs j
on e.job_id = j.job_id
where salary between 3000 and 5000;
--29. �����ȣ, ��, �̸�, �޿�, �μ�, �μ����� ����ϰ�, 
--�޿��� 6000�̻��� ������ ������������ ������ ���� �̸��� �տ� 3���ڸ� ǥ���ϰ� �������� '*'�� ǥ���ϼ���.
select employee_id, last_name ,rpad(substr(first_name,1,3),length(first_name),'*'), salary , e.department_id, department_name
from hr.employees e join hr.departments d
on e.department_id = d.department_id
where salary >=6000
order by 3 desc;
--30.�̱� ����� �ƴ� ������ ��, �̸�, ��������, ������, �ּ�, ���� ��ȣ�� ���
select last_name, first_name, job_title, country_name, street_address, postal_code
from hr.employees e join hr.jobs j 
on e.job_id = j.job_id join hr.departments d
on e.department_id = d.department_id join hr.locations l
on d.location_id = l.location_id join hr.countries c
on l.country_id = c.country_id
where l.country_id <> 'US';





