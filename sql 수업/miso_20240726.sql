-- �����Լ�
-- round : round(11.1268 , 2) 2��° �ڿ� �ִ� ���ڸ� �ݿø� �Ѵ�.
select round(15.19345 , 4) , round(157.756,0), round(157.156) ,round(157.789, -1) , round(157.489, -2) 
from dual;
-- trunc : round(11.1268 , 2) 2��° �ڿ� �ִ� ���ڸ� ������.
select trunc(15.19345 , 4) , trunc(157.756,0), trunc(157.156), trunc(157.789, -1) , trunc(157.489, -2) 
from dual;

-- mod : mod(Į���� , ��������) ������
select mod(salary , 5000) from hr.employees where mod(salary , 5000) between 2000 and 3000;
-- ������ SA_REP�� ������� �޿��� 5000���� ���� �������� ���ΰ�
select employee_id, first_name, job_id, salary, mod(salary , 5000) from hr.employees where job_id = 'SA_REP';

-- ���� �� �� �� �� �� �� : �ð��� �� �ڸ��� ������.
-- 20 24/07/26 10:49:50 
-- ���糯¥ �������� sysdate
select sysdate from dual;
select first_name, last_name, salary, job_id, '2024/05/27', sysdate from hr.employees;
-- �Ի��Ϸκ��� ������� �󸶳� ��������
select first_name, salary, employee_id, (sysdate - hire_date) from hr.employees;
-- �Ի��Ϸκ��� ������� ���ְ� ��������
select first_name, salary, employee_id, (sysdate - hire_date) / 7 from hr.employees;
-- �Ի��� �� ������� �� ���� ��������
select first_name, salary, job_id, department_id, hire_date, months_between(sysdate, hire_date) from hr.employees;
-- �Ի��� �� ������� �� ���� ��������
select first_name, salary, job_id, department_id, hire_date, months_between(sysdate, hire_date)/ 12 from hr.employees;
-- �̹����� ������ ��
select last_day(sysdate) from dual;
--  �Ի��� ���� ������ ��
select hire_date, last_day(hire_date) from hr.employees;
-- �Ի��� ���� ������ ����� ���
select hire_date, last_day(hire_date) from hr.employees where last_day(hire_date) like '%/02/29';
-- ���� ��¥���� 3���� �Ĵ� �����ΰ�?
select add_months(sysdate, 3) from dual;
-- �Ի��� ������ 5�� ���� ��¥�� 7���� ���
select * from hr.employees where add_months(hire_date,5) like '%/07/%';
-- ���� �ݿ�����?
select next_day(sysdate, '��'), next_day(sysdate, '�ݿ���') from dual;
-- �Ի��� ������ ���� �ݿ����� 08�� 02���� ������?
select * from hr.employees where next_day(hire_date,'��') like '%/08/02';
-- ���� ��¥�� ���� �������� �Ͽ����� ��¥�� ���� ��������¥�� ����� ��¥�� ����Ͻÿ�
select next_day(sysdate-7, '��'), next_day(sysdate, '��') from dual;
-- �Ի��� ���� �Ͽ���, �Ի��� ���� ������� ���
select hire_date, next_day(hire_date-7,'��'), next_day(hire_date,'��') from hr.employees;

-- ��ȯ �Լ�
select to_number('30') + 30 from dual; -- ���ڿ��� ���ڷ� �ڵ� ����ȯ �Ǳ� ������ �� ������� �ʴ´�.

-- ��¥�� ���ڷ� to_char
select sysdate, to_char(sysdate,'yy-mm-dd'),to_char(sysdate,'yyyy-mm-dd')
, to_char(sysdate, 'yyyy-mm-dd hh:mi:ss AM dy'), to_char(sysdate, 'yyyy-mm-dd hh24:mi:ss AM dy')
from dual;

-- ������ mm-dd-yy ���Ϸ� ��� mm-dd-yy dy , mm-dd-yy day
select employee_id, job_id, first_name, hire_date, to_char(hire_date, 'mm-dd-yy day') from hr.employees;

-- ���ڸ� ���ڷ� to_char
select to_char(123456789,'9,999,999,999,999')as num from dual;
select to_char(123456789,'$099,999,999,999')as num from dual;
select to_char(123456789,'L9,999,999,999,999')as num from dual; -- L : local
select to_char(-123456789,'99,999,999,999mi')as num from dual; -- mi : -
select to_char(-123456789,'L99,999,999,999mi')as num from dual;

