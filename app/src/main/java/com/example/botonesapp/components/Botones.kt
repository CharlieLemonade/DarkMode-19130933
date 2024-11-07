package com.example.botonesapp.components

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Star
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.Switch
import androidx.compose.material3.SwitchDefaults
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun BotonNormal() {
    Button(onClick = { /*TODO*/ }, enabled = true, colors = ButtonDefaults.buttonColors(
        containerColor = Color(0xFF8BC34A) // Verde claro
    )) {
        Text(text = "Mi Boton", fontSize = 30.sp, color = Color.White)
    }
}

@Composable
fun BotonNormal2() {
    Button(
        onClick = { /*TODO*/ }, colors = ButtonDefaults.buttonColors(
            containerColor = Color(0xFF2196F3) // Azul
        )
    ) {
        Text(text = "Mi Boton", fontSize = 30.sp, color = Color.White)
    }
}

@Composable
fun BotonTexto() {
    TextButton(onClick = { /*TODO*/ }, colors = ButtonDefaults.textButtonColors(
        contentColor = Color(0xFFFF9800) // Naranja
    )) {
        Text(text = "Mi Boton", fontSize = 30.sp)
    }
}

@Composable
fun BotonOutline() {
    OutlinedButton(onClick = { /*TODO*/ }, border = BorderStroke(2.dp, Color(0xFFFFC107)), colors = ButtonDefaults.outlinedButtonColors(
        contentColor = Color(0xFFFFC107) // Ámbar
    )) {
        Text(text = "Mi Boton", fontSize = 30.sp)
    }
}

@Composable
fun BotonIcono() {
    IconButton(onClick = { /*TODO*/ }) {
        Icon(
            Icons.Filled.Star,
            contentDescription = "Icono",
            tint = Color(0xFF673AB7), // Púrpura
            modifier = Modifier.size(50.dp)
        )
    }
}

@Composable
fun BotonSwitch() {
    var switched by remember { mutableStateOf(false) }
    Switch(
        checked = switched, onCheckedChange = { switched = it },
        colors = SwitchDefaults.colors(
            checkedThumbColor = Color(0xFF4CAF50), // Verde
            checkedTrackColor = Color(0xFF81C784), // Verde claro
            uncheckedThumbColor = Color(0xFFF44336), // Rojo
            uncheckedTrackColor = Color(0xFFEF9A9A) // Rojo claro
        )
    )
}

@Composable
fun DarkMode(darkMode: MutableState<Boolean>, onDarkModeChange: (Boolean) -> Unit) {
    Button(onClick = {
        // Cambia el valor de darkMode
        val newDarkMode = !darkMode.value
        darkMode.value = newDarkMode
        // Llama al callback para actualizar la preferencia
        onDarkModeChange(newDarkMode)
    }, colors = ButtonDefaults.buttonColors(
        containerColor = Color(0xFF3F51B5) // Azul oscuro
    )) {
        Icon(imageVector = Icons.Default.Star, contentDescription = "DarkMode", tint = Color.White)
        Spacer(modifier = Modifier.width(15.dp))
        Text(text = "Dark Mode", fontSize = 30.sp, color = Color.White)
    }
}


@Composable
fun FloatingAction() {
    FloatingActionButton(
        onClick = { /*TODO*/ },
        containerColor = Color(0xFFFF5722), // Naranja oscuro
        contentColor = Color.White
    ) {
        Icon(
            Icons.Filled.Add,
            contentDescription = "",
            modifier = Modifier.size(30.dp)
        )
    }
}

@Composable
fun Space() {
    Spacer(modifier = Modifier.height(10.dp))
}