package com.programacionmovilprimeraapp.taller.questions

import com.programacionmovilprimeraapp.taller.dataClass.Question

val quizQuestions = listOf(
    Question(
        id = 1,
        question = "¿En qué año fue presentado oficialmente Android Studio?",
        options = listOf(
            "2011",
            "2012",
            "2013",
            "2014"
        ),
        correctAnswer = "2013",
        funFact = "Android Studio fue presentado oficialmente por Google en 2013 durante Google I/O."
    ),
    Question(
        id = 2,
        question = "¿Qué herramienta se utilizaba antes de Android Studio para desarrollar aplicaciones Android?",
        options = listOf(
            "Visual Studio",
            "NetBeans",
            "Eclipse con ADT",
            "IntelliJ IDEA"
        ),
        correctAnswer = "Eclipse con ADT",
        funFact = "Antes de Android Studio, la mayoría de desarrolladores Android utilizaban Eclipse junto al plugin ADT."
    ),
    Question(
        id = 3,
        question = "¿Qué lenguaje de programación es actualmente recomendado para Android Studio?",
        options = listOf(
            "Java",
            "C++",
            "Kotlin",
            "Python"
        ),
        correctAnswer = "Kotlin",
        funFact = "Kotlin fue declarado por Google como el lenguaje recomendado para Android en 2019."
    )
)