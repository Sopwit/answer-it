package com.example.answerit.data

data class PlayerProfile(
    val name: String = "Yarışmacı",
    val bestScore: Int = 0,
    val gamesPlayed: Int = 0,
    val totalWinnings: Int = 0,
    val lastPlayedDate: Long = 0
) 