--���� 1) ȸ�� ���̺��� ����ÿ�. �� �÷��� ���� ������ �ο� �Ͻÿ�. ���� ������ alter���� �̿��Ұ� , �������� ���̺� ���� �Ѵ� �ǽ��� ������.
--Table MEMBER
--================================
--user_num          not null          VARCHAR2(20)  
--USER_ID     	NOT NULL 	VARCHAR2(20)  
--USER_PW     	NOT NULL 	VARCHAR2(200) 
--USER_NAME   	NOT NULL 	VARCHAR2(40)  
--USER_BIRTH  	NOT NULL 	TIMESTAMP 
--USER_GENDER 	NOT NULL 	VARCHAR2(1)   
--USER_ADDR   	NOT NULL 	VARCHAR2(200) 
--USER_PH1    	NOT NULL 	VARCHAR2(13)  
--USER_PH2             		VARCHAR2(13)  
--USER_REGIST          		TIMESTAMP  
--USER_EMAIL           		VARCHAR2(200) 
--JOIN_OK              			VARCHAR2(500)
--
--ȸ�� ��������
--user_num     : primary key (MEMBER_USER_ID_PK)
--USER_EMAIL : unique (member_USER_EMAIL_UU)
--USER_ID : unique (member_USER_ID_UU)
--USER_EMAIL : unique (member_USER_EMAIL_UU)
--USER_REGIST  : ����Ʈ ���� sysdate
--USER_GENDER : M/F�� �����Ѵ�.
--USER_PH1  : 11���� 13�ڸ��� ���� �Ѵ�.
drop table member;
drop table board;
create table member(
user_num            VARCHAR2(20),
USER_ID         	VARCHAR2(20) not null ,
USER_PW     		VARCHAR2(200) not null,
USER_NAME   		VARCHAR2(40) not null ,
USER_BIRTH  	 	TIMESTAMP not null ,
USER_GENDER 	 	VARCHAR2(1) not null,   
USER_ADDR   	 	VARCHAR2(200) not null , 
USER_PH1    	 	VARCHAR2(20) not null ,
USER_PH2        	VARCHAR2(13)  ,
USER_REGIST      	TIMESTAMP  ,
USER_EMAIL      	VARCHAR2(200) ,
JOIN_OK            	VARCHAR2(500)
);
-- primary key ���̺�
alter table member
add constraint MEMBER_USER_NUM_PK primary key(user_num);
-- primary key ��
alter table member
modify (constraint MEMBER_USER_NUM_PK primary key(user_num));
-- unique ���̺�
alter table member
add (constraint USER_EMAIL_uk unique(USER_EMAIL),
    constraint USER_ID_uk unique(USER_ID));
-- unique ��
alter table member
modify (USER_EMAIL varchar2(200) constraint USER_EMAIL_uk unique
        , USER_ID VARCHAR2(20) constraint USER_ID_uk unique);
-- default
alter table member
modify USER_REGIST TIMESTAMP default sysdate;
-- check ���̺�
alter table member
add(constraint gender1 check(user_gender in('F','M'))
,constraint phone_num1 check(length(USER_PH1) between 11 and 13));
-- check ��
alter table member
modify (USER_GENDER VARCHAR2(1) constraint gender1 check(user_gender in('F','M'))
,USER_PH1 VARCHAR2(20) constraint phone_num1 check(length(USER_PH1) between 11 and 13);

--����2) �Խ��� ���̺��� ����� �� �÷��� ���������� �ο� �Ͻÿ�.���� ������ alter���� �̿��Ұ� , �������� ���̺� ���� �Ѵ� �ǽ��� ������.
--Table BOARD
--====================================
--BOARD_NUM     	NOT NULL 	NUMBER         
--USER_num       	NOT NULL 	VARCHAR2(20)   
--BOARD_NAME    	NOT NULL 	VARCHAR2(20)    --- �� ���� 
--BOARD_PASS    	NOT NULL 	VARCHAR2(200)  
--BOARD_SUBJECT 	NOT NULL 	VARCHAR2(100)  -- ����
--BOARD_CONTENT          		VARCHAR2(2000) -- ����
--BOARD_DATE             		TIMESTAMP   
--IP_ADDR                		VARCHAR2(15)   
--READ_COUNT             		NUMBER      
--
--�Խ��� �������� 
--BOARD_NUM : primary key (BOARD_BOARD_NUM_PK)
--READ_COUNT ; ����Ʈ ���� 0
--USER_num : FOREIGN KEY (BOARD_USER_ID_FK)
drop table board;
create table board(
BOARD_NUM     	NUMBER not null,         
USER_ID      	VARCHAR2(20) not null,   
BOARD_NAME   	VARCHAR2(20) not null,   
BOARD_PASS   	VARCHAR2(200) not null, 
BOARD_SUBJECT 	VARCHAR2(100) not null, 
BOARD_CONTENT   VARCHAR2(2000), 
BOARD_DATE      TIMESTAMP   ,
IP_ADDR         VARCHAR2(15) ,  
READ_COUNT      NUMBER ,
user_num        VARCHAR2(20)
);
-- primary key ���̺�
alter table board 
add constraint BOARD_BOARD_NUM_PK primary key(BOARD_NUM);
-- primary key ��
alter table board
modify (constraint BOARD_BOARD_NUM_PK primary key(BOARD_NUM));
-- default
alter table board
modify READ_COUNT default 0;
-- foreign key ���̺���
alter table board
add constraint board_user_num_fk foreign key(user_num)
references member(user_num);
-- foreign key ������
alter table board
modify (constraint board_user_num_fk foreign key(user_num) references member(user_num));

