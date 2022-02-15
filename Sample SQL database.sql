--table creation ----------------------------------------------------------------------------------

CREATE TABLE Employee (
	id_num SERIAL UNIQUE,
	first_name varchar(50) NOT NULL,
	last_name varchar(50) NOT NULL,
	salary_type varchar(50) NOT NULL,
	salary FLOAT DEFAULT 0,
	bonus FLOAT DEFAULT 0,
	current_residence varchar(50),
	tax_bracket varchar(50),
	reduction_401k FLOAT DEFAULT 0,
	e_ssn INT UNIQUE NOT NULL,
	PRIMARY KEY (id_num, first_name, last_name)
);

drop table employee;

insert into employee(first_name, last_name, salary_type, salary, bonus, tax_bracket, current_residence, reduction_401k, e_ssn)
	values ('ayman', 'fahsi', 'employee1', '12000',  '100','upper middle class', 'norcal', '1000', '109374');

select * from employee;

CREATE TABLE FederalTaxes (
	id_num int not null,
	tax_bracket varchar(50) NOT NULL,
	federal_tax_rate FLOAT DEFAULT 0,
	FOREIGN KEY (id_num) REFERENCES Employee(id_num) ON DELETE CASCADE
);

drop table federaltaxes;
insert into federaltaxes (id_num, tax_bracket, federal_tax_rate)
	values('1','middle class', '6.04');

select * from federaltaxes;

CREATE TABLE Payments (
	id_num int unique not null,
	social_security_rates FLOAT,
	medicare_rate FLOAT DEFAULT 0,
	FOREIGN KEY (id_num) REFERENCES Employee(id_num) ON DELETE CASCADE
);

drop table  payments;

select * from payments;

CREATE TABLE Dependants (
	e_id_num INT not NULL,
	d_first_name varchar(50),
	d_last_name varchar(50),
	d_ssn INT UNIQUE NOT NULL,
	relationship varchar(50),
	FOREIGN KEY (e_id_num) REFERENCES Employee(id_num) ON DELETE CASCADE
);

drop table dependants;

select * from dependants;


CREATE TABLE StateTaxes (
	id_num int not null,
	state varchar(50),
	state_tax_rate FLOAT DEFAULT 0,
	FOREIGN KEY (id_num) REFERENCES Employee(id_num) ON DELETE CASCADE
);

select * from statetaxes;

drop table statetaxes;

insert into statetaxes (id_num, state, state_tax_rate)
	values(1,'illinois', '4.39');
select * from statetaxes; 


CREATE TABLE insurance (
	id_num INT unique not null,
	insurance_plan varchar(50),
	individual_employee_cost FLOAT DEFAULT 0,
	family_employee_cost FLOAT DEFAULT 0,
	individual_employer_cost FLOAT DEFAULT 0,
	family_employer_cost FLOAT DEFAULT 0,
	FOREIGN KEY (id_num) REFERENCES Employee(id_num) ON DELETE CASCADE
);

drop table insurance;

insert into insurance (id_num,insurance_plan, individual_employee_cost, family_employee_cost)
	values(1,'Full package', '900','1100');
select * from insurance;


CREATE TABLE Benefits (
	id_num int unique not null ,
	health_plan varchar(50) default 'N/A',
	contribution_401k FLOAT  default 0,
	attorney_plan varchar(50) default 'N/A',
	life_insurance varchar(50) default 'N/A',
	dental varchar(50) default 'N/A',
	vision varchar(50) default 'N/A',
	PRIMARY KEY (health_plan, contribution_401k, attorney_plan, life_insurance, dental, vision),
	FOREIGN KEY (id_num) REFERENCES Employee(id_num) ON DELETE CASCADE
);

drop table benefits;


insert into benefits (id_num,health_plan, contribution_401k, attorney_plan, life_insurance, dental )
	values(1 ,'health plan', 10.3,'attorney plan', 'life insurance', 'dental');
select * from benefits;
--index creation----------------------------------------------------------------------------------
	
	CREATE Index id_number
	on Employee(id_num);
	CREATE INDEX full_name
	On Employee(first_name, Last_name);
	CREATE index address
	ON Employee(current_residence);
	Create index SocialSecurityNumber
	on Dependants(d_ssn);

--user creation ----------------------------------------------------------------------------------
create user testEmployee with password'testemployee';
grant employee to testemployee;

create role Manager;
alter role Manager with password 'manager';
create role admin;
alter role admin with password 'admin';
create role Employee;
alter role employee with password 'employee';

--granting privleges----------------------------------------------------------------------------------
--all can select for reports
grant select on "employee", "benefits", "dependants","insurance", "statetaxes", "federaltaxes", "payments","insurance" to Manager, admin, Employee;
-- update privilege
grant update on "employee" to Manager, Employee, admin;
grant update on "payments", "benefits", "dependants" to Manager, admin;
grant update on "federaltaxes", "statetaxes", "insurance" to admin;
--only admin can delete for saftey
grant delete on "employee", "benefits", "dependants","insurance", "statetaxes", "federaltaxes", "payments" to admin;
-- insert privilege
grant insert on "payments", "benefits", "employee", "insurance", "dependants" to Manager, admin;
grant insert on "federaltaxes", "statetaxes" to admin;
GRANT USAGE, SELECT ON SEQUENCE employee_id_num_seq TO manager;

--create privlige
grant create on database payroll to admin;
SELECT rolname FROM pg_roles;


