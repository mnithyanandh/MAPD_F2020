package com.example.exercise_1

import android.os.Bundle
import com.google.android.material.floatingactionbutton.FloatingActionButton
import com.google.android.material.snackbar.Snackbar
import androidx.appcompat.app.AppCompatActivity
import android.content.Intent;
import android.widget.Button;
import android.widget.EditText;

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

//      Creating tags for holding values of different user variables
        val FullName = findViewById<EditText>(R.id.Full_Name_Entry)
        val Qualification = findViewById<EditText>(R.id.Qualification_Entry)
        val Profession = findViewById<EditText>(R.id.Profession_Entry)
        val Hobby = findViewById<EditText>(R.id.Hobby_Entry)
        val DreamJob = findViewById<EditText>(R.id.Dream_Job_Entry)

//      Creating tag for the 'Submit' Button
        val Submit = findViewById<Button>(R.id.Submit)

//      Declaring 'Submit' button intent. Also convert the user variables to Strings to pass down to second activity for display
        Submit.setOnClickListener {
//          String conversion of user data:
            val fullname = FullName.text.toString()
            val qualification = Qualification.text.toString()
            val profession = Profession.text.toString()
            val hobby = Hobby.text.toString()
            val dreamjob = DreamJob.text.toString()

//          Intent declaration:
            val intent = Intent(this@MainActivity, UserInputDisplay::class.java)
            intent.putExtra("Full Name: ", fullname)
            intent.putExtra("Qualifications: ", qualification)
            intent.putExtra("Profession: ", profession)
            intent.putExtra("Hobbies: ", hobby)
            intent.putExtra("Dream Job: ", dreamjob)
            startActivity(intent)
        }
    }
}