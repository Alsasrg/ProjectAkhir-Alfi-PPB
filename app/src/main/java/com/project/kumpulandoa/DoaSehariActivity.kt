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

class DoaSehariActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_doasehari)

        val doaSehari = findViewById<RecyclerView>(R.id.rvdoasehari)
        ApiConfig.getService().getdoa2().enqueue(object : Callback<ResponseDoaSehari>{
            override fun onResponse(
                call: Call<ResponseDoaSehari>,
                response: Response<ResponseDoaSehari>
            ) {
                if (response.isSuccessful) {
                    val responseDoaHadits = response.body()
                    val dataDoaSehari = responseDoaHadits?.data
                    val doaHaditsAdapter = DoaAlquranAdapter(dataDoaSehari)
                    doaSehari.apply {
                        layoutManager = LinearLayoutManager(this@DoaSehariActivity)
                        setHasFixedSize(true)
                        adapter = doaHaditsAdapter
                        doaHaditsAdapter.notifyDataSetChanged()
                    }
                }
            }

            override fun onFailure(call: Call<ResponseDoaSehari>, t: Throwable) {
                Toast.makeText(applicationContext, t.localizedMessage, Toast.LENGTH_SHORT).show()
            }

        })


    }
}

private fun <T> Call<T>.enqueue(callback: Callback<ResponseDoaSehari>) {
            TODO("Not yet implemented")
}
