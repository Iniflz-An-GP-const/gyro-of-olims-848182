package milagros.gyroofolims.mobile.ui.composable.approot.background.points

import androidx.compose.ui.unit.dp
import milagros.gyroofolims.mobile.ui.composable.approot.background.BackgroundPattern
import milagros.gyroofolims.mobile.ui.composable.approot.background.gridAnchors

/** Every other cell of a 6 x 10 grid, like a checkerboard — a diamond lattice. */
val AppBackgroundPattern = BackgroundPattern(
    anchors = gridAnchors(columns = 6, rows = 10) { column, row -> (column + row) % 2 == 0 },
    iconSize = 28.dp,
)
