package com.project.kumpulandoa

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle

class DashboardActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_dashboard)

        val cardView1= findViewById<androidx.cardview.widget.CardView>(R.id.cdKat1alquran)

        cardView1.setOnClickListener {
            val intent = Intent(this, DoaAlquranActivity::class.java)
            startActivity(intent)
        }
        val cardView2= findViewById<androidx.cardview.widget.CardView>(R.id.cdkat2hadits)

        cardView2.setOnClickListener {
            val intent = Intent(this, DoaHaditsActivity::class.java)
            startActivity(intent)
        }

        val cardView3= findViewById<androidx.cardview.widget.CardView>(R.id.cdkat3sehari)

        cardView3.setOnClickListener {
            val intent = Intent(this, DoaSehariActivity::class.java)
            startActivity(intent)
        }

        val cardView4= findViewById<androidx.cardview.widget.CardView>(R.id.cdkat4sunnah)

        cardView4.setOnClickListener {
            val intent = Intent(this, DoaSunnahActivity::class.java)
            startActivity(intent)
        }

    }
}