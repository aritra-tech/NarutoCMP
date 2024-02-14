package utils

import androidx.compose.ui.graphics.Color
import theme.Blue300
import theme.Blue500
import theme.Green300
import theme.Green500
import theme.Red300
import theme.Red500
import theme.Yellow300
import theme.Yellow500

data class CategoryCardState(
    val title: String,
    val icon: String,
    val startColor: Color,
    val endColor: Color
) {
    companion object {
        val narutodex = CategoryCardState(
            title = "Narutodex",
            icon = "",
            startColor = Yellow300,
            endColor = Yellow500
        )
        val clan = CategoryCardState(
            title = "Clans",
            icon = "",
            startColor = Red300,
            endColor = Red500
        )
        val village = CategoryCardState(
            title = "Villages",
            icon = "",
            startColor = Green300,
            endColor = Green500
        )
        val teams = CategoryCardState(
            title = "Teams",
            icon = "",
            startColor = Blue300,
            endColor = Blue500
        )
    }
}