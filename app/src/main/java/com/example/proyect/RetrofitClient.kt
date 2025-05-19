package com.example.proyect

import com.example.proyect.Api.AlertaEmergenciaApi
import com.example.proyect.Api.DiarioApi
import com.example.proyect.Api.FormularioApi
import com.example.proyect.Api.PacienteApi
import com.example.proyect.Api.PreguntaFormularioApi
import com.example.proyect.Api.PsicologoApi
import com.example.proyect.Api.RespuestaFormularioApi
import com.example.proyect.Api.SesionApi
import com.example.proyect.Api.UsuarioApi
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object RetrofitClient {
    private const val BASE_URL = "http://10.0.2.2:8080" // Cambia por tu IP si es físico o remoto

    private val retrofit by lazy {
        Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    }

    val diarioApi: DiarioApi by lazy {
        retrofit.create(DiarioApi::class.java)
    }

    val psicologoApi: PsicologoApi by lazy {
        retrofit.create(PsicologoApi::class.java)
    }

    val pacienteApi: PacienteApi by lazy {
        retrofit.create(PacienteApi::class.java)
    }

    val usuarioApi: UsuarioApi by lazy {
        retrofit.create(UsuarioApi::class.java)
    }

    val sesionApi: SesionApi by lazy {
        retrofit.create(SesionApi::class.java)
    }

    val alertaEmergenciaApi: AlertaEmergenciaApi by lazy {
        retrofit.create(AlertaEmergenciaApi::class.java)
    }

    val formularioApi: FormularioApi by lazy {
        retrofit.create(FormularioApi::class.java)
    }

    val preguntaFormularioApi: PreguntaFormularioApi by lazy {
        retrofit.create(PreguntaFormularioApi::class.java)
    }

    val respuestaFormularioApi: RespuestaFormularioApi by lazy {
        retrofit.create(RespuestaFormularioApi::class.java)
    }
}
