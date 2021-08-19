/* 의사 */
CREATE TABLE Doctors (
	doc_id NUMBER(10) NOT NULL, /* 의사ID */
	major_treat VARCHAR2(25) NOT NULL, /* 담당진료과목 */
	doc_name VARCHAR2(20) NOT NULL, /* 성명 */
	doc_gen char(1) NOT NULL, /* 성별 */
	doc_phone VARCHAR2(15), /* 전화번호 */
	doc_email VARCHAR2(50), /* 이메일 */
	doc_position VARCHAR2(20) NOT NULL /* 직급 */
);

CREATE UNIQUE INDEX PK_Doctors
	ON Doctors (
		doc_id ASC
	);

CREATE UNIQUE INDEX UIX_Doctors
	ON Doctors (
		doc_email ASC
	);

ALTER TABLE Doctors
	ADD
		CONSTRAINT PK_Doctors
		PRIMARY KEY (
			doc_id
		);

ALTER TABLE Doctors
	ADD
		CONSTRAINT UK_Doctors
		UNIQUE (
			doc_email
		);

/* 환자 */
CREATE TABLE Patients (
	pat_id number(10) NOT NULL, /* 환자ID */
	nur_id number(10) NOT NULL, /* 간호사ID */
	doc_id NUMBER(10) NOT NULL, /* 의사ID */
	pat_name VARCHAR2(20) NOT NULL, /* 환자성명 */
	pat_gen CHAR(1) NOT NULL, /* 환자성별 */
	pat_jumin VARCHAR2(14) NOT NULL, /* 주민번호 */
	pat_addr VARCHAR2(100) NOT NULL, /* 주소 */
	pat_phone VARCHAR2(15), /* 전화번호 */
	pat_email VARCHAR2(50), /* 이메일 */
	pat_job VARCHAR2(20) NOT NULL /* 직업 */
);

CREATE UNIQUE INDEX PK_Patients
	ON Patients (
		pat_id ASC
	);

CREATE UNIQUE INDEX UIX_Patients
	ON Patients (
		pat_email ASC
	);

ALTER TABLE Patients
	ADD
		CONSTRAINT PK_Patients
		PRIMARY KEY (
			pat_id
		);

ALTER TABLE Patients
	ADD
		CONSTRAINT UK_Patients
		UNIQUE (
			pat_email
		);

/* 간호사 */
CREATE TABLE Nurses (
	nur_id number(10) NOT NULL, /* 간호사ID */
	major_job VARCHAR2(25) NOT NULL, /* 담당업무 */
	nur_name VARCHAR2(20) NOT NULL, /* 성명 */
	nur_gen CHAR(1) NOT NULL, /* 성별 */
	nur_phone VARCHAR2(15), /* 전화번호 */
	nur_email VARCHAR2(50), /* 이메일 */
	nur_position VARCHAR2(20) NOT NULL /* 직급 */
);

CREATE UNIQUE INDEX PK_Nurses
	ON Nurses (
		nur_id ASC
	);

CREATE UNIQUE INDEX UIX_Nurses
	ON Nurses (
		nur_email ASC
	);

ALTER TABLE Nurses
	ADD
		CONSTRAINT PK_Nurses
		PRIMARY KEY (
			nur_id
		);

ALTER TABLE Nurses
	ADD
		CONSTRAINT UK_Nurses
		UNIQUE (
			nur_email
		);

/* 차트 */
CREATE TABLE Charts (
	chart_id VARCHAR2(20) NOT NULL, /* 차트번호 */
	treat_id number(15) NOT NULL, /* 진료ID */
	doc_id NUMBER(10) NOT NULL, /* 의사ID */
	pat_id number(10) NOT NULL, /* 환자ID */
	nur_id number(10) NOT NULL, /* 간호사ID */
	chart_contents VARCHAR2(1000) NOT NULL /* 차트내용 */
);

CREATE UNIQUE INDEX PK_Charts
	ON Charts (
		chart_id ASC,
		treat_id ASC,
		doc_id ASC,
		pat_id ASC
	);

ALTER TABLE Charts
	ADD
		CONSTRAINT PK_Charts
		PRIMARY KEY (
			chart_id,
			treat_id,
			doc_id,
			pat_id
		);

/* 진료 */
CREATE TABLE Treatments (
	treat_id number(15) NOT NULL, /* 진료ID */
	doc_id NUMBER(10) NOT NULL, /* 의사ID */
	pat_id number(10) NOT NULL, /* 환자ID */
	treat_contents VARCHAR2(1000) NOT NULL, /* 진료내용 */
	treat_date DATE NOT NULL /* 진료날짜 */
);

CREATE UNIQUE INDEX PK_Treatments
	ON Treatments (
		treat_id ASC,
		doc_id ASC,
		pat_id ASC
	);

ALTER TABLE Treatments
	ADD
		CONSTRAINT PK_Treatments
		PRIMARY KEY (
			treat_id,
			doc_id,
			pat_id
		);

ALTER TABLE Patients
	ADD
		CONSTRAINT FK_Doctors_TO_Patients
		FOREIGN KEY (
			doc_id
		)
		REFERENCES Doctors (
			doc_id
		);

ALTER TABLE Patients
	ADD
		CONSTRAINT FK_Nurses_TO_Patients
		FOREIGN KEY (
			nur_id
		)
		REFERENCES Nurses (
			nur_id
		);

ALTER TABLE Charts
	ADD
		CONSTRAINT FK_Treatments_TO_Charts
		FOREIGN KEY (
			treat_id,
			doc_id,
			pat_id
		)
		REFERENCES Treatments (
			treat_id,
			doc_id,
			pat_id
		);

ALTER TABLE Charts
	ADD
		CONSTRAINT FK_Nurses_TO_Charts
		FOREIGN KEY (
			nur_id
		)
		REFERENCES Nurses (
			nur_id
		);

ALTER TABLE Treatments
	ADD
		CONSTRAINT FK_Doctors_TO_Treatments
		FOREIGN KEY (
			doc_id
		)
		REFERENCES Doctors (
			doc_id
		);

ALTER TABLE Treatments
	ADD
		CONSTRAINT FK_Patients_TO_Treatments
		FOREIGN KEY (
			pat_id
		)
		REFERENCES Patients (
			pat_id
		);