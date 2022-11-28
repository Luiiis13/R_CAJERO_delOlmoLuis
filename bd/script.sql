
use progamacion;

drop table if exists  usuario_rol;
drop table if exists  Movimiento;
drop table if exists  Cuenta;
drop table if exists  Rol;
drop table if exists  Usuario;
drop table if exists  Tarjeta;
drop table if exists  Cajero;



create table Usuario(
id int AUTO_INCREMENT primary key not null, 
nombre varchar(20) not null,
edad int not null,
primer_apellido varchar(20),
rol varchar(20) not null
);



create table Tarjeta(
id int AUTO_INCREMENT primary key not null ,
numero int unique key not null,
fecha_expiracion date not null,
cvv int not null, 
pin int not null
);

create table Cuenta(
id int AUTO_INCREMENT primary key not null,
numero int unique key not null,
iban varchar(20) unique key not null,
saldo float not null ,
tarjeta_asociada int not null,
id_usuario int not null  ,
foreign key (id_usuario) references usuario(id),
foreign key(tarjeta_asociada) REFERENCES tarjeta(id) 
);


create table Movimiento(
id int auto_increment primary key not null ,
id_cuenta_origen int not null,
id_cuenta_destino int not null ,
cantidad float not null,
fecha_del_movimiento date not null,
foreign key (id_cuenta_origen) references Cuenta(id),
foreign key (id_cuenta_destino) references Cuenta(id)
);

create table Cajero(
id int auto_increment not null  primary key,
ubicacion varchar(40) not null
);