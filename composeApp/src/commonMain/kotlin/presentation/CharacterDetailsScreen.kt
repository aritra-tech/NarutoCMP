package presentation

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.imePadding
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Icon
import androidx.compose.material.IconButton
import androidx.compose.material.Scaffold
import androidx.compose.material.Text
import androidx.compose.material.TopAppBar
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.ArrowBack
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import cafe.adriel.voyager.core.screen.Screen
import cafe.adriel.voyager.navigator.LocalNavigator
import cafe.adriel.voyager.navigator.currentOrThrow
import io.kamel.image.KamelImage
import io.kamel.image.asyncPainterResource
import model.Characters

data class CharacterDetailsScreen(
    private val narutoCharacter: Characters
) : Screen {
    @Composable
    override fun Content() {

        val navigator = LocalNavigator.currentOrThrow

        Scaffold(
            topBar = {
                TopAppBar(
                    content = {
                        Row(
                            verticalAlignment = Alignment.CenterVertically,
                            horizontalArrangement = Arrangement.Start
                        ) {
                            IconButton(
                                onClick = { navigator.pop() }
                            ) {
                                Icon(
                                    imageVector = Icons.Rounded.ArrowBack,
                                    contentDescription = "Back"
                                )
                            }
                            Text(
                                text = narutoCharacter.name,
                                fontSize = 18.sp
                            )
                        }
                    }
                )
            }
        ) {
            Column(
                Modifier.fillMaxSize()
                    .imePadding()
                    .padding(it)
                    .padding(horizontal = 16.dp, vertical = 20.dp)
            ) {
                KamelImage(
                    resource = asyncPainterResource(narutoCharacter.photoUrl),
                    contentDescription = narutoCharacter.name,
                    contentScale = ContentScale.Crop,
                    modifier = Modifier.size(110.dp).clip(RoundedCornerShape(10.dp)),
                )

                Spacer(Modifier.height(10.dp))

                Text(
                    text = narutoCharacter.name,
                    fontSize = 16.sp
                )

                Spacer(Modifier.height(10.dp))

                Text(
                    text = narutoCharacter.description,
                    textAlign = TextAlign.Center,
                    fontSize = 14.sp
                )
            }
        }
    }
}