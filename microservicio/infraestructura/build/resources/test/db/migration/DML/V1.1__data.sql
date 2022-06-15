insert into client(id, identificacion_personal, nombre, direccion) values(1, '001', 'MILTON PAREDES', 'QUITO');
insert into client(id, identificacion_personal, nombre, direccion) values(2, '002', 'JUAN ANDRADE', 'MEDELLIN');
insert into client(id, identificacion_personal, nombre, direccion) values(3, '003', 'CARMEN SALINAS', 'GUAYAQUIL');

insert into tarifa(id, nombre, codigo, tiempo_hora_secado, costo_por_metro_cuadrado, limpieza_profunda) values(1, 'VAPOR O AGUA CALIENTE', 'W001',24, 15, 1);
insert into tarifa(id, nombre, codigo, tiempo_hora_secado, costo_por_metro_cuadrado, limpieza_profunda) values(2, 'EXTRACCION DE AIRE VONSCHADER', 'W002',5, 20, 1);
insert into tarifa(id, nombre, codigo, tiempo_hora_secado, costo_por_metro_cuadrado, limpieza_profunda) values(3, 'CEPILLO DE ROTOR', 'W003', 12, 10, 0);

insert into cita(id, id_client, id_tarifa, fecha_cita, hora_cita, horario, estado, costo) values (1, 1, 1,'2022-06-14', '08:00:00', 'DIA', 1, 15);
insert into cita(id, id_client, id_tarifa, fecha_cita, hora_cita, horario, estado, costo) values (2, 2, 1,'2022-06-14', '14:00:00', 'DIA', 1, 15);
insert into cita(id, id_client, id_tarifa, fecha_cita, hora_cita, horario, estado, costo) values (3, 2, 1,'2022-06-14', '16:00:00', 'DIA', 1, 15);

insert into cliente(id, nombre, tipo_cliente) values(1,'Cliente 1','PREFERENCIAL');
insert into cliente(id, nombre, tipo_cliente) values(2,'Cliente 2','COMUN');
insert into producto(id, nombre, aplica_iva, valor) values(1,'Producto 1',1, 25000);
insert into producto(id, nombre, aplica_iva, valor) values(2,'Producto 2',0, 10000);

insert into factura(id_cliente, valor_total, estado ) values(1, 25000, 'ACTIVA');
insert into factura(id_cliente, valor_total, estado ) values(2, 3000, 'ANULADA');
insert into producto_facturar( id_factura, id_producto, cantidad ) values(1, 1, 2);