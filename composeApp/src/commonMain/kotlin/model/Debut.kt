package model

import kotlinx.serialization.Serializable

@Serializable
data class Debut(
    var novel: String?,
    var movie: String?,
    var appearsIn: String?
)