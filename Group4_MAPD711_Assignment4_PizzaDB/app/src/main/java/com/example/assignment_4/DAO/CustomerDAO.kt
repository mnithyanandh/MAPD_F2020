package com.example.assignment_4.DAO

import android.view.WindowId
import androidx.room.*
import com.example.assignment_4.Data.Customer

@Dao
interface CustomerDAO {

    // Creating a function to track new Admin with avoiding conflicts for already existing Customers.
    @Insert(onConflict = OnConflictStrategy.IGNORE)
    fun addCustomer(customer: Customer)

    // Find all Customers:
    @Query("SELECT * FROM Customer")
    fun getAllCustomer(): List<Customer>

    // Find Customers by name:
    @Query("SELECT * FROM Customer WHERE First_Name LIKE :FName AND Last_Name LIKE :LName LIMIT 1")
    fun findCustomerByName(FName: String, LName: String): Customer

    // Find Customers by their Usernames:
    @Query("SELECT * FROM Customer WHERE Username LIKE :username LIMIT 1")
    fun findCustomerByUsername(username: String): Customer

    // Find Customer by their Password:
    @Query("SELECT * FROM Customer WHERE Password LIKE :password LIMIT 1")
    fun findByCustomerPassword(password: String): Customer

    // Find Customers by their ID:
    @Query("SELECT * FROM Customer WHERE customerId IN (:CId)")
    fun loadAllCustomersByIds(CId: IntArray): List<Customer>

    // Delete an Customers
    @Delete
    fun deleteCustomer(customer: Customer)
}