-- �޿� 3�ڸ��� ǥ���Ͽ� ���
select trim(to_char(salary,'$999,999,999')) num from hr.employees;
select trim(to_char(salary,'$999,999,999')) as num , trim(to_char(commission_pct,'0.00')) as pct from hr.employees;

-- ���ڿ��� ��¥�� to_date
select * from hr.employees where hire_date = to_date('18-07-04','dd-mm-yy');

--17/06/03
select * from hr.employees where hire_date >= to_date('17/06/03','dd-mm-yy');
select employee_id,first_name, next_day(hire_date-7,'��'), next_day(hire_date,'��') from hr.employees where hire_date = to_date('17/06/03','dd-mm-yy');
select next_day(to_date('17/06/03','dd-mm-yy')-7,'��'), next_day(to_date('17/06/03','dd-mm-yy'),'��') from dual;



-- �Ϲ��Լ� : nvl, nvl2, coalesce, nullif
-- �Ϲ��Լ� nvl : null�� ��� value�� �����Ѵ�  
-- salary*12*(1+nvl(commission_pct,0)) : commission_pct�� null�̸� 0���� �־��־� ������ null�� �������ʰ���
select first_name, job_id, salary, nvl(commission_pct,0) as pct, department_id
, salary*12*(1+nvl(commission_pct,0)) as year_sal from hr.employees;
-- �Ϲ��Լ� coalesce : nvl�� ��������� �������� ���� ��밡��(������ null�̸� �� ����)
select first_name, job_id, salary, coalesce(commission_pct,0) as pct, department_id
, salary*12*(1+coalesce(commission_pct,0)) as year_sal from hr.employees;
select coalesce(null,10,20,30) ,coalesce(null,null,null,30) , nvl(null,10)
from dual; -- nvl(null,10):�Ѱ��� ���ڸ� ��밡��(null �ٷ� ������������) / coalesce(null,10,20,30) : �������� ���� ��밡��(������ null�̸� �� ����)
-- �Ϲ��Լ� nvl2 : ���� null�̸� �ٴ����� ���, null�� �ƴϸ� �ٷ� ������ ���
select nvl2(null,10,20), nvl2('��',10,20) from dual;
--
select first_name, job_id, salary, commission_pct as pct, department_id
, salary*12*(1+nvl(commission_pct,0)) as year_nvl
, salary*12*(nvl2(commission_pct,1+commission_pct,1)) as year_nvl2
, salary*12*(1+ coalesce(commission_pct,0)) as year_coalesce from hr.employees;
-- nullif : ù��° ���ڿ� �ι�° ���ڰ� ������ null�� ���, �ٸ��� ù��° ���ڸ� ��� : �ΰ��� �����͸� ���ϱ� ���� ���
select nullif(1,1), nullif(1,2) from dual;
-- �̸��� ���� ���̰� ���� ����� ����Ͻÿ�
select * from hr.employees where nullif(length(first_name),length(last_name)) is null;

-- case �� ���: case when then
select first_name, job_id, salary 
, case job_id  when 'IT_PROG' then 1.10*salary 
               when 'ST_CLERK' then 1.15*salary 
               when 'SA_REP' then 1.20*salary  
               else salary end as job_sal
               from hr.employees;

select first_name, job_id, salary 
, case when job_id = 'IT_PROG' then 1.10*salary 
       when job_id = 'ST_CLERK' then 1.15*salary 
       when job_id = 'SA_REP' then 1.20*salary  
       else salary end as job_sal
       from hr.employees;

select first_name, salary, case when salary <= 5000 then 'low'
                               when salary <= 10000 then 'Medium'
                               when salary <= 20000 then 'Good'
                               else 'Excellent' end as sal 
                               from hr.employees;

-- salary / 2000 ���� ���� 
select first_name, salary, case trunc(salary / 2000) when 0 then 0
                                                     when 1 then 0.09
                                                     when 2 then 0.20
                                                     when 3 then 0.30
                                                     when 4 then 0.40
                                                     else 0.50 end as tax
                                                     from hr.employees;

-- decode : case�Ŀ��� when�� then�� ,�� �ϰ� end�� ���ָ� ��ü ��ȣ          
select first_name, salary, decode (trunc(salary / 2000) , 0 , 0
                                                        , 1 , 0.09
                                                        , 2 , 0.20
                                                        , 3 , 0.30
                                                        , 4 , 0.40
                                                        , 0.50) as tax
                                                        from hr.employees;                           

select first_name, job_id, salary 
, decode (job_id  , 'IT_PROG' , 1.10*salary 
               , 'ST_CLERK' , 1.15*salary 
               , 'SA_REP' , 1.20*salary  
               , salary ) as job_sal
               from hr.employees;
