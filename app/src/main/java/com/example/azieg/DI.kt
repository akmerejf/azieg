package com.example.azieg

import com.example.azieg.redux.AppState
import com.example.azieg.redux.AppStateReducer
import com.example.azieg.redux.DefaultStore

object DI {
  val store = DefaultStore(initialState = AppState(), reducer = AppStateReducer)
}