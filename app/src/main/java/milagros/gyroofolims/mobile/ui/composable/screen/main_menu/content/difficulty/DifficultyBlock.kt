package milagros.gyroofolims.mobile.ui.composable.screen.main_menu.content.difficulty

import androidx.compose.animation.AnimatedContent
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.SegmentedButton
import androidx.compose.material3.SegmentedButtonDefaults
import androidx.compose.material3.SingleChoiceSegmentedButtonRow
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.TextAlign
import milagros.gyroofolims.mobile.ui.composable.screen.main_menu.content.block.MenuBlockDefaults
import milagros.gyroofolims.mobile.ui.composable.screen.main_menu.content.block.menuBlockSurface
import milagros.gyroofolims.mobile.ui.composable.screen.main_menu.content.difficulty.DifficultyBlockItem
import milagros.gyroofolims.mobile.ui.composable.screen.main_menu.content.difficulty.DifficultyFieldPreview
import milagros.gyroofolims.mobile.ui.composable.screen.main_menu.content.difficulty.difficultyFieldPreviewHeight
import milagros.gyroofolims.mobile.ui.theme.LocalDimens

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun DifficultyBlock(
    item: DifficultyBlockItem,
    onSelect: (index: Int) -> Unit,
    modifier: Modifier = Modifier,
) {
    val dimens = LocalDimens.current

    Column(
        modifier = modifier.menuBlockSurface(),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.spacedBy(dimens.contentSpacing),
    ) {
        Text(
            text = item.title,
            color = MenuBlockDefaults.contentColor,
            style = MaterialTheme.typography.titleMedium,
        )

        SingleChoiceSegmentedButtonRow(modifier = Modifier.fillMaxWidth()) {
            item.levels.forEachIndexed { index, level ->
                SegmentedButton(
                    selected = index == item.selectedIndex,
                    onClick = { onSelect(index) },
                    shape = SegmentedButtonDefaults.itemShape(
                        index = index,
                        count = item.levels.size
                    ),
                    label = { Text(text = level.title, maxLines = 1) },
                )
            }
        }

        AnimatedContent(targetState = item.selectedIndex, label = "difficultyLevel") { index ->
            val level = item.levels[index]

            Column(
                modifier = Modifier.fillMaxWidth(),
                horizontalAlignment = Alignment.CenterHorizontally,
                verticalArrangement = Arrangement.spacedBy(dimens.tightSpacing),
            ) {
                Box(
                    modifier = Modifier.height(difficultyFieldPreviewHeight(item.maxRows)),
                    contentAlignment = Alignment.Center,
                ) {
                    DifficultyFieldPreview(rows = level.rows, columns = level.columns)
                }
                Text(
                    text = level.subtitle,
                    color = MenuBlockDefaults.secondaryContentColor,
                    style = MaterialTheme.typography.bodyMedium,
                    textAlign = TextAlign.Center,
                )
            }
        }
    }
}
