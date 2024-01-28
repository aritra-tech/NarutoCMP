import androidx.compose.runtime.Composable
import cafe.adriel.voyager.navigator.Navigator
import ui.screen.home.HomeScreen
import ui.theme.NarutoCMPTheme

@Composable
fun App() {
    NarutoCMPTheme {
        Navigator(HomeScreen())
    }
}
