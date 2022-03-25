package com.example.kmvvm.domain

import com.example.kmvvm.data.QuoteRepository
import com.example.kmvvm.data.model.QuoteModel
import com.example.kmvvm.domain.model.Quote
import javax.inject.Inject

class GetRandomQuoteUsesCase @Inject constructor(private val repository: QuoteRepository) {
    suspend operator fun invoke(): Quote? {
        val quotes = repository.getAllQuotesFromRoom()
        if (!quotes.isNullOrEmpty()) {
            val randomNumber = (quotes.indices).random()
            return quotes[randomNumber]
        }
        return null
    }
}