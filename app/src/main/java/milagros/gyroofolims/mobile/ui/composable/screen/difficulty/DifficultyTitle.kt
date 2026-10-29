package milagros.gyroofolims.mobile.ui.composable.screen.difficulty

import milagros.gyroofolims.mobile.R
import milagros.gyroofolims.mobile.data.model.Difficulty

fun Difficulty.titleRes(): Int = when (this) {
    Difficulty.Easy -> R.string.difficulty_easy
    Difficulty.Medium -> R.string.difficulty_medium
    Difficulty.Hard -> R.string.difficulty_hard
}
