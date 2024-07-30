SELECT * from hr.employees;
SELECT * from hr.departments;

select department_id , department_name , manager_id , location_id
from hr.departments; -- select column���� ���� �˻��� �� ���� -> ��������
select * from hr.departments; -- ��� column�� �˻�
select manager_id , department_id , 30 , '������' from hr.departments;
select * from hr.employees;
select employee_id, first_name, salary + 300, manager_id from hr.employees;
select employee_id, first_name, salary, salary * 12, manager_id from hr.employees;
select employee_id, first_name, salary, salary * 12 + 100, manager_id from hr.employees;
select null from dual; -- �� �� ���� ��

select employee_id, last_name, hire_date, salary, commission_pct, department_id from hr.employees;
select employee_id, last_name, hire_date, salary, commission_pct,salary*commission_pct, department_id from hr.employees;
select employee_id, first_name, last_name, salary, commission_pct,salary*12,salary*commission_pct*12 + salary*12 , department_id from hr.employees;

-- alias -- heading name �����ϱ� : as year_saló�� column�� �ڿ� �̸��� �����ָ� �ȴ�.
select employee_id, first_name, last_name, salary, commission_pct,salary*12,salary*commission_pct*12 + salary*12 as year_sal, department_id from hr.employees;

-- ��ҹ���, ���鹮�ڸ� heading name�� ���-- as "heading name" 
select employee_id, first_name, last_name, salary, commission_pct,salary*12,salary*commission_pct*12 + salary*12 as "Year Sal", department_id from hr.employees;

-- ���Ῥ���� || --
select last_name, job_id, employee_id, salary, last_name||job_id from hr.employees;

-- ���ڿ� ���ͳ�
select last_name, job_id, employee_id, salary , last_name||' is a ' || job_id from hr.employees;
select employee_id || '�� �̸���' || last_name || '�̰� ������' || job_id || '�Դϴ�.' as employee from hr.employees;
select * from hr.departments;

-- Administration�� manager�� 200�Դϴ�.
select department_name || '�� manager��' || manager_id || '�Դϴ�.' as manager from hr.departments;
SELECT last_name ||'�� 1�� ���� = '||salary Monthly from hr.employees;
select 'Administration department''s manager_id 200' from dual;

-- department's manager_id -- ���ڿ� �ȿ� ' �� ����ϱ�
select department_name ||  'department''s manager_id'|| manager_id from hr.departments;
select department_name ||  q'[department's manager_id]'|| manager_id from hr.departments;

-- �ߺ� �� ���� DISTINCT : select �ٷ� ������ �;��Ѵ� select DISTINCT �ߺ������� �� from hr.employees;
select last_name , salary, job_id, department_id from hr.employees;
select DISTINCT department_id from hr.employees;

select department_id, job_id from hr.employees;
select DISTINCT department_id, job_id from hr.employees;

-- table ���� Ȯ�� --
desc hr.employees; -- DESCRIBE
DESCRIBE hr.employees;
-- 1. �μ����� �޿��� ���� ����� ������ �ѹ��� ����� �� �μ��� �޿��� ����ϼ���
select DISTINCT salary as "�޿�", job_id as "�μ�" from hr.employees;
-- 2. �Ի����� ���� ������ ���� ����� ������ �ѹ��� ����ϼ���. �Ի��ϰ� ������ ���
select DISTINCT hire_date as "�Ի���", job_id as "�μ�" from hr.employees;

-- ���ϴ� ��(column) : projection
-- ���ϴ� �� : selection : where

-- �����ȣ�� 100�� ��� ���
select * from hr.employees;
select * from hr.employees where employee_id = 100;
select * from hr.employees where EMPLOYEE_ID = 100;

-- ���� king�� ����� ���
SELECT * FROM HR.EMPLOYEES WHERE LAST_NAME = 'King';
select * from hr.employees where last_name = 'KING';
select * from hr.employees where last_name = 'king';

-- ����� ���� �� �����ȣ, �̸� , �޿�, ������ ���
-- ������ 'FI_ACCOUNT'�� ����鸸 ����ϼ���.
select employee_id, first_name, salary, job_id from hr.employees
where job_id = 'FI_ACCOUNT'; -- selection������ ���ͳ��� ��ҹ��ڰ� �����Ϳ� ��ġ�ؾ� �Ѵ�.(��ҹ��� ����)

