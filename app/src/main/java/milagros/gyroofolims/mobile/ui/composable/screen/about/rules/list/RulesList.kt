package milagros.gyroofolims.mobile.ui.composable.screen.about.rules.list

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import milagros.gyroofolims.mobile.ui.theme.ControlDivider
import milagros.gyroofolims.mobile.ui.theme.LocalDimens

@Composable
fun RulesList(rules: List<String>, modifier: Modifier = Modifier) {
    val dimens = LocalDimens.current

    Column(modifier = modifier) {
        rules.forEachIndexed { index, rule ->
            if (index > 0) {
                ControlDivider()
            }

            Text(
                text = rule,
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(vertical = dimens.contentSpacing),
                color = MaterialTheme.colorScheme.onSurfaceVariant,
                style = MaterialTheme.typography.bodyMedium,
            )
        }
    }
}
