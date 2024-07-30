-- 숫자함수
-- round : round(11.1268 , 2) 2번째 뒤에 있는 숫자를 반올림 한다.
select round(15.19345 , 4) , round(157.756,0), round(157.156) ,round(157.789, -1) , round(157.489, -2) 
from dual;
-- trunc : round(11.1268 , 2) 2번째 뒤에 있는 숫자를 버린다.
select trunc(15.19345 , 4) , trunc(157.756,0), trunc(157.156), trunc(157.789, -1) , trunc(157.489, -2) 
from dual;

-- mod : mod(칼럼명 , 나눌숫자) 나머지
select mod(salary , 5000) from hr.employees where mod(salary , 5000) between 2000 and 3000;
-- 직무가 SA_REP인 사원들의 급여를 5000으로 나눈 나머지가 얼마인가
select employee_id, first_name, job_id, salary, mod(salary , 5000) from hr.employees where job_id = 'SA_REP';

-- 세기 년 월 일 시 분 초 : 시간은 두 자리씩 나뉜다.
-- 20 24/07/26 10:49:50 
-- 현재날짜 가져오기 sysdate
select sysdate from dual;
select first_name, last_name, salary, job_id, '2024/05/27', sysdate from hr.employees;
-- 입사일로부터 현재까지 얼마나 지났을까
select first_name, salary, employee_id, (sysdate - hire_date) from hr.employees;
-- 입사일로부터 현재까지 몇주가 지났을까
select first_name, salary, employee_id, (sysdate - hire_date) / 7 from hr.employees;
-- 입사한 후 현재까지 몇 달이 지났을까
select first_name, salary, job_id, department_id, hire_date, months_between(sysdate, hire_date) from hr.employees;
-- 입사한 후 현재까지 몇 년이 지났을까
select first_name, salary, job_id, department_id, hire_date, months_between(sysdate, hire_date)/ 12 from hr.employees;
-- 이번달의 마지막 날
select last_day(sysdate) from dual;
--  입사한 달의 마지막 날
select hire_date, last_day(hire_date) from hr.employees;
-- 입사한 달이 윤년인 사원을 출력
select hire_date, last_day(hire_date) from hr.employees where last_day(hire_date) like '%/02/29';
-- 현재 날짜에서 3개월 후는 언제인가?
select add_months(sysdate, 3) from dual;
-- 입사한 직원이 5달 지난 날짜가 7월인 사원
select * from hr.employees where add_months(hire_date,5) like '%/07/%';
-- 다음 금요일은?
select next_day(sysdate, '월'), next_day(sysdate, '금요일') from dual;
-- 입사한 날에서 다음 금요일이 08월 02일인 직원은?
select * from hr.employees where next_day(hire_date,'월') like '%/08/02';
-- 현재 날짜의 주의 시작일인 일요일의 날짜와 주의 마지막날짜인 토요일 날짜를 출력하시오
select next_day(sysdate-7, '일'), next_day(sysdate, '토') from dual;
-- 입사한 주의 일요일, 입사한 주의 토요일을 출력
select hire_date, next_day(hire_date-7,'일'), next_day(hire_date,'토') from hr.employees;

-- 변환 함수
select to_number('30') + 30 from dual; -- 문자열을 숫자로 자동 형변환 되기 때문에 잘 사용하진 않는다.

-- 날짜를 문자로 to_char
select sysdate, to_char(sysdate,'yy-mm-dd'),to_char(sysdate,'yyyy-mm-dd')
, to_char(sysdate, 'yyyy-mm-dd hh:mi:ss AM dy'), to_char(sysdate, 'yyyy-mm-dd hh24:mi:ss AM dy')
from dual;

-- 형식을 mm-dd-yy 요일로 출력 mm-dd-yy dy , mm-dd-yy day
select employee_id, job_id, first_name, hire_date, to_char(hire_date, 'mm-dd-yy day') from hr.employees;

-- 숫자를 문자로 to_char
select to_char(123456789,'9,999,999,999,999')as num from dual;
select to_char(123456789,'$099,999,999,999')as num from dual;
select to_char(123456789,'L9,999,999,999,999')as num from dual; -- L : local
select to_char(-123456789,'99,999,999,999mi')as num from dual; -- mi : -
select to_char(-123456789,'L99,999,999,999mi')as num from dual;

-- 급여 3자리씩 표시하여 출력
select trim(to_char(salary,'$999,999,999')) num from hr.employees;
select trim(to_char(salary,'$999,999,999')) as num , trim(to_char(commission_pct,'0.00')) as pct from hr.employees;

-- 문자열을 날짜로 to_date
select * from hr.employees where hire_date = to_date('18-07-04','dd-mm-yy');

--17/06/03
select * from hr.employees where hire_date >= to_date('17/06/03','dd-mm-yy');
select employee_id,first_name, next_day(hire_date-7,'일'), next_day(hire_date,'토') from hr.employees where hire_date = to_date('17/06/03','dd-mm-yy');
select next_day(to_date('17/06/03','dd-mm-yy')-7,'일'), next_day(to_date('17/06/03','dd-mm-yy'),'토') from dual;



-- 일반함수 : nvl, nvl2, coalesce, nullif
-- 일반함수 nvl : null일 경우 value를 변경한다  
-- salary*12*(1+nvl(commission_pct,0)) : commission_pct가 null이면 0값을 넣어주어 연봉이 null로 나오지않게함
select first_name, job_id, salary, nvl(commission_pct,0) as pct, department_id
, salary*12*(1+nvl(commission_pct,0)) as year_sal from hr.employees;
-- 일반함수 coalesce : nvl와 비슷하지만 여러개의 인자 사용가능(다음이 null이면 그 다음)
select first_name, job_id, salary, coalesce(commission_pct,0) as pct, department_id
, salary*12*(1+coalesce(commission_pct,0)) as year_sal from hr.employees;
select coalesce(null,10,20,30) ,coalesce(null,null,null,30) , nvl(null,10)
from dual; -- nvl(null,10):한개의 인자만 사용가능(null 바로 다음꺼만가능) / coalesce(null,10,20,30) : 여러개의 인자 사용가능(다음이 null이면 그 다음)
-- 일반함수 nvl2 : 앞이 null이면 다다음꺼 출력, null이 아니면 바로 다음꺼 출력
select nvl2(null,10,20), nvl2('정',10,20) from dual;
--
select first_name, job_id, salary, commission_pct as pct, department_id
, salary*12*(1+nvl(commission_pct,0)) as year_nvl
, salary*12*(nvl2(commission_pct,1+commission_pct,1)) as year_nvl2
, salary*12*(1+ coalesce(commission_pct,0)) as year_coalesce from hr.employees;
-- nullif : 첫번째 인자와 두번째 인자가 같으면 null을 출력, 다르면 첫번째 인자를 출력 : 두개의 데이터를 비교하기 위해 사용
select nullif(1,1), nullif(1,2) from dual;
-- 이름과 성의 길이가 같은 사람만 출력하시오
select * from hr.employees where nullif(length(first_name),length(last_name)) is null;

-- case 식 사용: case when then
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

-- salary / 2000 나눈 값이 
select first_name, salary, case trunc(salary / 2000) when 0 then 0
                                                     when 1 then 0.09
                                                     when 2 then 0.20
                                                     when 3 then 0.30
                                                     when 4 then 0.40
                                                     else 0.50 end as tax
                                                     from hr.employees;

-- decode : case식에서 when과 then을 ,로 하고 end를 없애며 전체 괄호          
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
