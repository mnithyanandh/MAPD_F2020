package com.example.assignment_4.Database

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.example.assignment_4.DAO.AdminDAO
import com.example.assignment_4.Data.Admin

@Database(entities = arrayOf(Admin::class), version = 1, exportSchema = false)
abstract class AdminDatabase : RoomDatabase() {
    abstract fun getDAO(): AdminDAO

    // Make a singleton instance of the Database using the 'companion' method:
    companion object{

        var DBinstance: AdminDatabase?=null
        //Get an instance of the Database using an object if null

        fun getDBInstance(context: Context): AdminDatabase?{
            if(DBinstance == null) {
                synchronized(AdminDatabase::class) {
                    DBinstance = Room.databaseBuilder(
                        context.applicationContext,
                        AdminDatabase::class.java,
                        "admin.db"
                    ).build()
                }
            }
            return DBinstance
        }

    }

}