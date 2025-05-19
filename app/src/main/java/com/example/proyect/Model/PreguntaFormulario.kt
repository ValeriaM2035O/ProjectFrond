package com.example.proyect.Model

data class PreguntaFormulario(
    val idPregunta: Long = 0,
    val texto: String,
    val formulario: Formulario?
)
