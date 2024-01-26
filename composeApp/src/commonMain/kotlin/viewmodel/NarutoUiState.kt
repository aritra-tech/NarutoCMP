package viewmodel

import model.Naruto

data class NarutoUiState(
    val naruto : Naruto = Naruto(emptyList())
)