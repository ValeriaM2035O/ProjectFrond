package com.example.proyect.ViewModel
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.proyect.Model.Psicologo
import com.example.proyect.Repository.PsicologoRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class PsicologoViewModel : ViewModel() {
    private val repository = PsicologoRepository()
    val psicologos = MutableLiveData<List<Psicologo>?>(emptyList())

    fun listar() {
        viewModelScope.launch {
            val result = withContext(Dispatchers.IO) { repository.obtenerPsicologos() }
            psicologos.postValue(result)
        }
    }

    fun buscarPorId(id: Long) {
        viewModelScope.launch {
            repository.obtenerPsicologo(id)
        }
    }

    fun guardar(psicologo: Psicologo) {
        viewModelScope.launch {
            repository.guardarPsicologo(psicologo)
            listar()
        }
    }

    fun actualizar(id: Long, psicologo: Psicologo) {
        viewModelScope.launch {
            repository.actualizarPsicologo(id, psicologo)
            listar()
        }
    }

    fun eliminar(id: Long) {
        viewModelScope.launch {
            repository.eliminarPsicologo(id)
            listar()
        }
    }
}