package presentation

import androidx.compose.animation.AnimatedVisibility
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import component.CharacterCard
import viewmodel.NarutoViewModel

@Composable
fun HomeScreen(narutoViewModel: NarutoViewModel) {

    val characterUiStateObserve by narutoViewModel.narutoUiState.collectAsState()

    AnimatedVisibility(characterUiStateObserve.naruto.characters.isNotEmpty()) {
        LazyVerticalGrid(
            columns = GridCells.Fixed(2),
            horizontalArrangement = Arrangement.spacedBy(10.dp),
            verticalArrangement = Arrangement.spacedBy(10.dp),
            modifier = Modifier.fillMaxSize().padding(16.dp),
            content = {
                items(characterUiStateObserve.naruto.characters) {
                    CharacterCard(it)
                }
            }
        )
    }
}