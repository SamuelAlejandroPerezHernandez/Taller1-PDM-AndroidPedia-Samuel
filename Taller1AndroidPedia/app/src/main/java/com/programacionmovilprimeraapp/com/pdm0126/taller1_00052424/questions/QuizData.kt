package com.programacionmovilprimeraapp.com.pdm0126.taller1_00052424.questions

import com.programacionmovilprimeraapp.com.pdm0126.taller1_00052424.dataClass.Question

val quizQuestions = listOf(
    Question(
        id = 1,
        question = "¿Cuál fue el primer dispositivo Android en venderse comercialmente?",
        options = listOf(
            "HTC Dream (T-Mobile G1)",
            "Motorola Droid",
            "Samsung Galaxy S",
            "HTC Hero"
        ),
        correctAnswer = "HTC Dream (T-Mobile G1)",
        funFact = "El HTC Dream fue lanzado en octubre de 2008, tenía teclado físico deslizable y apenas 192 MB de RAM."
    ),
    Question(
        id = 2,
        question = "¿A partir de qué versión Google dejó de anunciar públicamente los nombres de postre de Android?",
        options = listOf("Android 9 Pie", "Android 10", "Android 11", "Android 8 Oreo"),
        correctAnswer = "Android 10",
        funFact = "Internamente Android 10 se llamó 'Queen Cake'. Google cambió para facilitar la pronunciación global del nombre."
    ),
    Question(
        id = 3,
        question = "¿Qué versión de Android introdujo el modo oscuro nativo a nivel de sistema?",
        options = listOf("Android 8 Oreo", "Android 9 Pie", "Android 10", "Android 11"),
        correctAnswer = "Android 10",
        funFact = "Antes de Android 10, fabricantes como Samsung ya ofrecían modo oscuro propio, pero no era parte del sistema base."
    )
)