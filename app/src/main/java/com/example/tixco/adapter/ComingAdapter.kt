package com.example.tixco.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import androidx.recyclerview.widget.RecyclerView
import com.example.tixco.R
import com.example.tixco.modal.Coming

class ComingAdapter (var comingList: ArrayList<Coming>) :
    RecyclerView.Adapter<ComingAdapter.ComingViewHolder>(){

    var onItemClick: ((Coming) -> Unit)? = null

    inner class ComingViewHolder(view : View): RecyclerView.ViewHolder(view){
        val ivComing : ImageView = view.findViewById(R.id.iv_konsercoming)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ComingViewHolder {
        val view : View = LayoutInflater.from(parent.context).inflate(R.layout.list_coming, parent,false)
        return ComingViewHolder(view)
    }

    override fun getItemCount(): Int {
        return comingList.size
    }

    override fun onBindViewHolder(holder: ComingViewHolder, position: Int) {
        val coming : Coming = comingList[position]
        holder.ivComing.setImageResource(coming.imageComing)

        holder.itemView.setOnClickListener{
            onItemClick?.invoke(coming)
        }
    }

}