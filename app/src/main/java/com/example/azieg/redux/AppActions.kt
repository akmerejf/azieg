package com.example.azieg.redux

sealed class AppActions: Action {
    object List: AppActions()
    object Details: AppActions()
}