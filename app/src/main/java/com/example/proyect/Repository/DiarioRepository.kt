package com.example.proyect.Repository

import com.example.proyect.Model.Diario
import com.example.proyect.RetrofitClient

class DiarioRepository {
    suspend fun obtenerDiarios(): List<Diario> {
        return RetrofitClient.diarioApi.listar()
    }

    suspend fun obtenerDiario(id: Long): Diario {
        return RetrofitClient.diarioApi.buscarPorId(id)
    }

    suspend fun guardarDiario(diario: Diario): Diario {
        return RetrofitClient.diarioApi.guardar(diario)
    }

    suspend fun eliminarDiario(id: Long) {
        RetrofitClient.diarioApi.eliminar(id)
    }
    suspend fun actualizarDiario(id: Long, diario: Diario): Diario{
        return RetrofitClient.diarioApi.actualizar(id, diario)
    }
}