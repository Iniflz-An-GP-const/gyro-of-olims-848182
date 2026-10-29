package milagros.gyroofolims.mobile

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import milagros.gyroofolims.mobile.ui.composable.approot.AppRoot
import milagros.gyroofolims.mobile.ui.theme.MOOSEAppTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            MOOSEAppTheme {
                AppRoot()
            }
        }
    }
}
