package model

import kotlinx.serialization.Serializable

@Serializable
data class Characters(

    var id: Int?,
    var name: String?,
    var images: List<String>,
    var debut: Debut?,
    var jutsu: List<String>,
    var personal: Personal?,
    var uniqueTraits: List<String>
)
