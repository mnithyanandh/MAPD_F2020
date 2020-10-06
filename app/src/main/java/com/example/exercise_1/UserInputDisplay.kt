package com.example.exercise_1

import android.annotation.SuppressLint
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView

class UserInputDisplay : AppCompatActivity() {
    @SuppressLint("SetTextI18n")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_user_input_display)

//      Intent declaration to receive data from the Main Activity
        val intent = intent
        val fname = intent.getStringExtra("Full Name: ")
        val qualif = intent.getStringArrayExtra("Qualifications: ")
        val prof = intent.getStringArrayExtra("Profession: ")
        val hobb = intent.getStringArrayExtra("Hobbies: ")
        val dj = intent.getStringArrayExtra("Dream Job: ")

//      Initialize the textview which is going to hold the data from Main activity
        val datadisplay = findViewById<TextView>(R.id.InputDisplay)

//      Display the user data in the textview
        datadisplay.text = "Full Name: "+fname+"\n\nQualifications: "+qualif+"\n\nProfession: "+prof+"\n\nHobbies: "+hobb+"\n\nDream Job:"+dj
    }
}