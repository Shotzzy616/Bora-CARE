package com.example.bora_care

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.bora_care.databinding.ActivityMainmenuBinding

class MainMenu : AppCompatActivity() {
    private lateinit var binding: ActivityMainmenuBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainmenuBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.Logout.setOnClickListener {
            val intent = Intent(this, MainActivity::class.java)
            startActivity(intent)
        }
        binding.Health.setOnClickListener {
            val intent = Intent(this, Health::class.java)
            startActivity(intent)
        }
        binding.Details.setOnClickListener {
            val intent = Intent(this, Details::class.java)
            startActivity(intent)
        }
    }
}