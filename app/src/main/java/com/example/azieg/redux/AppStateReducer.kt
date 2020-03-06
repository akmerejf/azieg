package com.example.azieg.redux

val AppStateReducer: Reducer<AppState> = { old, action ->
    when (action) {
        is AppActions.List -> AppState()
        is AppActions.Details -> old.copy("details")
        else -> old
    }
}
