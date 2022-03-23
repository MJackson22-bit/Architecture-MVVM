package com.example.kmvvm.data

import com.example.kmvvm.data.model.QuoteModel
import com.example.kmvvm.data.model.QuoteProvider
import com.example.kmvvm.data.network.QuoteService

class QuoteRepository {
    private val api = QuoteService()
    suspend fun getAllQuotes(): List<QuoteModel>{
        val response = api.getQuotes()
        QuoteProvider.quotes = response
        return response
    }
}