package com.example.smartrelaycontrol

import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity

class DashboardActivity : AppCompatActivity() {

    // Deklarasi variabel
    private lateinit var tvStatusRelay: TextView
    private lateinit var btnNyalakan: Button
    private lateinit var btnMatikan: Button
    private lateinit var btnLogout: Button

    // Variabel status relay
    private var relayNyala = false

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_dashboard)

        // Hubungkan komponen tampilan
        tvStatusRelay = findViewById(R.id.tvStatusRelay)
        btnNyalakan = findViewById(R.id.btnNyalakan)
        btnMatikan = findViewById(R.id.btnMatikan)
        btnLogout = findViewById(R.id.btnLogout)

        // Aksi tombol nyalakan
        btnNyalakan.setOnClickListener {
            relayNyala = true
            updateStatusRelay()
            // Nanti di sini tambah kode untuk kirim perintah ke perangkat keras
            Toast.makeText(this, "Relay Dinyalakan", Toast.LENGTH_SHORT).show()
        }

        // Aksi tombol matikan
        btnMatikan.setOnClickListener {
            relayNyala = false
            updateStatusRelay()
            // Nanti di sini tambah kode untuk kirim perintah ke perangkat keras
            Toast.makeText(this, "Relay Dimatikan", Toast.LENGTH_SHORT).show()
        }

        // Aksi tombol keluar
        btnLogout.setOnClickListener {
            finish() // Kembali ke halaman login
            Toast.makeText(this, "Berhasil Keluar", Toast.LENGTH_SHORT).show()
        }
    }

    // Fungsi untuk memperbarui tampilan status
    private fun updateStatusRelay() {
        if (relayNyala) {
            tvStatusRelay.text = "Nyala"
            tvStatusRelay.setTextColor(resources.getColor(R.color.accent_green, theme))
        } else {
            tvStatusRelay.text = "Mati"
            tvStatusRelay.setTextColor(resources.getColor(R.color.accent_red, theme))
        }
    }
}