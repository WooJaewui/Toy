drop table guestbook;
create table guestbook(
    no NUMBER,
    nick VARCHAR2(20),
    content VARCHAR2(400),
    password VARCHAR2(20),
    writedate Date
);

drop sequence guestbook_seq;
create sequence guestbook_seq;

--test
insert into guestbook 
values(guestbook_seq.nextval, '한조', '안녕하세요', '1111', SYSDATE);

--글 목록 보기 쿼리.
select * from guestbook order by no desc;

--글 비밀번호 확인.
select * from guestbook where no = 2 and password = '1111';

--글 삭제 쿼리.
delete from guestbook where no = 3;

commit;





