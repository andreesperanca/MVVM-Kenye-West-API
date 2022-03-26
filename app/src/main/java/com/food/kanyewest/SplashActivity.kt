package com.food.kanyewest

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import android.widget.ImageView

class SplashActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash)

        val imgSplash = findViewById<ImageView>(R.id.splash_img)

        imgSplash.animate().apply {
            duration = 1000
            alpha(1.0f)
            start()

            Handler(Looper.getMainLooper()).postDelayed({
                imgSplash.animate().apply {
                    duration = 1000
                    alpha(0.0f)
                    start()
                }
                val intent = Intent(baseContext, MainActivity::class.java)
                intent.flags = Intent.FLAG_ACTIVITY_CLEAR_TASK or Intent.FLAG_ACTIVITY_NEW_TASK
                startActivity(intent)
                overridePendingTransition(android.R.anim.fade_in, android.R.anim.fade_out)

            },2000 )
        }
    }
}
