package com.example.proyect.Interfaces.Paciente

import androidx.compose.foundation.layout.*
import androidx.compose.material3.AlertDialog
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController

@Composable
fun EmergenciaScreen(navController: NavHostController) {
    var mostrarDialogo by remember { mutableStateOf(false) }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(24.dp),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(
            text = "Botón de Emergencia",
            fontSize = 26.sp,
            fontWeight = FontWeight.Bold,
            color = Color.Red
        )

        Spacer(modifier = Modifier.height(32.dp))

        Button(
            onClick = { mostrarDialogo = true },
            colors = ButtonDefaults.buttonColors(containerColor = Color.Red),
            modifier = Modifier
                .height(60.dp)
                .width(240.dp)
        ) {
            Text("Activar Alerta", color = Color.White, fontSize = 18.sp)
        }
    }

    if (mostrarDialogo) {
        EmergenciaDialog(
            onDismiss = { mostrarDialogo = false },
            onConfirm = {
                mostrarDialogo = false
                // Aquí puedes agregar la lógica para enviar la alerta
                println("⚠️ Alerta de emergencia activada")
            }
        )
    }
}

@Composable
fun EmergenciaDialog(
    onDismiss: () -> Unit,
    onConfirm: () -> Unit
) {
    AlertDialog(
        onDismissRequest = onDismiss,
        title = {
            Text(
                text = "🚨 Alerta de Emergencia",
                fontWeight = FontWeight.Bold,
                fontSize = 20.sp,
                color = Color.Red
            )
        },
        text = {
            Text(
                "¿Estás seguro de que deseas activar la alerta de emergencia? Esta acción notificará a tu red de apoyo y profesionales inmediatamente.",
                fontSize = 16.sp
            )
        },
        confirmButton = {
            Button(
                onClick = onConfirm,
                colors = ButtonDefaults.buttonColors(containerColor = Color.Red)
            ) {
                Text("Sí, activar alerta", color = Color.White)
            }
        },
        dismissButton = {
            OutlinedButton(onClick = onDismiss) {
                Text("Cancelar")
            }
        }
    )
}
