package com.example.kmvvm.domain.model

import com.example.kmvvm.data.database.entities.QuoteEntity
import com.example.kmvvm.data.model.QuoteModel

data class Quote(val quote: String, val author: String)

fun QuoteModel.toDomain() = Quote(quote, author)
fun QuoteEntity.toDomain() = Quote(quote, author)