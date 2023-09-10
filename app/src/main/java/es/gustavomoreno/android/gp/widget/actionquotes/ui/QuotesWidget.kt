package es.gustavomoreno.android.gp.widget.actionquotes.ui

import android.content.Context
import androidx.compose.material3.MaterialTheme
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.datastore.preferences.core.Preferences
import androidx.datastore.preferences.core.intPreferencesKey
import androidx.datastore.preferences.core.stringPreferencesKey
import androidx.glance.GlanceId
import androidx.glance.GlanceModifier
import androidx.glance.ImageProvider
import androidx.glance.action.ActionParameters
import androidx.glance.action.clickable
import androidx.glance.appwidget.GlanceAppWidget
import androidx.glance.appwidget.action.ActionCallback
import androidx.glance.appwidget.action.actionRunCallback
import androidx.glance.appwidget.provideContent
import androidx.glance.appwidget.state.updateAppWidgetState
import androidx.glance.background
import androidx.glance.currentState
import androidx.glance.layout.Alignment
import androidx.glance.layout.Box
import androidx.glance.layout.Column
import androidx.glance.layout.Spacer
import androidx.glance.layout.height
import androidx.glance.layout.padding
import androidx.glance.state.GlanceStateDefinition
import androidx.glance.state.PreferencesGlanceStateDefinition
import androidx.glance.text.FontFamily
import androidx.glance.text.FontStyle
import androidx.glance.text.FontWeight
import androidx.glance.text.Text
import androidx.glance.text.TextAlign
import androidx.glance.text.TextStyle
import androidx.glance.unit.ColorProvider
import es.gustavomoreno.android.gp.widget.actionquotes.R
import es.gustavomoreno.android.gp.widget.actionquotes.data.services.network.models.QuoteResponse
import es.gustavomoreno.android.gp.widget.actionquotes.domain.GetQuotesUseCase


private val currentQuoteKey = stringPreferencesKey("currentQuote")
private val currentTextSizeKey = intPreferencesKey("currentTextSize")
private var quotes: List<QuoteResponse>? = mutableListOf(QuoteResponse("Ernest Hemingway ","Never confuse movement with action"))
private val getQuotesUseCase = GetQuotesUseCase()

class QuotesWidget : GlanceAppWidget() {
    override val stateDefinition: GlanceStateDefinition<*> = PreferencesGlanceStateDefinition
    override suspend fun provideGlance(context: Context, id: GlanceId) {
        quotes = getQuotesUseCase()
        provideContent {
            val preferences = currentState<Preferences>()
            val textSize = preferences[currentTextSizeKey] ?: 19
            val currentQuote = quotes?.random()

            MaterialTheme {
                Box(
                    modifier = GlanceModifier
                        .background(imageProvider = ImageProvider(R.drawable.card_shapes)
                        )
                        .padding(16.dp)
                        .clickable(actionRunCallback<RefreshQuoteAction>())
                ) {
                    Column (horizontalAlignment = Alignment.Horizontal.CenterHorizontally) {
                        Text(
                            text = "${currentQuote?.text}",
                            style = TextStyle(
                                fontWeight = FontWeight.Bold,
                                fontSize = textSize.sp,
                                textAlign = TextAlign.Center,
                                fontFamily = FontFamily.Cursive,
                                color = ColorProvider(
                                    color = Color(0xFFE7E7E7))
                                )
                            )
                        Spacer(modifier = GlanceModifier.height(16.dp))

                        Text(
                            text = "${currentQuote?.author}",
                            style = TextStyle(
                                fontWeight = FontWeight.Bold,
                                fontSize = textSize.sp,
                                textAlign = TextAlign.Right,
                                fontStyle = FontStyle.Italic,
                                fontFamily = FontFamily.Cursive,
                                color = ColorProvider(
                                    color =Color(0xFFE7E7E7))
                            ),
                        )
                    }

                }
            }
        }
    }
}

class RefreshQuoteAction : ActionCallback {
    override suspend fun onAction(
        context: Context,
        glanceId: GlanceId,
        parameters: ActionParameters
    ) {
        updateAppWidgetState(context, PreferencesGlanceStateDefinition, glanceId) { preferences ->
            preferences.toMutablePreferences().apply {
                quotes = getQuotesUseCase()
                val currentQuote = quotes?.random()
                val quoteText = "${currentQuote?.text} \n ${currentQuote?.author}"
                this[currentQuoteKey] = quoteText
            }
        }
        QuotesWidget().update(context, glanceId)
    }
}


