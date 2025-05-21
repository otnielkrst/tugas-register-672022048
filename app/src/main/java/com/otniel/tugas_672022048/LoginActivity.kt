package com.otniel.tugas_672022048

import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.otniel.tugas_672022048.databinding.ActivityLoginBinding

class LoginActivity : AppCompatActivity() {
    private lateinit var binding: ActivityLoginBinding
    private var registeredUsername: String? = null
    private var registeredPassword: String? = null
    private var fullName: String? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityLoginBinding.inflate(layoutInflater)
        setContentView(binding.root)

        // Ambil data dari RegisterActivity
        registeredUsername = intent.getStringExtra("username")
        registeredPassword = intent.getStringExtra("password")
        fullName = intent.getStringExtra("fullName")

            binding.btnLogin.setOnClickListener {
                val inputUsername = binding.etUsername.text.toString()
                val inputPassword = binding.etPassword.text.toString()

                if (inputUsername == registeredUsername && inputPassword == registeredPassword) {
                    val intent = Intent(this, WelcomeActivity::class.java)
                    intent.putExtra("fullName", fullName)
                    startActivity(intent)
                    finish()
                } else {
                    Toast.makeText(this, "Username atau Password salah", Toast.LENGTH_SHORT).show()
                }
            }

        // Tombol untuk pindah ke Register
        binding.tvRegister.setOnClickListener {
            val intent = Intent(this, RegisterActivity::class.java)
            startActivity(intent)

        }
    }
}
