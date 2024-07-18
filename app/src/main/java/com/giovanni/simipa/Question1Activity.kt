package com.giovanni.simipa

import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.giovanni.simipa.databinding.ActivityQuestion1Binding

class Question1Activity : AppCompatActivity() {
    private lateinit var binding: ActivityQuestion1Binding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityQuestion1Binding.inflate(layoutInflater)
        setContentView(binding.root)

        next()
    }

    private fun next() {
        binding.btnLogin.setOnClickListener {
            if (!binding.radioButton.isChecked && !binding.radioButton2.isChecked){
                Toast.makeText(this, "Data harus diisi", Toast.LENGTH_SHORT).show()
            } else {
                val intent = Intent(this@Question1Activity, Question2Activity::class.java)
                startActivity(intent)
            }
        }
    }
}