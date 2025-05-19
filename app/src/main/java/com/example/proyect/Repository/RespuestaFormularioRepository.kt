package com.example.proyect.Repository

import com.example.proyect.Model.RespuestaFormulario
import com.example.proyect.RetrofitClient

class RespuestaFormularioRepository {

    suspend fun obtenerRespuestas(): List<RespuestaFormulario> {
        return RetrofitClient.respuestaFormularioApi.listar()
    }

    suspend fun obtenerRespuesta(id: Long): RespuestaFormulario {
        return RetrofitClient.respuestaFormularioApi.buscarPorId(id)
    }

    suspend fun guardarRespuesta(respuesta: RespuestaFormulario): RespuestaFormulario {
        return RetrofitClient.respuestaFormularioApi.guardar(respuesta)
    }

    suspend fun eliminarRespuesta(id: Long) {
        RetrofitClient.respuestaFormularioApi.eliminar(id)
    }
    suspend fun actualizarRespuesta(id: Long, respuesta: RespuestaFormulario): RespuestaFormulario{
        return RetrofitClient.respuestaFormularioApi.actualizar(id, respuesta)
    }
}