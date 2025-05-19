package com.example.proyect.Repository

import com.example.proyect.Model.AlertaEmergencia
import com.example.proyect.RetrofitClient

class AlertaEmergenciaRepository {
    suspend fun obtenerAlertas(): List<AlertaEmergencia> {
        return RetrofitClient.alertaEmergenciaApi.listar()
    }

    suspend fun obtenerAlerta(id: Long): AlertaEmergencia {
        return RetrofitClient.alertaEmergenciaApi.buscarPorId(id)
    }

    suspend fun guardarAlerta(alerta: AlertaEmergencia): AlertaEmergencia {
        return RetrofitClient.alertaEmergenciaApi.guardar(alerta)
    }

    suspend fun eliminarAlerta(id: Long) {
        RetrofitClient.alertaEmergenciaApi.eliminar(id)
    }
    suspend fun actualizarAlerta(id: Long, alerta: AlertaEmergencia): AlertaEmergencia {
        return RetrofitClient.alertaEmergenciaApi.actualizar(id, alerta)
    }
}