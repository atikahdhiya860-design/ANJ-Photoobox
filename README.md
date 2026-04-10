## Deskripsi

Project ini merupakan hasil praktikum Pemrograman Mobile minggu ke-3 yang berfokus pada implementasi Activity dan Intent dalam pengembangan aplikasi Android.

Aplikasi yang dibuat memiliki fitur utama berupa halaman login yang memungkinkan pengguna untuk memasukkan email dan password. Setelah data diisi dengan benar, pengguna akan diarahkan ke halaman dashboard menggunakan Explicit Intent. Selain itu, terdapat fitur Lupa Password yang memanfaatkan Implicit Intent untuk membuka aplikasi email dan menghubungi admin.

Melalui project ini, diharapkan mahasiswa dapat memahami konsep dasar navigasi antar activity serta komunikasi antar aplikasi dalam Android secara sederhana dan terstruktur.

---

## Fitur

### 1. Halaman Login (MainActivity)

#### Source Code
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

        btnLogin.setOnClickListener {

            val inputEmail = email.text.toString()
            val inputPassword = password.text.toString()

            if (inputEmail.isNotEmpty() && inputPassword.isNotEmpty()) {

                Toast.makeText(this, "Login Berhasil", Toast.LENGTH_SHORT).show()

                val intent = Intent(this, DashboardActivity::class.java)
                startActivity(intent)

            } else {
                Toast.makeText(this, "Isi semua data!", Toast.LENGTH_SHORT).show()
            }
        }

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

#### Penjelasan
MainActivity digunakan sebagai halaman login. User memasukkan email dan password, lalu sistem melakukan validasi sederhana. Jika data terisi, aplikasi akan berpindah ke DashboardActivity menggunakan Explicit Intent. Jika kosong, akan muncul pesan peringatan. Fitur lupa password akan membuka aplikasi email menggunakan Implicit Intent.

---

### 2. Halaman Dashboard (DashboardActivity)

#### Source Code
```kotlin
package com.example.anjphotobox

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity

class DashboardActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_dashboard)
    }
}
```

#### Penjelasan
DashboardActivity merupakan halaman yang ditampilkan setelah login berhasil. Activity ini menampilkan layout dashboard sebagai halaman utama setelah proses login.

---

### 3. Explicit Intent (Pindah Halaman)

#### Source Code
```kotlin
val intent = Intent(this, DashboardActivity::class.java)
startActivity(intent)
```

#### Penjelasan
Digunakan untuk berpindah dari MainActivity ke DashboardActivity dalam satu aplikasi.

---

### 4. Implicit Intent (Kirim Email)

#### Source Code
```kotlin
val intent = Intent(Intent.ACTION_SENDTO)
intent.data = Uri.parse("mailto:admin@anjphotobox.com")
intent.putExtra(Intent.EXTRA_SUBJECT, "Lupa Password")
intent.putExtra(Intent.EXTRA_TEXT, "Halo admin, saya lupa password akun saya.")

startActivity(intent)
```

#### Penjelasan
Digunakan untuk membuka aplikasi email dan mengirim pesan ke admin tanpa menentukan aplikasi tujuan secara langsung.
