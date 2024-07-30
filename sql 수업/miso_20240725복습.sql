select * from hr.departments;
-- projection
select department_id, location_id from hr.departments; 

select first_name, salary ,300, salary+300 from hr.employees;
select first_name, salary * 12 from hr.employees;
select first_name, (salary + 300) * 12 from hr.employees;

--null : 알 수 없는 값 
select null+100 from dual; -- dual : 테이블 사용하지 않을 때 

select first_name, salary, commission_pct, department_id , job_id from hr.employees;
select first_name, salary, commission_pct, salary*commission_pct as sal, department_id , job_id from hr.employees where job_id like 'SA\_%' ESCAPE '\';

-- heading name : 머리글 -> 별칭으로 바꿔준다.

-- 연결 연산자 ||
select '정지원' || '정' from dual;
select first_name || ' ' || last_name as name from hr.employees;

select 'thi''s is cup' from dual; -- '

-- 중복 -- DISTINCT 
select DISTINCT department_id from hr.employees;
select distinct department_id from hr.employees;

-- table 정보 확인
desc hr.employees;
desc hr.departments;

-- selection
select * from hr.employees where employee_id = 100;
select first_name , salary from hr.employees where employee_id in(100, 105, 110); -- 프로젝션과 같이 사용가능
select * from hr.employees where salary between 12000 and 24000;
select * from hr.employees where salary >= 12000;









