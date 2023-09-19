package es.gustavomoreno.android.gp.widget.actionquotes

import android.os.Bundle
import androidx.activity.compose.setContent
import androidx.appcompat.app.AppCompatActivity
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import es.gustavomoreno.android.gp.widget.actionquotes.ui.SettingsScreen
import es.gustavomoreno.android.gp.widget.actionquotes.ui.theme.ActionQuotesWidgetTheme


class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            ActionQuotesWidgetTheme {
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.surface
                ) {
                    SettingsScreen()
                }
            }
        }
    }
}

@Composable
fun Space(height: Int = 0) {
    Spacer(Modifier.height(height.dp))
}
