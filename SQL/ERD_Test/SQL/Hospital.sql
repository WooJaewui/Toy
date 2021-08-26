--project hospital.
insert into doctors 
values(lpad(980312,6,'0'), '소아과', '이태정', 'M', '010-333-1340', 'ltj@hanbh.com','과장');
insert into doctors 
values(lpad(000601,6,'0'), '내과', '안성기', 'M', '011-222-0987', 'ask@hanbh.com','과장');
insert into doctors 
values(lpad(1208,6,'0'), '외과', '김민종', 'M', '010-333-8743', 'kmj@han.com','과장');
insert into doctors 
values(020403, '피부과', '이태서', 'M', '019-777-3764', 'lts@hanbh.com','과장');
insert into doctors 
values(050900, '소아과', '김연아', 'F', '010-555-3746', 'kya@hanbh.com','전문의');
insert into doctors 
values(050101, '내과', '차태현', 'M', '011-222-7643', 'cth@hanbh.com','전문의');
insert into doctors 
values(062019, '소아과', '전지현', 'F', '010-999-1265', 'jjh@hanbh.com','전문의');
insert into doctors 
values(070576, '피부과', '홍길동', 'M', '016-333-7263', 'hgd@hanbh.com','전문의');
insert into doctors 
values(080543, '방사선과', '유재석', 'M', '010-222-1263', 'yjs@hanbh.com','과장');
insert into doctors 
values(091001, '외과', '김병만', 'M', '010-555-3542', 'kbm@hanbh.com','전문의');

select * from doctors where doc_id= 1208;

insert into nurses 
values(050302, '소아과', '김은영', 'F', '010-555-8751', 'key@hanbh.com', '수간호사');

insert into nurses 
values(050021, '내과', '윤성애', 'F', '016-333-8745', 'ysa@hanbh.com', '수간호사');
insert into nurses 
values(040089, '피부과', '신지원', 'M', '010-666-7646', 'sjw@hanbh.com', '주임');
insert into nurses 
values(070605, '방사선과', '유정화', 'F', '010-333-4588', 'yjh@hanbh.com', '주임');
insert into nurses 
values(070804, '내과', '라하나', 'F', '010-222-1340', 'nhn@hanbh.com', '주임');
insert into nurses 
values(071018, '소아과', '김화경', 'F', '019-888-4116', 'khk@hanbh.com', '주임');
insert into nurses 
values(100356, '소아과', '이선용', 'M', '010-777-1234', 'lsy@hanbh.com', '간호사');
insert into nurses 
values(104145, '외과', '김현', 'M', '010-999-8520', 'kh@hanbh.com', '간호사');
insert into nurses 
values(120309, '피부과', '박성완', 'M', '010-777-4996', 'psw@hanbh.com', '간호사');
insert into nurses 
values(130211, '외과', '이서연', 'F', '010-222-3214', 'lsy2@hanbh.com', '간호사');




insert into patients
values(2345, 050302, 980312, '안상건', 'M', '232345', '서울', '010-555-7845', 'ask@ab.com', '회사원');

insert into patients
values(3545, 040089, 020403, '김성룡', 'M', '543545', '서울', '010-333-7812', 'ksr@bb.com', '자영업');
insert into patients
values(3424, 070605, 080543, '이종진', 'M', '433424', '부산', '019-888-4859', 'ljj@ab.com', '회사원');
insert into patients
values(7675, 100356, 050900, '최광석', 'M', '677675', '당진', '010-222-4847', 'cks@ab.com', '회사원');
insert into patients
values(4533, 070804, 000601, '정한경', 'M', '744533', '강릉', '010-777-9630', 'jhk@ab.com', '교수');
insert into patients
values(5546, 120309, 070576, '유원현', 'M', '765546', '대구', '016-777-0214', 'ywh@ab.com', '자영업');
insert into patients
values(4543, 070804, 050101, '최재정', 'M', '454543', '부산', '010-555-4187', 'cjj@bb.com', '회사원');
insert into patients
values(9768, 130211, 091001, '이진희', 'F', '119768', '서울', '010-888-3675', 'ljh@ab.com', '교수');
insert into patients
values(4234, 130211, 091001, '오나미', 'F', '234234', '속초', '010-999-6541', 'onm@cc.com', '학생');
insert into patients
values(7643, 071018, 062019, '송성묵', 'M', '987643', '서울', '010-222-5874', 'ssm@bb.com', '학생');

