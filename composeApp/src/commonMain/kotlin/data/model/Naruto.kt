package data.model

import kotlinx.serialization.Serializable

@Serializable
data class Naruto(
    val characters: List<Characters>,
)
