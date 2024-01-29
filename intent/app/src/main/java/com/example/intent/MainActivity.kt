package com.example.intent

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView

class MainActivity : AppCompatActivity() {
    lateinit var name : TextView
    lateinit var age : TextView
    lateinit var sendb : Button
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        name = findViewById(R.id.inputName)
        age = findViewById(R.id.inputAge)
        sendb = findViewById(R.id.submit)

        sendb.setOnClickListener{
            var userName:String = name.text.toString()
            var userAge:Int = age.text.toString().toInt()
            intent = Intent(this@MainActivity,SecondActivity::class.java)
            intent.putExtra("username",userName)
            intent.putExtra("userage",userAge)
            startActivity(intent)
        }


    }
}