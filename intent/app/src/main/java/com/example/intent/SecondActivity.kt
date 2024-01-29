package com.example.intent

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView

class SecondActivity : AppCompatActivity() {
    lateinit var resultf: TextView
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_second)

        resultf = findViewById(R.id.resultFinal)

        var name : String = intent.getStringExtra("username").toString()
        var age : Int = intent.getIntExtra("userage",0).toString().toInt()

        resultf.text="Your name is $name and age is $age"


    }
}