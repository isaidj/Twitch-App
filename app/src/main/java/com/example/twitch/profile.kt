package com.example.twitch

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageButton
import android.widget.TextView

class profile : AppCompatActivity() {
    private lateinit var name :TextView
    private lateinit var btnBack:ImageButton
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_profile)





        btnBack=findViewById(R.id.backCuenta)
        btnBack.setOnClickListener {
            finish()
        }
    }
}