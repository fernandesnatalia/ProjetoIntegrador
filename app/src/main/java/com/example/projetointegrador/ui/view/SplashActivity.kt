package com.example.projetointegrador.ui.view

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.projetointegrador.MainActivity
import com.example.projetointegrador.databinding.ActivitySplashBinding
import java.util.*

class SplashActivity : AppCompatActivity() {
    private lateinit var binding: ActivitySplashBinding
    private val timer = Timer()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivitySplashBinding.inflate(layoutInflater)
        setContentView(binding.root)
        timer.schedule(object : TimerTask() {
            override fun run() {
                jump()
            }
        }, 3000)
    }

    private fun jump() {
        timer.cancel()
        startActivity(Intent(this, MainActivity::class.java))
        this.finish()
    }
}