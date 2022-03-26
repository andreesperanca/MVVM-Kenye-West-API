package com.food.kanyewest.repositories

import com.food.kanyewest.rest.RetrofitService

class MainRepository constructor (private val retrofitService: RetrofitService) {

    suspend fun getQuote() = retrofitService.getQuote()
}