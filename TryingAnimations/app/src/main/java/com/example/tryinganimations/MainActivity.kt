package com.example.tryinganimations

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import com.daimajia.androidanimations.library.Techniques
import com.daimajia.androidanimations.library.YoYo

class MainActivity : AppCompatActivity() {
    lateinit var b1:Button
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        b1=findViewById(R.id.animateButton)

        b1.setOnClickListener{
            YoYo.with(Techniques.Tada)
                .duration(700)
                .repeat(5)
                .playOn(findViewById(R.id.textView));

        }

    }
}