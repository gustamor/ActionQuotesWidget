package es.gustavomoreno.android.gp.widget.actionquotes.domain

import es.gustavomoreno.android.gp.widget.actionquotes.data.services.QuotesService
import es.gustavomoreno.android.gp.widget.actionquotes.data.services.network.models.QuoteResponse

class GetQuotesUseCase {
    private val service: QuotesService = QuotesService()

    suspend operator fun invoke(): List<QuoteResponse>? {
        return service.getQuotes()

    }
}