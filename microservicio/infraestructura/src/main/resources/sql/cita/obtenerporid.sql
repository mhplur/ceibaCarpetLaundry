select id, id_client, id_tarifa, fecha_cita, hora_cita, horario, estado, costo, metros_cuadrados
from cita
where id =:id