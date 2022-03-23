package com.example.kmvvm.ui.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.kmvvm.data.model.QuoteModel
import com.example.kmvvm.data.model.QuoteProvider
import com.example.kmvvm.domain.GetQuoteUsesCase
import com.example.kmvvm.domain.GetRandomQuoteUsesCase
import kotlinx.coroutines.launch

class QuoteViewModel: ViewModel() {
    val quoteModel = MutableLiveData<QuoteModel>()
    var getQuoteUsesCase = GetQuoteUsesCase()
    val isLoading = MutableLiveData<Boolean>()
    var getRandomQuoteUsesCase = GetRandomQuoteUsesCase()
    fun onCreate() {
        viewModelScope.launch {
            isLoading.postValue(true)
            val result = getQuoteUsesCase()
            if(!result.isNullOrEmpty()){
                quoteModel.postValue(result[0])
                isLoading.postValue(false)
            }
        }
    }
    fun randomQuote(){
        isLoading.postValue(true)
        val quote = getRandomQuoteUsesCase()
        if(quote != null){
            quoteModel.postValue(quote)
        }
        isLoading.postValue(false)
    }
}