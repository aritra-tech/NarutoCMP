package ui.theme

import androidx.compose.material.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.CompositionLocalProvider
import androidx.compose.runtime.getValue

@Composable
fun NarutoCMPTheme(content: @Composable () -> Unit) {
    CompositionLocalProvider(LocalUiModePreferenceController provides UiModeController) {
        val uiMode by rememberUiMode()
        MaterialTheme(
            colors = if (uiMode == UiMode.DARK) darkColors else lightColors,
            content = content
        )
    }
}