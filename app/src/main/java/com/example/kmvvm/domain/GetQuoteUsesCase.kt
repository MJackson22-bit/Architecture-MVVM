package com.example.kmvvm.domain

import com.example.kmvvm.data.QuoteRepository
import com.example.kmvvm.data.database.entities.toDatabase
import com.example.kmvvm.data.database.entities.toDatabase
import com.example.kmvvm.data.model.QuoteModel
import com.example.kmvvm.domain.model.Quote
import javax.inject.Inject

class GetQuoteUsesCase @Inject constructor(private val repository: QuoteRepository) {
    suspend operator fun invoke(): List<Quote>{
        val quotes = repository.getAllQuotesFromApi()
        return if(quotes.isNotEmpty()){
            repository.clearQuotes()
            repository.insertQuote(quotes.map { it.toDatabase() })
            quotes
        }else{
            return  repository.getAllQuotesFromRoom()
        }
    }
}