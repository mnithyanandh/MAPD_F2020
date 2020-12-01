package com.example.assignment_4.DAO

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.example.assignment_4.Data.Customer

@Dao
interface CustomerDAO {
    // Creating a function to track new Admin with avoiding conflicts for already existing Admins.
    @Insert(onConflict = OnConflictStrategy.IGNORE)
    suspend fun addAdmin(customer: Customer)

    // Find all Admins:
    @Query("SELECT * FROM customer")
    fun getAllAdmins(): List<Customer>

    // Find Admins by name:
    @Query("SELECT * FROM user WHERE First_Name LIKE :FName AND " +
            "First_Name LIKE :LName LIMIT 1")
    fun findAdminByName(FName: String, LName: String): Customer

    // Find Admins by their ID:
    @Query("SELECT * FROM admin WHERE adminId IN (:CId)")
    fun loadAllByIds(CId: IntArray): List<Customer>

    // Delete an Admin
    fun deleteAdmin(customer: Customer)
}