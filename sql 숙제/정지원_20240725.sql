-- 프로젝션 : 원하는 열만 가져오도록 한다.
-- 직원 정보
select * from hr.employees;
-- 1. 직원번호, 이름 , 이메일, 입사일 
select employee_id, first_name, email, hire_date from hr.employees;

-- 2. 직원번호, 이름 , 급여, 각 사원 급여에 100더하시오
select employee_id, first_name, salary, salary+100 from hr.employees;
-- 3. 직원번호, 성, 입사일, 직무, 연봉을 출력하시오
-- 각행에 있는 열에 수식을 사용가능
select employee_id, last_name, hire_date, salary*12 from hr.employees;

-- 부서정보
select * from hr.departments;
--- 4. 주소, 부서번호, 부서장번호, 부서명순으로 출력
-- 컬럼의 순서를 무작위로 사용가능
select location_id, department_id, manager_id, department_name from hr.departments; 
-- 5. 사원테이블에서 직원번호 , 입사일, 성, 급여순으로 출력
-- 컬럼의 순서를 무작위로 사용가능
select employee_id, hire_date, last_name, salary from hr.employees;
-- 6. 연산:
-- 사원테이블에서 사원번호, 부서번호 , 직무, 연봉을 출력하는데 
-- 매월 300씩 보너스가 지급이 된다.
select employee_id, department_id, job_id, salary*12 from hr.employees;

-- 7. 사원테이블에서 사원번호, 부서번호 , 직무, 연봉을 출력하는데 
-- 마지막 달에 300이 특별 보너스로 지급이 된다.
select employee_id, department_id, job_id, salary*12+300 from hr.employees;

-- 8. 사원테이블에서 사원번호, 성, 이메일 , 급여에 대한 커미션이 30%씩 지급이될 때
-- 커미션 까지 출력하시오.
select employee_id, last_name, email, salary*0.3 as 보너스 from hr.employees;

-- 9.  사원테이블에서 직원번호 이메일 이름 입사일 급여, 커미션퍼센트를 출력
select employee_id, email, first_name, hire_date, salary, commission_pct from hr.employees;

-- 10.  사원테이블에서 직원번호 이메일 이름 입사일 급여, 커미션퍼센트를 출력하는데
-- 각 사원이 받는 커미션의 금액도 같이 출력하시오.
select employee_id, email, first_name, hire_date, salary, commission_pct,salary*commission_pct from hr.employees;

-- 11. 직원번호, 이메일, 이름, 입사일, 연락처, 부서번호, 급여, 커미션퍼센트, 
-- 그리고 커미션이 포한된 연봉을 출력하시오,
select employee_id,email, first_name, hire_date,salary,commission_pct, salary*12 + salary*commission_pct*12  from hr.employees;

--12.  heading name에 별칭 주기 (as를 사요하는 것과 사용하지 않는것을 혼합해 볼것) 
-- 사원번호 eid로 이메일, 성은 lname으로 입사일은 hd로 연락처는 ph로 부서번호는 did로 급여는 sal로 커미션은 comm으로
-- 커미션을 포함한 년봉은 year_sal로 별칭를 줘서 출력하시오. 단 eamil은 별칭을 주지 않는다.
select employee_id eid, email, last_name as lname, hire_date hd , phone_number as ph, department_id did, salary as sal, commission_pct comm,salary*12 + salary*commission_pct*12 as year_sal from hr.employees;
-- 13. employee_id,  '나의 성은 last_name' , first_name , 급여를 출력하세요.
select employee_id, '나의 성은 ' || last_name, first_name, salary from hr.employees;
-- 14 사원번호, 이름 급여 부서번호를 출력할 때  리터널 날짜 2021-11-19와 숫자 35를  같이 출력하세요.,
select employee_id, first_name, salary, department_id ,'2021-11-19',35 from hr.employees;
--- 15. 직원번호, last_name first_name(KingSteven),급여, 직무 출력
select employee_id, last_name || first_name , salary, job_id from hr.employees;
--16. 15번문제에서 성과 이름에 공백문자를 넣자.
select employee_id, last_name ||' ' || first_name , salary, job_id from hr.employees;
-- 17. 사원번호와 급여를 출력하는 사이에 아래 내용이 출력되게 하시오. 
-- "KingSteven의 직무는 AD_PRES입니다"로 출력하자.
select employee_id, last_name||first_name||'의 직무는'|| job_id||'입니다' as job, salary from hr.employees;
-- 18. 직원의 부서번호만 출력하시오.
select employee_id from hr.employees;
-- 19. 직원의 부서를 모두 출력하지 말고 한번씩만 출력하시오.
--     직원이 속해있는 부서가 어떠한 부서들인지 알고 싶다.
select distinct employee_id from hr.employees;
-- 20.직무와 부서가 같은 직원 정보는 한번만 출력하시오.
select distinct job_id , department_id from hr.employees;
---21. 직무와 입사일이 중복되지 않게 출력하시오.
select distinct job_id , hire_date from hr.employees;
-- 22. 90인 부서의 사원들을 출력하시오. 
select * from hr.employees where department_id = 90;
-- 23. 사원번호, 성, 이름, 급여를 출력
select employee_id, last_name, first_name, salary from hr.employees;
-- 24. 90인 부서의 사원들을 출력할 때 사원번호, 이름 , 성, 급여 출력
select employee_id, last_name, first_name, salary from hr.employees where department_id = 90;
-- 25. 이름이 'Nancy'인 사원의 입사일 , 직무, 급여, 커미션퍼센트를 출력하세요.
-- 문자열 리터널인 경우에는 대소문자를 구분하여 사용해야 한다.
select hire_date, job_id, salary, commission_pct from hr.employees where first_name = 'Nancy'; 

