package com.example.assignment_4

import android.content.Context
import android.content.SharedPreferences
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.appcompat.app.AlertDialog
import org.w3c.dom.Text
import java.util.*

class LoginScreen : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login_screen)

        // Initialize Shared Preferences for storing Login Data:
        val SharedPreferences = getSharedPreferences("sharedPref_data", Context.MODE_PRIVATE)

        // Initialize the Login Button as well
        val loginButton = findViewById<Button>(R.id.loginBtn)
        loginButton.setOnClickListener{

            // Register and track Username and Password:
            val usrName = findViewById<EditText>(R.id.usernameEntry).toString().trim()
            val passwrd = findViewById<EditText>(R.id.passwordEntry).toString().trim()

            // Handle Shared Preferences by registering in above information:
            val addData = SharedPreferences.edit()
            addData.putString("Username", usrName)
            addData.putString("Password", passwrd)

            // Apply changes to the Shared Preferences manager after adding the data
            addData.apply()
        }
        // ------------------------------------------------------------------------------------------- //
        // OPTIONAL TEST FUNCTIONALITY: - ** MAKE SURE TO SET 'id/testBtn' VISIBILITY TO "GONE" BEFORE EXEC **
        // Test SharedPreferences data to check if user entry is being saved:
        // Initialize the TestButton for handling test data fir Shared Preferences
        var testButton = findViewById<Button>(R.id.testBtn)
        testButton.setOnClickListener {
            val usrName = SharedPreferences.getString("Username", "")
            val passwrd = SharedPreferences.getString("Password", "")

            // OPTIONAL TEST FUNCTIONALITY: - ** MAKE SURE TO SET 'id/testData' VISIBILITY TO "GONE" BEFORE EXEC **
            // Display SharedPreferences data to check if user entry is being saved:
            val testView = findViewById<TextView>(R.id.testData)
            testView.text = "Username: $usrName \nPassword: $passwrd"
        }
        // ------------------------------------------------------------------------------------------- //
    }
}