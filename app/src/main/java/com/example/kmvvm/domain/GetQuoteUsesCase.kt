package com.example.kmvvm.domain

import com.example.kmvvm.data.QuoteRepository
import com.example.kmvvm.data.model.QuoteModel
import javax.inject.Inject

class GetQuoteUsesCase @Inject constructor(private val repository: QuoteRepository) {
    suspend operator fun invoke(): List<QuoteModel> = repository.getAllQuotes()
}