package com.example.bora_care

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.TextView
import android.widget.Toast
import com.google.android.material.snackbar.Snackbar
import java.util.Calendar
import java.util.Date
import com.example.bora_care.databinding.ActivityMainBinding
import com.google.firebase.auth.FirebaseAuth


class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private lateinit var auth: FirebaseAuth

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        auth = FirebaseAuth.getInstance()

        binding.signup.setOnClickListener {
            val intent = Intent(this,Signup::class.java)
            startActivity(intent)
        }

        binding.button.setOnClickListener {
            ValidateUser(it)
        }
    }


    private fun ValidateUser(it: View) {
        val email = binding.editEmail.text
        val password = binding.editPassword.text
        if (email.toString().equals("esp32@gmail.com") && password.toString().equals("esp32")) {
            // Toast.makeText( this, "welcome to Esp32", Toast.LENGTH_SHORT).show()
            val username = "Esp32"
            val message = getString(R.string.welcome_message,username)

            val intent = Intent(this,MainMenu::class.java)
            startActivity(intent)
        } else {
            // Toast.makeText(this, "Sorry your not allowed in", Toast.LENGTH_SHORT).show()
            Snackbar.make(it, "Sorry, your not allowed in", Snackbar.LENGTH_SHORT).show()
        }
    }

    private fun displayToast() {
        Toast.makeText(this, "Login Successful: ${getDate()}", Toast.LENGTH_LONG).show()
    }

    private fun getDate(): Date = Calendar.getInstance().time
}