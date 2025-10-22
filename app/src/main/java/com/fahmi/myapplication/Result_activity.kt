package com.fahmi.myapplication

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.fahmi.myapplication.databinding.ActivityResultBinding

class ResultActivity : AppCompatActivity() {

    private lateinit var binding: ActivityResultBinding


    companion object {
        const val EXTRA_FULLNAME = "EXTRA_FULLNAME"
        const val EXTRA_NICKNAME = "EXTRA_NICKNAME"
        const val EXTRA_AGE = "EXTRA_AGE"
        const val EXTRA_EMAIL = "EXTRA_EMAIL"
        const val EXTRA_GENDER = "EXTRA_GENDER"
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityResultBinding.inflate(layoutInflater)
        setContentView(binding.root)


        val fullName = intent.getStringExtra(EXTRA_FULLNAME)
        val nickname = intent.getStringExtra(EXTRA_NICKNAME)
        val age = intent.getStringExtra(EXTRA_AGE)
        val email = intent.getStringExtra(EXTRA_EMAIL) //
        val gender = intent.getStringExtra(EXTRA_GENDER)


        binding.tvResultFullName.text = "Nama Lengkap: $fullName"
        binding.tvResultNickname.text = "Nama Panggilan: $nickname"
        binding.tvResultAge.text = "Umur: $age"
        binding.tvResultEmail.text = "Email: $email"
        binding.tvResultJenisKelamin.text = "Jenis Kelamin: $gender"
    }
}