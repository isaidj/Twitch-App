package com.example.twitch

import android.content.DialogInterface
import android.content.Intent
import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.MenuItem
import android.view.View
import android.widget.Toast
import androidx.appcompat.widget.Toolbar
import androidx.annotation.RequiresApi
import androidx.appcompat.app.AlertDialog
import androidx.fragment.app.Fragment
import androidx.navigation.findNavController
import com.google.android.material.bottomnavigation.BottomNavigationView
import android.view.Gravity
import android.widget.ImageButton
import android.widget.ImageView


class MainActivity : AppCompatActivity() {
    // creamos variable para el nav view
    private lateinit var btnNavView: BottomNavigationView
    private lateinit var iconUser: ImageButton


    @RequiresApi(Build.VERSION_CODES.LOLLIPOP)
    override fun onCreate(savedInstanceState: Bundle?) {

        setTheme(R.style.Theme_Twitch)
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        //message dialog en middlemenu

        ToastTopMenu()


        //fragmentos
        val fragmentDiscover=FragmentDiscover()
        val  fragmentFavorite=FragmentFavorite()
        val  fragmentBrowse=FragmentBrowse()




        makeCurrentFragment(fragmentDiscover)

        //       Buscamos id de nav view

        btnNavView = findViewById(R.id.bottomNavigationView)
        btnNavView.menu.getItem(1).isChecked = true

        iconUser=findViewById(R.id.imageView7)
        iconUser.setOnClickListener {
            CallProfile()
        }


        //
     btnNavView.setOnNavigationItemSelectedListener {

         when (it.itemId){

             R.id.fragmentDiscover -> makeCurrentFragment(fragmentDiscover)
             R.id.fragmentFavorite -> makeCurrentFragment(fragmentFavorite)
             R.id.fragmentBrowse -> makeCurrentFragment(fragmentBrowse)
         }
         true
     }




    }

    private fun ToastTopMenu() {
        val topmenu=findViewById<Toolbar>(R.id.topMenu)
        topmenu.setOnMenuItemClickListener { item ->
            when (item.itemId) {
                R.id.iconNotification -> {


                    Toast.makeText(applicationContext, "No tienes notificaciones", Toast.LENGTH_SHORT).show()


                    return@setOnMenuItemClickListener true
                }
                R.id.iconMessage -> {

                    intent=Intent(this,Messages::class.java)
                    startActivity(intent)

                    return@setOnMenuItemClickListener true
                }
                R.id.iconSearch -> {


                    Toast.makeText(applicationContext, "Busqueda no disponible", Toast.LENGTH_SHORT).show()


                    return@setOnMenuItemClickListener true
                }

            }
            false
        }
    }

    private fun makeCurrentFragment(fragment: Fragment)=supportFragmentManager.beginTransaction().apply {

    replace(R.id.nav_host_fragment, fragment)
        commit()
    }

    private fun CallProfile(){
        intent= Intent(this,profile::class.java)

        startActivity(intent)
    }



}