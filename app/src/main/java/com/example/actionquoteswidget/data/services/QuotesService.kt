package com.example.actionquoteswidget.data.services

import android.util.Log
import com.example.actionquoteswidget.data.di.RetroFitModule
import com.example.actionquoteswidget.data.services.network.models.QuoteResponse
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

class QuotesService
{
    val retrofitModule = RetroFitModule()
    val api = retrofitModule.providesQuotesApiClient()

    suspend fun getQuotes(): List<QuoteResponse>? {
        var quote : List<QuoteResponse> = mutableListOf()
            try {
                val quotesList =  api.getQuotes()
                if (quotesList.isSuccessful) {
                    val quotesListResponse = quotesList.body()
                    val quotes = quotesListResponse
                   return quotes
                } else {
                    return quote

                }
            } catch (e: Exception) {
               throw Exception("Api error ${e.message}")
            }

        }

}