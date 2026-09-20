package com.example.intentapp

import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.intentapp.databinding.ActivityLoginBinding

class LoginActivity : AppCompatActivity() {

    private lateinit var binding: ActivityLoginBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityLoginBinding.inflate(layoutInflater)
        setContentView(binding.root)

        with(binding) {
            btnLogin.setOnClickListener {
                val username = edtUsername.text.toString().trim()
                val password = edtPassword.text.toString().trim()

                if (username.isEmpty() || password.isEmpty()) {
                    Toast.makeText(this@LoginActivity, "Please enter username and password", Toast.LENGTH_SHORT).show()
                    return@setOnClickListener
                }

                val intent = Intent(this@LoginActivity, HomeActivity::class.java).apply {
                    putExtra(HomeActivity.EXTRA_USERNAME, username)
                    putExtra(HomeActivity.EXTRA_EMAIL, "$username@example.com")
                    putExtra(HomeActivity.EXTRA_PHONE, "+628123456789")
                }
                startActivity(intent)
            }

            tvToRegister.setOnClickListener {
                val intent = Intent(this@LoginActivity, RegisterActivity::class.java)
                startActivity(intent)
            }
        }
    }
}