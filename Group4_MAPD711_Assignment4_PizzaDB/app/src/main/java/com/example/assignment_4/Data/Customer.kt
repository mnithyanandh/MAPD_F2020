package com.example.assignment_4.Data

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "Customer")
class Customer {
    @PrimaryKey
    var customerId: Int = 0
    @ColumnInfo(name = "Username")
    var userName: String = ""
    @ColumnInfo(name = "Password")
    var password: String = ""
    @ColumnInfo(name = "First_Name")
    var firstName: String = ""
    @ColumnInfo(name = "Last_Name")
    var lastName: String = ""
    @ColumnInfo(name = "Email")
    var email: String = ""
    @ColumnInfo(name = "Address")
    var address: String = ""
    @ColumnInfo(name = "Postal_Code")
    var postal_code: String = ""
    @ColumnInfo(name = "City")
    var city: String = ""
    @ColumnInfo(name = "Phone Number")
    var phone: String = ""
}