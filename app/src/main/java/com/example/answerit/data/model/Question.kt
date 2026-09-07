package com.example.answerit.data.model

data class Question(
    val id: Int,
    val question: String,
    val options: List<String>,
    val correctAnswer: Int,
    val difficulty: Difficulty,
    val category: Category = Category.GENERAL,
    val prizeMoney: Int
)
