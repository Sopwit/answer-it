package com.example.answerit.data

data class Question(
    val id: Int,
    val question: String,
    val options: List<String>,
    val correctAnswer: Int,
    val difficulty: Difficulty,
    val prizeMoney: Int
)

enum class Difficulty {
    EASY, MEDIUM, HARD, EXPERT
} 