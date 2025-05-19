package com.example.proyect.Model

data class RespuestaFormulario(
    val idRespuesta: Long = 0,
    val respuesta: String,
    val formulario: Formulario,
    val paciente: Paciente,
    val pregunta: PreguntaFormulario
)
