package com.noxo.evapp.ui

import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import com.noxo.evapp.databinding.ActivityLoginBinding
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class LoginActivity : AppCompatActivity() {

    private val loginViewModel: LoginViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val binding = ActivityLoginBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.buttonLogin.setOnClickListener {
            loginViewModel.login(binding.editTextUsername.text.toString(), binding.editTextPassword.text.toString())
        }

        loginViewModel.currentCredentials.observe(this) {
            it.onFailure {
                Toast.makeText(this, "Login failed", Toast.LENGTH_LONG).show()
            }
            it.onSuccess {
                val intent = Intent(this, StationActivity::class.java)
                intent.putExtra("token", it.token)
                startActivity(intent)
            }
        }
    }
}