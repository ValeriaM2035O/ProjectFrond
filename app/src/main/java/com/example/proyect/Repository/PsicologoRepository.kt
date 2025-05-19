package com.example.proyect.Repository

import com.example.proyect.Model.Psicologo
import com.example.proyect.RetrofitClient

class PsicologoRepository {
    suspend fun obtenerPsicologos(): List<Psicologo> {
        return RetrofitClient.psicologoApi.listar()
    }

    suspend fun obtenerPsicologo(id: Long): Psicologo {
        return RetrofitClient.psicologoApi.buscarPorId(id)
    }

    suspend fun guardarPsicologo(psicologo: Psicologo): Psicologo {
        return RetrofitClient.psicologoApi.guardar(psicologo)
    }

    suspend fun eliminarPsicologo(id: Long) {
        RetrofitClient.psicologoApi.eliminar(id)
    }
    suspend fun actualizarPsicologo(id: Long, psicologo: Psicologo): Psicologo {
        return RetrofitClient.psicologoApi.actualizar(id, psicologo)
    }
}