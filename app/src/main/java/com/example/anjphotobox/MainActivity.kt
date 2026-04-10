package com.example.anjphotobox

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import android.content.Intent
import android.net.Uri
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

            val email = findViewById<EditText>(R.id.etEmail)
            val password = findViewById<EditText>(R.id.etPassword)
            val btnLogin = findViewById<Button>(R.id.btnLogin)
            val lupaPassword = findViewById<TextView>(R.id.tvLupaPassword)

            // 🔐 LOGIN
            btnLogin.setOnClickListener {

                val inputEmail = email.text.toString()
                val inputPassword = password.text.toString()

                if (inputEmail.isNotEmpty() && inputPassword.isNotEmpty()) {

                    Toast.makeText(this, "Login Berhasil", Toast.LENGTH_SHORT).show()

                    // 👉 PINDAH HALAMAN (Explicit Intent)
                    val intent = Intent(this, DashboardActivity::class.java)
                    startActivity(intent)

                } else {
                    Toast.makeText(this, "Isi semua data!", Toast.LENGTH_SHORT).show()
                }
            }

            // 📧 LUPA PASSWORD (Implicit Intent)
            lupaPassword.setOnClickListener {

                val intent = Intent(Intent.ACTION_SENDTO)
                intent.data = Uri.parse("mailto:admin@anjphotobox.com")
                intent.putExtra(Intent.EXTRA_SUBJECT, "Lupa Password")
                intent.putExtra(Intent.EXTRA_TEXT, "Halo admin, saya lupa password akun saya.")

                startActivity(intent)
            }
        }

    }
