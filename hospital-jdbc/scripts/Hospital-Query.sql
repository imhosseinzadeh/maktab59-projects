create
database hospital;

use
hospital;

create table patient
(
    id            int primary key auto_increment,
    address       varchar(50),
    name          varchar(50),
    age           int,
    date_of_birth date,
    gender        varchar(10)
);

create table doctor
(
    id         int primary key auto_increment,
    name       varchar(50),
    profession varchar(50),
    seniority  varchar(50)
);

create table department
(
    id   int primary key auto_increment,
    name varchar(50),
    type varchar(50)
);

create table bed
(
    id            int primary key auto_increment,
    type          varchar(50),
    department_id int,
    foreign key (department_id) references department (id)
);

create table reception
(
    reception_number int primary key auto_increment,
    reception_date   date,
    discharge_date   date,
    patient_id       int,
    foreign key (patient_id) references patient (id),
    doctor_id        int,
    foreign key (doctor_id) references doctor (id)
);


create table surgery
(
    id         int primary key auto_increment,
    date_time  datetime,
    patient_id int,
    foreign key (patient_id) references patient (id)
);


create table surgery_doctor
(
    id         int primary key auto_increment,
    surgery_id int,
    foreign key (surgery_id) references surgery (id),
    doctor_id  int,
    foreign key (doctor_id) references doctor (id)
);
