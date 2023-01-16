insert into usuario (nombre,dni ,primer_apellido ,es_admin,contraseña ) values ("Luis","12345678Q","Olmo",true,1111);
insert into cuenta (numero,iban ,saldo ,id_usuario ) values (12345,"12345A",0,2);
insert into tarjeta (numero,fecha_expiracion ,cvv ,pin,bloqueado,id_cuenta_asociada ) values (875,20240101,777,1111,0,2);
insert into bonobus (saldo,id_tarjeta_asociada ) values (0,3);
insert into telefono (numero,saldo,id_tarjeta_asociada ) values (123456789,0,3);