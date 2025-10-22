package com.fahmi.myapplication

import android.content.Intent
import android.os.Bundle
import android.widget.RadioButton
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.fahmi.myapplication.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.btnSubmit.setOnClickListener {
            submitForm()
        }
    }

    private fun submitForm() {
        val fullName = binding.etFullName.text.toString().trim()
        val nickname = binding.etNickname.text.toString().trim()
        val age = binding.etAge.text.toString().trim()
        val email = binding.etEmail.text.toString().trim()
        val password = binding.etPassword.text.toString()
        val confirmPassword = binding.etConfirmPassword.text.toString()

        val selectedGenderId = binding.rgJenisKelamin.checkedRadioButtonId
        val gender = if (selectedGenderId != -1) {
            findViewById<RadioButton>(selectedGenderId).text.toString()
        } else {
            ""
        }

        if (fullName.isEmpty() || nickname.isEmpty() || age.isEmpty() || password.isEmpty() || confirmPassword.isEmpty() || gender.isEmpty()) {
            Toast.makeText(this, "Semua kolom wajib diisi!", Toast.LENGTH_SHORT).show()
            return
        }

        if (password != confirmPassword) {
            binding.etConfirmPassword.error = "Password tidak cocok!"
            Toast.makeText(this, "Password dan konfirmasi tidak cocok", Toast.LENGTH_SHORT).show()
            return
        } else {
            binding.etConfirmPassword.error = null
        }

        val intent = Intent(this, ResultActivity::class.java)

        intent.putExtra(ResultActivity.EXTRA_FULLNAME, fullName)
        intent.putExtra(ResultActivity.EXTRA_NICKNAME, nickname)
        intent.putExtra(ResultActivity.EXTRA_AGE, age)
        intent.putExtra(ResultActivity.EXTRA_EMAIL, email)
        intent.putExtra(ResultActivity.EXTRA_GENDER, gender)

        startActivity(intent)
    }
}