-- create schema progamacion;
use progamacion;


drop table if exists  Rol;
drop table if exists  Usuario;
drop table if exists  usuario_rol;
drop table if exists  Cuenta;
drop table if exists  Tarjeta;


create table Rol(
id int AUTO_INCREMENT primary key, 
rol varchar(20),
descripcion text
);

create table Usuario(
id int AUTO_INCREMENT primary key not null, 
nombre varchar(20) not null,
edad int not null,
primer_apellido varchar(20),

);

create table usuario_rol(
id int not null primary key auto_increment,
id_usuario int not null ,
id_rol int  not null ,
CONSTRAINT id_usuario_fk FOREIGN KEY (id_usuario) REFERENCES Usuario (id),
 constraint id_rol_fk foreign key(id_rol) REFERENCES Rol(id) 
);


create table Tarjeta(
id int AUTO_INCREMENT primary key not null ,
numero int unique key,
fecha_expiracion date ,
cvv int, 
pin int
);

create table Cuenta(
id int AUTO_INCREMENT primary key not null,
numero int unique key,
iban varchar(20) unique key,
saldo float not null ,
tarjeta_asociada int not null,
id_usuario int not null  ,
foreign key (id_usuario) references usuario(id),
foreign key(tarjeta_asociada) REFERENCES tarjeta(id) 
);