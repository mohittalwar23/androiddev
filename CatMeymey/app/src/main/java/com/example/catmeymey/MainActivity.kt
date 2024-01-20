package com.example.catmeymey

import android.annotation.SuppressLint
import android.media.MediaPlayer
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageView

class MainActivity : AppCompatActivity() {
    private var happySong: MediaPlayer? = null
    private var happyImage: ImageView? = null

    private var maxwellSong: MediaPlayer? = null
    private var maxwellImage: ImageView? = null

    private var bananaSong: MediaPlayer? = null
    private var bananaImage: ImageView? = null

    private var chippiSong: MediaPlayer? = null
    private var chippiImage: ImageView? = null

    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        happyImage = findViewById(R.id.imageView2) // Correct ID
        happySong = MediaPlayer.create(this, R.raw.happy)

        happyImage!!.setOnClickListener {
            happySong?.start() // Use safe call operator to avoid NullPointerException
        }
        maxwellImage = findViewById(R.id.imageView3) // Correct ID
        maxwellSong = MediaPlayer.create(this, R.raw.maxwell)

        maxwellImage!!.setOnClickListener {
            maxwellSong?.start() // Use safe call operator to avoid NullPointerException
        }
        bananaImage = findViewById(R.id.imageView4) // Correct ID
        bananaSong = MediaPlayer.create(this, R.raw.banana)

        bananaImage!!.setOnClickListener {
            bananaSong?.start() // Use safe call operator to avoid NullPointerException
        }
        chippiImage = findViewById(R.id.imageView5) // Correct ID
        chippiSong = MediaPlayer.create(this, R.raw.chippi)

        chippiImage!!.setOnClickListener {
            chippiSong?.start() // Use safe call operator to avoid NullPointerException
        }
    }
}
