package com.example.twitch

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageButton

class Messages : AppCompatActivity() {
    private lateinit var backChat:ImageButton
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_messages)
        backChat=findViewById(R.id.backChat)

        //Para finalizar la Activity
        backChat.setOnClickListener {
            finish()
        }
    }
}