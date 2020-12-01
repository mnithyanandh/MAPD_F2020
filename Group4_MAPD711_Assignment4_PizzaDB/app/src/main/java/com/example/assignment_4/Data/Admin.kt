package com.example.assignment_4.Data

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "Admin")
data class Admin (
    @PrimaryKey(autoGenerate = true) val adminId: Int,
    @ColumnInfo(name = "Username") val userName: String,
    @ColumnInfo(name = "Password") var password: String,
    @ColumnInfo(name = "First_Name") val firstName: String,
    @ColumnInfo(name = "Last_Name") val lastName: String
)