package com.food.kanyewest

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.TextView
import android.widget.Toast
import androidx.lifecycle.Observer
import androidx.lifecycle.ReportFragment
import androidx.lifecycle.ViewModelProvider
import com.food.kanyewest.databinding.ActivityMainBinding
import com.food.kanyewest.repositories.MainRepository
import com.food.kanyewest.rest.RetrofitService
import com.food.kanyewest.viewmodel.main.MainViewModel
import com.food.kanyewest.viewmodel.main.MainViewModelFactory


class MainActivity : AppCompatActivity() {

    lateinit var viewModel: MainViewModel

    private lateinit var binding : ActivityMainBinding

    private val retrofitService = RetrofitService.getInstance()

    lateinit var repo: MainRepository

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(layoutInflater)

        setContentView(binding.root)

        repo = MainRepository(retrofitService)

        viewModel =
            ViewModelProvider(this, MainViewModelFactory(MainRepository(retrofitService))).get(
                MainViewModel::class.java
            )

        getQuote()

        binding.btnNewQuote.setOnClickListener {

            getQuote()

        }
    }

    private fun getQuote() {

        val txtOriginal = findViewById<TextView>(R.id.kw_original)

        try {
            viewModel.getQuote()
            viewModel.response.observe(this) {
                if (it.isSuccessful) {
                    txtOriginal.text = it.body()?.quote
                } else {
                    Log.d("Response", it.errorBody().toString())
                }
            }
        } catch (e : Exception) {
            txtOriginal.text = e.toString()
        }
    }
}

