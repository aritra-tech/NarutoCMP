package model

import kotlinx.serialization.Serializable

@Serializable
data class Naruto(
    var characters: List<Characters>,
)
