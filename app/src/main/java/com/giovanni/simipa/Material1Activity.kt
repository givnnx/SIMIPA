package com.giovanni.simipa

import android.graphics.Bitmap
import android.media.MediaPlayer
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.giovanni.simipa.databinding.ActivityMaterial1Binding
import com.google.zxing.BarcodeFormat
import com.google.zxing.EncodeHintType
import com.google.zxing.MultiFormatWriter
import com.google.zxing.common.BitMatrix
import java.util.EnumMap

class Material1Activity : AppCompatActivity() {
    private lateinit var binding:ActivityMaterial1Binding
    private lateinit var mediaPlayer: MediaPlayer
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMaterial1Binding.inflate(layoutInflater)
        setContentView(binding.root)

        val receivedData = intent.getStringExtra(NavigationMaterialActivity.EXTRA_KEY_1)
        val receivedData2 = intent.getStringExtra(NavigationMaterialActivity.EXTRA_KEY_2)
        val resulGenerate = generateQR(receivedData.toString())
        binding.ivBarcode.setImageBitmap(resulGenerate)

//        playAudio(receivedData2.toString())
    }

    private fun playAudio(audio: String){
        when (audio) {
            "yogyakarta" -> {
                mediaPlayer = MediaPlayer.create(this, R.raw.gempa)
                mediaPlayer.start()
            }
            "bantul" -> {
                mediaPlayer = MediaPlayer.create(this, R.raw.tsunami)
                mediaPlayer.start()
            }
            "sleman" -> {
                mediaPlayer = MediaPlayer.create(this, R.raw.banjir)
                mediaPlayer.start()
            }
            else -> {
                mediaPlayer = MediaPlayer.create(this, R.raw.gunungmeletus)
                mediaPlayer.start()
            }
        }
    }

    private fun generateQR(isiData : String) : Bitmap? {
        val bitMatrix : BitMatrix = try {
            val hints = EnumMap<EncodeHintType, Any>(EncodeHintType::class.java)
            hints[EncodeHintType.CHARACTER_SET] = "UTF-8"
            MultiFormatWriter().encode(
                isiData,
                BarcodeFormat.QR_CODE,
                600,600,
                hints
            )
        } catch (e : Exception) {
            e.printStackTrace()
            return null
        }

        val qrCodeWidth = bitMatrix.width
        val qrCodeHeight = bitMatrix.height
        val datapixels = IntArray(qrCodeWidth*qrCodeHeight)

        for (y in 0 until qrCodeHeight) {
            val offset = y * qrCodeWidth
            for (x in 0 until qrCodeWidth) {
                datapixels[offset + x] = if (bitMatrix[x,y]) {
                    resources.getColor(R.color.black, theme)
                } else {
                    resources.getColor(R.color.white, theme)
                }
            }
        }

        val bitmap = Bitmap.createBitmap(qrCodeWidth, qrCodeHeight, Bitmap.Config.RGB_565)
        bitmap.setPixels(datapixels,0,qrCodeWidth,0,0,qrCodeWidth,qrCodeHeight)
        return bitmap
    }

    private fun releaseMediaPlayer() {
        if (mediaPlayer.isPlaying) {
            mediaPlayer.stop()
        }
        mediaPlayer.release()
    }

    override fun onDestroy() {
        releaseMediaPlayer() // Release the media player when the activity is destroyed
        super.onDestroy()
    }
}