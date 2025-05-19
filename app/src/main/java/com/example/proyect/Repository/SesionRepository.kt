package com.example.proyect.Repository

import com.example.proyect.Model.Sesion
import com.example.proyect.RetrofitClient

class SesionRepository {

    suspend fun obtenerSesiones(): List<Sesion> {
        return RetrofitClient.sesionApi.listar()
    }

    suspend fun obtenerSesion(id: Long): Sesion {
        return RetrofitClient.sesionApi.buscarPorId(id)
    }

    suspend fun guardarSesion(sesion: Sesion): Sesion {
        return RetrofitClient.sesionApi.guardar(sesion)
    }

    suspend fun eliminarSesion(id: Long) {
        RetrofitClient.sesionApi.eliminar(id)
    }
    suspend fun actualizarSesion(id: Long, sesion: Sesion): Sesion {
        return RetrofitClient.sesionApi.actualizar(id, sesion)
    }
}