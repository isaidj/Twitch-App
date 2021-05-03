package com.example.twitch


import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.util.Log
import android.widget.Button
import android.widget.EditText
import androidx.core.widget.addTextChangedListener
import androidx.core.widget.doOnTextChanged
import com.google.android.material.bottomnavigation.BottomNavigationView


class Login : AppCompatActivity() {


private lateinit var name: EditText
private lateinit var password: EditText
private lateinit var btnlog: Button
private lateinit var btnSignIn: Button



    override fun onCreate(savedInstanceState: Bundle?) {

        Thread.sleep(2000)
        setTheme(R.style.Theme_Twitch)
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)

        name=findViewById(R.id.fieldUsername)
        password=findViewById(R.id.fieldPassword)
        btnlog=findViewById(R.id.btnLogin)
        btnSignIn=findViewById(R.id.btnSignUpLog)




        btnlog.setOnClickListener(){

            intent = Intent(this,MainActivity::class.java).apply {
                putExtra("name",name.text.toString())
            }

            startActivity(intent)
        }

        btnSignIn.setOnClickListener(){

            intent = Intent(this,SignIn::class.java).apply {
                putExtra("name",name.text.toString())
            }

            startActivity(intent)
        }


        name.addTextChangedListener (object : TextWatcher{
            override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {
                Log.i("beforeTextChanged:  ","Not override")
            }

            override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {
                if(name.length()>1){
                    btnlog.isEnabled=true
                }
                if(name.length()<=1){
                    btnlog.isEnabled=false
                }
            }

            override fun afterTextChanged(s: Editable?) {
                Log.i("afterTextChanged:  ","Not override")
            }

        })








    }
}