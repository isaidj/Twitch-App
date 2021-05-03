package com.example.twitch

import android.app.AlertDialog
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import android.widget.Toast



class SignIn : AppCompatActivity() {

    private lateinit var btnSingIn:Button
    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_sign_in)

        // Get the Intent that started this activity and extract the string
        val message = intent.getStringExtra("name")

        // Capture the layout's TextView and set the string as its text
        val textView = findViewById<TextView>(R.id.fieldUsername).apply {
            text = message
        }

        btnSingIn= findViewById<Button>(R.id.btnSignUp)
        btnSingIn.setOnClickListener () {


            val builder = AlertDialog.Builder(this)

            builder.setTitle("Create account")
            builder.setMessage("¿Do you want create this account?")
            builder.setPositiveButton("Yes"){dialog, which ->
                Toast.makeText(applicationContext,"Creada",Toast.LENGTH_SHORT).show()

                CallMainMenu()

            }
            builder.setNegativeButton("No"){dialog, which ->
                Toast.makeText(applicationContext,"C",Toast.LENGTH_SHORT).show()
            }
            val dialog: AlertDialog = builder.create()

            // Display the alert dialog on app interface


            dialog.show()
        }


    }

private fun CallMainMenu (){
intent = Intent(this,MainActivity::class.java).apply {

}
    startActivity(intent)
}
}