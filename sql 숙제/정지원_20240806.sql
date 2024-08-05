--���� 1) ȸ�� ���̺��� ����ÿ�. �� �÷��� ���� ������ �ο� �Ͻÿ�. ���� ������ alter���� �̿��Ұ� , �������� ���̺� ���� �Ѵ� �ǽ��� ������.
--Table MEMBER
--================================
--USER_ID     	NOT NULL 	VARCHAR2(20)  
--USER_PW     	NOT NULL 	VARCHAR2(200) 
--USER_NAME   	NOT NULL 	VARCHAR2(40)  
--USER_BIRTH  	NOT NULL 	TIMESTAMP 
--USER_GENDER 	NOT NULL 	VARCHAR2(1)   
--USER_ADDR   	NOT NULL 	VARCHAR2(200) 
--USER_PH1    	NOT NULL 	VARCHAR2(13)  
--USER_PH2             			VARCHAR2(13)  
--USER_REGIST          		TIMESTAMP  
--USER_EMAIL           		VARCHAR2(200) 
--JOIN_OK              			VARCHAR2(500)
--
--ȸ�� ��������
--USER_ID     : primary key (MEMBER_USER_ID_PK)
--USER_EMAIL : unique (member_USER_EMAIL_UU)
--USER_REGIST  : ����Ʈ ���� sysdate
drop table board;
drop table member;
create table member(
    USER_ID      	VARCHAR2(20)  ,
USER_PW     		VARCHAR2(200) ,
USER_NAME   		VARCHAR2(40)  ,
USER_BIRTH  	 	TIMESTAMP ,
USER_GENDER 	 	VARCHAR2(1),   
USER_ADDR   	 	VARCHAR2(200) , 
USER_PH1    	 	VARCHAR2(13)  ,
USER_PH2        	VARCHAR2(13)  ,
USER_REGIST      	TIMESTAMP  ,
USER_EMAIL      	VARCHAR2(200) ,
JOIN_OK            	VARCHAR2(500)
);

alter table member
add constraint USER_ID_pk primary key(USER_ID);
alter table member
add constraint user_email_uk unique(user_email);
alter table member 
modify USER_REGIST date default sysdate;
alter table member
modify USER_PW not null;
alter table member
modify USER_NAME not null;
alter table member
modify USER_BIRTH not null;
alter table member
modify USER_GENDER not null;
alter table member
modify USER_ADDR not null;
alter table member
modify USER_PH1 not null;
desc member;

--����2) �Խ��� ���̺��� ����� �� �÷��� ���������� �ο� �Ͻÿ�.���� ������ alter���� �̿��Ұ� , �������� ���̺� ���� �Ѵ� �ǽ��� ������.
--Table BOARD
--====================================
--BOARD_NUM     	NOT NULL 	NUMBER         
--USER_ID       	NOT NULL 	VARCHAR2(20)   
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
--USER_ID : FOREIGN KEY (BOARD_USER_ID_FK)
drop table board;
create table board(
BOARD_NUM     	NUMBER,         
USER_ID      	VARCHAR2(20),   
BOARD_NAME   	VARCHAR2(20),   
BOARD_PASS   	VARCHAR2(200) , 
BOARD_SUBJECT 	VARCHAR2(100) , 
BOARD_CONTENT   VARCHAR2(2000), 
BOARD_DATE      TIMESTAMP   ,
IP_ADDR         VARCHAR2(15) ,  
READ_COUNT      NUMBER 
);
alter table board 
add constraint BOARD_BOARD_NUM_PK primary key(BOARD_NUM);
alter table board
modify READ_COUNT default 0;
alter table board
add constraint board_user_id_fk foreign key(user_id)
references member(user_id);
alter table board
modify BOARD_NAME not null;
alter table board
modify  BOARD_PASS not null;
alter table board
modify BOARD_SUBJECT not null;


 desc board;
