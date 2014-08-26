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

var alumnos = [
    {
        'nombre': 'María López González',
        'foto': 'img/alumnos/maria_lopez.jpg'
    },
    {
        'nombre': 'Juan Pérez González',
        'foto': 'img/alumnos/juan_perez.jpg'
    },
    {
        'nombre': 'Laura Gutierrez Pérez',
        'foto': 'img/alumnos/laura_gutierrez.jpg'
    },
    {
        'nombre': 'Jacobo Anselma',
        'foto': 'img/alumnos/jacobo_anselma.jpg'
    },
    {
        'nombre': 'Ester Eliseo',
        'foto': 'img/alumnos/ester_eliseo.jpg'
    },
    {
        'nombre': 'Leopoldo Emigdio',
        'foto': 'img/alumnos/leopoldo_emigdio.jpg'
    },
    {
        'nombre': 'Aarón Angelina',
        'foto': 'img/alumnos/aaron_angelina.jpg'
    },
    {
        'nombre': 'Teo Reinaldo',
        'foto': 'img/alumnos/teo_reinaldo.jpg'
    },
    {
        'nombre': 'Albina Heliodoro',
        'foto': 'img/alumnos/albina_eliodoro.jpg'
    }
];

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
                'nombre': 'María López González',
                'foto': 'img/alumnos/maria_lopez.jpg',
                'motivo': 'Galardonada en las Olimpiadas Municipales de Lengua Inglesa'
            },
            {
                'nombre': 'Juan Pérez González',
                'foto': 'img/alumnos/juan_perez.jpg',
                'motivo': 'Campeon local de ajedrez'
            },
            {
                'nombre': 'Laura Gutierrez Pérez',
                'foto': 'img/alumnos/laura_gutierrez.jpg',
                'motivo': '3er premio en el concurso de geografía'
            }
        ];
        // Índice aleatorio entre 0 y la cantidad de alumnos destacados
        var indiceAlumnoAleatorio = Math.floor(Math.random() * destacados.length);
        // Responder a la petición Ajax con un alumno destacado aleatorio
        this.responseText = destacados[indiceAlumnoAleatorio];
    }
});
$.mockjax({
    url: '/api/cumpleanyos/*',
    response: function () {
        var cantidad = Math.floor(Math.random() * 3) + 3;
        var cumpleanyos = [];
        var escogidos = [];
        var indiceAlumnoAleatorio;
        for (var i = 1; i <= cantidad; i++) {
            do {
                indiceAlumnoAleatorio = Math.floor(Math.random() * alumnos.length);
            } while (escogidos[indiceAlumnoAleatorio]);
            escogidos[indiceAlumnoAleatorio] = true;
            cumpleanyos.push(alumnos[indiceAlumnoAleatorio]);
        }
        // Responder a la petición Ajax con la lista de alumnos aleatorios
        this.responseText = cumpleanyos;
    }
});