desc member;
 desc board;
select * from member;
select * from board;
--
--���� 3) ȸ�����̺� �Ʒ� ������ �����Ͽ� 5���� �����͸� �����ÿ�.
--ȸ����ȣ�� mem_100001���� �ο��ȴ�.
--insert into member (USER_num, user_id,USER_PW,USER_NAME,USER_BIRTH,USER_GENDER,USER_ADDR ,USER_PH1,USER_PH2,USER_REGIST,USER_EMAIL)
--values(USER_num �ڵ��ο�, 'highland0','111111','�̼���','1999-12-12','1','����','010-1234-1234',null,default,null);
insert into member (USER_num, user_id,USER_PW,USER_NAME,USER_BIRTH,USER_GENDER,USER_ADDR ,USER_PH1,USER_PH2,USER_REGIST,USER_EMAIL)
values((select concat('mem_',(nvl(substr(max(USER_num),5),100000)+1)) from member)
, 'highland1','111111','�̼���','1999-12-12','F','����','010-1234-1234',null,default,null);
select * from member;


--����4)�Խ��� ���̺� �����͸� �Ʒ� ���� ���� 6�� �̻��� �ִµ� �� ȸ������ �ּ� �Ѱ� �̻� �Խñ��� ��ϵǰ� �Ͻÿ�.
--BOARD_NUM�� �Է����� �ʰ� �ڵ��ο��� �ǰ� �ۼ��Ͻÿ�. 
--insert into board(BOARD_NUM,USER_NUM,BOARD_NAME,BOARD_PASS,BOARD_SUBJECT,BOARD_CONTENT,IP_ADDR)
--values( BOARD_NUM �ڵ��ο� , USER_NUM ��ȣ , '����� �ƺ�', '1111','����', '����', '192.168.3.117');
insert into board(BOARD_NUM,USER_NUM,BOARD_NAME,BOARD_PASS,BOARD_SUBJECT,BOARD_CONTENT,IP_ADDR, USER_ID)
values(  (select nvl(max(BOARD_NUM),0)+1 from board) , 'mem_100005' , '����� �ƺ�', '1111','����', '����', '192.168.3.117','asd');
select * from board;
truncate table board;


--����5) highland0ȸ���� ȸ�����̵�, ȸ����, �̸���, �Խñ� ��ȣ, �Խñ� ����, READ_COUNT�� ����Ͻÿ�.
select b.user_id, user_name, USER_EMAIL, board_num, board_subject, read_count
from board b join member m
on b.user_num = m.user_num;

--����6) �Խñ��� ������ READ_COUNT�� 1�� ���� �� ���̴�. 
--         update���� ���� �� ������ READ_COUNT 1���� �Ҽ� �ְ� update���� �ۼ��Ͻÿ�.
--         1�� �Խñ��� ���� ��Ű�ÿ�.
select read_count from board;
select max(read_count) +1 from board;
update board
set read_count = read_count +1
where board_num =1 ;
select * from board
where board_num = 1;
--���� 7) �Խñ� 2���� �ش��ϴ� ȸ���� ����Ͻÿ�.
select * from board
where board_num = 2;
--���� 8) ��ϵ� �Խñ��� ������ ����Ͻÿ�.
select count(*) from board;
--���� 9) �� ȸ���� �Խñ��� ������ ����Ͻÿ�. (���� �ƴ�)
select count(user_id) from member
group by user_id;

