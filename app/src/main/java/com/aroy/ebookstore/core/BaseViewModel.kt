package com.aroy.ebookstore.core

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.channels.Channel
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.consumeAsFlow
import kotlinx.coroutines.flow.receiveAsFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch

/**
 * A generic base class for implementing the MVI (Model–View–Intent) pattern in ViewModels.
 *
 * This class provides three generic type parameters:
 * - [VS] : ViewState — represents the immutable state of the UI. Defaults to [Any].
 * - [E]  : Event — represents one-time events such as navigation, toast, or snackbar. Defaults to [Any].
 * - [I]  : Intent — represents user actions or process intents that drive business logic. Defaults to [Any].
 *
 * ### Features:
 * - Maintains a [StateFlow] of the current [VS] (ViewState).
 * - Provides a [Channel] for one-time [E] (Events).
 * - Provides a [Channel] for processing [I] (Intents).
 * - Offers helper methods to update state, send events, and process intents.
 *
 * ### Usage:
 * Subclass this ViewModel and:
 * - Define your own [VS], [E], and [I] types.
 * - Implement [handleIntent] to process incoming intents.
 * - Use [setState] to update the UI state.
 * - Use [sendEvent] to emit one-time events.
 * - Call [processIntent] from the UI layer to dispatch user actions.
 *
 * @param initialState The initial [VS] (ViewState) to start with.
 */
abstract class BaseViewModel<VS : Any, E : Any, I : Any>(
    initialState: VS
) : ViewModel() {

    /** Backing state flow holding the current [VS]. */
    private val _viewState = MutableStateFlow(initialState)

    /** Public immutable state flow for observing UI state. */
    val viewState: StateFlow<VS> = _viewState.asStateFlow()

    /** Channel for one-time [E] (Events). */
    private val _eventChannel = Channel<E>(Channel.BUFFERED)

    /** Flow for observing one-time events. */
    val events: Flow<E> = _eventChannel.receiveAsFlow()

    /** Channel for processing [I] (Intents). */
    private val _intentChannel = Channel<I>(Channel.UNLIMITED)

    init {
        // Collect intents and process them
        viewModelScope.launch {
            _intentChannel.consumeAsFlow().collect { intent ->
                handleIntent(intent)
            }
        }
    }

    /**
     * Update the current [VS] (ViewState) by applying a reducer function.
     *
     * @param reducer A function that takes the current state and returns a new state.
     */
    protected fun setState(reducer: VS.() -> VS) {
        _viewState.update { it.reducer() }
    }

    /**
     * Send a one-time [E] (Event) to the UI.
     *
     * @param event The event to send.
     */
    protected fun sendEvent(event: E) {
        viewModelScope.launch {
            _eventChannel.send(event)
        }
    }

    /**
     * Dispatch a user [I] (Intent) to be processed by [handleIntent].
     *
     * @param intent The intent to process.
     */
    fun processIntent(intent: I) {
        viewModelScope.launch {
            _intentChannel.send(intent)
        }
    }

    /**
     * Handle incoming [I] (Intents).
     *
     * Subclasses must implement this to define how each intent should be processed.
     *
     * @param intent The intent to handle.
     */
    protected abstract suspend fun handleIntent(intent: I)
}