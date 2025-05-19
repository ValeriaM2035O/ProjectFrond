package com.example.proyect.ViewModel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.proyect.Model.Paciente
import com.example.proyect.Repository.PacienteRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class PacienteViewModel : ViewModel() {
    private val repository = PacienteRepository()
    val pacientes = MutableLiveData<List<Paciente>?>(emptyList())

    fun listar() {
        viewModelScope.launch {
            val result = withContext(Dispatchers.IO) { repository.obtenerPacientes() }
            pacientes.postValue(result)
        }
    }

    fun buscarPorId(id: Long) {
        viewModelScope.launch {
            repository.obtenerPaciente(id)
        }
    }

    fun guardar(paciente: Paciente) {
        viewModelScope.launch {
            repository.guardarPaciente(paciente)
            listar()
        }
    }

    fun actualizar(id: Long, paciente: Paciente) {
        viewModelScope.launch {
            repository.actualizarPaciente(id, paciente)
            listar()
        }
    }

    fun eliminar(id: Long) {
        viewModelScope.launch {
            repository.eliminarPaciente(id)
            listar()
        }
    }
}