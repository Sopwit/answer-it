package com.example.answerit.data.model

data class PlayerProfile(
    val name: String = "Yarışmacı",
    val bestScore: Int = 0,
    val gamesPlayed: Int = 0,
    val totalWinnings: Long = 0L,
    val lastPlayedDate: Long = 0L
)
