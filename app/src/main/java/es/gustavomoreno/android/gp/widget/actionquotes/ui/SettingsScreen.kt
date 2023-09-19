package es.gustavomoreno.android.gp.widget.actionquotes.ui

import android.app.Activity
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.platform.LocalUriHandler
import androidx.compose.ui.platform.testTag
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import es.gustavomoreno.android.gp.widget.actionquotes.R
import es.gustavomoreno.android.gp.widget.actionquotes.Space

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun SettingsScreen() {
    val activity = (LocalContext.current as? Activity)
    val uriHandler = LocalUriHandler.current
    val uri: String = stringResource(R.string.gp_link)
    Column(Modifier.fillMaxSize().testTag("settingsMainScreen"), horizontalAlignment = Alignment.CenterHorizontally) {

        Text(
            text = "Hello!",
            style = TextStyle(
                fontWeight = FontWeight.Bold,
                fontSize = 32.sp,
                textAlign = TextAlign.Right,
                fontStyle = FontStyle.Italic,
                color = MaterialTheme.colorScheme.onSurface
            ),
            modifier = Modifier.testTag("settingTextTitle")
        )
        Space(3)
        Image(
            painter = painterResource(id = R.drawable.ic_launcher_round),
            contentDescription = "Icon of the app",
            modifier = Modifier
                .padding(32.dp)
                .size(height = 128.dp, width = 128.dp)
                .testTag("settingsAppIcon")
        )
        Space(16)
        Column(Modifier.fillMaxSize(), horizontalAlignment = Alignment.CenterHorizontally) {
            Space(32)
            Text(
                text = "This is an Action Quotes Widget app",
                style = TextStyle(
                    fontWeight = FontWeight.Bold,
                    fontSize = 28.sp,
                    textAlign = TextAlign.Center,
                    fontStyle = FontStyle.Normal,
                    color = MaterialTheme.colorScheme.onSurface
                ),
                modifier = Modifier.testTag("SettingTextOne")
            )
            Space(16)
            Text(
                text = "Drop your widget onto your home screen",
                style = TextStyle(
                    fontWeight = FontWeight.Bold,
                    fontSize = 23.sp,
                    textAlign = TextAlign.Center,
                    fontStyle = FontStyle.Normal,
                    color = MaterialTheme.colorScheme.onSurface
                ),
                modifier = Modifier.testTag("SettingTextTwo")
            )
            Space(32)
            Text(
                text = "Enjoy it!",
                style = TextStyle(
                    fontWeight = FontWeight.Bold,
                    fontSize = 28.sp,
                    textAlign = TextAlign.Center,
                    fontStyle = FontStyle.Normal,
                    color = MaterialTheme.colorScheme.onSurface
                ),
                modifier = Modifier.testTag("SettingTextThree")
            )
            Space(48)
            TextButton(
                onClick = {
                    uriHandler.openUri(uri)
                },
                modifier = Modifier
                    .width(width = 200.dp)
                    .testTag("SettingRateButton"),
                elevation = ButtonDefaults.buttonElevation(10.dp),
                colors = ButtonDefaults.buttonColors(
                    containerColor = Color(0xFFFEBF00),
                    contentColor = Color(0xFF1B1B1B),
                )
            ) {
                Icon(
                    imageVector = Icons.Filled.Favorite,
                    contentDescription = "Heart Icon",
                    modifier = Modifier
                        .size(ButtonDefaults.IconSize)
                        .testTag("SettingRateButtonIcon")
                )
                Spacer(modifier = Modifier.size(ButtonDefaults.IconSpacing))
                Text(
                    "Like", modifier = Modifier.testTag("SettingTextButtonContent")
                )
            }
            Space(16)
            TextButton(
                onClick = {
                    activity?.finishAndRemoveTask()
                },
                modifier = Modifier
                    .width(width = 200.dp)
                    .testTag("SettingTextButtonClose"),
                elevation = ButtonDefaults.buttonElevation(10.dp),
                colors = ButtonDefaults.buttonColors(
                    containerColor = Color(0xFFFEBF00),
                    contentColor = Color(0xFF1B1B1B),
                )
            ) {
                Icon(
                    imageVector = Icons.Filled.ArrowBack,
                    contentDescription = "ArrowBack Icon",
                    modifier = Modifier
                        .size(ButtonDefaults.IconSize)
                        .testTag("SettingButtonIcon")
                )
                Spacer(modifier = Modifier.size(ButtonDefaults.IconSpacing))
                Text(
                    "Back", modifier = Modifier.testTag("SettingTextButtonContentBack")
                )
            }
        }
    }
}