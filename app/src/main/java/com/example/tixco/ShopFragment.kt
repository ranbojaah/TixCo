package com.example.tixco

import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.appcompat.widget.SearchView
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.tixco.adapter.ShopAdapter
import com.example.tixco.databinding.FragmentShopBinding
import com.example.tixco.modal.Shop
import java.util.*
import kotlin.collections.ArrayList

class ShopFragment : Fragment() {

    private lateinit var rvShop: RecyclerView
    private var binding: FragmentShopBinding? = null
    private lateinit var tiketList: ArrayList<Shop>
    private lateinit var shopAdapter: ShopAdapter
    private lateinit var searchView: SearchView

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view =  inflater.inflate(R.layout.fragment_shop, container, false)

        //recycler
        rvShop = view.findViewById(R.id.rv_shop)
        rvShop.setHasFixedSize(true)
        rvShop.layoutManager = LinearLayoutManager(requireContext(), RecyclerView.VERTICAL,false)

        tiketList = ArrayList()

        tiketList.add(Shop(R.drawable.koc,"Rp1.000.000", "Rp800.000", "Rp792.000", "KINGS OF CONVENIENCE",R.drawable.kocdetail, "9 Maret 2023", "Ballroom The Ritz-Carlton, Pacific Place, Jakarta", 1000000, 880000, 792000))
        tiketList.add(Shop(R.drawable.neyo,"Rp1.250.000", "Rp900.000", "Rp600.000","NE-YO", R.drawable.neyodetail, "17 Januari 2023", "Hall D2 JIExpo Kemayoran, Jakarta",1250000, 900000, 600000))
        tiketList.add(Shop(R.drawable.sheila,"Rp950.000", "Rp750.000", "Rp450.000","SHEILA ON 7", R.drawable.sheiladetail, "31 Desember 2033 - 1 Januari 2023", "kawasan Garuda Wisnu Kencana", 950000, 750000, 450000))
        tiketList.add(Shop(R.drawable.wuf,"Rp1.125.000", "Rp875.000", "Rp700.000","WOKE UP FEST",R.drawable.wufdetail, "25 Februari 2023", "Istora Senayan dan Parkir Selatan Senayan, Jakarta", 1125000, 875000, 700000))
        tiketList.add(Shop(R.drawable.bp,"Rp3.835.000", "Rp2.935.000", "Rp1.385.000", "BLACK PINK BORN PINK",R.drawable.bpdetail, "11 Maret 2023 - 12 Maret 2023", "Stadion Utama Gelora Bung Karno (SUGBK), Jakarta Selatan.", 3835000, 2935000, 1385000))

        shopAdapter = ShopAdapter(tiketList)
        rvShop.adapter = shopAdapter

        //intent detail
        shopAdapter.onItemClick= {
            val intent = Intent(requireContext(), DetailShop::class.java)
            intent.putExtra("shp", it)
            startActivity(intent)
        }

        //search
        searchView = view.findViewById(R.id.searchView)
        searchView.setOnQueryTextListener(object : SearchView.OnQueryTextListener{
            override fun onQueryTextSubmit(query: String?): Boolean {
                return false
            }

            override fun onQueryTextChange(newText: String?): Boolean {
                fileList(newText)
                return true
            }

        })

        return view
    }

    private fun fileList(newText: String?) {
        if (newText != null ){
            val filteredList = kotlin.collections.ArrayList<Shop>()
            for (i in tiketList){
                if (i.name.lowercase(Locale.ROOT).contains(newText)){
                    filteredList.add(i)
                }
            }

            if (filteredList.isEmpty()){
                Toast.makeText(requireContext(), "No Data Found", Toast.LENGTH_SHORT).show()
            }else{
                shopAdapter.setFilteredList(filteredList)
            }
        }
    }

}