-- 26. 입사일이 06/01/03인 사원을 출력하시오.
select * from hr.employees where hire_date = '06.01.03';
-- 비교 연산(관계연산) :  =, >, >=, <, <=, <>, !=, ^=
-- 27. 급여가 3000이상인 사원들의 성, 급여를 출력하시오.
select last_name, salary from hr.employees where salary >= 3000;

-- 28. 입사일이 06/01/03보다 늦게 입사한 직원의 사원번호 이름 급여를 출력하시오.
select employee_id, first_name, salary from hr.employees where hire_date >= '06.01.03';
-- 30. 급여가 3000이 아닌 사원을 모두 출력하시오.
select * from hr.employees where hire_date != '06.01.03';
-- 31. 급여가 2500에서 3500사이인 사원들 중 사원번호와 이름, 급여, 직무, 입사일을 출력
select employee_id, first_name, job_id, hire_date from hr.employees where salary between 2500 and 3500;

-- 32. 성이 King부터  Smith사이에 있는 사원들을 출력하시오.
select * from hr.employees where last_name between 'King' and 'Smith';

-- 33. 입사일이 02/06/07부터 06/01/03사이에 입사한 사원들을 출력하시오.
select * from hr.employees where hire_date between '02.06.07' and '06.01.03';
-- 34. 50, 70, 90인 부서의 사원들을 출력하세요.
select * from hr.employees where department_id in(50,70,90);
-- 35. 상사가 100,101,102인 사원들을 구하시오.
select * from hr.employees where manager_id between 100 and 102;
-- 36. 성이 'Hartstein', 'Vargas'인 사원들을 출력하시오.
select * from hr.employees where last_name in('Hartstein','Vargas');

-- 37. 사장의 직원번호는 100번이다. 사장이 직속상사인 사원은?
select * from hr.employees where manager_id = 100;

-- like
-- 38. 성에 s가 포함되어 있는 직원을 출력하세요.
select * from hr.employees where last_name like '%s%';
-- 39. 직무에 'CL'이 포함한된 사원들을 출력하시오.
select * from hr.employees where job_id like '%CL%';
-- 40. 직무에 'ST'이 포함한된 사원들을 출력하시오
select * from hr.employees where job_id like '%ST%';

-- 41. 이름이 'B'로 시작하는 지원을 출력하세요.
select * from hr.employees where first_name like 'B%';
-- 42. 이름이 'a'로 끝나는 지원을 출력하세요.
select * from hr.employees where first_name like '%a';

-- 43. 02년도에 입사한 사원?
select * from hr.employees where hire_date like '02%';

-- 44. 02월에 입사한 사원은? --52번에 답
select * from hr.employees where hire_date like '%/02/%';
-- 45. 이메일에 두번째 글자가 'K'인 사원을 출력하시오.
select * from hr.employees where email like '_K%';
-- 46. 성에 두번째 글자가 'o'인 사원을 출력하시오.
select * from hr.employees where last_name like '_o%';
-- 47. 이메일에 세번째 글자가 'A'시작하는 사원?
select * from hr.employees where email like '__A%';
-- 48. 이메일에 세번째 글자가 'O'시작하는 사원?
select * from hr.employees where email like '__O%';

-- 49. 이메일의 마지막에서 두번째 글자 'O'인 사원은?
select * from hr.employees where email like '_O%';

-- 50. 이메일의 앞에서 두번재가 K이고 뒤에서 두번째가 'O'인 사원을 출력하시오.
select * from hr.employees where email like '_K%O_';

