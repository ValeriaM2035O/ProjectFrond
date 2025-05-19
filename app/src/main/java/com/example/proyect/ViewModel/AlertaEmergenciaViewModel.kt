package com.example.proyect.ViewModel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.proyect.Model.AlertaEmergencia
import com.example.proyect.Repository.AlertaEmergenciaRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class AlertaEmergenciaViewModel : ViewModel() {
    private val repository = AlertaEmergenciaRepository()
    val alertas = MutableLiveData<List<AlertaEmergencia>?>(emptyList())

    fun listar() {
        viewModelScope.launch {
            val result = withContext(Dispatchers.IO) { repository.obtenerAlertas() }
            alertas.postValue(result)
        }
    }

    fun buscarPorId(id: Long) {
        viewModelScope.launch {
            repository.obtenerAlerta(id)
        }
    }

    fun guardar(alerta: AlertaEmergencia) {
        viewModelScope.launch {
            repository.guardarAlerta(alerta)
            listar()
        }
    }

    fun actualizar(id: Long, alerta: AlertaEmergencia) {
        viewModelScope.launch {
            repository.actualizarAlerta(id, alerta)
            listar()
        }
    }

    fun eliminar(id: Long) {
        viewModelScope.launch {
            repository.eliminarAlerta(id)
            listar()
        }
    }
}