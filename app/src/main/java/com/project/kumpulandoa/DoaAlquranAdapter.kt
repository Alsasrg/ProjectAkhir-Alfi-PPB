package com.project.kumpulandoa

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class DoaAlquranAdapter(val dataDoa: List<DataItem?>?) : RecyclerView.Adapter<DoaAlquranAdapter.MyViewHolder>() {
    class MyViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val Judul = view.findViewById<TextView>(R.id.judul)

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.row_mainv, parent, false)
        return MyViewHolder(view)
    }

    override fun getItemCount(): Int {
        if (dataDoa != null){
            return dataDoa.size
        }
        return 0
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        holder.Judul.text =  dataDoa?.get(position)?.namaDoa

//        holder.itemView.setOnClickListener{
//            val Judul = dataDoa?.get(position)?.namaDoa
//            Toast.makeText(holder.itemView.context, "${Judul}", Toast.LENGTH_SHORT).show()
//        }

    }

}
