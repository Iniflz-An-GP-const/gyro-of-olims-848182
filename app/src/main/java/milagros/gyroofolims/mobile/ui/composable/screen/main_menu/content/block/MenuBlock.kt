package milagros.gyroofolims.mobile.ui.composable.screen.main_menu.content.block

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import milagros.gyroofolims.mobile.ui.composable.screen.main_menu.content.block.content.MenuBlockContent
import milagros.gyroofolims.mobile.ui.composable.screen.main_menu.content.block.shell.MenuBlockShell

@Composable
fun MenuBlock(
    item: MenuBlockItem,
    onClick: () -> Unit,
    modifier: Modifier = Modifier,
) {
    MenuBlockShell(onClick = onClick, emphasis = item.emphasis, modifier = modifier) {
        MenuBlockContent(item = item)
    }
}
