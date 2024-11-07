package com.example.botonesapp

import android.content.Context
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.sp
import com.example.botonesapp.ui.theme.BotonesAppTheme
import com.example.botonesapp.components.*

class MainActivity : ComponentActivity() {

    // Definir la clave de preferencia para el modo oscuro
    private val darkModePreferenceKey = "DARK_MODE_KEY"

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContent {
            // Obtener el estado del modo oscuro guardado en SharedPreferences
            val darkMode = remember { mutableStateOf(getDarkModePreference()) }

            BotonesAppTheme(darkTheme = darkMode.value) {
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    Content(
                        darkMode = darkMode,
                        onDarkModeChange = { isDarkMode ->
                            darkMode.value = isDarkMode
                            setDarkModePreference(isDarkMode)
                        }
                    )
                }
            }
        }
    }

    // Función para obtener el valor del modo oscuro desde SharedPreferences
    private fun getDarkModePreference(): Boolean {
        val sharedPref = getSharedPreferences("app_preferences", Context.MODE_PRIVATE)
        return sharedPref.getBoolean(darkModePreferenceKey, false) // Por defecto es false (modo claro)
    }

    // Función para guardar el valor del modo oscuro en SharedPreferences
    private fun setDarkModePreference(isDarkMode: Boolean) {
        val sharedPref = getSharedPreferences("app_preferences", Context.MODE_PRIVATE)
        with(sharedPref.edit()) {
            putBoolean(darkModePreferenceKey, isDarkMode)
            apply()
        }
    }
}

@Composable
fun Content(darkMode: MutableState<Boolean>, onDarkModeChange: (Boolean) -> Unit) {
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .wrapContentSize(Alignment.Center),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        BotonNormal()
        Space()
        BotonNormal2()
        Space()
        BotonTexto()
        Space()
        BotonOutline()
        Space()
        BotonIcono()
        Space()
        BotonSwitch()
        Space()
        DarkModeButton(darkMode = darkMode, onDarkModeChange = onDarkModeChange)  // Botón que cambia entre Dark Mode y Light Mode
        Space()
        FloatingAction()
    }
}

@Composable
fun DarkModeButton(darkMode: MutableState<Boolean>, onDarkModeChange: (Boolean) -> Unit) {
    // Cambia el texto y la funcionalidad del botón según el estado actual de `darkMode`
    val buttonText = if (darkMode.value) "Light Mode" else "Dark Mode"

    Button(onClick = {
        val newDarkMode = !darkMode.value
        darkMode.value = newDarkMode
        onDarkModeChange(newDarkMode)
    }) {
        Text(text = buttonText, fontSize = 30.sp)
    }
}