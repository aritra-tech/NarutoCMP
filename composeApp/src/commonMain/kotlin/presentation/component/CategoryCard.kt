package presentation.component

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.scale
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import io.kamel.image.KamelImage
import io.kamel.image.asyncPainterResource
import utils.CategoryCardState

@Composable
fun CategoryCard(
    onClick: () -> Unit,
    categoryCardState: CategoryCardState,
    modifier: Modifier = Modifier
) {
    Row(
        modifier = modifier
            .clip(MaterialTheme.shapes.medium)
            .clickable {
                onClick()
            }
            .background(
                Brush.linearGradient(
                    listOf(categoryCardState.startColor, categoryCardState.endColor)
                )
            )
            .padding(16.dp),
        verticalAlignment = Alignment.CenterVertically

    ) {
        Text(
            text = categoryCardState.title,
            color = Color.White,
            style = MaterialTheme.typography.titleMedium.copy(
                fontWeight = FontWeight.Bold
            )
        )

        Spacer(Modifier.weight(1f))

        Box(
            contentAlignment = Alignment.Center
        ) {
            Box(
                modifier = Modifier
                    .scale(1f, .5f)
                    .offset(y = 40.dp)
                    .size(40.dp)
                    .background(
                        Brush.radialGradient(
                            listOf(
                                Color.Black.copy(alpha = .3f),
                                Color.Transparent
                            )
                        )
                    )
            )

            KamelImage(
                modifier = Modifier.size(40.dp),
                resource = asyncPainterResource(categoryCardState.icon),
                contentDescription = categoryCardState.title
            )
        }
    }
}