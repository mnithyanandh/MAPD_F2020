package com.example.assignment_4

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.room.Room
import com.example.assignment_4.Data.Customer
import com.example.assignment_4.Database.AdminDatabase
import com.example.assignment_4.Database.CustomerDatabase

class CustomerSignup : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_customer_signup)

        // Initialize global variables for all EditTexts:
        var fname = findViewById<EditText>(R.id.CFName_Entry)
        var lname = findViewById<EditText>(R.id.CLName_Entry)
        var email = findViewById<EditText>(R.id.CEmail_Entry)
        var address = findViewById<EditText>(R.id.CAddress_Entry)
        var postal_code = findViewById<EditText>(R.id.CPostal_Code_Entry)
        var city = findViewById<EditText>(R.id.CCity_Entry)
        var phone = findViewById<EditText>(R.id.CPhone_Entry)

        // Room DB Calls:
        var CRoomDB = Room.databaseBuilder(applicationContext, CustomerDatabase::class.java,"CustomerDB").build()

        // Inserting in the values entered by the new Customer:
        // Create an object of the Customer Entity
        var cust = Customer()
        cust.userName = email.text.toString()
        cust.firstName = fname.text.toString()
        cust.lastName = lname.text.toString()
        cust.email = email.text.toString()
        cust.address = address.text.toString()
        cust.postal_code = postal_code.text.toString()
        cust.city = city.text.toString()
        cust.phone = phone.text.toString()

        val signUpBtn = findViewById<Button>(R.id.SignUpBtn)
        signUpBtn.setOnClickListener{
            val signUp = Intent(this@CustomerSignup, LoginScreen::class.java)
            CRoomDB.getDAO().addCustomer(cust)
            startActivity(signUp)
        }
    }
}