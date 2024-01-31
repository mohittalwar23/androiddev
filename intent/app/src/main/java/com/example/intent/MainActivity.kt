package com.example.intent

import android.content.Intent
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView

class MainActivity : AppCompatActivity() {
    lateinit var name : TextView
    lateinit var age : TextView
    lateinit var sendb : Button
    lateinit var google1 : Button
    lateinit var shareButton: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        name = findViewById(R.id.inputName)
        age = findViewById(R.id.inputAge)
        sendb = findViewById(R.id.submit)
        google1 = findViewById(R.id.openG)
        shareButton = findViewById(R.id.shareB)



        sendb.setOnClickListener{
            var userName:String = name.text.toString()
            var userAge:Int = age.text.toString().toInt()
            intent = Intent(this@MainActivity,SecondActivity::class.java)
            intent.putExtra("username",userName)
            intent.putExtra("userage",userAge)
            startActivity(intent)
        }

        google1.setOnClickListener {
            val intent = Intent(Intent.ACTION_VIEW, Uri.parse("https://www.google.com/"))
            startActivity(intent)
        }
        shareButton.setOnClickListener {
            val textToShare = name.text.toString()
            val shareIntent = Intent().apply {
                action = Intent.ACTION_SEND
                type = "text/plain"
                putExtra(Intent.EXTRA_TEXT, textToShare)
            }
            startActivity(Intent.createChooser(shareIntent, "Share via"))
        }

    }
}