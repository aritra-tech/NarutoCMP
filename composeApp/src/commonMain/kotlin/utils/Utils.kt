package utils

import data.model.Characters

object Utils {

    fun Characters.getCharacteristics(): List<Pair<String,String>> {
        val characteristicItems = mutableListOf<Pair<String,String>>()

        characteristicItems.add(Pair("Clan", clan))
        characteristicItems.add(Pair("Ranking", ranking))
        characteristicItems.add(Pair("Ability", ability))

        return characteristicItems
    }
}