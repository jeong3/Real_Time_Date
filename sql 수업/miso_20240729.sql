-- ������ �Լ� : �׷��Լ� : null�� �������� �ʴ´� / �׷��Լ��� �� �ุ ����ϱ� ������ ���� ���� ����ϴ� Į������ ����� �� ����.
-- group by �� ���� Į���� ��� ����
-- �޿����� �޿��� ���� �޴� ������ ���� ���� ����, �׸��� �Ѵ� �޿��� ��հ� �Ѵ� ���� ���޵Ǵ� �޿��� �ݾ��� ���
select max(salary), min(salary), round(avg(salary)), sum(salary) from hr.employees;

-- ��ü ���� �� -- NOT NULL�� �����ϴ� Į�����δ� ī��Ʈ�ؼ� �ȵȴ�.
select count(employee_id), count(last_name),count(email), count(hire_date) from hr.employees;
-- Ŀ�̼��� �޴� ����� ��
select count(commission_pct) from hr.employees;
-- �μ��� �ִ� ����� ��
select count(department_id) from hr.employees;
-- �μ��� ���� ����� ��
select count(*) from hr.employees where department_id is null;
-- 80�� �μ��� ���� ���� �ִ� �޿��� �ּ� �޿��� ���Ͻÿ�
select count(*), max(salary), min(salary) from hr.employees where department_id = 80;
-- �μ� ���
select department_id from hr.employees;
-- �μ��� �ѹ����� 
select DISTINCT department_id from hr.employees;
-- �μ��� ���� ���
select count(DISTINCT department_id) from hr.employees;
-- ������ RE�� ������ ���� ��
select count(*) from hr.employees where job_id like '%RE%';
-- ������ RE�� ������ ������ �ִ� �޿��� �ּ� �޿�, ���� ���� ��� �޿��� ���
select count(*), max(salary), min(salary), round(avg(salary)) from hr.employees where job_id like '%RE%';

-- ���ϸ��� �Ի��� ����� ���� ���߿� �Ի��� ����� �Ի��� ���
select min(hire_date), max(hire_date) from hr.employees;
select max(hire_date)-min(hire_date) from hr.employees;

-- 80�� �μ����� Ŀ�̼Ǹ� ����Ͻÿ�.
select commission_pct from hr.employees where department_id = 80;
-- Ŀ�̼��� �޴� ��� ��
select count(commission_pct) from hr.employees where department_id = 80;

--  Ŀ�̼��� �޴� ����� Ŀ�̼��� ����� ���Ͻÿ�
select avg(commission_pct), sum(commission_pct)/count(commission_pct) from hr.employees;
select nvl(commission_pct,0) from hr.employees;
-- Ŀ�̼��� ��ü�� ����� ���Ͻÿ�
select avg(nvl(commission_pct,0)) from hr.employees;
select sum(commission_pct)/count(*) from hr.employees;

--80�� �μ����� ������ 'SA_MAN'�� ����� ���� Ŀ�̼��� ����� ���Ͻÿ�
select count(*), avg(commission_pct) from hr.employees where department_id = 80 and job_id = 'SA_MAN';


-- 80�� �μ��� �޿� ���,��,�ִ�,�ּ� �� ���Ͻÿ�
select avg(salary), sum(salary), max(salary), min(salary) from hr.employees where department_id = 80;
-- 90�� �μ��� �޿� ���,��,�ִ�,�ּ� �� ���Ͻÿ�
select avg(salary), sum(salary), max(salary), min(salary) from hr.employees where department_id = 90;
-- 70�� �μ��� �޿� ���,��,�ִ�,�ּ� �� ���Ͻÿ�
select avg(salary), sum(salary), max(salary), min(salary) from hr.employees where department_id = 70;
-- group by �μ��� 
select department_id, avg(salary), sum(salary), max(salary), min(salary) from hr.employees group by department_id;
select department_id, avg(salary), sum(salary), max(salary), min(salary) from hr.employees 
where department_id in (80,90,70)
group by department_id;

