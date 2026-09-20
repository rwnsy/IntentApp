package com.example.intentapp

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.intentapp.databinding.ActivityHomeBinding

class HomeActivity : AppCompatActivity() {

    private lateinit var binding: ActivityHomeBinding

    companion object {
        const val EXTRA_USERNAME = "extra_username"
        const val EXTRA_EMAIL = "extra_email"
        const val EXTRA_PHONE = "extra_phone"
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityHomeBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val username = intent.getStringExtra(EXTRA_USERNAME) ?: "User"
        val email = intent.getStringExtra(EXTRA_EMAIL) ?: "email@example.com"
        val phone = intent.getStringExtra(EXTRA_PHONE) ?: "-"

        with(binding) {
            tvWelcomeUsername.text = "Welcome $username"
            tvEmailStatus.text = "Your email $email has been activated"
            tvPhoneStatus.text = "Your phone $phone has been registered"

            btnShare.setOnClickListener {
                val shareText = "Hello! My Username is $username and my Email is $email."
                val shareIntent = Intent(Intent.ACTION_SEND).apply {
                    type = "text/plain"
                    putExtra(Intent.EXTRA_TEXT, shareText)
                }
                startActivity(Intent.createChooser(shareIntent, "Share Info via"))
            }

            btnLogout.setOnClickListener {
                val intent = Intent(this@HomeActivity, LoginActivity::class.java).apply {
                    flags = Intent.FLAG_ACTIVITY_NEW_TASK or Intent.FLAG_ACTIVITY_CLEAR_TASK
                }
                startActivity(intent)
                finish()
            }
        }
    }
}