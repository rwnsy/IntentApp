package com.example.intentapp

import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.intentapp.databinding.ActivityRegisterBinding

class RegisterActivity : AppCompatActivity() {

    private lateinit var binding: ActivityRegisterBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityRegisterBinding.inflate(layoutInflater)
        setContentView(binding.root)

        with(binding) {
            btnRefisterClick()
            tvToLogin.setOnClickListener {
                val intent = Intent(this@RegisterActivity, LoginActivity::class.java)
                startActivity(intent)
            }
        }
    }

    private fun ActivityRegisterBinding.btnRefisterClick() {
        btnRegister.setOnClickListener {
            val username = edtUsername.text.toString().trim()
            val email = edtEmail.text.toString().trim()
            val phone = edtPhone.text.toString().trim()
            val password = edtPassword.text.toString().trim()

            if (username.isEmpty() || email.isEmpty() || phone.isEmpty() || password.isEmpty()) {
                Toast.makeText(this@RegisterActivity, "Please fill in all fields", Toast.LENGTH_SHORT).show()
                return@setOnClickListener
            }

            if (!cbTerms.isChecked) {
                Toast.makeText(this@RegisterActivity, "Please agree to Terms and Conditions", Toast.LENGTH_SHORT).show()
                return@setOnClickListener
            }

            val intent = Intent(this@RegisterActivity, HomeActivity::class.java).apply {
                putExtra(HomeActivity.EXTRA_USERNAME, username)
                putExtra(HomeActivity.EXTRA_EMAIL, email)
                putExtra(HomeActivity.EXTRA_PHONE, phone)
            }
            startActivity(intent)
        }
    }
}