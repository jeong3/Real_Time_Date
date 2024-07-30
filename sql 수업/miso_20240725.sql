-- ����
select * from hr.employees;
-- �޿��� 10000�̻��̰� ������ MK_MAN�� ��� ���
select employee_id, last_name, job_id, salary from hr.employees where salary >= 10000 and job_id = 'MK_MAN';
-- �޿��� 10000�̻��̰� ������ �ڰ� MAN���� ������ ��� ���
select employee_id, last_name, job_id, salary from hr.employees where salary >= 10000 and job_id like '%MAN';
-- �޿��� 10000�̻�� ������ MK_MAN�� ��� ���
select employee_id, last_name, job_id, salary from hr.employees where salary >= 10000 or job_id = 'MK_MAN';
-- �޿��� 10000�̻��̰� ������ MAN�� �����ϴ� ��� ���
select employee_id, last_name, job_id, salary from hr.employees where salary >= 10000 and job_id like '%MAN%';

-- �켱���� ��Ģ : () > and > or
select last_name, job_id, salary from hr.employees where (job_id = 'SA_REP' or job_id = 'AD_PRES') and salary > 15000;

-- ���� : order by : ascending(��������) : asc / descending(��������) : desc / ���� column�� ������ ���� ,�� ����Ѵ�.
select * from hr.employees order by employee_id desc;
select * from hr.employees order by hire_date asc; -- asc�� ������ �����ϴ�.
select * from hr.employees order by hire_date ; -- asc�� ������ �����ϴ�.
select last_name, job_id as jobs, department_id, hire_date  -- 1
from hr.employees -- 2
where job_id = 'SA_REP'; -- 3
--���� ������ 2 - 3 - 1 �̱� ������ ��Ī�� �ν��� �� �����Ƿ� where������ ����� �� ����.
select last_name, job_id as jobs, department_id, hire_date from hr.employees order by jobs; -- order by �� where���� �ٸ��� ��Ī�� �����ϴ�.
-- column���� �ε����� �����Ѵ�. db������ �ε����� 1���� �����Ѵ�.
-- index    1            2               3            4
select last_name, job_id as jobs, department_id, hire_date 
from hr.employees 
order by 2;
-- 1. ������ ���� ������� ���
select employee_id , first_name, salary * 12 from hr.employees order by 3;
-- 2. �μ���ȣ�� ������������ �ϰ� ���� �μ��� ������� �޿��� ������������ ���
select first_name , department_id, salary from hr.employees order by 2 asc, 3 desc;
-- 3. �μ���ȣ�� 80 �� ����� �Ի��Ͽ� ������������ ���
select employee_id, first_name, department_id, hire_date from hr.employees where department_id = 80 order by 4 desc; --------------
-- 4. �Ի����� 02/08/17������ ����� �Ի����� ���� ������� ��� , �Ի����� ���� ������ �޿��� ���� �޴� �������� ���
select employee_id, first_name, job_id, hire_date, department_id from hr.employees where hire_date >= '02/08/17' order by 4, salary desc; ----------


-- ���� �� �Լ� : �ϳ��� ���� �ϳ��� �� �� / ���� �� �Լ� : �ϳ��� ���� ���� ���� �� �� 

-- ��ҹ��� ��ȯ �Լ� ��� lower(), upper()
select last_name ,upper(last_name), lower(last_name), job_id, lower(job_id) from hr.employees;
-- ��ҹ��� ��ȯ �Լ� ��� initcap()
select first_name, last_name, employee_id, salary from hr.employees where last_name = initcap('abel');
select first_name, last_name, employee_id, salary from hr.employees where last_name = initcap('ABEL');
select first_name, last_name, employee_id, salary from hr.employees where lower(last_name) = ('abel');
select first_name, last_name, employee_id, salary from hr.employees where upper(last_name) = ('ABEL');

--���� �Լ� concat()
-- ����, �����ȣ, ��, �̸�, �޿��� ����ϴµ� ���� �̸��� ������ ���
select employee_id, department_id, last_name || first_name as name, salary from hr.employees;
select employee_id, department_id, concat(last_name , first_name) as name, salary from hr.employees;
-- ����, �����ȣ, ��, �̸�, �޿��� ����ϴµ� ���� �޿��� ������ ���
select employee_id, department_id, last_name || salary , first_name from hr.employees;
-- concat()�� ����ϴ� ���� => ���ڿ� ���ڰ� ������ �� �ڵ�����ȯ�� �����ʴ� ������ �߻��� �� �ֱ� ����
select employee_id, department_id, concat(last_name,  salary) , first_name from hr.employees;

