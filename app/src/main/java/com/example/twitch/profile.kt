package com.example.twitch

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageButton

class profile : AppCompatActivity() {

    private lateinit var btnBack:ImageButton
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_profile)
        btnBack=findViewById(R.id.backCuenta)
        btnBack.setOnClickListener {
            intent=Intent(this,MainActivity::class.java)
            startActivity(intent)
        }
    }
}