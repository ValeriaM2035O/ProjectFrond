package com.example.proyect.Navegacion

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.compose.foundation.layout.*
import androidx.compose.material3.Text
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.sp
import com.example.proyect.Interfaces.Admin.GestionUsuariosScreen
import com.example.proyect.Interfaces.Admin.LoginAdminScreen
import com.example.proyect.Interfaces.Paciente.CalendarioScreen
import com.example.proyect.Interfaces.Paciente.DashboardPacienteScreen
import com.example.proyect.Interfaces.Paciente.DiarioScreen
import com.example.proyect.Interfaces.Paciente.EmergenciaScreen
import com.example.proyect.Interfaces.Paciente.FormularioScreen
import com.example.proyect.Interfaces.Paciente.HistorialSesionesScreen
import com.example.proyect.Interfaces.Paciente.LoginPacienteScreen
import com.example.proyect.Interfaces.Psicologo.WelcomeScreen

@Composable
fun AppNavigation(startDestination: String = "welcome") {
    val navController: NavHostController = rememberNavController()

    NavHost(navController = navController, startDestination = startDestination) {

        // Pantalla de bienvenida
        composable("welcome") { WelcomeScreen(navController) }

        // Logins por rol
        composable("login_paciente") { LoginPacienteScreen(navController) }
        /*composable("login_psicologo") { LoginPsicologoScreen(navController) }*/
        composable("login_admin") { LoginAdminScreen(navController) }

        // Dashboard por rol
        composable("dashboard_paciente") { DashboardPacienteScreen(navController) }
        composable("dashboard_psicologo") {
            DashboardPacienteScreen(navController)
        }
        composable("dashboard_admin") {
            GestionUsuariosScreen(navController)

        }

        // Otras rutas del paciente
        composable("formulario") {
            FormularioScreen(navController) { nuevoFormulario ->
                // Guardar el formulario en el backStack anterior para recuperarlo
                navController.previousBackStackEntry
                    ?.savedStateHandle
                    ?.set("nuevoFormulario", nuevoFormulario)
                navController.popBackStack()
            }
        }
        composable("calendario") {
            CalendarioScreen(navController)
        }

        composable("emergencia") {
            EmergenciaScreen(navController)
        }
        composable("recursos") {
            PlaceholderScreen("Recursos de Bienestar")

        }
        composable("diario") {
            DiarioScreen(navController)
        }
        composable("historial") {
            HistorialSesionesScreen(navController)
        }
    }
}

@Composable
fun NavHost(
    navController: NavHostController,
    startDestination: String,
    content: @Composable () -> composable
) {
    TODO("Not yet implemented")
}

@Composable
fun PlaceholderScreen(title: String) {
    Box(
        modifier = Modifier.fillMaxSize(),
        contentAlignment = Alignment.Center
    ) {
        Text(text = title, fontSize = 24.sp)
    }
}
