package com.example.exercise_2

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import com.example.exercise_2.R.string
import java.lang.reflect.Type

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

//      Initialize a String values to pull in the values from the Resource file
        val full_name = resources.getString(R.string.full_name)
        val qualification = resources.getString(R.string.qualification)
        val profession = resources.getString(R.string.profession)
        val hobbies = resources.getString(R.string.hobbies)
        val dreamjob = resources.getString(R.string.dream_job)

//      Initialize the 'Submit' button already created.
        val send = findViewById<Button>(R.id.SendButton)

//      Adding an Intent to the 'Submit' button
        send.setOnClickListener {
            val intent = Intent(this@MainActivity, UserInfoDisplay::class.java)

//          Pass the 'Submit' button information to the second screen to display the User info.
            intent.putExtra("Full Name:", full_name)
            intent.putExtra("Qualification:", qualification)
            intent.putExtra("Profession:", profession)
            intent.putExtra("Hobbies:", hobbies)
            intent.putExtra("Dream Job:", dreamjob)

//          Kick off the activity intent to swap after button press
            startActivity(intent)
        }

    }
}