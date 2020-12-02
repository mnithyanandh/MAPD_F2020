package com.example.assignment_4.Database

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.example.assignment_4.DAO.CustomerDAO
import com.example.assignment_4.Data.Customer

@Database(entities = arrayOf(Customer::class), version = 1, exportSchema = false)
abstract class CustomerDatabase : RoomDatabase(){
    abstract fun getDAO(): CustomerDAO

    // Make a singleton instance of the Database using the 'companion' method:
    companion object{

        var DBinstance: CustomerDatabase?=null
        //Get an instance of the Database using an object if null

        fun getDBInstance(context: Context): CustomerDatabase? {
            if(DBinstance == null) {
                synchronized(CustomerDatabase::class) {
                    DBinstance = Room.databaseBuilder(
                        context.applicationContext,
                        CustomerDatabase::class.java,
                        "customer.db"
                    ).build()
                }
            }
            return DBinstance
        }

    }
}