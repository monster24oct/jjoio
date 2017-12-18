DROP TABLE users;
CREATE TABLE users(user_id NUMBER(5) PRIMARY KEY,username VARCHAR2(30),password VARCHAR2(20),role VARCHAR2(5),mobile_no NUMBER(10));
drop sequence userIdSequence;
create sequence userIdSequence start with 10000;
insert into users values(userIdSequence.nextval,'Ramukaka','ram1234','user',9916348201);
insert into users values(userIdSequence.nextval,'Ankur','ank1234','admin',8126039867);
insert into users values(userIdSequence.nextval,'Nikunj','nik1234','admin',9331125670);
insert into users values(userIdSequence.nextval,'Nikita','nik1234','admin',9867549785);
insert into users values(userIdSequence.nextval,'Ritwika','rit1234','user',9658976521);



DROP TABLE passengers;
CREATE TABLE passengers(user_id REFERENCES users(user_id),passenger_id NUMBER(5) PRIMARY KEY,passenger_name VARCHAR2(30),passenger_age NUMBER(3),gender VARCHAR2(6));
drop sequence passIdSequence;
create sequence passIdSequence start with 50000;
insert into passengers values(10002,passIdSequence.nextval,'Kangana',25,'Female');
insert into passengers values(10002,passIdSequence.nextval,'Rohit',28,'male');
insert into passengers values(10001,passIdSequence.nextval,'Mangal',35,'male');
insert into passengers values(10001,passIdSequence.nextval,'draupadi',18,'Female');
insert into passengers values(10001,passIdSequence.nextval,'Barbara',36,'Female');
insert into passengers values(10001,passIdSequence.nextval,'Rock',40,'male');




DROP TABLE flight_information;
CREATE TABLE flight_information(flight_id number(5) PRIMARY KEY,airline VARCHAR2(25),departure_city VARCHAR2(30),arrival_city VARCHAR2(30),departure_time VARCHAR2(10),arrival_time VARCHAR2(10),no_of_seats NUMBER(3),Bus_fare NUMBER(7,2),eco_fare number(7,2));
insert into flight_information values(12808,'AirIndia','Bangalore','Kolkata','10:30','12:30',120,12500.00,2500.00);
insert into flight_information values(22181,'Indigo','Bangalore','Delhi','15:30','18:50',150,14500.00,4500.00);
insert into flight_information values(12721,'Kingfisher','Mumbai','Kolkata','07:30','10:00',100,15500.00,5500.00);
insert into flight_information values(18197,'GoAir','Mumbai','Kolkata','21:00','23:15',180,13000.00,3000.00);
insert into flight_information values(52430,'Vistara','kolkata','Mumbai','18:00','20:40',210,15500.00,5500.00);
insert into flight_information values(78546,'JetAirways','Kolkata','Chennai','23:30','00:30',140,12450.00,2460.00);




DROP TABLE airport;
CREATE TABLE airport(airport_name VARCHAR2(30),abbreviation VARCHAR2(5),location VARCHAR2(30));
insert into airport values('KempadgowdaBang','BLR','Bangalore');
insert into airport values('RajivGandhi','Del','Delhi');
insert into airport values('NSCB','CCO','Kolkata');
insert into airport values('ChhatrapatiShivaji','Bom','Mumbai');



drop sequence Booking_id_seq;
create sequence Booking_id_seq start with 4000;
DROP TABLE booking_information;
CREATE TABLE booking_information(user_id REFERENCES users(user_id),flight_id REFERENCES flight_information(flight_id), booking_id NUMBER(5) PRIMARY KEY,booking_date DATE,no_of_passengers NUMBER(3),class_type VARCHAR2(10),total_fare NUMBER(7,2));
insert into booking_information values(10001,12808,Booking_id_seq.nextval,'24-Dec-2017',3,'Economy',7500.00);
insert into booking_information values(10002,22181,Booking_id_seq.nextval,'04-Jan-2018',2,'Business',29000.00);


Queries->
//for flight info
select flight_id,airline from flight_information where departure_city='Bangalore' AND arrival_city='Delhi' AND class;
//for adding Booking details
insert into booking_information values(?,?,Booking_id_seq.nextval,?,?,);
