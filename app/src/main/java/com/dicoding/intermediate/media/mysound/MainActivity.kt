package com.dicoding.intermediate.media.mysound

import android.media.SoundPool
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.Toast

class MainActivity : AppCompatActivity() {

    private lateinit var sp: SoundPool
    private var soundId = 0
    private var spLoaded = false

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        sp = SoundPool.Builder()
            .setMaxStreams(10)
            .build()
        
        sp.setOnLoadCompleteListener { _, _, status ->
            if (status == 0) {
                spLoaded = true
            } else {
                Toast.makeText(this, "Gagal memuat data", Toast.LENGTH_SHORT).show()
            }
        }

        soundId = sp.load(this, R.raw.heavy_metal_door, 1)

        val btnSound = findViewById<Button>(R.id.btn_sound_pool)

        btnSound.setOnClickListener {
            if (spLoaded) {
                sp.play(soundId, 1f, 1f, 0, 0, 1f)
            }
        }

    }

}