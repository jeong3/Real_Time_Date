-- subquery : �ٸ� SELECT ���� ���� ���ԵǴ� SELECT �� 
-- ���� �������� ���� �������� �ִ´�. / ������������ ����ǰ� ������������ ����ȴ�.
-- where�� �Ӹ��ƴ϶� having������ ������������ ����� �� �ִ�
-- ��� �޿��� �ִ� ���� ������ ���
select max(avg(salary)) from hr.employees
group by job_id;

select job_id, salary from hr.employees
where salary =  (select max(avg(salary)) from hr.employees
group by job_id); 

-- Abel�� �޿��� ���
select salary from hr.employees
where last_name = 'Abel';
-- Abel�� ���� �޿��� �޴� �������� ���
select * from hr.employees
where salary = (select salary from hr.employees
where last_name = 'Abel');

-- 90 �κμ����� �޿��� ���� ���� �޴� ����� �޿��� ����Ͻÿ�
select max(salary) from hr.employees
where department_id = 90;
-- 24000�̻��� �޿��� �޴� ��� ���
select * from hr.employees
where salary >= 24000;
-- 90 �� �μ����� ���� ���� �޴� ����� �޿����� ���� �޴� ����� ����Ͻÿ�
select * from hr.employees
where salary >= (select max(salary) from hr.employees
where department_id = 90);

-- �����ȣ 103�� ����� ���� ���� ��縦 �� ������ �̸� , ���, �μ�, ����ȣ�� ���
select first_name, employee_id, department_id, manager_id from hr.employees
where manager_id = (select manager_id from hr.employees where employee_id = 103);

-- 90�� �μ��� ��ձ޿� ���� �� ���� �޴� ����� ��, ����, ���, �μ��� ���
select last_name, job_id, employee_id, department_id from hr.employees
where salary > (select avg(salary) from hr.employees where department_id = 90);

-- ���� Rogers�� ����� �޿��� ���
select salary from hr.employees where last_name = 'Rogers'; -- 2900
-- ���� Rogers�� ����� ������ ���
select job_id from hr.employees where last_name = 'Rogers'; -- ST_CLERK
-- �޿��� 2900�̸鼭 ������ ST_CLERK�� ����� �̸�, ����, �޿�, �Ի����� ���
select first_name, job_id, salary, hire_date from hr.employees
where salary = 2900
and job_id = 'ST_CLERK';
-- ���� Rogers�� ����� �޿��� ������ ���� ����� �̸� , ����, �޿�, �Ի����� ���
select first_name, job_id, salary, hire_date from hr.employees
where salary = (select salary from hr.employees where last_name = 'Rogers')
and job_id = (select job_id from hr.employees where last_name = 'Rogers');

-- �Ի����� ���� ���� ����� �̸�, ����, ���, �Ի��� , �޿� ���
select first_name, job_id, employee_id, hire_date, salary from hr.employees
where hire_date = (select max(hire_date) from hr.employees);

-- ���� Kumar �� ����� ������ ���� Kumar �� ������� �Ի����� ���� ������� �� �̸� ���� �Ի��� �μ��� ���
select last_name, first_name, job_id, hire_date, department_id from hr.employees
where job_id = (select job_id from hr.employees where last_name = 'Kumar')
and hire_date < (select hire_date from hr.employees where last_name = 'Kumar');

-- ���庸�� ���� �Ի��� ������� ���
select * from hr.employees 
where hire_date < (select hire_date from hr.employees where employee_id = 100 );

-- ���� �� subquery
-- 30�� �μ��� �ִ� ������ ���� ������ �ִ� ������� ���
select * from hr.employees
where job_id in (select job_id from hr.employees where department_id = 30);

-- ���� Taylor�� ����� ���� ������ �ϴ� ������� ��� ������ ���
select * from hr.employees
where job_id in (select job_id from hr.employees where last_name = 'Taylor');

-- �� �μ��� ��� �޿��� ���Ͻÿ�
select department_id ,min(salary) from hr.employees
group by department_id;

--30,60,90 �μ��� �ּ� �޿��� ���Ͻÿ�
select min(salary) from hr.employees
where department_id in (30,60,90)
GROUP by department_id;

-- ������ 'RE'�� �����ϴ� ������ ������ ������ �������� ���
select * from hr.employees
where job_id not like '%RE%';

-- --30,60,90 �μ��� �ּ� �޿��� ���� 'RE'�� �����ϴ� ������ ������������ ����� ���
select * from hr.employees
where salary in (select min(salary) from hr.employees
where department_id in (30,60,90) GROUP by department_id) and job_id not like '%RE%';

