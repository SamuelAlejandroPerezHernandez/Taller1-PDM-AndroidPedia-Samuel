package com.programacionmovilprimeraapp.com.pdm0126.taller1_00052424.dataClass

data class Question(
    val id: Int,
    val question: String,
    val options: List<String>,
    val correctAnswer: String,
    val funFact: String
)