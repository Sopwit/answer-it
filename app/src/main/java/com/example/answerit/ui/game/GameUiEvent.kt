package com.example.answerit.ui.game

sealed interface GameUiEvent {
    data class ShowGameResult(val won: Boolean, val prize: Int) : GameUiEvent
    data class ShowPhoneFriendHint(val hint: String) : GameUiEvent
    data class ShowAudienceHelp(val percentages: List<Int>) : GameUiEvent
    data class ShowQuitDialog(val safeHavenAmount: String) : GameUiEvent
}
