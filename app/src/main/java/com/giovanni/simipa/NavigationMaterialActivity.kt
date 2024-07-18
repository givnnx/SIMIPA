package com.giovanni.simipa

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.giovanni.simipa.databinding.ActivityNavigationMaterialBinding

class NavigationMaterialActivity : AppCompatActivity() {
    private lateinit var binding: ActivityNavigationMaterialBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityNavigationMaterialBinding.inflate(layoutInflater)
        setContentView(binding.root)

        cardButtonAction()
    }

    private fun cardButtonAction(){
        binding.icon1.setOnClickListener {
            val intent = Intent(this@NavigationMaterialActivity, Material1Activity::class.java)
            intent.putExtra(EXTRA_KEY_1, DATA_ICON_1)
            intent.putExtra(EXTRA_KEY_2, ADDITIONAL_DATA_ICON_1)
            startActivity(intent)
        }

        binding.icon2.setOnClickListener {
            val intent = Intent(this@NavigationMaterialActivity, Material1Activity::class.java)
            intent.putExtra(EXTRA_KEY_1, DATA_ICON_2)
            intent.putExtra(EXTRA_KEY_2, ADDITIONAL_DATA_ICON_2)
            startActivity(intent)
        }

        binding.icon3.setOnClickListener {
            val intent = Intent(this@NavigationMaterialActivity, Material1Activity::class.java)
            intent.putExtra(EXTRA_KEY_1, DATA_ICON_3)
            intent.putExtra(EXTRA_KEY_2, ADDITIONAL_DATA_ICON_3)
            startActivity(intent)
        }

        binding.icon4.setOnClickListener {
            val intent = Intent(this@NavigationMaterialActivity, Material1Activity::class.java)
            intent.putExtra(EXTRA_KEY_1, DATA_ICON_4)
            intent.putExtra(EXTRA_KEY_2, ADDITIONAL_DATA_ICON_4)
            startActivity(intent)
        }
    }

    companion object {
        const val EXTRA_KEY_1 = "extra_key_1"
        const val EXTRA_KEY_2 = "extra_key_2"
        const val DATA_ICON_1 = "https://sites.google.com/view/simipa/daerah-istimewa-yogyakarta?authuser=0"
        const val DATA_ICON_2 = "https://sites.google.com/view/simipa/kabupaten-bantul?authuser=0"
        const val DATA_ICON_3 = "https://sites.google.com/view/simipa/kabupaten-sleman?authuser=0"
        const val DATA_ICON_4 = "https://sites.google.com/view/simipa/kabupaten-gunung-kidul?authuser=0"
        const val ADDITIONAL_DATA_ICON_1 = "yogyakarta"
        const val ADDITIONAL_DATA_ICON_2 = "bantul"
        const val ADDITIONAL_DATA_ICON_3 = "sleman"
        const val ADDITIONAL_DATA_ICON_4 = "gunungkidul"
    }
}