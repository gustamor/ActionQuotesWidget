package com.example.actionquoteswidget.data.services.network.models

import com.google.gson.annotations.SerializedName

data class QuoteResponse(
@SerializedName("author") val author: String,
@SerializedName("text") val text: String)
