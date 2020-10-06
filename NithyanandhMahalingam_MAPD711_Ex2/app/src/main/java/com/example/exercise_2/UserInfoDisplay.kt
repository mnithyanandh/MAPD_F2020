package com.example.exercise_2

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView
import java.lang.reflect.Type

class UserInfoDisplay : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_user_info_display)

//      Intent declaration to receive data from the Main Activity
        val intent = getIntent()

//      Get data from the MainActivity
        val fname = intent.getStringExtra("Full Name:")
        val qualif = intent.getStringExtra("Qualification:")
        val proff = intent.getStringExtra("Profession:")
        val hobb = intent.getStringExtra("Hobbies:")
        val djob = intent.getStringExtra("Dream Job:")


//      Initialize the textview which is going to hold the data from Main activity
        val infodisplay = findViewById<TextView>(R.id.StringInfo)

//      Print the information stored from the resource file.
        infodisplay.text = "Full Name: $fname"+"\n\nQualification: $qualif"+"\n\nProfession: $proff"+"\n\nHobbies: $hobb"+"\n\nDream Job: $djob"

    }
}