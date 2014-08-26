/*jslint vars: true */
/*global $ */
'use strict';

var plantillaAlumno = $('#plantillaAlumno').html(); // Obtener el código de la plantilla

/**
 * Genera código HTML a partir de una plantilla y datos de sustitución
 * @param {string} pantilla - Cadena con la plantilla HTML
 * @param {Object} datos - Diccionario de nombres de datos a remplazar 
 *      con su respectivo valor
 */
function generarHtml(plantilla, datos) {
    var html = plantilla;                       // Inicializar el HTML con la plantilla
    var nombresDeDatos = Object.keys(datos);    // Obtener lista de datos a remplazar
    nombresDeDatos.forEach(function (nombreDato) {  // Por cada dato a remplazar:
        var nombre = new RegExp('{{' + nombreDato + '}}', 'g'); // Obtener el nombre a remplazar
        var valor = datos[nombreDato];                    // Obtener valor de remplazo
        html = html.replace(nombre, valor);               // Remplazar nombre por valor
    });
    return html;                                // Devolver HTML generado
}

/**
 * Actualiza la lista de alumnos cuyo cumpleaño coincide con la fecha indicada
 * @param {object[]} listaAlumnos - Lista de objetos con los datos de los alumnos: 
 *      nombre y foto
 */
function actualizarListaAlumnos(listaAlumnos) {
    $('#alumnos').html('');                     // Inicializar la lista HTML como vacía
    listaAlumnos.forEach(function (alumno) {    // Por cada alumno:
        var html = generarHtml(plantillaAlumno, alumno); // Generar el HTML con sus datos
        $('#alumnos').append(html);             // Añadir el HTML generado a la lista
    });
}

/**
 * Carga la lista de alumnos que cumplen años y actualiza la interfaz 
 * con los datos cargados
 */
function cargarCumpleanyos() {
    var fecha = $('#fecha').val();          // Obtener fecha de consulta
    var url = '/api/cumpleanyos/' + fecha;  // Generar url de consulta
    $.getJSON(url, function (result) {      // Solicitar lista de alumnos
        if (result) {                       // Si se obtiene alguna lista
            actualizarListaAlumnos(result); // Actualizar lista de alumnos
        }
    });
}

$('#buscar').click(cargarCumpleanyos);      // Al hacer clic: cargar alumnos que cumplen años


























































// Ignorar esta línea que no sería necesaria en una aplicación conectada con un servicio REST real
$('<script src="js/simular_servicio_rest.js"></script>').insertAfter('script:first');