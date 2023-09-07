package com.example.actionquoteswidget.domain

import com.example.actionquoteswidget.QuotesWidgetReceiver
import com.example.actionquoteswidget.data.services.QuotesService
import com.example.actionquoteswidget.data.services.network.models.QuoteResponse

class GetQuotesUseCase {
    private val service: QuotesService = QuotesService()

    suspend operator fun invoke(): List<QuoteResponse>? {
        return service.getQuotes()

    }
}