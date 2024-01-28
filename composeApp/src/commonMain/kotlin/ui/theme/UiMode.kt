package ui.theme

import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.State
import androidx.compose.runtime.compositionLocalOf
import androidx.compose.runtime.produceState
import kotlinx.coroutines.channels.BufferOverflow
import kotlinx.coroutines.flow.MutableSharedFlow
import kotlinx.coroutines.flow.asSharedFlow

val LocalUiModePreferenceController =
    compositionLocalOf<UiModePreferenceController> { error("Not provided") }

enum class UiMode {
    LIGHT, DARK
}

@Composable
fun rememberUiMode(): State<UiMode> {
    val systemInDarkMode = isSystemInDarkTheme()

    val uiModeController = LocalUiModePreferenceController.current

    return produceState(uiMode(systemInDarkMode)) {
        uiModeController.toggleRequests.collect {
            value = value.oppositeMode
        }
    }
}

fun uiMode(isInDarkMode: Boolean): UiMode = when(isInDarkMode) {
    true -> UiMode.DARK
    false -> UiMode.LIGHT
}

val UiMode.oppositeMode get() = when (this) {
    UiMode.LIGHT -> UiMode.DARK
    UiMode.DARK -> UiMode.LIGHT
}

class UiModePreferenceController {
    private val _toggleRequests = MutableSharedFlow<Unit>(
        extraBufferCapacity = 1,
        onBufferOverflow = BufferOverflow.DROP_OLDEST
    )
    val toggleRequests = _toggleRequests.asSharedFlow()
    fun toggle() = _toggleRequests.tryEmit(Unit)
}

val UiModeController = UiModePreferenceController()