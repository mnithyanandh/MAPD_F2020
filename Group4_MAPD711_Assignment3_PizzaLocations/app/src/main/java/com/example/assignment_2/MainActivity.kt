package com.example.assignment_2

import android.content.DialogInterface
import android.content.Intent
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

        // Creating tags for holding values of different user selected options
        var userPizza = ""
        var userPizzaSize = ""
        val userPizzaToppings = arrayListOf<String>()

        when (item.itemId) {
            // Sample Toast message
            // R.id.meat_supreme -> Toast.makeText(this, "You chose Meat Supreme.", Toast.LENGTH_LONG).show()

            R.id.meat_supreme -> {
                // Store the value that the user has chosen the preferred pizza
                userPizza = "Meat Supreme Pizza"

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
                    // Store the value that the user has chosen the preferred size
                    userPizzaSize = pizza_size_items[i]
                }
                psBuilder.setPositiveButton("Next") { dialog, which ->
                    // Move to the next Alert Dialog screen to take ingredients
                    val piBuilder = AlertDialog.Builder(this)
                    val pizzaIngredients = arrayOf("Extra Cheese","Green Pepper", "Smoked Ham", "Spinach", "Black Olives", "Spanish Onions", "Mushrooms")
                    // Check whether the user has selected any ingredients
                    val checkedpizzaIngredients = booleanArrayOf(true, false, true, false, false, true, false)
                    //Convert the booleanArray to a proper List for Checked box method
                    val pizzaIngredientsList = Arrays.asList(*pizzaIngredients)
                    piBuilder.setTitle("Select your preferred Toppings:")
                    piBuilder.setMultiChoiceItems(pizzaIngredients, checkedpizzaIngredients){DialogInterface, j, isChecked ->
                        checkedpizzaIngredients[j] = isChecked
                        val userItem = pizzaIngredientsList[j]
                    }
                    piBuilder.setPositiveButton("Checkout") {dialog, which ->
                        for (n in checkedpizzaIngredients.indices){
                            val checkedItem = checkedpizzaIngredients[n]
                            if (checkedItem){
                                userPizzaToppings.add(pizzaIngredientsList[n])
                                finish()
                            }
                        }
                        val checkout_intent = Intent(this@MainActivity, CheckoutScreen::class.java)
                        checkout_intent.putExtra("Type of Pizza: ", userPizza)
                        checkout_intent.putExtra("Size of Pizza: ", userPizzaSize)
                        checkout_intent.putStringArrayListExtra("Toppings selected: ", userPizzaToppings)
                        startActivity(checkout_intent)
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

                // Store the value that the user has chosen the preferred pizza
                userPizza = "Super Hawaiian Pizza"

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
                    userPizzaSize = pizza_size_items[i]
                }
                psBuilder.setPositiveButton("Next") { dialog, which ->
                    // Move to the next Alert Dialog screen to take ingredients
                    val piBuilder = AlertDialog.Builder(this)
                    val pizzaIngredients = arrayOf("Extra Cheese","Green Pepper", "Smoked Ham", "Spinach", "Black Olives", "Spanish Onions", "Mushrooms")
                    // Check whether the user has selected any ingredients
                    val checkedpizzaIngredients = booleanArrayOf(true, false, true, true, false, true, false)
                    //Convert the booleanArray to a proper List for Checked box method
                    val pizzaIngredientsList = Arrays.asList(*pizzaIngredients)
                    piBuilder.setTitle("Select your preferred Toppings:")
                    piBuilder.setMultiChoiceItems(pizzaIngredients, checkedpizzaIngredients){DialogInterface, j, isChecked ->
                        checkedpizzaIngredients[j] = isChecked
                        val userItem = pizzaIngredientsList[j]
                    }
                    piBuilder.setPositiveButton("Checkout") {dialog, which ->
                        for (n in checkedpizzaIngredients.indices){
                            val checkedItem = checkedpizzaIngredients[n]
                            if (checkedItem){
                                userPizzaToppings.add(pizzaIngredientsList[n])
                                finish()
                            }
                        }
                        val checkout_intent = Intent(this@MainActivity, CheckoutScreen::class.java)
                        checkout_intent.putExtra("Type of Pizza: ", userPizza)
                        checkout_intent.putExtra("Size of Pizza: ", userPizzaSize)
                        checkout_intent.putStringArrayListExtra("Toppings selected: ", userPizzaToppings)
                        startActivity(checkout_intent)
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

                // Store the value that the user has chosen the preferred pizza
                userPizza = "Veggie Pizza"

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
                    userPizzaSize = pizza_size_items[i]
                }
                psBuilder.setPositiveButton("Next") { dialog, which ->
                    // Move to the next Alert Dialog screen to take ingredients
                    val piBuilder = AlertDialog.Builder(this)
                    val pizzaIngredients = arrayOf("Extra Cheese","Green Pepper", "Smoked Ham", "Spinach", "Black Olives", "Spanish Onions", "Mushrooms")
                    // Check whether the user has selected any ingredients
                    val checkedpizzaIngredients = booleanArrayOf(true, true, false, true, true, false, true)
                    //Convert the booleanArray to a proper List for Checked box method
                    val pizzaIngredientsList = Arrays.asList(*pizzaIngredients)
                    piBuilder.setTitle("Select your preferred Toppings:")
                    piBuilder.setMultiChoiceItems(pizzaIngredients, checkedpizzaIngredients){DialogInterface, j, isChecked ->
                        checkedpizzaIngredients[j] = isChecked
                        val userItem = pizzaIngredientsList[j]
                    }
                    piBuilder.setPositiveButton("Checkout") {dialog, which ->
                        for (n in checkedpizzaIngredients.indices){
                            val checkedItem = checkedpizzaIngredients[n]
                            if (checkedItem){
                                userPizzaToppings.add(pizzaIngredientsList[n])
                                finish()
                            }
                        }
                        val checkout_intent = Intent(this@MainActivity, CheckoutScreen::class.java)
                        checkout_intent.putExtra("Type of Pizza: ", userPizza)
                        checkout_intent.putExtra("Size of Pizza: ", userPizzaSize)
                        checkout_intent.putStringArrayListExtra("Toppings selected: ", userPizzaToppings)
                        startActivity(checkout_intent)
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

                // Store the value that the user has chosen the preferred pizza
                userPizza = "Mediterranean Pizza"

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
                    userPizzaSize = pizza_size_items[i]
                }
                psBuilder.setPositiveButton("Next") { dialog, which ->
                    // Move to the next Alert Dialog screen to take ingredients
                    val piBuilder = AlertDialog.Builder(this)
                    val pizzaIngredients = arrayOf("Extra Cheese","Green Pepper", "Smoked Ham", "Spinach", "Black Olives", "Spanish Onions", "Mushrooms")
                    // Check whether the user has selected any ingredients
                    val checkedpizzaIngredients = booleanArrayOf(false, true, false, false, true, true, false)
                    //Convert the booleanArray to a proper List for Checked box method
                    val pizzaIngredientsList = Arrays.asList(*pizzaIngredients)
                    piBuilder.setTitle("Select your preferred Toppings:")
                    piBuilder.setMultiChoiceItems(pizzaIngredients, checkedpizzaIngredients){DialogInterface, j, isChecked ->
                        checkedpizzaIngredients[j] = isChecked
                        val userItem = pizzaIngredientsList[j]
                    }
                    piBuilder.setPositiveButton("Checkout") {dialog, which ->
                        for (n in checkedpizzaIngredients.indices){
                            val checkedItem = checkedpizzaIngredients[n]
                            if (checkedItem){
                                userPizzaToppings.add(pizzaIngredientsList[n])
                                finish()
                            }
                        }
                        val checkout_intent = Intent(this@MainActivity, CheckoutScreen::class.java)
                        checkout_intent.putExtra("Type of Pizza: ", userPizza)
                        checkout_intent.putExtra("Size of Pizza: ", userPizzaSize)
                        checkout_intent.putStringArrayListExtra("Toppings selected: ", userPizzaToppings)
                        startActivity(checkout_intent)
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

                // Store the value that the user has chosen the preferred pizza
                userPizza = "Cheddar Supreme Pizza"

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
                    userPizzaSize = pizza_size_items[i]
                }
                psBuilder.setPositiveButton("Next") { dialog, which ->
                    // Move to the next Alert Dialog screen to take ingredients
                    val piBuilder = AlertDialog.Builder(this)
                    val pizzaIngredients = arrayOf("Extra Cheese","Green Pepper", "Smoked Ham", "Spinach", "Black Olives", "Spanish Onions", "Mushrooms")
                    // Check whether the user has selected any ingredients
                    val checkedpizzaIngredients = booleanArrayOf(true, false, false, false, false, true, false)
                    //Convert the booleanArray to a proper List for Checked box method
                    val pizzaIngredientsList = Arrays.asList(*pizzaIngredients)
                    piBuilder.setTitle("Select your preferred Toppings:")
                    piBuilder.setMultiChoiceItems(pizzaIngredients, checkedpizzaIngredients){DialogInterface, j, isChecked ->
                        checkedpizzaIngredients[j] = isChecked
                        val userItem = pizzaIngredientsList[j]
                    }
                    piBuilder.setPositiveButton("Checkout") {dialog, which ->
                        for (n in checkedpizzaIngredients.indices){
                            val checkedItem = checkedpizzaIngredients[n]
                            if (checkedItem){
                                userPizzaToppings.add(pizzaIngredientsList[n])
                                finish()
                            }
                        }
                        val checkout_intent = Intent(this@MainActivity, CheckoutScreen::class.java)
                        checkout_intent.putExtra("Type of Pizza: ", userPizza)
                        checkout_intent.putExtra("Size of Pizza: ", userPizzaSize)
                        checkout_intent.putStringArrayListExtra("Toppings selected: ", userPizzaToppings)
                        startActivity(checkout_intent)
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