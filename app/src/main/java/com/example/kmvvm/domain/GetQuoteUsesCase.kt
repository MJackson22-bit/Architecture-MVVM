package com.example.kmvvm.domain

import com.example.kmvvm.data.QuoteRepository
import com.example.kmvvm.data.model.QuoteModel

class GetQuoteUsesCase {
    private val repository = QuoteRepository()
    suspend operator fun invoke(): List<QuoteModel> = repository.getAllQuotes()
}