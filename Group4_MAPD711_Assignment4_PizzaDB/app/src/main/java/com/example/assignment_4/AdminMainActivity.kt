package com.example.assignment_4

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button

class AdminMainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_admin_main)

        val logout = findViewById<Button>(R.id.Logout)

        logout.setOnClickListener {
            val performLogout = Intent(this@AdminMainActivity, LoginScreen::class.java)
            startActivity(performLogout)
        }
    }
}