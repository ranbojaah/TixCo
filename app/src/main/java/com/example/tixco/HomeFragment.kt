package com.example.tixco

import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.tixco.adapter.ComingAdapter
import com.example.tixco.databinding.FragmentHomeBinding
import com.example.tixco.modal.Coming
import com.google.firebase.auth.FirebaseAuth


class HomeFragment : Fragment() {
    lateinit var firebaseAuth: FirebaseAuth
    private lateinit var rvComing : RecyclerView
    private lateinit var comingList: ArrayList<Coming>
    private lateinit var comingAdapter: ComingAdapter
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val binding = FragmentHomeBinding.bind(inflater.inflate(R.layout.fragment_home, container, false))
        firebaseAuth = FirebaseAuth.getInstance()


        //recyclerview
        rvComing = binding.rvComingsoon
        rvComing.setHasFixedSize(true)
        rvComing.layoutManager = LinearLayoutManager(requireContext(),RecyclerView.VERTICAL,false)

        comingList = ArrayList()

        comingList.add(Coming(R.drawable.westlife, "WESTLIFE", getString(R.string.desc_westlife), R.drawable.ini))
        comingList.add(Coming(R.drawable.asiansound, "ASIAN SOUND SYNDICATE VOL. 2", getString(R.string.desc_asiansound), R.drawable.asian))
        comingList.add(Coming(R.drawable.synchronize, "SYNCGRONIZE FEST", getString(R.string.desc_synchronize), R.drawable.sync))

        comingAdapter = ComingAdapter(comingList)
        rvComing.adapter = comingAdapter

        comingAdapter.onItemClick= {
            val intent = Intent(requireContext(),DetailComing::class.java)
            intent.putExtra("coming", it)
            startActivity(intent)
        }

        return binding.root
    }

}