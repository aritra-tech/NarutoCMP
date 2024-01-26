package presentation

import androidx.compose.animation.AnimatedVisibility
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import cafe.adriel.voyager.core.screen.Screen
import cafe.adriel.voyager.navigator.LocalNavigator
import cafe.adriel.voyager.navigator.currentOrThrow
import component.CharacterCard
import dev.icerock.moko.mvvm.compose.getViewModel
import dev.icerock.moko.mvvm.compose.viewModelFactory
import viewmodel.NarutoViewModel

class HomeScreen : Screen {

    @Composable
    override fun Content() {
        val navigator = LocalNavigator.currentOrThrow
        val narutoViewModel = getViewModel(Unit, viewModelFactory { NarutoViewModel() })
        val characterUiStateObserve by narutoViewModel.narutoUiState.collectAsState()

        AnimatedVisibility(characterUiStateObserve.naruto.characters.isNotEmpty()) {
            LazyVerticalGrid(
                columns = GridCells.Fixed(2),
                horizontalArrangement = Arrangement.spacedBy(10.dp),
                verticalArrangement = Arrangement.spacedBy(10.dp),
                modifier = Modifier.fillMaxSize().padding(16.dp),
                content = {
                    items(characterUiStateObserve.naruto.characters) { narutoCharacter ->
                        CharacterCard(
                            character = narutoCharacter
                        ) {
                            navigator.push(CharacterDetailsScreen(narutoCharacter))
                        }
                    }
                }
            )
        }
    }
}