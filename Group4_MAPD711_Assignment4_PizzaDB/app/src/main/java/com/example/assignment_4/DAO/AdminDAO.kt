package com.example.assignment_4.DAO

import androidx.room.*
import com.example.assignment_4.Data.Admin
import com.example.assignment_4.Data.Customer

@Dao
interface AdminDAO {

    // Creating a function to track new Admin with avoiding conflicts for already existing Admins.
    @Insert(onConflict = OnConflictStrategy.IGNORE)
    fun addAdmin(admin: Admin)

    // Find all Admins:
    @Query("SELECT * FROM Admin")
    fun getAllAdmins(): List<Admin>

    // Find Admins by name:
    @Query("SELECT * FROM Admin WHERE First_Name LIKE :FName AND Last_Name LIKE :LName LIMIT 1")
    fun findAdminByName(FName: String, LName: String): Admin

    // Find Admin by Username:
    // Find Customers by their Usernames:
    @Query("SELECT * FROM Admin WHERE Username LIKE :username LIMIT 1")
    fun findAdminByUsername(username: String): Admin

    // Find Admins by their ID:
    @Query("SELECT * FROM Admin WHERE adminId IN (:AId)")
    fun loadAllByIds(AId: IntArray): List<Admin>

    // Delete an Admin
    @Delete
    fun deleteAdmin(admin: Admin)
}