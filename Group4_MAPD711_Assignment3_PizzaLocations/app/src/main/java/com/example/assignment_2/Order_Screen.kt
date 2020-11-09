// Author; Nithyanandh Mahalingam | ID: 301162314
// Co-Author: Dhrumil Vipul Malaviya | ID: 301058391
// Assignment: MAPD 711 - Assignment 3
// Date: 11/9/2020
package com.example.assignment_2

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView
import android.widget.Button

class Order_Screen : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_order__screen)

        // Intent declaration to receive data from the CheckoutScreen
        val ointent = intent
        val cname = ointent.getStringExtra("Name: ")
        val caddress = ointent.getStringExtra("Address: ")
        val cpostal_code = ointent.getStringExtra("Postal Code: ")
        val ctelephone = ointent.getStringExtra("Telephone: ")
        val ccname = ointent.getStringExtra("Card Holder Name: ")
        val ccnumber = ointent.getStringExtra("Card Number: ")
        val ccexpiry = ointent.getStringExtra("Card Expiry: ")
        val cccvv = ointent.getStringExtra("Card CVV: ")
        val pizzaType = ointent.getStringExtra("Pizza Type: ")
        val pizzaSize = ointent.getStringExtra("Pizza Size: ")
        val pizzaToppings = ointent.getStringExtra("Pizza Toppings: ")

        // Initialize the textview which is going to hold the data from Main activity
        val cinfo = findViewById<TextView>(R.id.Customer_Info)

        // Display the user data in the textview
        cinfo.text = "Customer Name: $cname"+
                "\n\nCustomer Address: \n$caddress"+
                "\n\nCustomer Phone Number: \n$ctelephone"+
                "\n\nType of Pizza: \n$pizzaType"+
                "\n\nSize of Pizza: \n$pizzaSize"+
                "\n\nToppings: \n$pizzaToppings"

        val homescreen = findViewById<Button>(R.id.Order_more)
        homescreen.setOnClickListener{
            val back_to_home = Intent(this@Order_Screen, MainActivity::class.java)
            startActivity(back_to_home)
        }
    }
}