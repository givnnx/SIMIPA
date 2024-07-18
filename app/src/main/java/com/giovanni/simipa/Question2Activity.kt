package com.giovanni.simipa

import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.giovanni.simipa.databinding.ActivityQuestion2Binding

class Question2Activity : AppCompatActivity() {
    private lateinit var binding: ActivityQuestion2Binding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityQuestion2Binding.inflate(layoutInflater)
        setContentView(binding.root)

        next()
    }

    private fun next() {

        binding.btnLogin.setOnClickListener {
            if (!binding.radioButton.isChecked && !binding.radioButton2.isChecked){
                Toast.makeText(this, "Data harus diisi", Toast.LENGTH_SHORT).show()
            } else {
                val intent = Intent(this@Question2Activity, NavigationMaterialActivity::class.java)
                intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK or Intent.FLAG_ACTIVITY_NEW_TASK)
                startActivity(intent)
                finish()
            }
        }

    }
}