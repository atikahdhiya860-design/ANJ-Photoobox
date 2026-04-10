# ANJ-Photobox.
Tugas 3-Kelompok 8
Nama :
1. Atikah Dhiya-L0324007
2. Nadiva Meiliya-L0324028
3. Sulthanah Jihan Zyarifah-L0324034

## 📌 Deskripsi

Project ini merupakan hasil praktikum Pemrograman Mobile minggu ke-3 yang berfokus pada implementasi *Activity* dan *Intent* dalam pengembangan aplikasi Android.

Aplikasi yang dibuat memiliki fitur utama berupa halaman login yang memungkinkan pengguna untuk memasukkan email dan password. Setelah data diisi dengan benar, pengguna akan diarahkan ke halaman dashboard menggunakan *Explicit Intent*. Selain itu, terdapat fitur **Lupa Password** yang memanfaatkan *Implicit Intent* untuk membuka aplikasi email dan menghubungi admin.

Melalui project ini, diharapkan mahasiswa dapat memahami konsep dasar navigasi antar activity serta komunikasi antar aplikasi dalam Android secara sederhana dan terstruktur.

---

## 🚀 Fitur

### 1. Halaman Login (MainActivity)

```kotlin
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

                // 👉 Explicit Intent
                val intent = Intent(this, DashboardActivity::class.java)
                startActivity(intent)

            } else {
                Toast.makeText(this, "Isi semua data!", Toast.LENGTH_SHORT).show()
            }
        }

        // 📧 Implicit Intent
        lupaPassword.setOnClickListener {

            val intent = Intent(Intent.ACTION_SENDTO)
            intent.data = Uri.parse("mailto:admin@anjphotobox.com")
            intent.putExtra(Intent.EXTRA_SUBJECT, "Lupa Password")
            intent.putExtra(Intent.EXTRA_TEXT, "Halo admin, saya lupa password akun saya.")

            startActivity(intent)
        }
    }
}

```
