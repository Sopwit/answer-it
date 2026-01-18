package com.example.answerit.data

data class GameState(
    val currentQuestionIndex: Int = 0,
    val score: Int = 0,
    val lifelines: Lifelines = Lifelines(),
    val gameStatus: GameStatus = GameStatus.PLAYING,
    val currentPrize: Int = 0
)

data class Lifelines(
    val fiftyFifty: Boolean = true,
    val phoneFriend: Boolean = true,
    val audienceHelp: Boolean = true
)

enum class GameStatus {
    PLAYING, WON, LOST, QUIT
} 