package com.example.proyect.Model

data class Formulario(
    val idFormulario: Long = 0,
    val nombre: String,
    val psicologo: Psicologo,
    val preguntas: List<PreguntaFormulario> = emptyList(),
    val respuestas: List<RespuestaFormulario> = emptyList()

)
