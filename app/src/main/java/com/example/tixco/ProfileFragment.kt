package com.example.tixco

import android.app.AlertDialog
import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.tixco.databinding.FragmentProfileBinding
import com.google.firebase.auth.FirebaseAuth

class ProfileFragment : Fragment() {
    lateinit var binding: FragmentProfileBinding
    lateinit var firebaseAuth: FirebaseAuth
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding = FragmentProfileBinding.bind(inflater.inflate(R.layout.fragment_profile, container, false))

        // Inisialisasi firebaseAuth

        firebaseAuth = FirebaseAuth.getInstance()

        val logout = binding.logout
        logout.setOnClickListener {
            showLogoutConfirmationDialog()
        }
        //ngambil nama user
        val currentUser = firebaseAuth.currentUser
        if (currentUser != null){
            val email = currentUser.email
            val username = email?.substring(0,email.indexOf("@"))?.capitalize()
            binding.nameProfile.text = username
        }

        //ngambil email user
        val emailUser = firebaseAuth.currentUser
        if (emailUser != null) {
            val email = emailUser.email
            binding.emailUser.text = email
        }


        return binding.root
    }
    private fun showLogoutConfirmationDialog() {
        val builder = AlertDialog.Builder(requireContext())
        builder.setTitle("Logout")
        builder.setMessage("Are you sure you want to logout?")
        builder.setPositiveButton("Logout") { dialog, _ ->
            dialog.dismiss()
            logout()
        }
        builder.setNegativeButton("Cancel") { dialog, _ ->
            dialog.dismiss()
        }
        val dialog = builder.create()
        dialog.show()
    }
    private fun logout() {
        FirebaseAuth.getInstance().signOut()
        val intent = Intent(context, Login::class.java)
        startActivity(intent)
        requireActivity().finish() // Optional: Finish the current activity after logout
    }

}