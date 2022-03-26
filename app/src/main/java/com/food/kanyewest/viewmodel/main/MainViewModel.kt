package com.food.kanyewest.viewmodel.main

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.food.kanyewest.models.Quote
import com.food.kanyewest.repositories.MainRepository
import kotlinx.coroutines.launch
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response


class MainViewModel constructor(private val repository: MainRepository) : ViewModel() {

    val response : MutableLiveData<Response<Quote>> = MutableLiveData()


    fun getQuote() {

        viewModelScope.launch {
            response.value = repository.getQuote()

        }
    }

}