package presentation

import androidx.compose.animation.AnimatedVisibility
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
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
        LazyColumn(
            modifier = Modifier.fillMaxSize().padding(horizontal = 16.dp),
            verticalArrangement = Arrangement.spacedBy(8.dp)
        ) {

            items(characterUiStateObserve.naruto.characters) {
                CharacterCard(it)
            }
        }
    }
}