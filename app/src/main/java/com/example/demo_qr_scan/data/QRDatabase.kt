package com.example.demo_qr_scan.data

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.example.demo_qr_scan.data.dao.UserDao
import com.example.demo_qr_scan.data.model.LoggedInUser
import com.example.demo_qr_scan.data.model.Transaction
import com.example.demo_qr_scan.data.model.Wallet

@Database(entities = [LoggedInUser::class, Transaction::class, Wallet::class], version = 1)
abstract class QRDatabase : RoomDatabase() {
    abstract fun userDao(): UserDao

    companion object {
        @Volatile
        private var INSTANCE: QRDatabase? = null

        fun getDatabase(context: Context): QRDatabase {
            return INSTANCE?: synchronized(this){
                val instance = Room.databaseBuilder(context.applicationContext, QRDatabase::class.java, "qr_database").build()
                INSTANCE = instance
                return instance
            }
        }
    }
}