-- ������ȣ�� 104�� ������ ������ ���� �� �μ��� �ִ� �޿��� �ش�Ǵ� ������ ��� ������ ���
select * from hr.employees
where job_id = (select job_id from hr.employees where employee_id = 104)
and salary in (select max(salary) from hr.employees group by department_id);

-- 50 �� �μ��� �ּ� �޿� ���
select min(salary) from hr.employees
where department_id = 50;
-- �� �μ��� �ּ� �޿��� 2100 �޿����� ���� �޴� �μ��� �ּ� �޿��� �μ���ȣ ���
select min(salary), department_id from hr.employees
group by department_id
having min(salary) > 2100;
-- �� �μ��� �ּ� �޿��� 50 �� �μ��� �ּ� �޿����� ���� �޴� �μ��� �ּ� �޿��� �μ���ȣ ���
select min(salary), department_id from hr.employees
group by department_id
having min(salary) > (select min(salary) from hr.employees
where department_id = 50);
-- FI_ACCOUNT �� ������ ���� ������� �ּ� �޿����� �� ���� �޴� ������� ����
select  min(salary) from hr.employees
group by job_id
having min(salary) in (select min(salary) from hr.employees where job_id = 'FI_ACCOUNT');

select * from hr.employees
where salary < (select  min(salary) from hr.employees
group by job_id
having min(salary) in (select min(salary) from hr.employees where job_id = 'FI_ACCOUNT'));

-- FI_ACCOUNT �� ������ ���� ����� �޿� ���
select salary from hr.employees
where job_id = 'FI_ACCOUNT';
-- 
select * from hr.employees
where salary in (select salary from hr.employees
where job_id = 'FI_ACCOUNT');
-- in : = any
--  < any : ū ������ ���� ��
select * from hr.employees
where salary < any(select salary from hr.employees
where job_id = 'FI_ACCOUNT');
--  > any : ���� ������ ū ��
select * from hr.employees
where salary > any(select salary from hr.employees
where job_id = 'FI_ACCOUNT');

--  > all : ū ������ �� ū ��
select * from hr.employees
where salary > all(select salary from hr.employees
where job_id = 'FI_ACCOUNT');
--  < all : ���� ������ �� ���� ��
select * from hr.employees
where salary < all(select salary from hr.employees
where job_id = 'FI_ACCOUNT');

-- ���������� �ִ� ����� ��� ���
select * from hr.employees
where employee_id in (select distinct manager_id from hr.employees);

-- ���������� ���� ����� ��� ���
select * from hr.employees
where employee_id not in (select distinct manager_id from hr.employees
where manager_id is not null);

-- ���� set������(union, intersect, minus)
-- ������ union
select salary from hr.employees where job_id = 'ST_CLERK' 
union
select salary from hr.employees where job_id = 'IT_PROG';
-- ������ intersect
select salary from hr.employees where job_id = 'ST_CLERK' 
INTERSECT
select salary from hr.employees where job_id = 'IT_PROG';
-- ������ minus
select salary from hr.employees where job_id = 'ST_CLERK' 
minus
select salary from hr.employees where job_id = 'IT_PROG';

-- �������� �ߺ��� ���� �ߺ��ؼ� ���
select salary from hr.employees where job_id = 'ST_CLERK'
union all
select salary from hr.employees where job_id = 'IT_PROG';

-- ���̺��� Į���� �������� �����ȣ�� ������ ���
-- set���� ���� �ִ� Į���� ����������� �ȴ�.
-- �����ϴ� ������ Ÿ���� ���ƾ��Ѵ� ���� ������ to_char(null)�� Ÿ���� �����ְ� null���� �ִ´�.
-- ���� Ÿ���� ��� �Ϲ������� to_number(null)���� 0�� ����
select employee_id, job_id from hr.employees
union
select employee_id, job_id from hr.job_history;

select employee_id, job_id from hr.employees
intersect
select employee_id, job_id from hr.job_history
order by 1;

select manager_id, hire_date, department_id
from hr.employees
union
select employee_id, start_date, department_id
from hr.job_history;

select * from  hr.locations;

select manager_id, hire_date
from hr.employees
union
select employee_id, to_date(null) 
from hr.job_history;

-- DML : CRUD insert select update delete
-- ���̺� ����
create table employees
as
select * from hr.employees;
select * from employees;
drop table employees;
create table employees
as
select * from hr.employees
where 1=2;
desc employees;

drop table employees;