select * from member;
select * from board;
--
--���� 3) ȸ�����̺� �Ʒ� ������ �����Ͽ� 5���� �����͸� �����ÿ�.
--insert into member (user_id,USER_PW,USER_NAME,USER_BIRTH,USER_GENDER,USER_ADDR ,USER_PH1,USER_PH2,USER_REGIST,USER_EMAIL)
--values('highland0','111111','�̼���','1999-12-12','1','����','010-1234-1234',null,default,null);
insert into member (user_id,USER_PW,USER_NAME,USER_BIRTH,USER_GENDER,USER_ADDR ,USER_PH1,USER_PH2,USER_REGIST,USER_EMAIL)
values('highland0','111111','�̼���','1999-12-12','1','����','010-1234-1234',null,default,null);
insert into member (user_id,USER_PW,USER_NAME,USER_BIRTH,USER_GENDER,USER_ADDR ,USER_PH1,USER_PH2,USER_REGIST,USER_EMAIL)
values('highland1','222222','�̼���','1999-12-12','1','����','010-1234-1234',null,default,null);
insert into member (user_id,USER_PW,USER_NAME,USER_BIRTH,USER_GENDER,USER_ADDR ,USER_PH1,USER_PH2,USER_REGIST,USER_EMAIL)
values('highland2','333333','�̼���','1999-12-12','1','����','010-1234-1234',null,default,null);
insert into member (user_id,USER_PW,USER_NAME,USER_BIRTH,USER_GENDER,USER_ADDR ,USER_PH1,USER_PH2,USER_REGIST,USER_EMAIL)
values('highland3','444444','�̼���','1999-12-12','1','����','010-1234-1234',null,default,null);
insert into member (user_id,USER_PW,USER_NAME,USER_BIRTH,USER_GENDER,USER_ADDR ,USER_PH1,USER_PH2,USER_REGIST,USER_EMAIL)
values('highland4','555555','�̼���','1999-12-12','1','����','010-1234-1234',null,default,null);
--����4)�Խ��� ���̺� �����͸� �Ʒ� ���� ���� 6�� �̻��� �ִµ� �� ȸ������ �ּ� �Ѱ� �̻� �Խñ��� ��ϵǰ� �Ͻÿ�.
--insert into board(BOARD_NUM,USER_ID,BOARD_NAME,BOARD_PASS,BOARD_SUBJECT,BOARD_CONTENT,IP_ADDR)
--values(1, 'highland0', '����� �ƺ�', '1111','����', '����', '192.168.3.117');
insert into board(BOARD_NUM,USER_ID,BOARD_NAME,BOARD_PASS,BOARD_SUBJECT,BOARD_CONTENT,IP_ADDR)
values(1, 'highland0', '����� �ƺ�', '1111','����', '����', '192.168.3.117');
insert into board(BOARD_NUM,USER_ID,BOARD_NAME,BOARD_PASS,BOARD_SUBJECT,BOARD_CONTENT,IP_ADDR)
values(2, 'highland1', '����� �ƺ�', '1111','����', '����', '192.168.3.117');
insert into board(BOARD_NUM,USER_ID,BOARD_NAME,BOARD_PASS,BOARD_SUBJECT,BOARD_CONTENT,IP_ADDR)
values(3, 'highland2', '����� �ƺ�', '1111','����', '����', '192.168.3.117');
insert into board(BOARD_NUM,USER_ID,BOARD_NAME,BOARD_PASS,BOARD_SUBJECT,BOARD_CONTENT,IP_ADDR)
values(4, 'highland3', '����� �ƺ�', '1111','����', '����', '192.168.3.117');
insert into board(BOARD_NUM,USER_ID,BOARD_NAME,BOARD_PASS,BOARD_SUBJECT,BOARD_CONTENT,IP_ADDR)
values(5, 'highland4', '����� �ƺ�', '1111','����', '����', '192.168.3.117');
insert into board(BOARD_NUM,USER_ID,BOARD_NAME,BOARD_PASS,BOARD_SUBJECT,BOARD_CONTENT,IP_ADDR)
values(6, 'highland0', '����� �ƺ�', '1111','����', '����', '192.168.3.117');
select * from board;
commit;
--����5) highland0ȸ���� ȸ�����̵�, ȸ����, �̸���, �Խñ� ��ȣ, �Խñ� ����, READ_COUNT�� ����Ͻÿ�.
select b.user_id, user_name, USER_EMAIL, board_num, board_subject, read_count
from board b join member m
on b.user_id = m.user_id;

--����6) �Խñ��� ������ READ_COUNT�� 1�� ���� �� ���̴�. 
--         update���� ���� �� ������ READ_COUNT 1���� �Ҽ� �ְ� update���� �ۼ��Ͻÿ�.
--         1�� �Խñ��� ���� ��Ű�ÿ�.
select read_count from board;
select max(read_count) +1 from board;
update board
set read_count = read_count +1
where board_num =1 ;
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
select 

--���� 12) �Խñ� 1���� ������ '���� ������ �����ҷ�', ������ '������ �����ؼ� \n ���� ����� �� �� �ְ� ����ؾ���'��  �����Ͻÿ�.
--���� 13) 1�� �Խñ��� ����� �� ������ \n�� <br /> �� ��µǰ� �Ͻÿ�.
--���� 14)  �Խñ� ������ �ʹ� �� ȭ�鿡 �� ��µǱ� ��ƴ� . ������ ù��° ���� ���� 5���ڸ� ����ϰ� �ڿ��� *�� 5���� ��µǰ� �Ͻÿ�.
--���� 15) '�̼���'ȸ���� ���̵� �ؾ���ȴٰ� �Ѵ�. �̸��ϰ� ��ȭ��ȣ�� �̿��ؼ� ���̵� ����ϴ� �� ���̵�� ��� ����ؼ��� �ȵǰ� ù���ں��� ������ �������� '*'�� ��µǰ� �Ͻÿ�.
--���� 16) �Խ��� ���̺��� �Խñ��� ���� �� �Խñ��� user_id�� �Խñ� ������ ���� ����Ͻÿ�.
--���� 17) ���ݱ����� �۾��� ��� ���� ���� ��Ű�ÿ�.
--���� 18) '�̼���'ȸ���� Ż���Ϸ��� �Ѵ�. �̼��� ȸ���� Ż�� �Ҽ� �ְ� �����Ͻÿ�.
--���� 19) '�̼���' ȸ���� Ż���ϴ� ���� �ƴϾ��� �� �� �� ������ �Ͽ��� . ���������� '�̼���'ȸ���� ���� ��� ������(�Խ��� ����) ���� �� �� �ְ� �Ͻÿ�.
--���� 20) ��highland0���� ȸ���� �α����� �Ͽ� �ڽ��� �� ���� 1�� �Խñ��� �����Ϸ��� �Ѵ�.
--�ش� �Խù��� ���� �ǰ� �Ͻÿ�.