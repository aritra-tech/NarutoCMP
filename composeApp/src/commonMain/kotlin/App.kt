import androidx.compose.material.MaterialTheme
import androidx.compose.runtime.Composable
import dev.icerock.moko.mvvm.compose.getViewModel
import dev.icerock.moko.mvvm.compose.viewModelFactory
import presentation.HomeScreen
import viewmodel.NarutoViewModel

@Composable
fun App() {
    MaterialTheme {
        val narutoViewModel = getViewModel(Unit, viewModelFactory { NarutoViewModel() })

        HomeScreen(narutoViewModel)
    }
}
