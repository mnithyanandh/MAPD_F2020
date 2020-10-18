package com.example.assignment_2

import android.content.DialogInterface
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.view.View
import android.widget.Toast
import android.widget.TextView
import android.widget.Button
import androidx.appcompat.app.AlertDialog
import kotlinx.android.synthetic.main.activity_main.*
import java.util.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }

    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        menuInflater.inflate(R.menu.menu, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when (item.itemId) {
            // Sample Toast message
            // R.id.meat_supreme -> Toast.makeText(this, "You chose Meat Supreme.", Toast.LENGTH_LONG).show()
            R.id.meat_supreme -> {
                // List of available Pizza sizes
                val pizza_size_items = arrayOf(
                    "Small - 9inches / 6 slices",
                    "Medium - 12inches / 8 slices",
                    "Large - 16inches / 10 slices",
                    "XLarge - 21inches / 13 slices"
                )
                // Declare an instance of the Alert-Dialogue-Box
                val psBuilder = AlertDialog.Builder(this)
                psBuilder.setTitle("Select the size of your Pizza:")
                psBuilder.setSingleChoiceItems(pizza_size_items, -1) { DialogInterface, i ->
                    // pizza_Size.text = pizza_size_items[i]
                    // Also need to register this user input to TextView variable for checkout info -> strings.xml
                    // .......
                }
                psBuilder.setPositiveButton("Next") { dialog, which ->
                    // Move to the next Alert Dialog screen to take ingredients
                    val piBuilder = AlertDialog.Builder(this)
                    val pizzaIngredients = arrayOf("Extra Cheese","Green Pepper", "Smoked Ham", "Spinach", "Black Olives", "Spanish Onions")
                    // Check whether the user has selected any ingredients
                    val checkedpizzaIngredients = booleanArrayOf(true, false, false, false, false, false)
                    //Convert the booleanArray to a proper List for Checked box method
                    val pizzaIngredientsList = Arrays.asList(*pizzaIngredients)
                    piBuilder.setTitle("Select your preferred Ingredients:")
                    piBuilder.setMultiChoiceItems(pizzaIngredients, checkedpizzaIngredients){DialogInterface, j, isChecked ->
                        checkedpizzaIngredients[j] = isChecked
                        val userItem = pizzaIngredientsList[j]
                    }
                    piBuilder.setPositiveButton("Checkout") {dialog, which ->
                        for (n in checkedpizzaIngredients.indices){
                            val checkedItem = checkedpizzaIngredients[n]
                            if (checkedItem){
                                dialog.dismiss()
                                // Also need to register this user input to TextView variable for checkout info -> strings.xml
                                // .......
                            }
                        }
                    }
                    piBuilder.setNegativeButton("Cancel") {dialog, which ->
                        dialog.cancel()
                    }
                    piBuilder.create().show()
                }
                psBuilder.setNeutralButton("Cancel") { dialog, which ->
                    // Do something when click the neutral button
                    dialog.cancel()
                }
                psBuilder.create().show()
            }

            // Sample Toast message
            // R.id.super_hawaiian -> Toast.makeText(this, "You chose Super Hawaiian", Toast.LENGTH_LONG).show()
            R.id.super_hawaiian -> {
                // List of available Pizza sizes
                val pizza_size_items = arrayOf(
                    "Small - 9inches / 6 slices",
                    "Medium - 12inches / 8 slices",
                    "Large - 16inches / 10 slices",
                    "XLarge - 21inches / 13 slices"
                )
                // Declare an instance of the Alert-Dialogue-Box
                val psBuilder = AlertDialog.Builder(this)
                psBuilder.setTitle("Select the size of your Pizza:")
                psBuilder.setSingleChoiceItems(pizza_size_items, -1) { DialogInterface, i ->
                    // pizza_Size.text = pizza_size_items[i]
                    // Also need to register this user input to TextView variable for checkout info -> strings.xml
                    // .......
                }
                psBuilder.setPositiveButton("Next") { dialog, which ->
                    // Move to the next Alert Dialog screen to take ingredients
                    val piBuilder = AlertDialog.Builder(this)
                    val pizzaIngredients = arrayOf("Extra Cheese","Green Pepper", "Smoked Ham", "Spinach", "Black Olives", "Spanish Onions")
                    // Check whether the user has selected any ingredients
                    val checkedpizzaIngredients = booleanArrayOf(true, false, false, false, false, false)
                    //Convert the booleanArray to a proper List for Checked box method
                    val pizzaIngredientsList = Arrays.asList(*pizzaIngredients)
                    piBuilder.setTitle("Select your preferred Ingredients:")
                    piBuilder.setMultiChoiceItems(pizzaIngredients, checkedpizzaIngredients){DialogInterface, j, isChecked ->
                        checkedpizzaIngredients[j] = isChecked
                        val userItem = pizzaIngredientsList[j]
                    }
                    piBuilder.setPositiveButton("Checkout") {dialog, which ->
                        for (n in checkedpizzaIngredients.indices){
                            val checkedItem = checkedpizzaIngredients[n]
                            if (checkedItem){
                                dialog.dismiss()
                                // Also need to register this user input to TextView variable for checkout info -> strings.xml
                                // .......
                            }
                        }
                    }
                    piBuilder.setNegativeButton("Cancel") {dialog, which ->
                        dialog.cancel()
                    }
                    piBuilder.create().show()
                }
                psBuilder.setNeutralButton("Cancel") { dialog, which ->
                    // Do something when click the neutral button
                    dialog.cancel()
                }
                psBuilder.create().show()
            }

            // Sample Toast message
            // R.id.veggie -> Toast.makeText(this, "You chose Veggie", Toast.LENGTH_LONG).show()
            R.id.veggie -> {
                // List of available Pizza sizes
                val pizza_size_items = arrayOf(
                    "Small - 9inches / 6 slices",
                    "Medium - 12inches / 8 slices",
                    "Large - 16inches / 10 slices",
                    "XLarge - 21inches / 13 slices"
                )
                // Declare an instance of the Alert-Dialogue-Box
                val psBuilder = AlertDialog.Builder(this)
                psBuilder.setTitle("Select the size of your Pizza:")
                psBuilder.setSingleChoiceItems(pizza_size_items, -1) { DialogInterface, i ->
                    // pizza_Size.text = pizza_size_items[i]
                    // Also need to register this user input to TextView variable for checkout info -> strings.xml
                    // .......
                }
                psBuilder.setPositiveButton("Next") { dialog, which ->
                    // Move to the next Alert Dialog screen to take ingredients
                    val piBuilder = AlertDialog.Builder(this)
                    val pizzaIngredients = arrayOf("Extra Cheese","Green Pepper", "Smoked Ham", "Spinach", "Black Olives", "Spanish Onions")
                    // Check whether the user has selected any ingredients
                    val checkedpizzaIngredients = booleanArrayOf(true, false, false, false, false, false)
                    //Convert the booleanArray to a proper List for Checked box method
                    val pizzaIngredientsList = Arrays.asList(*pizzaIngredients)
                    piBuilder.setTitle("Select your preferred Ingredients:")
                    piBuilder.setMultiChoiceItems(pizzaIngredients, checkedpizzaIngredients){DialogInterface, j, isChecked ->
                        checkedpizzaIngredients[j] = isChecked
                        val userItem = pizzaIngredientsList[j]
                    }
                    piBuilder.setPositiveButton("Checkout") {dialog, which ->
                        for (n in checkedpizzaIngredients.indices){
                            val checkedItem = checkedpizzaIngredients[n]
                            if (checkedItem){
                                dialog.dismiss()
                                // Also need to register this user input to TextView variable for checkout info -> strings.xml
                                // .......
                            }
                        }
                    }
                    piBuilder.setNegativeButton("Cancel") {dialog, which ->
                        dialog.cancel()
                    }
                    piBuilder.create().show()
                }
                psBuilder.setNeutralButton("Cancel") { dialog, which ->
                    // Do something when click the neutral button
                    dialog.cancel()
                }
                psBuilder.create().show()
            }

            // Sample Toast message
            // R.id.mediterranean -> Toast.makeText(this, "You chose Mediterranean", Toast.LENGTH_LONG).show()
            R.id.mediterranean -> {
                // List of available Pizza sizes
                val pizza_size_items = arrayOf(
                    "Small - 9inches / 6 slices",
                    "Medium - 12inches / 8 slices",
                    "Large - 16inches / 10 slices",
                    "XLarge - 21inches / 13 slices"
                )
                // Declare an instance of the Alert-Dialogue-Box
                val psBuilder = AlertDialog.Builder(this)
                psBuilder.setTitle("Select the size of your Pizza:")
                psBuilder.setSingleChoiceItems(pizza_size_items, -1) { DialogInterface, i ->
                    // pizza_Size.text = pizza_size_items[i]
                    // Also need to register this user input to TextView variable for checkout info -> strings.xml
                    // .......
                }
                psBuilder.setPositiveButton("Next") { dialog, which ->
                    // Move to the next Alert Dialog screen to take ingredients
                    val piBuilder = AlertDialog.Builder(this)
                    val pizzaIngredients = arrayOf("Extra Cheese","Green Pepper", "Smoked Ham", "Spinach", "Black Olives", "Spanish Onions")
                    // Check whether the user has selected any ingredients
                    val checkedpizzaIngredients = booleanArrayOf(true, false, false, false, false, false)
                    //Convert the booleanArray to a proper List for Checked box method
                    val pizzaIngredientsList = Arrays.asList(*pizzaIngredients)
                    piBuilder.setTitle("Select your preferred Ingredients:")
                    piBuilder.setMultiChoiceItems(pizzaIngredients, checkedpizzaIngredients){DialogInterface, j, isChecked ->
                        checkedpizzaIngredients[j] = isChecked
                        val userItem = pizzaIngredientsList[j]
                    }
                    piBuilder.setPositiveButton("Checkout") {dialog, which ->
                        for (n in checkedpizzaIngredients.indices){
                            val checkedItem = checkedpizzaIngredients[n]
                            if (checkedItem){
                                dialog.dismiss()
                                // Also need to register this user input to TextView variable for checkout info -> strings.xml
                                // .......
                            }
                        }
                    }
                    piBuilder.setNegativeButton("Cancel") {dialog, which ->
                        dialog.cancel()
                    }
                    piBuilder.create().show()
                }
                psBuilder.setNeutralButton("Cancel") { dialog, which ->
                    // Do something when click the neutral button
                    dialog.cancel()
                }
                psBuilder.create().show()
            }

            // Sample Toast message
            // R.id.cheddar_supreme -> Toast.makeText(this, "You chose Cheddar Supreme", Toast.LENGTH_LONG).show()
            R.id.cheddar_supreme -> {
                // List of available Pizza sizes
                val pizza_size_items = arrayOf(
                    "Small - 9inches / 6 slices",
                    "Medium - 12inches / 8 slices",
                    "Large - 16inches / 10 slices",
                    "XLarge - 21inches / 13 slices"
                )
                // Declare an instance of the Alert-Dialogue-Box
                val psBuilder = AlertDialog.Builder(this)
                psBuilder.setTitle("Select the size of your Pizza:")
                psBuilder.setSingleChoiceItems(pizza_size_items, -1) { DialogInterface, i ->
                    // pizza_Size.text = pizza_size_items[i]
                    // Also need to register this user input to TextView variable for checkout info -> strings.xml
                    // .......
                }
                psBuilder.setPositiveButton("Next") { dialog, which ->
                    // Move to the next Alert Dialog screen to take ingredients
                    val piBuilder = AlertDialog.Builder(this)
                    val pizzaIngredients = arrayOf("Extra Cheese","Green Pepper", "Smoked Ham", "Spinach", "Black Olives", "Spanish Onions")
                    // Check whether the user has selected any ingredients
                    val checkedpizzaIngredients = booleanArrayOf(true, false, false, false, false, false)
                    //Convert the booleanArray to a proper List for Checked box method
                    val pizzaIngredientsList = Arrays.asList(*pizzaIngredients)
                    piBuilder.setTitle("Select your preferred Ingredients:")
                    piBuilder.setMultiChoiceItems(pizzaIngredients, checkedpizzaIngredients){DialogInterface, j, isChecked ->
                        checkedpizzaIngredients[j] = isChecked
                        val userItem = pizzaIngredientsList[j]
                    }
                    piBuilder.setPositiveButton("Checkout") {dialog, which ->
                        for (n in checkedpizzaIngredients.indices){
                            val checkedItem = checkedpizzaIngredients[n]
                            if (checkedItem){
                                dialog.dismiss()
                                // Also need to register this user input to TextView variable for checkout info -> strings.xml
                                // .......
                            }
                        }
                    }
                    piBuilder.setNegativeButton("Cancel") { dialog, which ->
                        dialog.cancel()
                    }
                    piBuilder.create().show()
                }
                psBuilder.setNeutralButton("Cancel") { dialog, which ->
                    // Do something when click the neutral button
                    dialog.cancel()
                }
                psBuilder.create().show()
            }
        }
        return true
    }
}