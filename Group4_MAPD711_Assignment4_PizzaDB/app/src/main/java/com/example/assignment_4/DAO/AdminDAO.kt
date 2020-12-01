package com.example.assignment_4.DAO

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.example.assignment_4.Data.Admin

@Dao
interface AdminDAO {

    // Creating a function to track new Admin with avoiding conflicts for already existing Admins.
    @Insert(onConflict = OnConflictStrategy.IGNORE)
    suspend fun addAdmin(admin: Admin)

    // Find all Admins:
    @Query("SELECT * FROM admin")
    fun getAllAdmins(): List<Admin>

    // Find Admins by name:
    @Query("SELECT * FROM user WHERE First_Name LIKE :FName AND " +
            "First_Name LIKE :LName LIMIT 1")
    fun findAdminByName(FName: String, LName: String): Admin

    // Find Admins by their ID:
    @Query("SELECT * FROM admin WHERE adminId IN (:AId)")
    fun loadAllByIds(AId: IntArray): List<Admin>

    // Delete an Admin
    fun deleteAdmin(admin: Admin)
}