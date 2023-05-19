package com.example.tixco

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageView
import android.widget.TextView
import com.example.tixco.databinding.ActivityDetailComingBinding
import com.example.tixco.databinding.FragmentProfileBinding
import com.example.tixco.modal.Coming
import com.google.firebase.auth.FirebaseAuth

class DetailComing : AppCompatActivity() {
    lateinit var binding: ActivityDetailComingBinding
    lateinit var firebaseAuth: FirebaseAuth
    lateinit var desc: TextView
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityDetailComingBinding.inflate(layoutInflater)
        setContentView(binding.root)
        firebaseAuth = FirebaseAuth.getInstance()

        binding.backHome.setOnClickListener {
            onBackPressed()
        }

        val coming = intent.getParcelableExtra<Coming>("coming")
        if(coming != null){
            val title: TextView = findViewById(R.id.tv_cs_judul)
            val image : ImageView = findViewById(R.id.iv_cs_foto)
            desc = findViewById(R.id.deskripsiComing)

            title.text = coming.titleComing
            image.setImageResource(coming.imageIntn)
            desc.text = coming.descComing
        }
    }
}