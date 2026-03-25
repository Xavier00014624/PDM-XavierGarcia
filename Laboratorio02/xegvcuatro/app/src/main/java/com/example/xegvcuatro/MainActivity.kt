package com.example.xegvcuatro

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
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
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.toMutableStateList
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.xegvcuatro.ui.theme.XegvcuatroTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            XegvcuatroTheme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    app(
                    )
                }
            }
        }
    }
}
@Composable
fun app() {

    val usuario = remember { mutableStateOf("") }
    val nombres = remember { mutableStateListOf("Cafe", "Azucar") }

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


@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    XegvcuatroTheme {
    }
}