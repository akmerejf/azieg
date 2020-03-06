
package com.example.azieg.redux

class DefaultStore <S: State>(
    initialState: S,
    private val reducer: Reducer<S>
) : Store<S> {

  private val subscribers = mutableSetOf<StoreSubscriber<S>>()

  private var state: S = initialState
    set(value) {
      field = value
      subscribers.forEach { it(value) }
    }

  override fun dispatch(action: Action) {
    state = reducer(state, action)
  }

  override fun add(subscriber: StoreSubscriber<S>) = subscribers.add(element = subscriber)
    
  override fun remove(subscriber: StoreSubscriber<S>) = subscribers.remove(element = subscriber)
}