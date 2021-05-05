package com.example.twitch

import android.app.AlertDialog
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.util.Log
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast



class SignIn : AppCompatActivity() {

    //asignamos variables
    private lateinit var btnSingIn:Button
    private lateinit var email : EditText
    private lateinit var username : EditText
    private lateinit var password : EditText



    override fun onCreate(savedInstanceState: Bundle?) {



        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_sign_in)

        // Get the Intent that started this activity and extract the string

//Obtenemos componentes

        email=findViewById(R.id.fieldUsername4)
        username=findViewById(R.id.fieldUsername)
        password=findViewById(R.id.fieldPassword)
        btnSingIn= findViewById<Button>(R.id.btnSignUp)




        btnSingIn.setOnClickListener () {



//Estrucutra de un AlertDialog

            val builder = AlertDialog.Builder(this)


            builder.setTitle("Create account")
            builder.setMessage("¿Do you want create this account?")
            builder.setPositiveButton("Ok"){dialog, which ->
                Toast.makeText(applicationContext,"Creada",Toast.LENGTH_SHORT).show()

                CallMainMenu()

            }
            builder.setNegativeButton("Cancel"){dialog, which ->
                dialog.cancel()
            }
            val dialog: AlertDialog = builder.create()

            // Display the alert dialog on app interface


            dialog.show()
        }


    }

    //Lammamos el intent MainActivity
private fun CallMainMenu (){


intent = Intent(this,MainActivity::class.java).apply {
    putExtra("name",username.editableText.toString())
}

    startActivity(intent)


}
}