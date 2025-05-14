package com.otniel.tugas_672022048

import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.otniel.tugas_672022048.databinding.ActivityRegisterBinding

class RegisterActivity : AppCompatActivity() {

    private lateinit var binding: ActivityRegisterBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityRegisterBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.btnRegister.setOnClickListener {
            if (validateInput()) {
                val fullName = binding.etFullName.text.toString().trim()
                val username = binding.etUsername.text.toString().trim()
                Toast.makeText(
                    this,
                    "Registrasi berhasil: $fullName ($username)",
                    Toast.LENGTH_LONG
                ).show()
                // TODO: lanjut simpan/data transfer atau pindah Activity
            }
        }
    }

    private fun validateInput(): Boolean {
        var valid = true

        // Reset errors
        listOf(
            binding.tilFullName,
            binding.tilUsername,
            binding.tilPassword,
            binding.tilConfirmPassword
        ).forEach { it.error = null }

        val name = binding.etFullName.text.toString().trim()
        val user = binding.etUsername.text.toString().trim()
        val pass = binding.etPassword.text.toString()
        val confirm = binding.etConfirmPassword.text.toString()

        if (name.isEmpty()) {
            binding.tilFullName.error = "Full Name wajib diisi"
            valid = false
        }
        if (user.isEmpty()) {
            binding.tilUsername.error = "Username wajib diisi"
            valid = false
        }
        if (pass.isEmpty()) {
            binding.tilPassword.error = "Password wajib diisi"
            valid = false
        }
        if (confirm.isEmpty()) {
            binding.tilConfirmPassword.error = "Confirm Password wajib diisi"
            valid = false
        }
        if (pass.isNotEmpty() && confirm.isNotEmpty() && pass != confirm) {
            binding.tilConfirmPassword.error = "Password tidak cocok"
            valid = false
        }

        return valid
    }
}
