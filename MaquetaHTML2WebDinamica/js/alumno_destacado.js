/*global $ */
'use strict';

/**
 * Actualiza los datos de un alumno, en la sección de alumno destacado
 * @param datosAlumno - Objeto con los datos del alumno: nombre, foto y motivo
 */
function actualizarAlumnoDestacado(datosAlumno) {
    $('#nombre').text(datosAlumno.nombre);
    $('#foto').attr('src', datosAlumno.foto);
    $('#motivo').text(datosAlumno.motivo);
}

/**
 * Carga los datos del alumno destacado y actualiza la interfaz 
 * con los datos cargados
 */
function cargarAlumnoDestacado() {
    var url = '/api/alumnoDestacado';
    $.getJSON(url, function (result) {
        if (result) {
            actualizarAlumnoDestacado(result);
        }
    });
}

$(document).ready(cargarAlumnoDestacado);


























































// Ignorar esta línea que no sería necesaria en una aplicación conectada con un servicio REST real
$('<script src="js/simular_servicio_rest.js"></script>').insertAfter('script:first');