package com.example.azieg.redux

interface Store <S: State> {
    fun dispatch(action: Action)
    fun add(subscriber: StoreSubscriber<S>): Boolean
    fun remove(subscriber: StoreSubscriber<S>): Boolean
}