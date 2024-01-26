package viewmodel

import dev.icerock.moko.mvvm.viewmodel.ViewModel
import extension.runIO
import io.ktor.client.HttpClient
import io.ktor.client.call.body
import io.ktor.client.plugins.contentnegotiation.ContentNegotiation
import io.ktor.client.request.get
import io.ktor.serialization.kotlinx.json.json
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import model.Naruto

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

    private fun updateNarutoCharacters() = runIO {
        val narutoCharacters = getNarutoCharacters()
        _narutoUiState.update {
            it.copy(naruto = narutoCharacters)
        }
    }
    private suspend fun getNarutoCharacters(): Naruto {
        return httpClient
            .get("https://mocki.io/v1/7045e412-4c60-4099-b787-910781aa2acc")
            .body<Naruto>()
    }
}