-- ũ�⸦ �� �� �ִ� length()
-- ���� ������ ������ 5�̻��� �����鸸 ����Ͻÿ�
select length(last_name), length(first_name) from hr.employees;
select * from hr.employees where length(last_name) >= 5;

-- ���� �ڸ��� substr()
select 'HelloWorld' from dual;
select substr('HelloWorld',1, 5) from dual; -- ù���ں��� 5����
select substr('HelloWorld',6, 2) from dual; -- Wo (����, ���� ����, ���� ���ڿ������� ������ ���ڼ�)
select substr('HelloWorld',-4, 3) from dual; -- ���̳ʽ��� �ڿ������� ���° ����
-- ('HelloWorld',-4, 3) = ('HelloWorld',7, 3)

-- �μ����� 2��°���� 5���ڸ� ���
select * from hr.departments;
select department_name, substr(department_name, 2 , 5) from hr.departments;

-- ������ 4��° ���ں��� 2���ڰ� 'PR'�� ������ ���� �������� ���
select * from hr.employees where substr(job_id,4,2) = 'PR';

-- �����ȣ, ��, �̸�, �޿��� ����� �� ���� 's'�� �ִ� ��� 's'�� �ε����� ���
select employee_id, last_name, first_name, salary, instr(last_name,'s') from hr.employees;

-- �����ȣ, ��, �̸�, �޿��� ����� �� ���� 's'�� �ִ� ��ġ���� 2���� ���
select employee_id, last_name, first_name, salary, instr(last_name,'s'), substr(last_name, instr(last_name,'s'),2) from hr.employees;
-- s�� ���� ���ڴ� �տ������� 2���ڸ� ����Ѵ�

-- 1. �̸����� 's'�� �ε����� 3�� �������� ���
select first_name from hr.employees where instr(first_name,'s') = 3;

-- 2. �����ȣ, ��, �̸�, �޿�
select employee_id, last_name, substr(first_name,3), salary from hr.employees;

-- instr
select instr('helloworld','o',instr('helloworld','o')+1) from dual; -- �ι�° o�� �ε��� ã��
select instr('helloworld','o',-1) from dual; -- �ڿ��� ���� ã��
-- ���� ���ڿ��� ã�� �� �ε����� 0�̳��´�
select instr('helloworld','hello') from dual; -- ã�� ���ڿ��� ù��° �ε����� �����´�.

-- lpad, rpad -> ***5567, iks****
select lpad('hello', 10, '*') from dual;
select rpad('hello',10,'*') from dual;
select lpad(substr('iks5567', -4,4), length('iks5567'),'*') from dual; --***5567
select rpad(substr('iks5567', 1,3), length('iks5567'),'*') from dual; --iks****

-- ���, (�̸��� 3���ڸ� ����ϰ� ������ �ڿ��� ��ǥ) , �޿� , ����
select employee_id , rpad(substr(first_name, 1,3),length(first_name),'*') as name , salary, job_id from hr.employees;
-- trim() ���鹮�� ���ֱ� ltrim(), rtrim() '    Steven      ' 
select * from hr.employees where first_name = trim('    Steven      ');
--trim('���ٹ���', from Į����)

-- replace()�� ����Ͽ� 'JACK and JUE' ���� 'J'�� 'BL'�� �����ϱ�
select replace('JACK and JUE','J','BL') from dual;

select employee_id, first_name, salary, replace(job_id, '_AS','abc'), department_id from hr.employees where job_id like '%\_AS%' ESCAPE '\';

-- 

select rpad(
            substr('010-111-1970',1,instr('010-111-1970','-'))
            , length(substr('010-111-1970',1,instr('010-111-1970','-',-1)-1))
            ,'*'
            ) 
            || substr('010-***-1970',-5,5) from dual;
            
select substr('010-111-1970',1,instr('010-111-1970','-')) from dual;
select length(substr('010-111-1970',1,instr('010-111-1970','-',-1)-1)) from dual;
select substr('010-***-1970',-5,5) from dual;


