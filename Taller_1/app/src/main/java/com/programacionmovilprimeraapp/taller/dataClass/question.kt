package com.programacionmovilprimeraapp.taller.dataClass

data class Question(
    val id: Int,
    val question: String,
    val options: List<String>,
    val correctAnswer: String,
    val funFact: String
)