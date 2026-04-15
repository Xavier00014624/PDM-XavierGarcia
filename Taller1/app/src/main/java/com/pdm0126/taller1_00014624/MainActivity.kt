package com.pdm0126.taller1_00014624
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            AndroidPediaApp()
        }
    }
}

// --------- APP PRINCIPAL ------
@Composable
fun AndroidPediaApp() {
    var started by remember { mutableStateOf(false) }
    var currentIndex by remember { mutableStateOf(0) }
    var score by remember { mutableStateOf(0) }
    var selectedOption by remember { mutableStateOf<String?>(null) }
    var answered by remember { mutableStateOf(false) }

    if (!started) {
        WelcomeScreen {
            started = true
        }
    } else if (currentIndex < quizQuestions.size) {
        QuestionScreen(
            question = quizQuestions[currentIndex],
            index = currentIndex,
            score = score,
            selectedOption = selectedOption,
            answered = answered,
            onOptionSelected = { option ->
                if (!answered) {
                    selectedOption = option
                    answered = true
                    if (option == quizQuestions[currentIndex].correctAnswer) {
                        score++
                    }
                }
            },
            onNext = {
                currentIndex++
                selectedOption = null
                answered = false
            }
        )
    } else {
        ResultScreen(
            score = score,
            onRestart = {
                currentIndex = 0
                score = 0
                selectedOption = null
                answered = false
                started = true
            },
            onGoHome = {
                currentIndex = 0
                score = 0
                selectedOption = null
                answered = false
                started = false
            }
        )
    }
}

// ------------- PANTALLA BIENVENIDA -------
@Composable
fun WelcomeScreen(onStart: () -> Unit) {
    Column(
        modifier = Modifier.fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        Text("AndroidPedia", style = MaterialTheme.typography.headlineLarge)
        Text("¿Cuánto sabes de Android?")
        Spacer(modifier = Modifier.height(16.dp))
        Text("Xavier Ernesto Garcia Villacorta - 00014624")
        Spacer(modifier = Modifier.height(24.dp))
        Button(onClick = onStart) {
            Text("Comenzar Quiz")
        }
    }
}

// ---------------- PANTALLA DE PREGUNTA ----------------
@Composable
fun QuestionScreen(
    question: Question,
    index: Int,
    score: Int,
    selectedOption: String?,
    answered: Boolean,
    onOptionSelected: (String) -> Unit,
    onNext: () -> Unit
) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {

        Text("Pregunta ${index + 1} de 3")
        Text("Puntaje: $score / 3")

        Spacer(modifier = Modifier.height(16.dp))

        Card {
            Text(
                text = question.question,
                modifier = Modifier.padding(16.dp)
            )
        }

        Spacer(modifier = Modifier.height(16.dp))

        Column {
            question.options.forEach { option ->

                val containerColor = if (!answered) {
                    Color(0xFF6200EE)
                } else {
                    when (option) {
                        selectedOption -> {
                            if (selectedOption == question.correctAnswer) {
                                Color(0xFF4CAF50)
                            } else {
                                Color(0xFFF44336)
                            }
                        }
                        question.correctAnswer -> Color(0xFF4CAF50)
                        else -> Color.White
                    }
                }

                Button(
                    onClick = { onOptionSelected(option) },
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(vertical = 4.dp),
                    colors = ButtonDefaults.buttonColors(
                        containerColor = containerColor,
                        disabledContainerColor = containerColor,
                        disabledContentColor = if (containerColor == Color.White) Color.Black else Color.White
                    ),
                    enabled = !answered
                ) {
                    Text(
                        text = option,
                        color = if (containerColor == Color.White) Color.Black else Color.White
                    )
                }
            }
        }

        if (answered) {
            Spacer(modifier = Modifier.height(12.dp))
            Text("Fun Fact: ${question.funFact}")

            Spacer(modifier = Modifier.height(12.dp))
            Button(onClick = onNext) {
                Text(if (index == 2) "Ver Resultado" else "Siguiente")
            }
        }
    }
}

// ------ RESULTADO FINAL -----------
@Composable
fun ResultScreen(
    score: Int,
    onRestart: () -> Unit,
    onGoHome: () -> Unit
) {
    val message = when (score) {
        3 -> "Excelente, dominas Android"
        2 -> "Buen trabajo, casi perfecto"
        1 -> "Necesitas repasar un poco"
        else -> "Debes estudiar más"
    }

    Column(
        modifier = Modifier.fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        Text("Obtuviste $score de 3")
        Text(message)

        Spacer(modifier = Modifier.height(16.dp))

        Button(onClick = onRestart) {
            Text("Reiniciar Quiz")
        }

        Spacer(modifier = Modifier.height(8.dp))

        Button(onClick = onGoHome) {
            Text("Ir al Inicio")
        }
    }
}