-- 51. IT_로 시작하는 직무를 구하시오
select job_id from hr.employees where job_id like 'IT\_%' escape '\';
-- 52. 02월에 입사한 사원들을 출력하세요.
select * from hr.employees where hire_date like '%/02/%';
-- null
-- 53. 커미션을 받지 못하는 직원들을 출력하시오.
select * from hr.employees where commission_pct is null;
-- 54. 상사가 없는 직원을 출력하시오.
select * from hr.employees where manager_id is null;
-- 55. 부서에 부서장이 없는 부서정보를 출력하세요.
select * from hr.departments where manager_id is null;
---56. 부서가 없는 직원을 출력하시오.
select * from hr.employees where department_id is null;
--- 논리 연산자.. or, and : 부울타입과의 연산
-- 57. 직무가 AD_VP이면서 부서번호가 90인 사원들을 출력하세요.
select * from hr.employees where job_id = 'AD_VP' and department_id = 90;
-- 58. 급여가 10000이상이면서 직무에 'MAN'포함되어 있는 사원은?
select * from hr.employees where salary >=10000 and job_id like '%MAN%';
-- 59. 급여가 5000부서 10000 사이인 사원을 구하시오.
select * from hr.employees where salary between 5000 and 10000;
-- 60. 입사일이 03/06/17에서 05/09/21사이에 입사한 사원을 출력하시오.and사용
select * from hr.employees where hire_date >= '03.06.17' and hire_date <='05.09.21'; 
-- 61. 급여가 10000이상인 사원을 출력
select * from hr.employees where salary >= 10000;
-- 62. 직무에 'MAN'을 포함하고 있는 사원을 출력
select * from hr.employees where job_id like '%MAN%';
-- 63. 61의 결과와 62의 결과를 같이 출력하세요.
-- 급여가 10000이상인 사람과 직무가 MAN을 포함하고 있는 사람을 출력하세요.
select * from hr.employees where salary >=10000 or job_id like '%MAN%';
---64. 부서가 100인 사원과 직무가 'SA_REP'인 사원을 출력하시오.
select * from hr.employees where department_id = 100 or job_id ='SA_REP';
-- 65.  부서가 100이면서 직무가 'SA_REP'인 사원을 출력하시오.
select * from hr.employees where department_id = 100 and job_id ='SA_REP';
-- 66. 직무가 'AD_PRES', 'AD_VP', 'IT_PROG'인 사원을 출력하세요
select * from hr.employees where job_id in('AD_PRES', 'AD_VP', 'IT_PROG');
--or
select * from employees where job_id='AD_PRES' or job_id='AD_VP' or job_id='IT_PROG';
--- 직무가 IT_PROG이거나 직무가 ST_MAN이면서 급여가 6000이상인 사원을 출력하시오.
select * from hr.employees where job_id = 'IT_PROG' or job_id = 'ST_MAN' and salary >= 6000;

-- 67. 직무가 'AD_PRES', 'AD_VP', 'IT_PROG'에 해당하지 않은 사원을 출력하세요
select * from hr.employees where job_id not in('AD_PRES', 'AD_VP', 'IT_PROG');
-- 68. 급여가 6000보다 작거나  10000보다 큰 사원을 출력하세요.
select * from hr.employees where salary not between 6000 and 10000;
-- 69. 커미션을 받지않는 사원들을 구하시오.
-- 커미션을 받는 사원들을 출력하세요.
select * from hr.employees where commission_pct is null;
select * from hr.employees where commission_pct is not null;
-- 70.  부서테이블에서 부서장이 있는 부서를 출력하시오.
select * from hr.departments where manager_id is not null;
-- 71. 급여를 기준으로 오름차순으로 정렬되어 급여, 사원번호, 이름 입사일을 출력하세요.
select salary, employee_id, first_name ,hire_date from hr.employees order by salary;
-- 72. 80번 부서의 사원들을 출력할 때 입사일이 제일 빠른 사람부터 출력하시오.
select * from hr.employees where department_id = 50 order by hire_date;
-- 73. 50번 부서의 사원들을 출력할 때 입사일이 제일 늦은 사람부터 출력하시오.
select * from hr.employees where department_id = 50 order by hire_date desc;
-- 74. 50번 부서의 사원들을 출력할 때  급여가 제일 작은 사람부터 출력하시오.
select * from hr.employees where department_id = 50 order by salary;
-- 75. 급여가 6000이상이고 10000이하인 사원들을 입사일이 빠른 사원들을 기준으로 출력하세요.
select * from hr.employees where salary between 6000 and 10000 order by hire_date;
-- 76. 
--- 사원번호, 이름, 입사일 , 급여, 부서번호 를 출력할 때 급여를 제일 많이 받는 
--- 사원부터 출력하시오. 급여에 sal로 별칭을 사용한다.
select employee_id, first_name, hire_date, salary, department_id from hr.employees order by salary desc;
-- 77. 부서가 오름차순으로 정렬된 상태에서 부서내에 있는 직무를 오름차순으로 정렬히세요.
select * from hr.employees order by department_id , job_id;
-- 78. 부서가 오름차순으로 정렬된 상태에서 부서내에 있는 직무를 내림차순으로 정렬
select * from hr.employees order by department_id , job_id desc;
-- 79. 부서를 오름차순으로 정렬하고 각부서에서 직무가 내림차순으로 정렬된 상태에서
--- 직무에 따른 급여를 제일 많이 받는 사람부터 출력되게 하세요.
select * from hr.employees order by department_id , job_id desc , salary desc;
-- 80 부서를 오름차순으로 정렬하여 출력하고 같은 부서에서 다른 직무를 가진 사원들이 있다면
--- 직무를 내림차순으로 정렬하고 같은 직무에서도 급여가 서로 다르므로 급여를 오름차순으로
--- 정렬하되 급여를 받는 사람들의 입사일을 오름차순으로 정렬하시오. 
select * from hr.employees order by department_id , job_id desc, salary , hire_date;
--- 81. 이름이 'steven'인 사람을  출력하시오.
select * from hr.employees where first_name = initcap('steven');
-- 82. 성이 KING인 직원을 출력하세요.
select * from hr.employees where last_name = initcap('KING');
-- 83. 이름의 글자의 갯수가 5인 사원들을 출력하세요.
select * from hr.employees where length(first_name) = 5;
-- 84.  급여가 5자리 이상인 사원을 구하시오.
select * from hr.employees where length(salary) = 5;

