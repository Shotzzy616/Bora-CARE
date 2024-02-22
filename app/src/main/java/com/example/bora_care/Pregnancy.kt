package com.example.bora_care

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.bora_care.databinding.ActivityDetailsBinding
import com.example.bora_care.databinding.ActivityPregnancyBinding
import com.google.firebase.database.DatabaseReference

class Pregnancy : AppCompatActivity() {
    private lateinit var binding: ActivityPregnancyBinding
    private lateinit var database: DatabaseReference
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityPregnancyBinding.inflate(layoutInflater)
        setContentView(binding.root)
    }
}