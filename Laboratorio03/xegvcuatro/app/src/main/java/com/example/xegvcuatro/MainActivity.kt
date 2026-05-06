package com.example.xegvcuatro

import android.content.Context
import android.hardware.Sensor
import android.hardware.SensorEvent
import android.hardware.SensorEventListener
import android.hardware.SensorManager
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.material3.Button
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.DisposableEffect
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.runtime.toMutableStateList
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.xegvcuatro.ui.theme.XegvcuatroTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            XegvcuatroTheme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    AppNavigation()
                }
            }
        }
    }
}

@Composable
fun AppNavigation() {
    val navController = rememberNavController()

    NavHost(
        navController = navController,
        startDestination = "home"
    ) {
        composable("home") {
            HomeScreen(navController)
        }
        composable("names") {
            app(navController)
        }
        composable("sensors") {
            SensorsScreen(navController)
        }
    }
}

@Composable
fun useSensor(sensorType: Int): List<Float> {
    val context = LocalContext.current
    val sensorManager = remember { context.getSystemService(Context.SENSOR_SERVICE) as SensorManager }
    val sensor = sensorManager.getDefaultSensor(sensorType) ?: return emptyList()
    var sensorValues by remember { mutableStateOf(listOf(0f, 0f, 0f)) }

    DisposableEffect(sensorType) {
        val listener = object : SensorEventListener {
            override fun onSensorChanged(event: SensorEvent?) {
                event?.values?.let {
                    sensorValues = it.toList()
                }
            }

            override fun onAccuracyChanged(sensor: Sensor?, accuracy: Int) {}
        }

        sensorManager.registerListener(listener, sensor, SensorManager.SENSOR_DELAY_UI)

        onDispose {
            sensorManager.unregisterListener(listener)
        }
    }

    return sensorValues
}
@Composable
fun SensorsScreen(navController: NavHostController) {
    val lightValues = useSensor(Sensor.TYPE_LIGHT)
    val gyroscopeValues = useSensor(Sensor.TYPE_GYROSCOPE)

    Scaffold { innerPadding ->
        Column (
            modifier = Modifier.fillMaxSize().padding(innerPadding),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Text(text = "Sensor de Luz", fontSize = 24.sp, fontWeight = FontWeight.Bold)
            Text(text = "Intensidad:${lightValues[0]} lx", fontSize = 18.sp)
            Text(text = "Giroscopio", fontSize = 24.sp, fontWeight = FontWeight.Bold)
            Text(text = "X:${gyroscopeValues[0]}", fontSize = 18.sp)
            Text(text = "Y:${gyroscopeValues[1]}", fontSize = 18.sp)
            Text(text = "Z:${gyroscopeValues[2]}", fontSize = 18.sp)
            Button(onClick = { navController.navigate("home") }) {
                Text("Volver a home")
            }
        }
    }
}

@Composable
fun app(navHostController: NavHostController) {

    val usuario = remember { mutableStateOf("") }
    val nombres = remember { mutableStateListOf<String>() }
    Column(
        modifier = Modifier
            .fillMaxHeight()
            .padding(20.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
    ) {

        TextField(
            value = usuario.value,
            onValueChange = {
                usuario.value = it
            },
            placeholder = { Text("Ingrese su nombre") },
        )
        
        Button(
            onClick = {
                if (usuario.value.isNotBlank()) {
                    nombres.add(usuario.value)
                    usuario.value = ""
                }
            }
        ) {
            Text(text = "Guardar")
        }

        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(10.dp),
            horizontalArrangement = Arrangement.SpaceBetween
        ) {

            Text(text = "Listado de nombres y posición")

            Button(
                onClick = {
                    nombres.clear()
                }
            ) {
                Text(text = "Limpiar")
            }
        }

        Column(
            modifier = Modifier
                .height(200.dp)
                .padding(10.dp)
                .background(Color.White),
        ) {

            LazyColumn {
                itemsIndexed(nombres) { index, item ->

                    Row(
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(10.dp),
                        horizontalArrangement = Arrangement.SpaceBetween
                    ) {

                        Text(text = item)

                        Text(text = (index + 1).toString())
                    }
                }
            }
        }
    }
}

@Composable
fun HomeScreen(navController: NavHostController) {

    Column(
        modifier = Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {

        Button(onClick = { navController.navigate("names") }) {
            Text("Ver lista de nombres")
        }

        Spacer(modifier = Modifier.height(16.dp))

        Button(onClick = { navController.navigate("sensors") }) {
            Text("Ver sensores")
        }
    }
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    XegvcuatroTheme {
    }
}