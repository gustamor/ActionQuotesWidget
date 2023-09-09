package es.gustavomoreno.android.gp.widget.actionquotes.data.services.network

import es.gustavomoreno.android.gp.widget.actionquotes.data.services.network.models.QuoteResponse
import retrofit2.Response
import retrofit2.http.GET

interface QuotesApiClient {
  @GET("dwyl/quotes/main/quotes.json")
  suspend fun getQuotes(): Response<List<QuoteResponse>>

}