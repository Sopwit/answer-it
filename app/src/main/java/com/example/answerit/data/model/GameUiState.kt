package com.example.answerit.data.model

data class GameUiState(
    val currentQuestion: Question? = null,
    val questionIndex: Int = 0,
    val totalQuestions: Int = 15,
    val currentPrize: Int = 0,
    val score: Int = 0,
    val safeHaven: Int = 0,
    val lifelines: Lifelines = Lifelines(),
    val gameStatus: GameStatus = GameStatus.PLAYING,
    val selectedOptionIndex: Int = -1,
    val hiddenOptionIndices: Set<Int> = emptySet()
)
