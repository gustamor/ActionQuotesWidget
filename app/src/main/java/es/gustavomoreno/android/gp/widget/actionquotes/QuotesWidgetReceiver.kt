package es.gustavomoreno.android.gp.widget.actionquotes

import androidx.glance.appwidget.GlanceAppWidget
import androidx.glance.appwidget.GlanceAppWidgetReceiver
import es.gustavomoreno.android.gp.widget.actionquotes.ui.QuotesWidget

class QuotesWidgetReceiver : GlanceAppWidgetReceiver() {

    override val glanceAppWidget: GlanceAppWidget = QuotesWidget()
}