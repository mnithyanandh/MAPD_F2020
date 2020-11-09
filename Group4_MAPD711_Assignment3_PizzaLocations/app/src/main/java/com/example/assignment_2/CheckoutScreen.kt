// Author; Nithyanandh Mahalingam | ID: 301162314
// Co-Author: Dhrumil Vipul Malaviya | ID: 301058391
// Assignment: MAPD 711 - Assignment 3
// Date: 11/9/2020
package com.example.assignment_2

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_checkout_screen.*
import org.w3c.dom.Text

class CheckoutScreen : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_checkout_screen)

        // Intent declaration to receive data from the MAinActivity
        val cintent = intent
        val pizzatype = cintent.getStringExtra("Type of Pizza: ")
        val pizzasize= cintent.getStringExtra("Size of Pizza: ")
        var pizzatoppings = cintent.getStringArrayListExtra("Toppings selected: ")

        // Creating tags for holding values of different user variables
        val CName = findViewById<EditText>(R.id.Name_Entry)
        val CAddress = findViewById<EditText>(R.id.Address_Entry)
        val CPostalCode = findViewById<EditText>(R.id.Postal_Code_Entry)

        //Validation for CPostalCode
        CPostalCode.addTextChangedListener(object:TextWatcher{
            override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {
            }

            override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {
                if(s.toString().length == 6){
                    Order.isEnabled = true
                }else{
                    Postal_Code_Entry.setError("Your zipcode should be 6 letters")
                    Order.isEnabled = false
                }
            }
            override fun afterTextChanged(s: Editable?) {
            }
        })

        val CTelephone = findViewById<EditText>(R.id.Telephone_Entry)

        //Validation for CTelephone:
        CTelephone.addTextChangedListener(object : TextWatcher{
            override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {
            }

            override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {
                if(s.toString().length == 10){
                    Order.isEnabled = true
                }else{
                    Telephone_Entry.setError("Your telephone number should of 10 digits")
                    Order.isEnabled = false
                }
            }
            override fun afterTextChanged(s: Editable?) {
            }
        })

        val CCName = findViewById<EditText>(R.id.Cardholder_Name_Entry)
        val CCNumber = findViewById<EditText>(R.id.Card_Number_Entry)

        // Validation for CCNumber:
        CCNumber.addTextChangedListener(object:TextWatcher{
            override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {
            }

            override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {
                if(s.toString().length == 16){
                    Order.isEnabled = true
                }else{
                    Card_Number_Entry.setError("Your credit card number should be 16 digits")
                    Order.isEnabled = false
                }
            }
            override fun afterTextChanged(s: Editable?) {
            }
        })
        val CCExpiry = findViewById<EditText>(R.id.Card_Expiry_Entry)

        //Validation for CCExpiry
        CCExpiry.addTextChangedListener(object: TextWatcher{
            override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {
            }

            override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {
                if(s.toString().matches("\\d{2}-\\d{2}".toRegex())){
                    Order.isEnabled = true
                }
            }
            override fun afterTextChanged(s: Editable?) {
            }
        })

        val CCCVV = findViewById<EditText>(R.id.Card_CVV_Entry)

        // Validation for CCCVV:
        CCCVV.addTextChangedListener(object:TextWatcher{
            override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {
            }

            override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {
                if(s.toString().length == 3){
                    Order.isEnabled = true
                }else{
                    Card_CVV_Entry.setError("Your CVV should be 3 digits")
                    Order.isEnabled = false
                }
            }
            override fun afterTextChanged(s: Editable?) {
            }
        })

        // Creating tag for the 'Order' Button
        val Order = findViewById<Button>(R.id.Order)

        // Declaring 'Order' button intent. Also convert the user variables to Strings to pass down to next activity for display
        Order.setOnClickListener {
            // String conversion of user data:
            val name = CName.text.toString()
            val address = CAddress.text.toString()
            val postal_code = CPostalCode.text.toString()
            val telephone = CTelephone.text.toString()
            val credit_card_name = CCName.text.toString()
            val credit_card_number = CCNumber.text.toString()
            val credit_card_expiry = CCExpiry.text.toString()
            val credit_card_cvv = CCCVV.text.toString()
            val ptype = pizzatype.toString()
            val psize = pizzasize.toString()

            // Regex to remove an any additional symbols parsed via toString()
            val re = "[^A-Za-z, ]".toRegex()
            var temptoppings = pizzatoppings.toString()
            temptoppings = re.replace(temptoppings, "")
            val ptoppings = temptoppings.toString()

            // Main Intent declaration where Tag names are linked to user input data and is ready to send to 2nd Screen :
            val order_intent = Intent(this@CheckoutScreen, Order_Screen::class.java)
            order_intent.putExtra("Name: ", name)
            order_intent.putExtra("Address: ", address)
            order_intent.putExtra("Postal Code: ", postal_code)
            order_intent.putExtra("Telephone: ", telephone)
            order_intent.putExtra("Card Holder Name: ", credit_card_name)
            order_intent.putExtra("Card Number: ", credit_card_number)
            order_intent.putExtra("Card Expiry: ", credit_card_expiry)
            order_intent.putExtra("Card CVV: ", credit_card_cvv)
            order_intent.putExtra("Pizza Type: ", ptype)
            order_intent.putExtra("Pizza Size: ", psize)
            order_intent.putExtra("Pizza Toppings: ", ptoppings)
            startActivity(order_intent)
        }
    }
}