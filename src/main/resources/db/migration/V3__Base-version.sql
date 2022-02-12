create sequence employee_id_seq start 1;

create table employee
(
    employee_id   bigint primary key,
    first_name    varchar(25) not null,
    last_name     varchar(30) not null,
    department_id bigint      not null,
    job_title     varchar(30) not null,
    gender        varchar(30) not null,
    date_of_birth varchar(30) not null
);
alter sequence employee_id_seq owned by employee.employee_id;
