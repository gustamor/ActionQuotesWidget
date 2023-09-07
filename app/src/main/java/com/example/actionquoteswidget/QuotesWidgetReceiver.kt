package com.example.actionquoteswidget

import androidx.glance.appwidget.GlanceAppWidget
import androidx.glance.appwidget.GlanceAppWidgetReceiver
import com.example.actionquoteswidget.ui.QuotesWidget

class QuotesWidgetReceiver : GlanceAppWidgetReceiver() {

    override val glanceAppWidget: GlanceAppWidget = QuotesWidget()
}