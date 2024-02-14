package com.example.catmeymey

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.catmeymey.adapter.CatCardAdapter

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // Get the RecyclerView from the layout
        val recyclerView: RecyclerView = findViewById(R.id.recyclerView)

        // Create an instance of the CatCardAdapter and set it on the RecyclerView
        val catCardAdapter = CatCardAdapter(this, R.layout.vertical)
        recyclerView.adapter = catCardAdapter

        // Set a LinearLayoutManager on the RecyclerView
        recyclerView.layoutManager = LinearLayoutManager(this)
    }
}
