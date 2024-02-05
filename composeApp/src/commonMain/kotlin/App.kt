import androidx.compose.runtime.Composable
import cafe.adriel.voyager.navigator.Navigator
import presentation.SplashScreen
import theme.NarutoCMPTheme

@Composable
fun App() {
    NarutoCMPTheme {
        Navigator(SplashScreen())
    }
}
