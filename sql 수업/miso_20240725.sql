-- 예제
select * from hr.employees;
-- 급여가 10000이상이고 직무가 MK_MAN인 사원 출력
select employee_id, last_name, job_id, salary from hr.employees where salary >= 10000 and job_id = 'MK_MAN';
-- 급여가 10000이상이고 직무가 뒤가 MAN으로 끝나는 사원 출력
select employee_id, last_name, job_id, salary from hr.employees where salary >= 10000 and job_id like '%MAN';
-- 급여가 10000이상과 직무가 MK_MAN인 사원 출력
select employee_id, last_name, job_id, salary from hr.employees where salary >= 10000 or job_id = 'MK_MAN';
-- 급여가 10000이상이고 직무가 MAN을 포함하는 사원 출력
select employee_id, last_name, job_id, salary from hr.employees where salary >= 10000 and job_id like '%MAN%';

-- 우선순위 규칙 : () > and > or
select last_name, job_id, salary from hr.employees where (job_id = 'SA_REP' or job_id = 'AD_PRES') and salary > 15000;

-- 정렬 : order by : ascending(오름차순) : asc / descending(내림차순) : desc / 여러 column을 정렬할 때는 ,를 사용한다.
select * from hr.employees order by employee_id desc;
select * from hr.employees order by hire_date asc; -- asc는 생략이 가능하다.
select * from hr.employees order by hire_date ; -- asc는 생략이 가능하다.
select last_name, job_id as jobs, department_id, hire_date  -- 1
from hr.employees -- 2
where job_id = 'SA_REP'; -- 3
--실행 순서가 2 - 3 - 1 이기 때문에 별칭을 인식할 수 없으므로 where절에는 사용할 수 없다.
select last_name, job_id as jobs, department_id, hire_date from hr.employees order by jobs; -- order by 은 where절과 다르게 별칭이 가능하다.
-- column명에는 인덱스가 존재한다. db에서는 인덱스가 1부터 시작한다.
-- index    1            2               3            4
select last_name, job_id as jobs, department_id, hire_date 
from hr.employees 
order by 2;
-- 1. 연봉이 낮은 사람부터 출력
select employee_id , first_name, salary * 12 from hr.employees order by 3;
-- 2. 부서번호를 오름차순으로 하고 같은 부서인 사원들의 급여를 내림차순으로 출력
select first_name , department_id, salary from hr.employees order by 2 asc, 3 desc;
-- 3. 부서번호가 80 인 사원을 입사일에 내림차순으로 출력
select employee_id, first_name, department_id, hire_date from hr.employees where department_id = 80 order by 4 desc; --------------
-- 4. 입사일이 02/08/17이후인 사원을 입사일이 빠른 사원부터 출력 , 입사일이 같은 직원의 급여는 많이 받는 직원부터 출력
select employee_id, first_name, job_id, hire_date, department_id from hr.employees where hire_date >= '02/08/17' order by 4, salary desc; ----------


-- 단일 행 함수 : 하나의 열에 하나의 행 값 / 다중 행 함수 : 하나의 열에 여러 개의 행 값 

-- 대소문자 변환 함수 사용 lower(), upper()
select last_name ,upper(last_name), lower(last_name), job_id, lower(job_id) from hr.employees;
-- 대소문자 변환 함수 사용 initcap()
select first_name, last_name, employee_id, salary from hr.employees where last_name = initcap('abel');
select first_name, last_name, employee_id, salary from hr.employees where last_name = initcap('ABEL');
select first_name, last_name, employee_id, salary from hr.employees where lower(last_name) = ('abel');
select first_name, last_name, employee_id, salary from hr.employees where upper(last_name) = ('ABEL');

--연결 함수 concat()
-- 직원, 사원번호, 성, 이름, 급여를 출력하는데 성과 이름을 붙혀서 출력
select employee_id, department_id, last_name || first_name as name, salary from hr.employees;
select employee_id, department_id, concat(last_name , first_name) as name, salary from hr.employees;
-- 직원, 사원번호, 성, 이름, 급여를 출력하는데 성과 급여을 붙혀서 출력
select employee_id, department_id, last_name || salary , first_name from hr.employees;
-- concat()을 사용하는 이유 => 문자와 숫자가 연결할 때 자동형변환이 되지않는 오류가 발생할 수 있기 때문
select employee_id, department_id, concat(last_name,  salary) , first_name from hr.employees;

-- 크기를 알 수 있는 length()
-- 성의 문자의 갯수가 5이상인 직원들만 출력하시오
select length(last_name), length(first_name) from hr.employees;
select * from hr.employees where length(last_name) >= 5;

-- 글자 자르기 substr()
select 'HelloWorld' from dual;
select substr('HelloWorld',1, 5) from dual; -- 첫글자부터 5글자
select substr('HelloWorld',6, 2) from dual; -- Wo (글자, 시작 글자, 시작 글자에서부터 가져올 글자수)
select substr('HelloWorld',-4, 3) from dual; -- 마이너스는 뒤에서부터 몇번째 글자
-- ('HelloWorld',-4, 3) = ('HelloWorld',7, 3)

-- 부서명을 2번째부터 5글자만 출력
select * from hr.departments;
select department_name, substr(department_name, 2 , 5) from hr.departments;

-- 직무가 4번째 글자부터 2글자가 'PR'인 직무를 가진 직원들을 출력
select * from hr.employees where substr(job_id,4,2) = 'PR';

-- 사원번호, 성, 이름, 급여를 출력할 때 성에 's'가 있는 경우 's'의 인덱스를 출력
select employee_id, last_name, first_name, salary, instr(last_name,'s') from hr.employees;

-- 사원번호, 성, 이름, 급여를 출력할 때 성에 's'가 있는 위치부터 2글자 출력
select employee_id, last_name, first_name, salary, instr(last_name,'s'), substr(last_name, instr(last_name,'s'),2) from hr.employees;
-- s가 없는 글자는 앞에서부터 2글자를 출력한다

-- 1. 이름에서 's'의 인덱스가 3인 직원들을 출력
select first_name from hr.employees where instr(first_name,'s') = 3;

-- 2. 사원번호, 성, 이름, 급여
select employee_id, last_name, substr(first_name,3), salary from hr.employees;

-- instr
select instr('helloworld','o',instr('helloworld','o')+1) from dual; -- 두번째 o의 인덱스 찾기
select instr('helloworld','o',-1) from dual; -- 뒤에서 부터 찾기
-- 없는 문자열을 찾을 땐 인덱스가 0이나온다
select instr('helloworld','hello') from dual; -- 찾는 문자열의 첫번째 인덱스를 가져온다.

-- lpad, rpad -> ***5567, iks****
select lpad('hello', 10, '*') from dual;
select rpad('hello',10,'*') from dual;
select lpad(substr('iks5567', -4,4), length('iks5567'),'*') from dual; --***5567
select rpad(substr('iks5567', 1,3), length('iks5567'),'*') from dual; --iks****

-- 사번, (이름에 3글자만 출력하고 나머지 뒤에는 별표) , 급여 , 직무
select employee_id , rpad(substr(first_name, 1,3),length(first_name),'*') as name , salary, job_id from hr.employees;
-- trim() 공백문자 없애기 ltrim(), rtrim() '    Steven      ' 
select * from hr.employees where first_name = trim('    Steven      ');
--trim('없앨문자', from 칼럼명)

-- replace()를 사용하여 'JACK and JUE' 에서 'J'를 'BL'로 변경하기
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