-- 85. 이름에 's'를 가지 사원들 중 이름에 몇번째에 있는지 출력하세요.
select first_name, instr(first_name, 's') from hr.employees; 

-- 86.  이름에 's'가 3번째에 있는 사원들을 출력하세요.
select * from hr.employees where instr(first_name, 's') = 3;

-- 87. 이름과 성과 급여와 직무를 출력할 때 이메일은 3번째 글자 부터 출력하시오.
select first_name, last_name, salary, job_id , substr(email,3) from hr.employees; 

--88. 이메일에 'S'부터 출력하고, 급여, 입사일, 이름 ,성을 출력하세요.
select substr(email,instr(email,'S')),salary, hire_date, first_name, last_name from hr.employees where email like '%S%';
--89. 이름 , 급여, 직무, 부서를 출력할 때 이메일은 3번째 부터 4글짜를 출력하시오.
select first_name, salary, job_id, department_id , substr(email,3,4) from hr.employees;

--90. 이메일에 3번째부터 4글자에 'ARTS'가 있는 상원을 출력하세요.
select * from hr.employees where substr(email,3,4) = 'ARTS';

--91.이메일에 's'가 5번째에 있는 사원을 출력하시오.
select * from hr.employees where instr(email,upper('s')) = 5;

select email , instr(email,'s',5) from hr.employees;
-- 아이디 찾기 highland0 : high*****
-- 92. 이메일에서 앞에서 2글자를 출력하고 나머지는 오른쪽에 *로 채워서 출력하세요.
select rpad(substr(email,1,2),length(email),'*') from hr.employees;

-- 93. 입사일이 03/06/17 전화번호가 515.123.4567인 사원의 이메일을 
--     앞에서 3글자만 출력하고 나머지는 *로 출력하세요
select rpad(substr(email,1,3),length(email),'*') from hr.employees where hire_date = '03.06.17' and phone_number = '515.123.4567';
-- 94. 직무가 _AS가 있다면 abc로 변경하시오,
select * from hr.employees where job_id like '%AS%' escape '\';
select replace(job_id, '_AS','abc') from hr.employees where job_id like '%AS%' escape '\';
-- 95.이메일에 'A'가 처음과 끝에 있다면 이메일에서 삭제하여 출력하자.
select * from hr.employees where email like 'A%A';
select substr(email, 2, length(email)-2) from hr.employees where email like 'A%A';
select trim('A' from email) from hr.employees;
-- 96. 이메일에서 뒤에서 한글자가지고 오고 또 이메일에서 뒤에서 부터 2글자 가지고 오며,
--     이메일에서 뒤에서 3번째부터 2글자만 출력하세요.
select email from hr.employees;
select substr(email,-1,1), substr(email,-2,2), substr(email,-3,2) from hr.employees;
--- 97. 이름, 입사일, 부서번호, 급여, 년봉을 출력하세요.
select first_name, hire_date, department_id, salary,salary*12 from hr.employees;

-- 98. 이름, 입사일, 부서번호, 급여 그리고 년봉을 출력할 때 
-- 년봉에는 커미션이 포함되어야 한다.
select first_name, hire_date, department_id, salary,salary*12*commission_pct from hr.employees;

