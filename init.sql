create table appointment
(
    id bigserial primary key,
    datetime timestamp,
    doctor_id BIGINT unique not null,
    patient_id BIGINT
);

create table doctor
(
    id bigserial primary key,
    uuid uuid unique not null,
    name varchar(255) not null,
    specialization varchar(255) not null,
    foreign key (id) references appointment (doctor_id) on delete cascade
);

create table patient
(
    id bigserial primary key,
    uuid uuid unique not null,
    name text not null,
    birthday DATE not null,
    phone_number varchar(12) not null
);
