package com.example.assignment_4.Data

import android.location.Address
import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "Customer")
data class Customer (
    @PrimaryKey(autoGenerate = true) val customerId: Int,
    @ColumnInfo(name = "Username") val userName: String,
    @ColumnInfo(name = "Password") var password: String,
    @ColumnInfo(name = "First_Name") val firstName: String,
    @ColumnInfo(name = "Last_Name") val lastName: String,
    @ColumnInfo(name = "Address") val address: Address,
    @ColumnInfo(name = "City") val city: String,
    @ColumnInfo(name = "Postal_Code") val postal_code: Int
)