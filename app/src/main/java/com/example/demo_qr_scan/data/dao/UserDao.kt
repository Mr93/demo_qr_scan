package com.example.demo_qr_scan.data.dao

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.example.demo_qr_scan.data.model.LoggedInUser

@Dao
interface UserDao {

    @Query("SELECT * from user_table where user_name = :name and password = :pass ")
    fun getUser(name: String, pass: String): LiveData<LoggedInUser>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun register(user: LoggedInUser)
}