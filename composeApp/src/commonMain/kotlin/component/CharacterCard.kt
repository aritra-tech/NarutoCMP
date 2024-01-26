package component

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Card
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import io.kamel.image.KamelImage
import io.kamel.image.asyncPainterResource
import data.model.Characters

@Composable
fun CharacterCard(
    character: Characters,
    navigateToCharacterDetailsScreen: (Characters) -> Unit
) {
    Card(
        modifier = Modifier.fillMaxWidth()
            .clickable {
                navigateToCharacterDetailsScreen(character)
            },
        shape = RoundedCornerShape(10.dp)
    ) {
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .padding(8.dp),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center
        ) {
            KamelImage(
                resource = asyncPainterResource(character.photoUrl),
                contentDescription = character.name,
                contentScale = ContentScale.Crop,
                modifier = Modifier.size(110.dp).clip(CircleShape),
            )
            Spacer(Modifier.height(10.dp))

            Text(
                text = character.name,
                fontSize = 16.sp,
            )
        }
    }

}