create table client (
 id int(11) not null auto_increment,
 identificacion_personal varchar(100) not null,
 nombre varchar(100) not null,
 direccion varchar(100) not null,
 primary key (id)
);

create table tarifa (
 id int(11) not null auto_increment,
 nombre varchar(100) not null,
 codigo varchar(20) not null,
 tiempo_hora_secado TINYINT not null,
 costo_por_metro_cuadrado TINYINT not null,
 limpieza_profunda TINYINT not null,
 primary key (id)
);

create table cita (
id int(11) not null auto_increment,
id_client int(11) not null,
id_tarifa int(11) not null,
fecha_cita date not null,
hora_cita time not null,
horario varchar(11) not null,
estado integer not null,
costo DECIMAL(10,2) not null,
 primary key (id)
);

ALTER TABLE cita
ADD CONSTRAINT client_fk
FOREIGN KEY (id_client)
REFERENCES client (id)
ON DELETE NO ACTION
ON UPDATE NO ACTION;

ALTER TABLE cita
ADD CONSTRAINT tarifa_fk
FOREIGN KEY (id_tarifa)
REFERENCES tarifa (id)
ON DELETE NO ACTION
ON UPDATE NO ACTION;