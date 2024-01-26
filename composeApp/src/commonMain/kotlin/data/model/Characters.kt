package data.model

import kotlinx.serialization.Serializable

@Serializable
data class Characters(
    var name: String,
    var ability: String,
    var clan: String,
    var photoUrl: String,
    var ranking: String,
    var description: String,
    var characterId: Int
)
