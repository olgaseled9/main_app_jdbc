create table employee
(
    employee_id   bigint primary key GENERATED ALWAYS AS IDENTITY,
    first_name    varchar(25) not null,
    last_name     varchar(30) not null,
    department_id bigint      not null,
    job_title     varchar(30) not null,
    gender        varchar(30) not null,
    date_of_birth varchar(30) not null
);

