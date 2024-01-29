package ui.screen.home

import androidx.compose.animation.AnimatedVisibility
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Lightbulb
import androidx.compose.material.icons.outlined.Lightbulb
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import cafe.adriel.voyager.core.screen.Screen
import cafe.adriel.voyager.navigator.LocalNavigator
import cafe.adriel.voyager.navigator.currentOrThrow
import component.CharacterCard
import dev.icerock.moko.mvvm.compose.getViewModel
import dev.icerock.moko.mvvm.compose.viewModelFactory
import ui.screen.details.CharacterDetailsScreen
import ui.theme.LocalUiModePreferenceController
import ui.theme.UiMode
import ui.theme.rememberUiMode
import viewmodel.NarutoViewModel

class HomeScreen : Screen {

    @OptIn(ExperimentalMaterial3Api::class)
    @Composable
    override fun Content() {
        val navigator = LocalNavigator.currentOrThrow
        val narutoViewModel = getViewModel(Unit, viewModelFactory { NarutoViewModel() })
        val characterUiStateObserve by narutoViewModel.narutoUiState.collectAsState()
        val controller = LocalUiModePreferenceController.current
        val uiMode by rememberUiMode()

        Scaffold(
            topBar = {
                TopAppBar(
                    title = { Text("NarutoCMP") },
                    colors = TopAppBarDefaults.topAppBarColors(containerColor = Color.Transparent),
                    actions = {
                        IconButton(onClick = controller::toggle) {
                            Icon(
                                imageVector = when (uiMode) {
                                    UiMode.DARK -> Icons.Outlined.Lightbulb
                                    UiMode.LIGHT -> Icons.Default.Lightbulb
                                },
                                contentDescription = null,
                            )
                        }
                    }
                )
            }
        ) {
            AnimatedVisibility(characterUiStateObserve.naruto.characters.isNotEmpty()) {
                LazyVerticalGrid(
                    columns = GridCells.Fixed(2),
                    horizontalArrangement = Arrangement.spacedBy(10.dp),
                    verticalArrangement = Arrangement.spacedBy(10.dp),
                    modifier = Modifier
                        .fillMaxSize()
                        .padding(it)
                        .padding(horizontal = 16.dp, vertical = 20.dp),
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
}