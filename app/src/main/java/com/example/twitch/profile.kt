package com.example.twitch

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageButton
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.widget.Toolbar
import kotlinx.android.synthetic.main.activity_profile.*

class profile : AppCompatActivity() {
    private lateinit var name :TextView
    private lateinit var btnBack:ImageButton
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_profile)
        val  name=intent.getStringExtra("name")
        nameUser.text   =name

        // Uso de SetOnMenuItemClickListener para selecionar los diferentes botones del menu. When=Switch
        val profileMenu=findViewById<Toolbar>(R.id.toolbarProfile)
        profileMenu.setOnMenuItemClickListener{
            item ->
            when (item.itemId) {
                R.id.privacy ->{
                    Toast.makeText(applicationContext,"Abriendo privacidad",Toast.LENGTH_SHORT).show()
                    return@setOnMenuItemClickListener true
                }
                R.id.security ->{
                    Toast.makeText(applicationContext,"Abriendo security",Toast.LENGTH_SHORT).show()
                    return@setOnMenuItemClickListener true
                }
                R.id.configuration ->{
                    Toast.makeText(applicationContext,"Abriendo configuration",Toast.LENGTH_SHORT).show()
                    return@setOnMenuItemClickListener true
                }
            }
            false
        }

        //Finalizar Activity

        btnBack=findViewById(R.id.backCuenta)
        btnBack.setOnClickListener {
            finish()
        }
    }
}