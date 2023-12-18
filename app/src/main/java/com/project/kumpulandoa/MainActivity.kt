package com.project.kumpulandoa

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val actButton= findViewById<Button>(R.id.btn_login)

        actButton.setOnClickListener {
            val intent = Intent(this, LoginActivity::class.java)
            startActivity(intent)
        }

        val actButton1= findViewById<Button>(R.id.btn_register)

        actButton1.setOnClickListener {
            val intent = Intent(this, RegisterActivity::class.java)
            startActivity(intent) }
    }
}