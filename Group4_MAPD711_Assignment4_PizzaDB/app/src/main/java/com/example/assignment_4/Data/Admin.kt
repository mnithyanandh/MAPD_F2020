package com.example.assignment_4.Data

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "Admin")
class Admin {
    @PrimaryKey(autoGenerate = true) var adminId: Int = 0
    @ColumnInfo(name = "Username") var userName: String = "admin"
    @ColumnInfo(name = "Password") var password: String = "admin"
    @ColumnInfo(name = "First_Name") var firstName: String = "Admin First Name"
    @ColumnInfo(name = "Last_Name") var lastName: String = "Admin Last Name"
}