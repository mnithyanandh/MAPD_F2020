package com.example.assignment_2

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView

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
        val cinfo = findViewById<TextView>(R.id.Thank_You)

        // Display the user data in the textview
        cinfo.text = "Customer Name: $cname"+
                "\n\nCustomer Address: $caddress"+
                "\n\nType of Pizza: $pizzaType"+
                "\n\nSize of Pizza: $pizzaSize"+
                "\n\nToppings: $pizzaToppings"
    }
}