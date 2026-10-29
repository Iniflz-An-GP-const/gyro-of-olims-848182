package milagros.gyroofolims.mobile.ui.composable.screen.difficulty.option.content

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.LocalContentColor
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import milagros.gyroofolims.mobile.R
import milagros.gyroofolims.mobile.ui.composable.screen.difficulty.option.DifficultyOptionDefaults
import milagros.gyroofolims.mobile.ui.composable.screen.difficulty.option.DifficultyOptionItem
import milagros.gyroofolims.mobile.ui.theme.LocalDimens

private val BadgeSize = 52.dp
private const val BadgeFillAlpha = 0.14f

@Composable
fun DifficultyOptionContent(
    item: DifficultyOptionItem,
    @Suppress("UNUSED_PARAMETER") meter: @Composable () -> Unit,
    modifier: Modifier = Modifier,
) {
    Row(
        modifier = modifier.fillMaxWidth(),
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.spacedBy(LocalDimens.current.contentSpacing),
    ) {
        Box(
            modifier = Modifier
                .size(BadgeSize)
                .background(
                    color = LocalContentColor.current.copy(alpha = BadgeFillAlpha),
                    shape = CircleShape
                ),
            contentAlignment = Alignment.Center,
        ) {
            Text(text = item.cardCount.toString(), style = MaterialTheme.typography.titleLarge)
        }

        Column {
            Text(text = item.title, style = DifficultyOptionDefaults.titleStyle)
            Text(
                text = stringResource(R.string.difficulty_pairs_format, item.pairCount),
                color = DifficultyOptionDefaults.secondaryContentColor,
                style = DifficultyOptionDefaults.subtitleStyle,
            )
        }
    }
}
