package com.example.actionquoteswidget.data.services.network

import com.example.actionquoteswidget.data.services.network.models.QuoteResponse
import retrofit2.Call
import retrofit2.Response
import retrofit2.http.GET

interface QuotesApiClient {
  @GET("dwyl/quotes/main/quotes.json")
  suspend fun getQuotes(): Response<List<QuoteResponse>>

}