-- yy/mm/dd
select * from hr.employees;
-- 070207�� ���� ����� ���
select * from hr.employees where hire_date = '07/02/07';
-- ����(100)���� ���� �� ����� ���
select * from hr.employees where employee_id = 100;
select * from hr.employees where hire_date < '03/06/17';
-- �޿��� 3000�޷� �̻��� ����� ���
select * from hr.employees where salary >= 3000;
-- ���, ��, �޿�, ������ ����ϴµ� �޿��� ���̸��� sal�� �Ѵ�
-- �̶� �޿��� 3000�̻��� ����� ���
select employee_id, first_name, salary as sal, job_id from hr.employees
where salary >= 3000; -- where������ ��Ī�� ����� �� ����.

 -- and || or
select first_name, salary from hr.employees where salary >= 2500 and salary <= 3000;
select first_name, salary from hr.employees where salary between 2500 and 3000;

select * from hr.employees where department_id = 50 or department_id = 70 or department_id = 90;
select * from hr.employees where department_id in (50,70,90);

-- ���� �̸��� 'Vance'�� ������ 90�� �μ��� ������ ���
select * from hr.employees where first_name = 'Vance' or department_id = 90;

-- ���� ���� 'Hartstein', 'Vargas'�� ������� ���
select * from hr.employees where last_name in ('Hartstein', 'Vargas');

--not : ~ �ƴ� in�� between �տ� ������.
select * from hr.employees where manager_id not in (100, 101, 201); --100, 101, 201�� �ƴ� ��� ��� (not)

select * from hr.employees where department_id not in (50,60,70);
select * from hr.employees where department_id not between 50 and 70; -- 50~70�� �ƴ� ��� ��� (not)

select * from hr.employees where hire_date not in ('03/06/17', '01/01/13', '07/03/17');

-- �޿��� 3000�̸�, 10000�� �ʰ��� ������ ���Ͻÿ�
select * from hr.employees where salary not between 3000 and 10000;

-- �μ��� ���� ������ ���
select * from hr.employees where department_id is null; 
select * from hr.employees where department_id is not null;
-- null�� ���� �Ҹ�Ȯ�ϱ� ������  = �� ����� �� ���� ���� is null Ȥ�� is not null�� ���� ���� �� �ִ�.

-- ���� 'K'�� �����ϴ� ��� ��� ���
select * from hr.employees where last_name like 'K%'; -- K�� �����ϴ� �� ���
-- ���� 'e'�� ������ ��� ��� ���
select * from hr.employees where last_name like '%e'; -- e�� ������ �� ���
-- ���� 'k'�� �����ϴ� ��� ��� ��� (%x% : 0���̻��� ���ڷ� x�� �Ǿհ� �ǵڿ��� ��� ����. 
select * from hr.employees where last_name like '%k%'; -- k�� �����ϴ� �� ���
select * from hr.employees where last_name like '%in%';  

-- ���� ù���ڴ� �ƹ� ���ڳ� ��������� �ι�° ���ڰ� u�� ����� ����Ͻÿ�.
select * from hr.employees where last_name like '_u%'; // �����(_)�� ������ ���� ���� ��
-- 3��° ���ڰ� s�� ��� ���
 select * from hr.employees where last_name like '__s%';
-- �ڿ��� 2��° ���ڰ� u�� ��� ���
select * from hr.employees where last_name like '%u_'; 
-- u�� i���̿� �ѱ��ڸ� ������ ��� ���
select * from hr.employees where last_name like '%u_i%'; 

select job_id from hr.employees ;

-- ������ AC_�� �����ϴ� ��� ���
select * from hr.employees where job_id like 'AC\_%' escape '\'; 
-- ���ڷ� _�� ����ϱ� ���ؼ� 'AC\_%' escape '\';�̷� ���·� �̽��������� ����ؾ��Ѵ�

--������ D_P�� ������� ���
select * from hr.employees where job_id like '%D\_P%' escape '\';





