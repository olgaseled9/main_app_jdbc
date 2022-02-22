create table gender
(
    id     bigint primary key GENERATED ALWAYS AS IDENTITY,
    gender varchar not null
);
