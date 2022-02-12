insert into employee (employee_id, first_name, last_name, department_id, job_title, gender, date_of_birth)
values (nextval('employee_id_seq'), 'Ivan', 'Ivanov', 1, 'project manager', 'MALE', '1991-11-27'),
       (nextval('employee_id_seq'), 'Victoria', 'Ivanova', 2, 'senior developer', 'FEMALE', '1992-12-01'),
       (nextval('employee_id_seq'), 'Petr', 'Pertov', 3, 'QA', 'MALE', '1995-04-07'),
       (nextval('employee_id_seq'), 'Anna', 'Petrova', 4, 'recruiter', 'FEMALE', '1998-09-14'),
       (nextval('employee_id_seq'), 'Alina', 'Sidorova', 2, 'junior developer', 'FEMALE', '1994-08-08'),
       (nextval('employee_id_seq'), 'Andrey', 'Sidorov', 3, 'QA', 'MALE', '1991-11-27'),
       (nextval('employee_id_seq'), 'Inna', 'Drozd', 2, 'middle developer', 'FEMALE', '1992-01-25');
