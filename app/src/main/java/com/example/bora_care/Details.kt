package com.example.bora_care

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.example.bora_care.databinding.ActivityDetailsBinding
import com.google.firebase.database.DatabaseReference
import com.google.firebase.database.FirebaseDatabase
import java.lang.Exception

class Details : AppCompatActivity() {
    private lateinit var binding: ActivityDetailsBinding
    private lateinit var database: DatabaseReference
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityDetailsBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.LED.setOnClickListener { setData() }
        binding.Age.setOnClickListener { setAge() }
        binding.Height.setOnClickListener { setHeight() }
        binding.Weight.setOnClickListener { setWeight() }
        binding.Pressure.setOnClickListener { setPressure() }
        binding.Pregnacy.setOnClickListener {
            val intent = Intent(this, Pregnancy::class.java)
            startActivity(intent)
        }
        binding.Back.setOnClickListener {
            val intent = Intent(this, MainMenu::class.java)
            startActivity(intent)
        }
    }

    private var ledState: Boolean = false // Initialize LED state

    private fun setData() {
        ledState = !ledState // Invert LED state
        database = FirebaseDatabase.getInstance().getReference("LED")
        database.child("Digital").setValue(ledState).addOnSuccessListener {
            if (ledState) {
                Toast.makeText(this, "LED turned on", Toast.LENGTH_SHORT).show()
            } else {
                Toast.makeText(this, "LED turned off", Toast.LENGTH_SHORT).show()
            }
        }.addOnFailureListener {
            Toast.makeText(this, "FAILED to turn LED", Toast.LENGTH_SHORT).show()
        }
    }
    private fun setAge() {
        var ageValue: Int = 0
        try {
            ageValue = binding.agevalue.text.toString().toInt()
        }catch (e:Exception){
            Toast.makeText(this, e.message, Toast.LENGTH_SHORT).show()
            return
        }
        database = FirebaseDatabase.getInstance().getReference("Details")
        database.child("Age").setValue(ageValue).addOnSuccessListener {
            Toast.makeText(this, "Age Value set successful", Toast.LENGTH_SHORT).show()
        }.addOnFailureListener {
            Toast.makeText(this, "Age Value set failed", Toast.LENGTH_SHORT).show()
        }
    }
    private fun setHeight() {
        var heightValue: Int = 0
        try {
            heightValue = binding.heightvalue.text.toString().toInt()
        }catch (e:Exception){
            Toast.makeText(this, e.message, Toast.LENGTH_SHORT).show()
            return
        }
        database = FirebaseDatabase.getInstance().getReference("Details")
        database.child("Height").setValue(heightValue).addOnSuccessListener {
            Toast.makeText(this, "Height Value set successful", Toast.LENGTH_SHORT).show()
        }.addOnFailureListener {
            Toast.makeText(this, "Height Value set failed", Toast.LENGTH_SHORT).show()
        }
    }
    private fun setWeight() {
        var weightValue: Int = 0
        try {
            weightValue = binding.weightvalue.text.toString().toInt()
        }catch (e:Exception){
            Toast.makeText(this, e.message, Toast.LENGTH_SHORT).show()
            return
        }
        database = FirebaseDatabase.getInstance().getReference("Details")
        database.child("Weight").setValue(weightValue).addOnSuccessListener {
            Toast.makeText(this, "Weight Value set successful", Toast.LENGTH_SHORT).show()
        }.addOnFailureListener {
            Toast.makeText(this, "Weight Value set failed", Toast.LENGTH_SHORT).show()
        }
    }
    private fun setPressure() {
        var pressureValue: Int = 0
        try {
            pressureValue = binding.pressurevalue.text.toString().toInt()
        }catch (e:Exception){
            Toast.makeText(this, e.message, Toast.LENGTH_SHORT).show()
            return
        }
        database = FirebaseDatabase.getInstance().getReference("Details")
        database.child("BloodPressure").setValue(pressureValue).addOnSuccessListener {
            Toast.makeText(this, "BloodPressure Value set successful", Toast.LENGTH_SHORT).show()
        }.addOnFailureListener {
            Toast.makeText(this, "BloodPressure Value set failed", Toast.LENGTH_SHORT).show()
        }
    }

}