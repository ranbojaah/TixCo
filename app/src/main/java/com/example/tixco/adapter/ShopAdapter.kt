package com.example.tixco.adapter

import android.app.Activity
import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.tixco.R
import com.example.tixco.modal.Shop

class ShopAdapter(var tiketList: ArrayList<Shop>) : RecyclerView.Adapter<ShopAdapter.ShopViewHolder>() {

    var onItemClick: ((Shop) -> Unit)? = null

    inner class ShopViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val ivShop: ImageView = view.findViewById(R.id.fotokonser)
        val tvVip: TextView = view.findViewById(R.id.tv_vipharga)
        val tvReguler: TextView = view.findViewById(R.id.tv_hargareguler)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ShopViewHolder {
        val view: View = LayoutInflater.from(parent.context).inflate(R.layout.shop_list, parent, false)
        return ShopViewHolder(view)
    }

    override fun getItemCount(): Int {
        return tiketList.size
    }

    override fun onBindViewHolder(holder: ShopViewHolder, position: Int) {
        val shop: Shop = tiketList[position]
        holder.ivShop.setImageResource(shop.image)
        holder.tvVip.text = shop.vip
        holder.tvReguler.text = shop.reguler

        holder.itemView.setOnClickListener {
            onItemClick?.invoke(shop)
        }
    }

    fun setFilteredList(tiketList: List<Shop>){
        this.tiketList = tiketList as ArrayList<Shop>
        notifyDataSetChanged()
    }
}
