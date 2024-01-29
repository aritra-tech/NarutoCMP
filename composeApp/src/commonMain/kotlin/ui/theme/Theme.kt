package ui.theme

import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.CompositionLocalProvider
import androidx.compose.runtime.getValue

@Composable
fun NarutoCMPTheme(content: @Composable () -> Unit) {
    CompositionLocalProvider(LocalUiModePreferenceController provides UiModeController) {
        val uiMode by rememberUiMode()
        MaterialTheme(
            colorScheme = if (uiMode == UiMode.DARK) darkColors else lightColors,
            content = content
        )
    }
}