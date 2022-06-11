package com.sunhang.to_dolist

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.sunhang.to_dolist.databinding.ActivityMainBinding

class SplashActivity : AppCompatActivity() {
    private lateinit var binding:ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
    }
}