/*jslint vars: true */
/*global $ */

/**
 * Simulador de servicio REST.
 * 
 * IGNORAR este archivo pues su único cometido es hacer
 * que las llamadas al servicio REST funcionen, sin tener
 * realmente disponible un servicio REST.
 */

'use strict';

// Inserta la referencia a la librería MockAjax, responsable de simular
// las respuestas a las peticiones Ajax
$('<script src="js/jquery.mockjax.js"></script>').insertAfter('script:first');
// Configura el simulador indicando qué respuesta dar, ante una petición Ajax
// a un supuesto servicio REST
$.mockjax({
    url: '/api/alumnoDestacado',
    response: function () {
        // Lista de supuestos alumnos destacados
        var destacados = [
            {
                "nombre": "María López González",
                "foto": "img/alumnos/maria_lopez.jpg",
                "motivo": "Galardonada en las Olimpiadas Municipales de Lengua Inglesa"
            },
            {
                "nombre": "Juan Pérez González",
                "foto": "img/alumnos/juan_perez.jpg",
                "motivo": "Campeon local de ajedrez"
            },
            {
                "nombre": "Laura Gutierrez Pérez",
                "foto": "img/alumnos/laura_gutierrez.jpg",
                "motivo": "3er premio en el concurso de geografía"
            }
        ];
        // Índice aleatorio entre 0 y la cantidad de alumnos destacados
        var indiceAlumnoAleatorio = Math.floor(Math.random() * destacados.length);
        // Responder a la peticińo Ajax con un alumno destacado aleatorio
        this.responseText = destacados[indiceAlumnoAleatorio];
    }
});