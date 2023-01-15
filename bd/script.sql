
use progamacion;

drop table if exists  Movimiento;
drop table if exists Bonobus;
drop table if exists telefono;
drop table if exists  Cuenta;
drop table if exists  Rol;
drop table if exists  Usuario;
drop table if exists  Tarjeta;
drop table if exists  Cajero;



create table Usuario(
id int AUTO_INCREMENT primary key not null, 
nombre varchar(20) not null,
dni char(9) not null,
primer_apellido varchar(20),
es_admin boolean not null,
contraseña varchar(50) null
);


create table Tarjeta(
id int AUTO_INCREMENT primary key not null ,
numero int unique key not null,
fecha_expiracion date not null,
cvv int not null, 
pin int not null,
bloqueado boolean not null,
id_cuenta_asociada int not null,
foreign key (id_cuenta_asociada) references Cuenta(id) ON DELETE CASCADE
);

create table Cuenta(
id int AUTO_INCREMENT primary key not null,
numero int unique key not null,
iban varchar(20) unique key not null,
saldo float not null ,
id_usuario int not null  ,
foreign key (id_usuario) references usuario(id) 
);


create table Movimiento(
id int auto_increment primary key not null ,
fecha_del_movimiento date not null,
tipo varchar(20) not null ,
id_tarjeta_asociada int not null,
foreign key(id_tarjeta_asociada) REFERENCES tarjeta(id) ON DELETE CASCADE
);

create table Cajero(
id int auto_increment not null  primary key,
ubicacion varchar(40) not null
);

create table Bonobus(
id int primary key not null auto_increment,
saldo float not null,
id_tarjeta_asociada int not null ,
foreign key(id_tarjeta_asociada) REFERENCES tarjeta(id) ON DELETE CASCADE
);

create table telefono(
id int primary key not null auto_increment,
numero int not null,
saldo float not null,
id_tarjeta_asociada int not null ,
foreign key(id_tarjeta_asociada) REFERENCES tarjeta(id)  ON DELETE CASCADE
);