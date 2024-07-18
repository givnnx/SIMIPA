package com.giovanni.simipa

import android.media.MediaPlayer
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.giovanni.simipa.databinding.ActivityExplanationBinding

class ExplanationActivity : AppCompatActivity() {
    private lateinit var binding:ActivityExplanationBinding
    private lateinit var mediaPlayer: MediaPlayer

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityExplanationBinding.inflate(layoutInflater)
        setContentView(binding.root)

        mediaPlayer = MediaPlayer.create(this, R.raw.tolol)

        audioAction()
    }

    override fun onDestroy() {
        super.onDestroy()
        mediaPlayer.release() // Release MediaPlayer resources when activity is destroyed
    }

    private fun audioAction(){
        binding.ctv1.setOnClickListener {
            if(mediaPlayer.isPlaying){
                mediaPlayer.stop()
            } else {
                mediaPlayer.start()
            }
        }
        binding.ctv2.setOnClickListener {
            if(mediaPlayer.isPlaying){
                mediaPlayer.stop()
            } else {
                mediaPlayer.start()
            }
        }
        binding.ctv3.setOnClickListener {
            if(mediaPlayer.isPlaying){
                mediaPlayer.stop()
            } else {
                mediaPlayer.start()
            }
        }
        binding.ctv4.setOnClickListener {
            if(mediaPlayer.isPlaying){
                mediaPlayer.stop()
            } else {
                mediaPlayer.start()
            }
        }
    }
}