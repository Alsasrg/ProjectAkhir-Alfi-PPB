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

class DoaHaditsActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_doahadits)

        val doaHaditsRecyclerView = findViewById<RecyclerView>(R.id.rvdoahadist)
        ApiConfig.getService().getdoa2().enqueue(object : Callback<ResponseDoaHadits> {
            override fun onResponse(
                call: Call<ResponseDoaHadits>, response: Response<ResponseDoaHadits>
            ) {
                if (response.isSuccessful) {
                    val responseDoaHadits = response.body()
                    val doa = responseDoaHadits?.data
                    val doaHaditsAdapter = DoaAlquranAdapter(doa)
                    doaHaditsRecyclerView.apply {
                        layoutManager = LinearLayoutManager(this@DoaHaditsActivity)
                        setHasFixedSize(true)
                        adapter = doaHaditsAdapter
                        doaHaditsAdapter.notifyDataSetChanged()
                    }
                }
            }

            override fun onFailure(call: Call<ResponseDoaHadits>, t: Throwable) {
                Toast.makeText(applicationContext, t.localizedMessage, Toast.LENGTH_SHORT).show()
            }
        })

        val actButton = findViewById<Button>(R.id.button)

        actButton.setOnClickListener {
            val intent = Intent(this, DashboardActivity::class.java)
            startActivity(intent)
        }
    }
}
