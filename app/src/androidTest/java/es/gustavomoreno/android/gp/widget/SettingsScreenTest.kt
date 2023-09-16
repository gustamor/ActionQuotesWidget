package es.gustavomoreno.android.gp.widget

import androidx.compose.ui.test.junit4.createAndroidComposeRule
import androidx.compose.ui.test.onNodeWithContentDescription
import androidx.compose.ui.test.onNodeWithTag
import androidx.compose.ui.test.onNodeWithText
import androidx.compose.ui.test.performClick
import es.gustavomoreno.android.gp.widget.actionquotes.MainActivity
import org.junit.Rule
import org.junit.Test

class SettingsScreenTest {
    val textTitle = "Hello!"
    val textSubtitle = "This is an Action Quotes Widget app"
    val textInstruction = "Drop your widget onto your home screen"
    val textEnjoy = "Enjoy it!"

    @get:Rule
    val composeTestRule = createAndroidComposeRule<MainActivity>()

    @Test
    fun check_is_main_column_exist() {
        composeTestRule.onNodeWithTag("settingsMainScreen").assertExists()
    }

    @Test
    fun check_is_text_of_title_exists() {
        composeTestRule.onNodeWithText(textTitle).assertExists()
    }
    @Test
    fun check_is_text_of_subtitle_exists() {
        composeTestRule.onNodeWithText(textSubtitle).assertExists()
    }
    @Test
    fun check_is_text_of_instruction_exists() {
        composeTestRule.onNodeWithText(textInstruction).assertExists()
    }
    @Test
    fun check_is_text_of_enjoy_exists() {
        composeTestRule.onNodeWithText(textEnjoy).assertExists()
    }
    @Test
    fun check_is_text_of_rate_textButton_exists() {
        composeTestRule.onNodeWithTag( "SettingRateButton").assertExists()
    }
    @Test
    fun check_is_text_of_close_textButton_exists() {
        composeTestRule.onNodeWithTag( "SettingTextButtonClose").assertExists()
    }
    @Test
    fun check_is_image_of_heart_icon_exists() {
        composeTestRule.onNodeWithContentDescription("Heart Icon").assertExists()

    }
    @Test
    fun check_is_image_of_arrowback_icon_exists() {
        composeTestRule.onNodeWithContentDescription( "ArrowBack Icon").assertExists()
    }
    @Test
    fun check_is_text_of_close_text_exists() {
        composeTestRule.onNodeWithText( "Back").assertExists()

    }

    @Test
    fun check_is_image_of_the_app_icon_exists() {
        composeTestRule.onNodeWithTag("settingsAppIcon").assertExists()
        composeTestRule.onNodeWithContentDescription("Icon of the app").assertExists()
    }

    @Test
    fun check_is_finishes_app() {
        composeTestRule.onNodeWithTag("SettingTextButtonClose").performClick()

    }

}