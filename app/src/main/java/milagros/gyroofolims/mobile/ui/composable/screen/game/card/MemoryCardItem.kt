package milagros.gyroofolims.mobile.ui.composable.screen.game.card

import androidx.compose.ui.graphics.vector.ImageVector
import milagros.gyroofolims.mobile.data.model.CardState

data class MemoryCardItem(
    val symbol: ImageVector,
    val state: CardState,
)
