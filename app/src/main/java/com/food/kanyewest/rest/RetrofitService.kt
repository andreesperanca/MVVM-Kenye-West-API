package com.food.kanyewest.rest

import com.food.kanyewest.models.Quote
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET

interface RetrofitService {

    @GET("/")

    suspend fun getQuote() : Response<Quote>


    companion object {

        private val retrofitService : RetrofitService by lazy {

            val retrofit = Retrofit.Builder()
                .baseUrl("https://api.kanye.rest/")
                .addConverterFactory(GsonConverterFactory.create())
                .build()

            retrofit.create(RetrofitService::class.java)

        }

        fun getInstance() : RetrofitService {
            return retrofitService

        }
    }
}
