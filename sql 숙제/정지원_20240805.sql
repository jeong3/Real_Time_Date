--1. ������ ���������� ���������� ����ϴ� ���������� ����
--������ ����Ͻÿ�. job_history�� �̿�
select * from hr.employees e left outer join hr.job_history jh
on e.employee_id = jh.employee_id;
--2. ������ 4��°���� 6��°���� PRO�� �ִٸ� it_program���� ���
--                                 ACC�� �ִٸ� finance_account
--                                 �������� business�� ����Ͻÿ�.
select job_id , case substr(job_id, 4,3) when '%PRO%' then 'it_program'
                                         when '%ACC%' then 'finance_account'
                                         else 'business' end as job_id
                                         from hr.employees;
--3. �޿��� 15000 �̻��̸� �ӿ����� ���
--             10000 �̻��̸� ����
--             7000  �̻��̸� ����
--             5000�̻��̸� �븮
--             �������� ������� ����Ͻÿ�.
select salary , case  when salary>=15000 then '����'
                      when salary>=7000 then '����'
                      when salary>=5000 then '�븮'
                      else '���' end as sal
                      from hr.employees;
--4. �μ��� �޿��� ����� 5000�̻��� �μ��� ����Ͻÿ�.
select department_id, trunc(avg(salary)) from hr.employees
group by department_id
having avg(salary)>=5000;
--5. �޿��� 10000�̻��� ������� �μ��� �޿� ����� 16000�̻��� �μ��� ����Ͻÿ�
select department_id, trunc(avg(salary)) from hr.employees
where salary >=10000
group by department_id
having avg(salary)>=16000;
--6. �Ի����� 2005�⵵  ������ �Ի��� ����� �� �μ��� �ִ�޿��� 8000�̻��� �μ��� �ִ� �޿��� ����Ͻÿ�.
select department_id, max(salary) from hr.employees
where hire_date < '2005.01.01'
group by department_id
having max(salary)>=8000;
--7. �μ��� �ִ� �޿��� 10000�̻��� �μ��� ����Ͻÿ�.
select department_id, max(salary) from hr.employees
group by department_id
having max(salary)>=10000;
--8. ������ 'REP'�����ϰ� ���� ���� ������� ������ �޿��� �հ谡 3000�� �ʰ��ϴ� ������ �޿��� �հ踦 ����Ͻÿ�.
--���� �޿��� �հ踦 ������������ �����Ͽ� ���
select sum(salary), job_id from hr.employees
where job_id not like '%REP%'
group by job_id
having sum(salary) > 3000;
--9.  ������ 25-10-2020������ �ٹ��ϼ��� ����Ͻÿ�.
--������ȣ, �μ���ȣ, �Ի���, �ٹ��ϼ�
select employee_id, department_id, hire_date, (to_date('25-10-2020', 'dd-mm-yyyy')-hire_date)  from hr.employees;
--10. '01-01-2005'�� �Ի��� ����� ����Ͻÿ�.
--������ȣ, �μ���ȣ, �Ի���, �ٹ��ϼ�
select employee_id, department_id, hire_date, (to_date('25-10-2020', 'dd-mm-yyyy')-hire_date)  from hr.employees
where hire_date = to_date('01-01-2005', 'dd-mm-yyyy');
select employee_id, department_id, hire_date, (sysdate-hire_date)  from hr.employees
where to_char(hire_date,'dd-mm-yyyy') = '01-01-2005';
--11. ����(�޿�*12) : �޿��� Ŀ�̼Ǳ��� ���Եȴ�.
--������ ����� ���Ͻÿ�.
-- ������ȣ, �μ���ȣ, �޿�, ���
select employee_id, department_id, salary, salary*12*(1+nvl(commission_pct,0)) from hr.employees;
--12.  'IT_PROG' �̸� �޿���  1.10*salary
--      'ST_CLERK' �̸� �޿���  1.15*salary
--      'SA_REP' �̸�  �޿��� 1.20*salary
--       ������ ������ salary �� �޿��� �����ϰ� heading name��      "REVISED_SALARY"�� �ǰ� �Ͻÿ�.
select job_id ,case job_id when 'IT_PROG' then 1.10*salary
                           when 'ST_CLERK' then 1.15*salary
                           when 'SA_REP' then 1.20*salary
                           else salary end as REVISED_SALARY
                           from hr.employees;
                           
--13 Ŀ�̼��� ������ �޿��� ����� ���Ͻÿ�. Ŀ�̼��� �ٴ��� ���� ������ ����
select salary*12*(1+nvl(commission_pct,0)) from hr.employees;
--14. ���μ��� Ŀ�̼��� ������ �޿��� �հ踦 ���Ͻÿ�.
select department_id,sum(salary*(1+nvl(commission_pct,0))) from hr.employees
group by department_id;
--15. �� �μ��� �������� 5�� �̻��� �μ��� ����Ͻÿ�. (join�ƴ�)
select department_id,count(department_id) from hr.employees
group by department_id
having count(department_id) = 5;
--16. �� �μ��� �ִ� ����� ������ �޿��� ����� ���Ͻÿ�.
select job_id, avg(salary) from hr.employees
group by job_id;
--17. �����ȣ, �̸� , �޿�, �Ի��� , �μ���ȣ, �μ���, ������ȣ, �������� ����� �� ������� �ʴ� ������ ����ϰ� ����� ���� ������ ����Ͻÿ�.
select employee_id, first_name, salary, hire_date, d.department_id, department_name, j.job_id, job_title
from hr.employees e left outer join hr.departments d
on e.department_id = d.department_id full outer join hr.jobs j
on e.job_id = j.job_id;
--18. ������̺��� ������ MAN�� �����ϰ� �޿��� 10000�̻��� 
--����� �����ȣ�� ���� ���� �׸��� �޿��� ����Ͻÿ�.
select job_id, salary, employee_id, first_name from hr.employees
where salary >= 10000 and job_id like '%MAN%';
--19. ������ SA_REP�� AD_PRES �̸鼭 �޿��� 15000�� �ʰ��ϴ�  ����� ����Ͻÿ�.
-- ��, ��, ����, �޿��� ��� or�� and�� ���
select  first_name, job_id, salary from hr.employees
where (job_id ='SA_REP' or job_id = 'AD_PRES') and salary > 15000;
--20. �� ������ in�����ڸ� ����Ͻÿ�.
select  first_name, job_id, salary from hr.employees
where job_id in('SA_REP','AD_PRES') and salary > 15000;
--21. �μ��� ������������ �����ϰ� �Ի��ϵ� ������������ ����
--�μ���ȣ , �޿�, �Ի���, ��
select employee_id, salary, hire_date, last_name from hr.employees
order by department_id desc, 3 desc;
--22. �μ��� ������������ �����ϰ� �Ի����� ������������ �����Ͽ� ���
--�μ���ȣ , �޿�, �Ի���, ��
select department_id, salary, hire_date, last_name from hr.employees
order by 1 desc, 3;
--23. �μ��� ������������ �����ϰ� �Ի����� ������������ �����Ͽ� 
--�޿��� ������������ �����Ͽ� ���
--�μ���ȣ ,  �Ի���, �޿�, ��
select department_id, hire_date, salary, last_name from hr.employees
order by 1 desc, 2, 3 desc;
