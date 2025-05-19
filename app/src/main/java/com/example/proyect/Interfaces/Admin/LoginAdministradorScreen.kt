package com.example.proyect.Interfaces.Admin

import android.content.res.Configuration
import androidx.compose.animation.core.animateFloatAsState
import androidx.compose.animation.core.tween
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AdminPanelSettings
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material.icons.filled.Login
import androidx.compose.material.icons.filled.Person
import androidx.compose.material.icons.filled.Visibility
import androidx.compose.material.icons.filled.VisibilityOff
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.scale
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalConfiguration
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.ui.text.font.FontWeight
import androidx.navigation.NavController

@Composable
fun LoginAdminScreen(navController: NavController) {
    var usuario by remember { mutableStateOf("") }
    var contraseña by remember { mutableStateOf("") }
    var passwordVisible by remember { mutableStateOf(false) }

    // Animación
    var animateLogo by remember { mutableStateOf(false) }
    val logoScale by animateFloatAsState(
        targetValue = if (animateLogo) 1f else 0.7f,
        animationSpec = tween(durationMillis = 1000), label = "LogoScale"
    )

    LaunchedEffect(Unit) {
        animateLogo = true
    }

    // Orientación
    val configuration = LocalConfiguration.current
    val isPortrait = configuration.orientation == Configuration.ORIENTATION_PORTRAIT

    // Colores
    val backgroundColor = Color(0xFFE3F2FD)
    val cardColor = Color(0xFFF1F8E9)
    val textColor = Color(0xFF37474F)
    val buttonColor = Color(0xFFB2DFDB)

    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(backgroundColor)
            .padding(24.dp),
        contentAlignment = Alignment.Center
    ) {
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .verticalScroll(rememberScrollState())
                .background(cardColor, shape = RoundedCornerShape(16.dp))
                .padding(24.dp),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            // Ícono animado
            Icon(
                imageVector = Icons.Filled.AdminPanelSettings,
                contentDescription = "Logo Admin",
                modifier = Modifier
                    .size(100.dp)
                    .scale(logoScale),
                tint = textColor
            )

            Spacer(modifier = Modifier.height(12.dp))

            // Título
            Text(
                text = "Login Administrador",
                style = MaterialTheme.typography.headlineMedium.copy(
                    color = textColor,
                    fontWeight = FontWeight.Bold
                ),
                modifier = Modifier.padding(bottom = 24.dp)
            )

            OutlinedTextField(
                value = usuario,
                onValueChange = { usuario = it },
                label = { Text("Correo electrónico", color = textColor) },
                modifier = Modifier.fillMaxWidth(),
                textStyle = LocalTextStyle.current.copy(color = textColor),
                colors = OutlinedTextFieldDefaults.colors(
                    focusedBorderColor = textColor,
                    unfocusedBorderColor = textColor,
                    focusedLabelColor = textColor,
                    unfocusedLabelColor = textColor,
                    cursorColor = textColor
                )
            )

            Spacer(modifier = Modifier.height(12.dp))

            OutlinedTextField(
                value = contraseña,
                onValueChange = { contraseña = it },
                label = { Text("Contraseña", color = textColor) },
                visualTransformation = if (passwordVisible) VisualTransformation.None else PasswordVisualTransformation(),
                modifier = Modifier.fillMaxWidth(),
                textStyle = LocalTextStyle.current.copy(color = textColor),
                trailingIcon = {
                    val icon = if (passwordVisible) Icons.Default.Visibility else Icons.Default.VisibilityOff
                    val description = if (passwordVisible) "Ocultar contraseña" else "Mostrar contraseña"

                    IconButton(onClick = { passwordVisible = !passwordVisible }) {
                        Icon(imageVector = icon, contentDescription = description, tint = textColor)
                    }
                },
                colors = OutlinedTextFieldDefaults.colors(
                    focusedBorderColor = textColor,
                    unfocusedBorderColor = textColor,
                    focusedLabelColor = textColor,
                    unfocusedLabelColor = textColor,
                    cursorColor = textColor
                )
            )

            Spacer(modifier = Modifier.height(24.dp))

            val buttonModifier = Modifier
                .fillMaxWidth()
                .background(buttonColor, RoundedCornerShape(8.dp))

            if (isPortrait) {
                Column(
                    verticalArrangement = Arrangement.spacedBy(12.dp),
                    modifier = Modifier.fillMaxWidth()
                ) {
                    Button(
                        onClick = { navController.navigate("dashboard_admin") },
                        shape = RoundedCornerShape(8.dp),
                        modifier = buttonModifier,
                        colors = ButtonDefaults.buttonColors(
                            containerColor = buttonColor,
                            contentColor = textColor
                        )
                    ) {
                        Icon(Icons.Default.Person, contentDescription = "Ingresar")
                        Spacer(modifier = Modifier.width(8.dp))
                        Text("Ingresar", fontSize = 16.sp)
                    }

                    Button(
                        onClick = { navController.popBackStack() },
                        shape = RoundedCornerShape(8.dp),
                        modifier = buttonModifier,
                        colors = ButtonDefaults.buttonColors(
                            containerColor = buttonColor,
                            contentColor = textColor
                        )
                    ) {
                        Icon(Icons.Default.ArrowBack, contentDescription = "Volver")
                        Spacer(modifier = Modifier.width(8.dp))
                        Text("Volver", fontSize = 16.sp)
                    }
                }
            } else {
                Row(
                    horizontalArrangement = Arrangement.spacedBy(16.dp),
                    modifier = Modifier.fillMaxWidth()
                ) {
                    Button(
                        onClick = { navController.navigate("dashboard_admin") },
                        shape = RoundedCornerShape(8.dp),
                        modifier = Modifier
                            .weight(1f)
                            .background(buttonColor, RoundedCornerShape(8.dp)),
                        colors = ButtonDefaults.buttonColors(
                            containerColor = buttonColor,
                            contentColor = textColor
                        )
                    ) {
                        Icon(Icons.Default.Login, contentDescription = "Ingresar")
                        Spacer(modifier = Modifier.width(8.dp))
                        Text("Ingresar", fontSize = 16.sp)
                    }

                    Button(
                        onClick = { navController.popBackStack() },
                        shape = RoundedCornerShape(8.dp),
                        modifier = Modifier
                            .weight(1f)
                            .background(buttonColor, RoundedCornerShape(8.dp)),
                        colors = ButtonDefaults.buttonColors(
                            containerColor = buttonColor,
                            contentColor = textColor
                        )
                    ) {
                        Icon(Icons.Default.ArrowBack, contentDescription = "Volver")
                        Spacer(modifier = Modifier.width(8.dp))
                        Text("Volver", fontSize = 16.sp)
                    }
                }
            }
        }
    }
}
