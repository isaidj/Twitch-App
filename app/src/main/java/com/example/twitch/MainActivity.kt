package com.example.twitch

import android.content.DialogInterface
import android.content.Intent
import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.MenuItem
import android.view.View
import android.widget.Toast

import androidx.annotation.RequiresApi
import androidx.appcompat.app.AlertDialog
import androidx.fragment.app.Fragment
import androidx.navigation.findNavController
import com.google.android.material.bottomnavigation.BottomNavigationView
import android.view.Gravity
import android.widget.ImageButton
import android.widget.ImageView
import androidx.appcompat.widget.Toolbar
import kotlinx.android.synthetic.main.activity_main.*


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
//        ToastMiddleMenu()
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


        //Sistema de navegacion de Fragmentos
     btnNavView.setOnNavigationItemSelectedListener {

         when (it.itemId){

             R.id.fragmentDiscover -> makeCurrentFragment(fragmentDiscover)
             R.id.fragmentFavorite -> makeCurrentFragment(fragmentFavorite)
             R.id.fragmentBrowse -> makeCurrentFragment(fragmentBrowse)
         }
         true
     }

        imageView7.setOnClickListener {
            CallProfile()

            Toast.makeText(applicationContext,"Abriendo", Toast.LENGTH_SHORT).show()

        }





    }
    // Funcion de menu Top

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

//    private fun ToastMiddleMenu() {
//
//        val fragment :Fragment
//
//        val middleMenu=findViewById<Toolbar>(R.id.toolbar2)
//        middleMenu.setOnMenuItemClickListener { item ->
//            when (item.itemId) {
//                R.id.noShow -> {
//
//
//                    Toast.makeText(this,"No se volverá a mostrar",Toast.LENGTH_SHORT).show()
//
//
//                    return@setOnMenuItemClickListener true
//                }
//                R.id.removeCategory -> {
//
//                    Toast.makeText(this,"Categoria removida",Toast.LENGTH_SHORT).show()
//
//                    return@setOnMenuItemClickListener true
//                }
//                R.id.reportCategory -> {
//
//
//                    Toast.makeText(this,"Categoria reportada",Toast.LENGTH_SHORT).show()
//
//
//                    return@setOnMenuItemClickListener true
//                }
//
//            }
//            false
//        }
//    }
//Intent a Profile y Enviamos nombre
    private fun CallProfile(){
        val  name=intent.getStringExtra("name")
        intent= Intent(this,profile::class.java).apply {
            putExtra("name",name)
        }

        startActivity(intent)
    }

    private fun makeCurrentFragment(fragment: Fragment)=supportFragmentManager.beginTransaction().apply {

    replace(R.id.nav_host_fragment, fragment)
        commit()
    }





}