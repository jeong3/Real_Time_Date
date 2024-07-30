-- join : �� ���� ���̺��� �����͸� �����´�. -> �������� �÷��̳� ���� ���� �� ������ �����ϴ�
-- ��Ī�� �ְԵǸ� ���̺���� ����� �� ����.
-- ���̺��� n���� �� ���� ������ n-1�� �̻��̴�

select * from hr.employees;
select * from hr.departments;
select * from hr.locations;
-- �����ȣ, �̸�, �Ի���, �޿�, �μ���ȣ
-- �μ���ȣ, �μ���

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
-- �����ȣ, �μ���ȣ, �̸�, ������ȣ
-- ������ȣ, ������
select employee_id, department_id, first_name, e.job_id
, j.job_id, job_title
from hr.employees e join hr.jobs j
on e.job_id = j.job_id;

-- Į���� �ƴ� ���� �������� ��
select * from hr.employees;
select * from hr.departments;
select d.department_id, department_name , d.manager_id
, employee_id, first_name, job_id, salary
from hr.employees e join hr.departments d
on d.manager_id = e.employee_id;

-- inner join ���� �����͸��� ��� 
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
select d.department_id, department_name, d.manager_id -- d.manager_id�� null�� �ƴ� ���� 11���̹Ƿ� 
, employee_id, first_name, job_id, salary             -- inner join���� ���� ���� ��µǱ� ������ 11���� �����͸� ��µ�   
from hr.employees e inner join hr.departments d
on e.employee_id = d.manager_id;

-- Natural JOIN : �÷����� ���� �� ���̺��� ������ �����ϴ�.
-- ��Ī�� ������� �ʴ´�
select employee_id, department_id, first_name
, job_id, job_title
from hr.employees e Natural join hr.jobs j;
-- on e.job_id = j.job_id;

-- ���� �μ��� �μ����� ���� �� �������� ������ �μ����� ���
select employee_id, first_name, job_id, salary, e.manager_id
, d.department_id, department_name, d.manager_id
from hr.employees e inner join hr.departments d
on e.department_id = d.department_id and e.manager_id = d.manager_id ;

select employee_id, first_name, job_id, salary, manager_id
, department_id, department_name, manager_id
from hr.employees  Natural join hr.departments;
-- on e.department_id = d.department_id and e.manager_id = d.manager_id ;

-- using �� : Natural join�� ���������� �÷����� ���� �� ���̺��� ������ �����ϴ�
select employee_id, first_name, job_id, salary, manager_id
, department_id, department_name,  manager_id
from hr.employees join hr.departments 
using( department_id , manager_id );

select employee_id, department_id, first_name, job_id
, job_id, job_title
from hr.employees join hr.jobs 
using (job_id);

-- �� ������ ������ȣ, ������ȣ,
-- �μ���ȣ, �μ��� 
-- �� �� 20,30,50,80�� �μ��� ���
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

-- �μ���ȣ, �μ���, �����ȣ
-- �ּҸ� ����� �� �����ȣ�� 1400�� ���
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

-- ���� ��ȣ, �̸�, �޿�, ����, �Ի���
-- �μ���ȣ, �μ����� ���  50�κμ�, 90�� �μ��� ����
select employee_id, first_name, salary, job_id, hire_date
, d.department_id, department_name
from hr.employees e join hr.departments d
on e.department_id = d.department_id
where d.department_id not in(50,90);

-- 3�� ����
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

--�������� 4��
select employee_id, first_name, e.department_id , salary , e.job_id
, d.department_id , department_name, d.location_id
, l.location_id, street_address
, j.job_id , job_title
from hr.employees e join hr.departments d
on e.department_id = d.department_id join hr.locations l
on d.location_id = l.location_id join hr.jobs j
on e.job_id = j.job_id;

--5��
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

-- self join : ���� ���̺� �����ϱ�
select * from hr.employees;
select e1.employee_id, e1.first_name, e1.salary, e1.job_id, e1.email, e1.manager_id 
,e2.first_name
from hr.employees e1 , hr.employees e2
where e1.manager_id = e2.employee_id and e1.employee_id = 105;

-- ����(100)�� ����� ����� �����ȣ, �̸�, �޿�, ����, ����ȣ �� ���
-- ������ �޿��� �Ի���
select e1.employee_id, e1.first_name, e1.salary, e1.job_id, e1.manager_id 
, e2.salary, e2.hire_date
from hr.employees e1 join hr.employees e2
on e1.manager_id = e2.employee_id
where e2.employee_id = 100;

-- �� � ���� : between A and B ( = �� ������� �ʴ´�)
select * from hr.jobs;
select * from hr.employees;

select employee_id, salary, first_name, e.job_id
, j.job_id, job_title, min_salary, max_salary
from hr.employees e join hr.jobs j
on salary between min_salary and max_salary;

-- outer join : ���� ��ġ���� �ʴ� ���ڵ� ��ȯ(���ǿ� �����ʴ� ���� ��µ��� �ʱ� ����)
-- ������ ���̺� ���� ��ġ���� �ʴ� ���ڵ� ���� ���� �� left outer join
select employee_id , first_name, salary, e.department_id
, department_name
from hr.employees e left outer join hr.departments d
on e.department_id = d.department_id;
-- �������� ���̺� ���� ��ġ���� �ʴ� ���ڵ� ���� ���� �� right outer join
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

-- īƼ�þ� �� : ���������� ���� �� ������ ���� ���� �����






