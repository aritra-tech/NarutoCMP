import androidx.compose.runtime.Composable
import cafe.adriel.voyager.navigator.Navigator
import ui.screen.SplashScreen
import ui.theme.NarutoCMPTheme

@Composable
fun App() {
    NarutoCMPTheme {
        Navigator(SplashScreen())
    }
}
