package com.example.proyect.Repository

import com.example.proyect.Model.PreguntaFormulario
import com.example.proyect.RetrofitClient

class PreguntaFormularioRepository {
    suspend fun obtenerPreguntas(): List<PreguntaFormulario> {
        return RetrofitClient.preguntaFormularioApi.listar()
    }

    suspend fun obtenerPregunta(id: Long): PreguntaFormulario {
        return RetrofitClient.preguntaFormularioApi.buscarPorId(id)
    }

    suspend fun guardarPregunta(pregunta: PreguntaFormulario): PreguntaFormulario {
        return RetrofitClient.preguntaFormularioApi.guardar(pregunta)
    }

    suspend fun eliminarPregunta(id: Long) {
        RetrofitClient.preguntaFormularioApi.eliminar(id)
    }
    suspend fun actualizarPregunta(id: Long, pregunta: PreguntaFormulario): PreguntaFormulario{
        return RetrofitClient.preguntaFormularioApi.actualizar(id,pregunta)
    }
}