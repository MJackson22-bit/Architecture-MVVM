package com.example.kmvvm.data

import com.example.kmvvm.data.database.dao.QuoteDao
import com.example.kmvvm.data.database.entities.QuoteEntity
import com.example.kmvvm.data.network.QuoteService
import com.example.kmvvm.domain.model.Quote
import com.example.kmvvm.domain.model.toDomain
import javax.inject.Inject

class QuoteRepository @Inject constructor(
    private val api: QuoteService,
    private val quoteDao: QuoteDao
) {
    suspend fun getAllQuotesFromApi(): List<Quote> {
        val response = api.getQuotes()
        return response.map {
            it.toDomain()
        }
    }
    suspend fun getAllQuotesFromRoom(): List<Quote>{
        val response = quoteDao.getAllQuote()
        return response.map {
            it.toDomain()
        }
    }

    suspend fun insertQuote(quotes: List<QuoteEntity>){
        quoteDao.insertAll(quotes)
    }

    suspend fun clearQuotes(){
        quoteDao.deleteAllQuotes()
    }
}