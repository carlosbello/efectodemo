/*global $ */
'use strict';

var plantillaAlumno = $('#plantillaAlumno').html();

/**
 * Genera código HTML a partir de una plantilla y datos de sustitución
 */
function generarHtml(plantilla, datos) {
    var html = plantilla;
    var nombresDeDatos = Object.keys(datos);
    nombresDeDatos.forEach(function (nombreDato) {
        console.log(nombreDato);
        var variable = new RegExp('{{' + nombreDato + '}}', 'g');
        var valor = datos[nombreDato];
        console.log(valor);
        html = html.replace(variable, valor);
    });
    return html;
}

/**
 * Actualiza la lista de alumnos cuyo cumpleaño coincide con la fecha indicada
 * @param {object[]} listaAlumnos - Lista de objetos con los datos de los alumnos: nombre y foto
 */
function actualizarListaAlumnos(listaAlumnos) {
    $('#alumnos').html('');
    listaAlumnos.forEach(function (alumno) {
        var html = generarHtml(plantillaAlumno, alumno);
        $('#alumnos').append(html);
    });
}

/**
 * Carga la lista de alumnos que cumplen años y actualiza la interfaz 
 * con los datos cargados
 */
function cargarCumpleanyos() {
    var fecha = $('#fecha').val();
    var url = '/api/cumpleanyos/' + fecha;
    $.getJSON(url, function (result) {
        if (result) {
            actualizarListaAlumnos(result);
        }
    });
}

$('#buscar').click(cargarCumpleanyos);


























































// Ignorar esta línea que no sería necesaria en una aplicación conectada con un servicio REST real
$('<script src="js/simular_servicio_rest.js"></script>').insertAfter('script:first');