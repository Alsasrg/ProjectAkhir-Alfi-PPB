package com.project.kumpulandoa

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.project.kumpulandoa.api.ApiConfig
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class DoaAlquranActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_doaalquran)

        val doaalquran = findViewById<RecyclerView>(R.id.rvdoaalquran)
        ApiConfig.getService().getdoa().enqueue(object : Callback<ResponseDoaAlquran> {
            override fun onResponse(
                call: Call<ResponseDoaAlquran>, response: Response<ResponseDoaAlquran>
            ) {
                if (response.isSuccessful) {
                    val responseDoaAlquran = response.body()
                    val dataDoa = responseDoaAlquran?.data
                    val doaAlquranAdapter = DoaAlquranAdapter(dataDoa)
                    doaalquran.apply {
                        layoutManager = LinearLayoutManager(this@DoaAlquranActivity)
                        setHasFixedSize(true)
                        doaAlquranAdapter.notifyDataSetChanged()
                        adapter = doaAlquranAdapter
                    }
                }
            }

            override fun onFailure(call: Call<ResponseDoaAlquran>, t: Throwable) {
                Toast.makeText(applicationContext, t.localizedMessage, Toast.LENGTH_SHORT).show()
            }
        })

        val actButton= findViewById<Button>(R.id.button)

        actButton.setOnClickListener {
            val intent = Intent(this, DashboardActivity::class.java)
            startActivity(intent)
        }

    }
}