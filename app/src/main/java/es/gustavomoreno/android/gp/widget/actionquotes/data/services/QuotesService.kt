package es.gustavomoreno.android.gp.widget.actionquotes.data.services

import es.gustavomoreno.android.gp.widget.actionquotes.data.di.RetroFitModule
import es.gustavomoreno.android.gp.widget.actionquotes.data.services.network.models.QuoteResponse

class QuotesService
{
    private val retrofitModule = RetroFitModule()
    private val api = retrofitModule.providesQuotesApiClient()

    suspend fun getQuotes(): List<QuoteResponse>? {
        val quote : List<QuoteResponse> = mutableListOf()
        return try {
            val quotesList =  api.getQuotes()
            if (quotesList.isSuccessful) {
                val quotesListResponse = quotesList.body()
                quotesListResponse
            } else {
                quote
            }
        } catch (e: Exception) {
            throw Exception("Api error ${e.message}")
        }

        }

}