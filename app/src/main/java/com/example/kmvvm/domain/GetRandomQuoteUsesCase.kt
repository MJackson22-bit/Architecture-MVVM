package com.example.kmvvm.domain

import com.example.kmvvm.data.QuoteRepository
import com.example.kmvvm.data.model.QuoteModel
import com.example.kmvvm.data.model.QuoteProvider
import javax.inject.Inject

class GetRandomQuoteUsesCase @Inject constructor(private val quoteProvider: QuoteProvider){
    operator fun invoke(): QuoteModel?{
        val quotes = quoteProvider.quotes
        if(!quotes.isNullOrEmpty()){
            val randomNumber = (quotes.indices).random()
            return quotes[randomNumber]
        }
        return null
    }
}