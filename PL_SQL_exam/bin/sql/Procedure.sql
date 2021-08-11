--create Procedure.
create or replace procedure Insert_member2(
	p_id in varchar2,
	p_passwd in varchar2,
	p_name in varchar2,
	p_age in number,
	p_addr in varchar2,
	p_email in varchar2
)
is
begin
	insert into member2 values(p_id,p_passwd,p_name,p_age,p_addr,p_email);	
end;