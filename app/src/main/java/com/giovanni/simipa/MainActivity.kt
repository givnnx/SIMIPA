package com.giovanni.simipa

import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.giovanni.simipa.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding:ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        
        login()
    }

    private fun login() {
        binding.btnLogin.setOnClickListener {
            if (binding.edEmail.text!!.isEmpty() || binding.edPassword.text!!.isEmpty()){
                Toast.makeText(this, "Data harus diisi", Toast.LENGTH_SHORT).show()
            } else {
                val intent = Intent(this@MainActivity, Question1Activity::class.java)
                intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP or Intent.FLAG_ACTIVITY_NEW_TASK)
                startActivity(intent)
                finish()
            }
        }
    }
}