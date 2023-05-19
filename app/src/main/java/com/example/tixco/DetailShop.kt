package com.example.tixco

import DetailPembelianFragment
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import com.example.tixco.databinding.ActivityDetailShopBinding
import com.example.tixco.modal.Shop
import com.google.firebase.auth.FirebaseAuth
import java.text.NumberFormat
import java.util.*

class DetailShop : AppCompatActivity() {
    lateinit var binding : ActivityDetailShopBinding
    lateinit var firebaseAuth: FirebaseAuth
    var h_vvip = 0
    var h_vip = 0
    var h_reg = 0
    var numVvip = 0
    var numVip = 0
    var numReg = 0
    lateinit var shop : Shop
    override fun onCreate(savedInstanceState: Bundle?) {
        binding = ActivityDetailShopBinding.inflate(layoutInflater)
        super.onCreate(savedInstanceState)
        setContentView(binding.root)
        firebaseAuth = FirebaseAuth.getInstance()

        binding.back.setOnClickListener {
            onBackPressed()
        }


        shop = intent.getParcelableExtra<Shop>("shp")!!
        if (shop != null) {
            with(binding) {
                tvDetailtitle.text = shop.name
                ivDetailshop.setImageResource(shop.imagadet)
                tanggal.text = shop.jadwal
                tempat.text = shop.tempat
                hVvip.text = shop.vvip
                hVip.text = shop.vip
                hReg.text = shop.reguler
                h_vvip = shop.hargavvip
                h_vip = shop.hargavip
                h_reg = shop.hargareg
            }
        }

        binding.plusvvip.setOnClickListener {
            numVvip++
            binding.angkaVvip.text = numVvip.toString()
            updateTotalItemAndHarga()
        }

        binding.minvvip.setOnClickListener {
            if (numVvip > 0) {
                numVvip--
                binding.angkaVvip.text = numVvip.toString()
                updateTotalItemAndHarga()
            }
        }

        binding.plusvip.setOnClickListener {
            numVip++
            binding.totalvip.text = numVip.toString()
            updateTotalItemAndHarga()
        }
        binding.minvip.setOnClickListener {
            if (numVip > 0) {
                numVip--
                binding.totalvip.text = numVip.toString()
                updateTotalItemAndHarga()
            }
        }
        binding.plusreg.setOnClickListener {
            numReg++
            binding.totalreg.text = numReg.toString()
            updateTotalItemAndHarga()
        }
        binding.minreg.setOnClickListener {
            if (numReg > 0) {
                numReg--
                binding.totalreg.text = numReg.toString()
                updateTotalItemAndHarga()
            }
        }
        binding.pesan.setOnClickListener {
            val totalTiket = binding.itemTotal.text.toString().toInt()
            val totalHarga = binding.hargaTotal.text.toString()

            val fragment = DetailPembelianFragment.newInstance(
                numVvip,
                numVip,
                numReg,
                numVvip * h_vvip,
                numVip * h_vip,
                numReg * h_reg,
                totalTiket,
                totalHarga
            )

            fragment.show(supportFragmentManager, "DetailPembelianFragment")
        }
    }

    private fun updateTotalItemAndHarga() {
        val totalItem = numVvip + numVip + numReg
        val totalHarga = (numVvip * h_vvip) + (numVip * h_vip) + (numReg * h_reg)
        with(binding) {
            angkaVvip.text = numVvip.toString()
            totalvip.text = numVip.toString()
            totalreg.text = numReg.toString()
            itemTotal.text = totalItem.toString()
            hargaTotal.text = formatCurrency(totalHarga)
        }
    }

    private fun formatCurrency(i: Int): CharSequence? {
        val currencyFormat = NumberFormat.getCurrencyInstance(Locale("id", "ID"))
        currencyFormat.maximumFractionDigits = 0
        return currencyFormat.format(i)
    }
    companion object {
        private const val ARG_NUM_VVIP = "num_vvip"
        private const val ARG_NUM_VIP = "num_vip"
        private const val ARG_NUM_REG = "num_reg"
        private const val ARG_TOTAL_HARGA_VVIP = "total_harga_vvip"
        private const val ARG_TOTAL_HARGA_VIP = "total_harga_vip"
        private const val ARG_TOTAL_HARGA_REG = "total_harga_reg"
        private const val ARG_TOTAL_ITEM = "total_item"
        private const val ARG_TOTAL_HARGA = "total_harga"
    }
}