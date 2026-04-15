package com.programacionmovilprimeraapp.taller

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Text
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.programacionmovilprimeraapp.taller.dataClass.Question
import com.programacionmovilprimeraapp.taller.questions.quizQuestions

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            App()
        }
    }
}

@Composable
fun App(){
    var currentScreen by rememberSaveable { mutableStateOf(1) }
    var currentScore by rememberSaveable { mutableStateOf(0) }
    var currentQueryId by rememberSaveable { mutableStateOf(0) }

    val questionList = quizQuestions
    val currentQuestion = questionList[currentQueryId]

    val nextQuestion: () -> Unit = {
        if(currentQueryId < questionList.size - 1){
            currentQueryId++
        } else {
            currentScreen = 3
        }
    }

    val newScore: () -> Unit = {
        currentScore++
    }

    val restartQuiz = {
        currentQueryId = 0
        currentScore = 0
        currentScreen = 1
    }

    val total = questionList.size

    when(currentScreen){
        1 -> pantallaBienvenida(
            onStart = { currentScreen = 2 }
        )

        2 -> pantallaPregunta(
            currentQuestion,
            nextQuestion,
            newScore,
            currentQueryId,
            total,
            currentScore
        )

        3 -> pantallaResultado(
            currentScore,
            total,
            restartQuiz
        )
    }
}

@Composable
fun pantallaBienvenida(onStart: () -> Unit){
    Column(
        modifier = Modifier.fillMaxSize().padding(24.dp),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ){
        Text("AndroidPedia", color = Color.Blue, fontSize = 30.sp)

        Spacer(modifier = Modifier
            .height(16.dp))

        Text("¿Cuánto sabes de Android?", fontSize = 20.sp)

        Spacer(modifier = Modifier
            .height(8.dp))

        Text("Samuel Alejandro Perez Hernandez - 00052424", fontSize = 16.sp)

        Spacer(modifier = Modifier
            .height(32.dp))

        Button(
            onClick = { onStart() },
            modifier = Modifier
                .fillMaxWidth(0.7f),
            colors = ButtonDefaults.buttonColors(containerColor = Color(0xFF00BFFF))
        ){
            Text("Comenzar Quiz", color = Color.White, fontSize = 18.sp)
        }
    }
}

@Composable
fun pantallaPregunta(
    question: Question,
    nextQuestion: () -> Unit,
    newQuizScore: () -> Unit,
    currentQueryId: Int,
    total: Int,
    score: Int
){
    var awnserOption by rememberSaveable { mutableStateOf<String?>(null) }
    var answered by rememberSaveable { mutableStateOf(false) }

    Column(
        modifier = Modifier.fillMaxSize()
            .padding(24.dp),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ){

        Text("Pregunta ${currentQueryId + 1} de $total")
        Text("Puntaje: $score / $total")

        Spacer(modifier = Modifier
            .height(16.dp))

        Card(
            modifier = Modifier.fillMaxWidth(),
            elevation = CardDefaults.cardElevation(6.dp)
        ){
            Text(
                text = question.question,
                modifier = Modifier
                    .padding(16.dp),
                fontSize = 22.sp
            )
        }

        Spacer(modifier = Modifier
            .height(20.dp))

        question.options.forEach{ opcions ->
            Button(
                onClick = {
                    if (!answered) {
                        awnserOption = opcions
                        answered = true

                        if (opcions == question.correctAnswer) {
                            newQuizScore()
                        }
                    }
                },
                enabled = !answered,
                modifier = Modifier
                    .fillMaxWidth(0.8f)
                    .padding(vertical = 6.dp),
                colors = ButtonDefaults.buttonColors(
                    containerColor =  Color.Gray,
                    disabledContainerColor = when {
                        opcions == question.correctAnswer -> Color.Green
                        opcions == awnserOption -> Color.Red
                        else -> Color.Gray
                    }
                )
            ){
                Text(opcions, color = Color.White, fontSize = 18.sp)
            }
        }

        if(answered){
            Spacer(modifier = Modifier
                .height(16.dp))
            Text(
                text = question.funFact,
                fontSize = 14.sp,
                color = Color.DarkGray
            )
        }

        Spacer(modifier = Modifier
            .height(24.dp))

        if(answered){
            Button(
                onClick = {
                    nextQuestion()
                    awnserOption = null
                    answered = false
                },
                modifier = Modifier.fillMaxWidth(0.8f),
                colors = ButtonDefaults.buttonColors(
                    containerColor = Color(0xFF00BFFF)
                )
            ){
                Text(
                    text = if(currentQueryId == total - 1) "Ver Resultado" else "Siguiente Pregunta",
                    color = Color.White,
                    fontSize = 18.sp
                )
            }
        }
    }
}

@Composable
fun pantallaResultado(score: Int, total: Int, restart: () -> Unit){


    val mensaje = when(score){
        total -> "¡Excelente!"
        total - 1 -> "¡Muy bien!"
        1 -> "!Casi!"
        else -> "Quizas a la otra"
    }

    Column(
        modifier = Modifier
            .fillMaxSize().padding(24.dp),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ){
        Text("Resultado Final", color = Color.Blue, fontSize = 28.sp)

        Spacer(modifier = Modifier
            .height(16.dp))

        Text("Tu puntaje es:", fontSize = 20.sp)

        Text(
            text = "$score / $total",
            fontSize = 26.sp,
            color = if(score == total) Color.Green else Color.Black
        )

        Spacer(modifier = Modifier
            .height(16.dp))

        Text(mensaje, fontSize = 18.sp)

        Spacer(modifier = Modifier
            .height(32.dp))

        Button(
            onClick = { restart() },
            modifier = Modifier
                .fillMaxWidth(0.7f),
            colors = ButtonDefaults.buttonColors(
                containerColor = Color(0xFF00BFFF)
            )
        ){
            Text("Reiniciar Quiz", color = Color.White, fontSize = 18.sp)
        }
    }
}