create
database if not exists hospital;

use
hospital;

create table patient
(
    id            bigint primary key auto_increment,
    address       varchar(50),
    name          varchar(50),
    age           int,
    date_of_birth date,
    gender        varchar(10)
);

create table doctor
(
    id         bigint primary key auto_increment,
    name       varchar(50),
    profession varchar(50),
    seniority  varchar(50)
);

create table department
(
    id   bigint primary key auto_increment,
    name varchar(50),
    type varchar(50)
);

create table bed
(
    id            bigint primary key auto_increment,
    type          varchar(50),
    department_id bigint,
    foreign key (department_id) references department (id)
);

create table reception
(
    reception_number bigint primary key auto_increment,
    reception_date   date,
    discharge_date   date,
    patient_id       bigint,
    foreign key (patient_id) references patient (id),
    doctor_id        bigint,
    foreign key (doctor_id) references doctor (id)
);


create table surgery
(
    id         bigint primary key auto_increment,
    date_time  datetime,
    patient_id bigint,
    foreign key (patient_id) references patient (id)
);


create table surgery_doctor
(
    id         bigint primary key auto_increment,
    surgery_id bigint,
    foreign key (surgery_id) references surgery (id),
    doctor_id  bigint,
    foreign key (doctor_id) references doctor (id)
);