insert into treatments
values(130516023, 980312, 2345, '감기, 몸살', TO_DATE('2013-05-16','YYYY-MM-DD'));

insert into treatments
values(130628100, 020403, 3545, '피부 트러블 치료', TO_DATE('2013-06-28','YYYY-MM-DD'));
insert into treatments
values(131205056, 080543, 3424, '목 디스크로 MRI 촬영', TO_DATE('2013-12-05','YYYY-MM-DD'));
insert into treatments
values(131218024, 050900, 7675, '중이염', TO_DATE('2013-12-18','YYYY-MM-DD'));
insert into treatments
values(131224012, 000601, 4533, '장염', TO_DATE('2013-12-24','YYYY-MM-DD'));
insert into treatments
values(140103001, 070576, 5546, '여드름 치료', TO_DATE('2014-01-03','YYYY-MM-DD'));
insert into treatments
values(140109026, 050101, 4543, '위염', TO_DATE('2014-01-09','YYYY-MM-DD'));
insert into treatments
values(140226102, 091001, 9768, '화상치료', TO_DATE('2014-02-26','YYYY-MM-DD'));
insert into treatments
values(140303003, 091001, 4234, '교통사고 외상치료', TO_DATE('2014-03-03','YYYY-MM-DD'));
insert into treatments
values(140308087, 062019, 7643, '장염', TO_DATE('2014-03-08','YYYY-MM-DD'));

insert into charts
values('p_130516023', 130516023, 980312, 2345, 050302, '감기 주사 및 약 처방');

insert into charts
values('d_130628100', 130628100, 020403, 3545, 040089, '피부 감염 방지 주사');
insert into charts
values('r_131205056', 131205056, 080543, 3424, 070605, '주사 처방');
insert into charts
values('p_131218024', 131218024, 050900, 7675, 100356, '귓속청소 및 약 처방');
insert into charts
values('i_131224012', 131224012, 000601, 4533, 070804, '장염 입원치료');
insert into charts
values('d_140103001', 140103001, 070576, 5546, 120309, '여드름 치료약 처방');
insert into charts
values('i_140109026', 140109026, 050101, 4543, 070804, '위내시경');
insert into charts
values('s_140226102', 140226102, 091001, 9768, 130211, '화상 크림약 처방');
insert into charts
values('s_140303003', 140303003, 091001, 4234, 130211, '입원치료');
insert into charts
values('p_140308087', 140308087, 062019, 7643, 071018, '장염 입원치료');

--(문) 홍길동 의사가 맡고 있던 담당진료과목이 피부과 -> 소아과로 변경.
update doctors set major_treat='소아과'
where doc_name='홍길동';

--(문) 김은영 간호사가 퇴사하였다. 테이블 정보를 변경하시오.
delete from nurses where nur_name='김은영'; -- 참조 오류.

--(문) 담당진료과목이 '소아과'인 의사에 대한 정보를 출력.
select * from doctors where major_treat='소아과';

--(문) 홍길동 의사에게 진료를 받은 환자에 대한 모든 정보를 출력하시오.
select p.* from patients p join doctors d on p.doc_id = d.doc_id
where d.doc_name ='홍길동';

--(문) 진료날짜가 2013년 12월인 환자에 대한 모든 정보를 오름차순 정렬하여 출력.
select p.* from patients p join treatments t on p.pat_id = t.pat_id
where t.treat_date BETWEEN '2013/12/01' and '2013/12/31'
order by t.treat_date asc;

--(문) 간호사 ID가 05로 시작하는 모든 간호사 정보를 출력.
select * from nurses
where lpad(nur_id, 6, '0') like '05%';



commit;



