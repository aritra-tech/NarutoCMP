import androidx.compose.runtime.Composable
import cafe.adriel.voyager.navigator.Navigator
import dev.icerock.moko.mvvm.compose.getViewModel
import dev.icerock.moko.mvvm.compose.viewModelFactory
import ui.screen.home.HomeScreen
import ui.theme.NarutoCMPTheme
import viewmodel.NarutoViewModel

@Composable
fun App() {
    NarutoCMPTheme {
        val narutoViewModel = getViewModel(Unit, viewModelFactory { NarutoViewModel() })

        Navigator(HomeScreen(narutoViewModel))
    }
}
