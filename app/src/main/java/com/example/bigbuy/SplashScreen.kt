package com.example.bigbuy

import android.content.Intent
import android.os.Bundle
import android.os.Handler
import android.view.animation.AnimationUtils
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_splash_screen.*


class SplashScreen : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash_screen)

        val animation = AnimationUtils.loadAnimation(applicationContext,R.anim.fadein )
        slpscreen.startAnimation(animation)
        slogan.startAnimation(animation)
        val handler = Handler()
        handler.postDelayed(Runnable {
            val intent = Intent(this@SplashScreen, Home::class.java)
            startActivity(intent)
            finish()
        }, 5000)

    }
}