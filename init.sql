create table appointment
(
    id        BIGINT
    constraint appointment_pk
    primary key,
    app_time timestamp,
    doctor_id BIGINT unique not null,
    patient_id BIGINT unique not null
);

create table doctor
(
    id BIGINT
        constraint doctor_pk
            primary key,
    uuid uuid not null,
    name varchar(255) not null,
    specialization varchar(255) not null,
    foreign key (id) references appointment (doctor_id) on delete cascade
);

create table patient
(
    id BIGINT
        constraint patient_pk
            primary key,
    uuid uuid not null,
    name text not null,
    birthday DATE not null,
    phone_number varchar(12) not null,
    foreign key (id) references appointment (patient_id) on delete cascade
);
