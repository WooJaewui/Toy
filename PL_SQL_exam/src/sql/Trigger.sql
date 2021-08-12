-- create trigger.
create or replace trigger member_del before insert
on member2
begin
	delete from member2;
end;