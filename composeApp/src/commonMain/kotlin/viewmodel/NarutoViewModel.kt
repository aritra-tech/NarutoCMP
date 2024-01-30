package viewmodel

import dev.icerock.moko.mvvm.viewmodel.ViewModel
import io.ktor.client.HttpClient
import io.ktor.client.call.body
import io.ktor.client.plugins.contentnegotiation.ContentNegotiation
import io.ktor.client.request.get
import io.ktor.serialization.kotlinx.json.json
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import data.model.Naruto

class NarutoViewModel : ViewModel() {

    private val _narutoUiState = MutableStateFlow(NarutoUiState())
    val narutoUiState = _narutoUiState.asStateFlow()

    init {
        updateNarutoCharacters()
    }

    private var httpClient = HttpClient {
        install(ContentNegotiation) {
            json()
        }
    }

    private fun updateNarutoCharacters() = viewModelScope.launch {
        val narutoCharacters = getNarutoCharacters()
        _narutoUiState.update {
            it.copy(naruto = narutoCharacters)
        }
    }
    private suspend fun getNarutoCharacters(): Naruto {
        return httpClient
            .get("https://mocki.io/v1/2af66ca9-dcab-4e26-b24f-bfc0c551b81d")
            .body<Naruto>()
    }
}

data class NarutoUiState(
    val naruto : Naruto = Naruto(emptyList())
)