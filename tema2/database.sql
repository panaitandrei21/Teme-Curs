create table student(
	student_number varchar(36) primary key,
    avarageMark double,
    person_id varchar(36) unique,
    foreign key (person_id) references person(id)
);

create table supervise (
	staff_number varchar(36),
    student_number varchar(36),
    primary key (staff_number, student_number),
    foreign key (staff_number) references profesor(staff_number),
    foreign key (student_number) references student(student_number)
);

insert into address (id, city, street, postalCode, country)
values ('ced8baf2-433b-11ee-be56-0242ac120002', 'Bucuresti', 'Florilor', 77150, 'Romania'),
		('04f905b0-433c-11ee-be56-0242ac120002', 'Ploiesti', 'Marului', 12345, 'Romania');
        
insert into address (id, city, street, postalCode, country)
values ('cd92b9fc-433d-11ee-be56-0242ac120002', 'Brasov', 'Bradului', 25132, 'Romania');

insert into person (id, name, phoneNumber, emailAddress, address_id)
values ('4f6380ee-433c-11ee-be56-0242ac120002', 'Andrei', '0771323921', 'andrei@gmail.com', 'ced8baf2-433b-11ee-be56-0242ac120002'),
		('63f86966-433c-11ee-be56-0242ac120002', 'Radu', '07715233921', 'radu@gmail.com', '04f905b0-433c-11ee-be56-0242ac120002');
		
        
insert into profesor (staff_number, salary, years_of_service, number_of_classes, person_id) 
values ('9a7721b2-433c-11ee-be56-0242ac120002', 7000, 10, 5, '4f6380ee-433c-11ee-be56-0242ac120002');

insert into profesor (staff_number, salary, years_of_service, number_of_classes, person_id) 
values ('9a7721b2-433c-11ee-be56-0242ac120003', 8000, 3, 2, '63f86966-433c-11ee-be56-0242ac120002');

insert into student (student_number, avarageMark, person_id) 
values ('bf489b2e-433c-11ee-be56-0242ac120002', 9, '63f86966-433c-11ee-be56-0242ac120002');

insert into supervise (staff_number, student_number)
values ('9a7721b2-433c-11ee-be56-0242ac120002', 'bf489b2e-433c-11ee-be56-0242ac120002');
