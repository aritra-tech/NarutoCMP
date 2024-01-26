import androidx.compose.material.MaterialTheme
import androidx.compose.runtime.Composable
import cafe.adriel.voyager.navigator.Navigator
import dev.icerock.moko.mvvm.compose.getViewModel
import dev.icerock.moko.mvvm.compose.viewModelFactory
import presentation.HomeScreen
import viewmodel.NarutoViewModel

@Composable
fun App() {
    MaterialTheme {
        Navigator(HomeScreen())
    }
}