--����
select * from hr.employees order by job_id;
-- job_id �� ����� �޿��� ���, ��, �ִ�, �ּ�
select job_id, avg(salary), sum(salary), max(salary), min(salary), count(*) from hr.employees  
group by job_id;
-- job_id FI_ACCOUNT, PU_CLERK, IT_PROG �� ����� �޿��� ���, ��, �ִ�, �ּ�
select job_id, avg(salary), sum(salary), max(salary), min(salary), count(*) from hr.employees
where job_id in('FI_ACCOUNT','PU_CLERK','IT_PROG') 
group by job_id;

-- �������� ��� ������ ����� �� �μ��� ������������ ����, ���ĵ� ���� �μ��ȿ��� ������ ������������ ����
select * from hr.employees order by department_id ,job_id;
-- ���� �μ� ���� �ٸ� �������� �޿��� ���, ��, �ִ� �ּ�
-- ���� �μ����� ���� ������ �ϴ� ������ �� ���
select department_id, job_id, avg(salary), sum(salary), max(salary), min(salary), count(*) from hr.employees 
group by department_id, job_id
order by department_id, job_id;

-- group by ���� �ִ� Į������ select���� ����� �� �ִ�.

-- �μ��� ��� �޿��� ���
select department_id, avg(salary) from hr.employees
group by department_id;
-- �̶� ��� �޿��� 8000�� �ʰ��� �μ��� ��ձ޿� ���
select department_id, avg(salary) from hr.employees
group by department_id
having avg(salary) > 8000 -- having ���� �׷��Լ��� �������� ����Ѵ�.
order by department_id;
-- �׷� �Լ��� group by ������ ����Ǳ� ������ ��������� ������ where���� ����� �� ����.

-- ������ �ִ�޿� �ּұ޿� �� ������ ��� �������� 3�� �̻��� ������ ���
select job_id, max(salary), min (salary), sum(salary), count(*) from hr.employees
group by job_id
having count(*) >= 3
order by job_id;

--REP�� �����ϰ� ���� ���� ������ �߿��� �� ������ �ִ�, �ּ�, �޿� ���� ��� �̶� �޿� ���� 13000�̻��� �͸� ��� �� ���� ���� �μ����� ���
select job_id, max(salary), min(salary), sum(salary) from hr.employees
where job_id not like '%REP%'
group by job_id
having sum(salary) >= 13000
order by 4 desc;
-- �� �μ��� �μ��� �޿� ��, �ִ�, �ּ�, ����� ��, ��� / ����� �Ҽ��� 2�ڸ������� ���
select department_id, max(salary), min(salary), sum(salary), count(*) ,trunc(avg(salary),2) from hr.employees
group by department_id;
-- �μ����� ���� ������ �ϴ� ������� �ִ� �޿�, �ּ�, ���, ��, ���� ������ �ϴ� ����� �� ���
select department_id, job_id, max(salary), min(salary), avg(salary), sum(salary), count(*) from hr.employees
group by department_id, job_id
order by department_id, job_id;
-- �� �μ����� ������ ���� ����� �� �Ի����� ���� ����� ���� ���Ͻÿ� ������� 2���̻� ��� ��, 80 �� �μ��� ���
select department_id, job_id,hire_date, count(*) from hr.employees
where department_id = 80
group by department_id, job_id, hire_date
having count(*) >= 2
order by department_id, job_id, hire_date;
-- ��� �޿��� 7000�̻��� �μ��� ���, ���� ������ ���
select department_id, trunc(avg(salary),2) from hr.employees
group by department_id
having trunc(avg(salary),2) >= 7000
order by 2 desc;
-- �� �μ��� ��ձ޿� �� �ִ� ��ձ޿��� ����Ͻÿ�
select max(avg(salary)) from hr.employees -- ��ø �׷��Լ�
group by department_id;

-- ���� : �ΰ� �̻��� ���̺�κ��� �����͸� �������� ��
select * from hr.employees;
select * from hr.departments;
-- �����ȣ, �̸�, �޿�, ����, �μ���ȣ, �μ���
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


