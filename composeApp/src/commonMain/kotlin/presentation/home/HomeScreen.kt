package presentation.home

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Lightbulb
import androidx.compose.material.icons.outlined.Lightbulb
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import cafe.adriel.voyager.core.screen.Screen
import cafe.adriel.voyager.navigator.LocalNavigator
import cafe.adriel.voyager.navigator.currentOrThrow
import presentation.characters.NarutoScreen
import presentation.clans.ClansScreen
import presentation.component.CategoryCard
import presentation.teams.TeamsScreen
import presentation.villages.VillagesScreen
import theme.LocalUiModePreferenceController
import theme.UiMode
import theme.rememberUiMode
import utils.CategoryCardState

class HomeScreen : Screen {

    @OptIn(ExperimentalMaterial3Api::class)
    @Composable
    override fun Content() {
        val navigator = LocalNavigator.currentOrThrow
        val controller = LocalUiModePreferenceController.current
        val uiMode by rememberUiMode()

        Scaffold(
            topBar = {
                TopAppBar(
                    title = {
                        Text(
                            text = "Kon'nichiwa 👋",
                            style = MaterialTheme.typography.displaySmall.copy(
                                fontWeight = FontWeight.Normal,
                                fontSize = 20.sp
                            )
                        )
                    },
                    colors = TopAppBarDefaults.topAppBarColors(containerColor = Color.Transparent),
                    actions = {
                        IconButton(onClick = controller::toggle) {
                            Icon(
                                imageVector = when (uiMode) {
                                    UiMode.DARK -> Icons.Outlined.Lightbulb
                                    UiMode.LIGHT -> Icons.Default.Lightbulb
                                },
                                contentDescription = null,
                            )
                        }
                    }
                )
            }
        ) {

            Column(
                Modifier
                    .padding(vertical = 50.dp)
                    .verticalScroll(rememberScrollState())
            ) {

                Text(
                    modifier = Modifier.padding(horizontal = 20.dp, vertical = 20.dp),
                    text = "What Naruto are you looking for ?",
                    color = MaterialTheme.colorScheme.onBackground,
                    style = MaterialTheme.typography.displaySmall.copy(
                        fontWeight = FontWeight.Bold,
                        fontSize = 30.sp
                    )
                )

                Spacer(Modifier.height(30.dp))

                Row(
                    modifier = Modifier.padding(20.dp, vertical = 10.dp),
                    horizontalArrangement = Arrangement.spacedBy(20.dp)
                ) {
                    CategoryCard(
                        onClick = {
                            navigator.push(NarutoScreen())
                        },
                        categoryCardState = CategoryCardState.narutodex,
                        modifier = Modifier.weight(1f)
                    )

                    CategoryCard(
                        onClick = {
                            navigator.push(ClansScreen())
                        },
                        categoryCardState = CategoryCardState.clan,
                        modifier = Modifier.weight(1f)
                    )
                }

                Row(
                    modifier = Modifier.padding(20.dp, vertical = 10.dp),
                    horizontalArrangement = Arrangement.spacedBy(20.dp)
                ) {
                    CategoryCard(
                        onClick = {
                            navigator.push(VillagesScreen())
                        },
                        categoryCardState = CategoryCardState.village,
                        modifier = Modifier.weight(1f)
                    )

                    CategoryCard(
                        onClick = {
                            navigator.push(TeamsScreen())
                        },
                        categoryCardState = CategoryCardState.teams,
                        modifier = Modifier.weight(1f)
                    )
                }
            }
        }
    }
}