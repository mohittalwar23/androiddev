package com.example.globalactuators

import android.os.Bundle
import android.util.Log
import android.widget.ImageButton
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import com.google.firebase.database.FirebaseDatabase
import com.google.firebase.database.DataSnapshot
import com.google.firebase.database.DatabaseError
import com.google.firebase.database.ValueEventListener

class MainActivity : AppCompatActivity() {

    private val database = FirebaseDatabase.getInstance().reference
    private val ledStateRef = database.child("led_state")
    private lateinit var stateTextView: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val toggleButton = findViewById<ImageButton>(R.id.imageButton)
        stateTextView = findViewById(R.id.stateTextView)

        toggleButton.setOnClickListener {
            toggleLEDState()
        }

        // Read initial LED state
        readLEDState()
    }

    private fun toggleLEDState() {
        ledStateRef.addListenerForSingleValueEvent(object : ValueEventListener {
            override fun onDataChange(dataSnapshot: DataSnapshot) {
                val currentState = dataSnapshot.getValue(String::class.java)
                val newState = if (currentState == "on") "off" else "on"
                ledStateRef.setValue(newState)
            }

            override fun onCancelled(databaseError: DatabaseError) {
                // Handle errors
                Log.e("Firebase", "Failed to read value.", databaseError.toException())
            }
        })
    }

    private fun readLEDState() {
        ledStateRef.addValueEventListener(object : ValueEventListener {
            override fun onDataChange(dataSnapshot: DataSnapshot) {
                val currentState = dataSnapshot.getValue(String::class.java)
                currentState?.let {
                    stateTextView.text = "State: $it"
                }
            }

            override fun onCancelled(databaseError: DatabaseError) {
                // Handle errors
                Log.e("Firebase", "Failed to read value.", databaseError.toException())
            }
        })
    }
}