--���� 10) ȸ���� ���� ����Ͻÿ�.
select count(*) from member;

--���� 11) ���̵� 'highland0'�� ȸ���� ��ȭ��ȣ�� '02-9876-1234', �̸����� 'highland0@nate.com', ��й�ȣ�� '22222'�� �����Ͻÿ�.
select * from member;
update member 
set user_ph1 = '02-9876-1234'
where user_id = 'highland0';
update member 
set user_email = 'highland0@nate.com'
where user_id = 'highland0';
update member 
set user_pw = '22222'
where user_id = 'highland0';

--���� 12) �Խñ� 1���� ������ '���� ������ �����ҷ�', ������ '������ �����ؼ� \n ���� ����� �� �� �ְ� ����ؾ���'��  �����Ͻÿ�.
select * from board;
update board
set board_subject = '���� ������ �����ҷ�', board_content = '������ �����ؼ� \n ���� ����� �� �� �ְ� ����ؾ���'
where board_num =1;

--���� 13) 1�� �Խñ��� ����� �� ������ \n�� <br /> �� ��µǰ� �Ͻÿ�.
select replace(board_content,'\n','<br />'), board_num, board_subject from board
where board_num = 1;

--���� 14)  �Խñ� ������ �ʹ� �� ȭ�鿡 �� ��µǱ� ��ƴ� . ������ ù��° ���� ���� 5���ڸ� ����ϰ� �ڿ��� *�� 5���� ��µǰ� �Ͻÿ�.
select rpad(substr(board_subject , 1 ,5), 14,'*') from board
where board_num =1; 

--���� 15) '�̼���'ȸ���� ���̵� �ؾ���ȴٰ� �Ѵ�. �̸��ϰ� ��ȭ��ȣ�� �̿��ؼ� ���̵� ����ϴ� �� ���̵�� ��� ����ؼ��� �ȵǰ� ù���ں��� ������ �������� '*'�� ��µǰ� �Ͻÿ�.
select * from member;
select rpad(substr(user_id,1,3), length(user_id), '*')
from member 
where user_email = 'highland0@nate.com' and user_ph1 = '02-9876-1234';

--���� 16) �Խ��� ���̺��� �Խñ��� ���� �� �Խñ��� user_id�� �Խñ� ������ ���� ����Ͻÿ�.
select * from board;

select user_num , count(*) from board
group by user_num
having count(*) >= (select max(count(user_num))from board
group by user_num);

select max(count(user_num))from board
group by user_num;



--���� 17) ���ݱ����� �۾��� ��� ���� ���� ��Ű�ÿ�.
commit;

--���� 18) '�̼���'ȸ���� Ż���Ϸ��� �Ѵ�. �̼��� ȸ���� Ż�� �Ҽ� �ְ� �����Ͻÿ�.
select * from member;
select * from board;

select * from user_constraints;

alter table board
drop constraint BOARD_USER_NUM_FK;

alter table board
add constraint board_user_num_fk foreign key(user_num)
references member(user_num) on delete cascade;

delete from member 
where user_name = '�̼���';

--���� 19) '�̼���' ȸ���� Ż���ϴ� ���� �ƴϾ��� �� �� �� ������ �Ͽ��� . ���������� '�̼���'ȸ���� ���� ��� ������(�Խ��� ����) ���� �� �� �ְ� �Ͻÿ�.
rollback;
alter table board
drop constraint BOARD_USER_NUM_FK;
alter table board
add constraint BOARD_USER_NUM_FK foreign key(user_num)
references member(user_num) on delete set null;
delete from member
where user_name = '�̼���';
select * from member;


--���� 20) ��asd���� ȸ���� �α����� �Ͽ� �ڽ��� �� ���� 1�� �Խñ��� �����Ϸ��� �Ѵ�.
select * from board;
delete from board 
where user_id = 'asd' and board_num = 1 ;

--�ش� �Խù��� ���� �ǰ� �Ͻÿ�.