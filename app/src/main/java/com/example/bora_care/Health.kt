package com.example.bora_care

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.example.bora_care.databinding.ActivityHealthBinding
import com.google.firebase.database.DataSnapshot
import com.google.firebase.database.DatabaseError
import com.google.firebase.database.DatabaseReference
import com.google.firebase.database.FirebaseDatabase
import com.google.firebase.database.ValueEventListener

class Health : AppCompatActivity() {
    private lateinit var  binding: ActivityHealthBinding
    private lateinit var database: DatabaseReference
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityHealthBinding.inflate(layoutInflater)
        setContentView(binding.root)

        // binding.DATA.setOnClickListener {readData()}
        databaseListener()
        binding.Back.setOnClickListener {
            val intent = Intent(this,MainMenu::class.java)
            startActivity(intent)
        }
    }
    private fun databaseListener() {
        database = FirebaseDatabase.getInstance().getReference()
        val postListener = object : ValueEventListener{
            override fun onDataChange(snapshot: DataSnapshot) {
                val heart = snapshot.child("Sensor/HeartRate").value
                val spoz = snapshot.child("Sensor/SPOZ").value
                val temp = snapshot.child("Sensor/Temprature").value
                val step = snapshot.child("Sensor/Steps").value
                binding.HearRate.setText(heart.toString())
                binding.SPOZ.setText(spoz.toString())
                binding.Temp.setText(temp.toString())
                binding.Steps.setText(step.toString())
            }

            override fun onCancelled(error: DatabaseError) {
                Toast.makeText(this@Health, "Failed to read sensor data", Toast.LENGTH_SHORT).show()
            }
        }
        database.addValueEventListener(postListener)
    }

    /* private fun readData() {
        database = FirebaseDatabase.getInstance().getReference("Sensor")
        database.child("Humidity").get().addOnSuccessListener {
            if (it.exists()) {
                val Humidity:Float = it.value.toString().toFloat()
                Toast.makeText(this, "successful Humidity reading", Toast.LENGTH_SHORT).show()
                binding.textView2.setText(Humidity.toString())
            }
            else {
                Toast.makeText(this, "Sensor/Humidity path does not exist", Toast.LENGTH_SHORT).show()
            }
        }.addOnFailureListener{
            Toast.makeText(this,"FAILED", Toast.LENGTH_SHORT).show()
        }
        database.child("Temprature").get().addOnSuccessListener {
            if (it.exists()) {
                val Temprature:Float = it.value.toString().toFloat()
                Toast.makeText(this, "successful Temprature reading", Toast.LENGTH_SHORT).show()
                binding.textView3.setText(Temprature.toString())
            }
            else {
                Toast.makeText(this, "Sensor/Temprature path does not exist", Toast.LENGTH_SHORT).show()
            }
        }.addOnFailureListener {
            Toast.makeText(this, "FAILED", Toast.LENGTH_SHORT).show()
        }
    }*/
}
