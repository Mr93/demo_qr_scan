package com.example.demo_qr_scan.data.model

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.Index
import androidx.room.PrimaryKey

/**
 * Data class that captures user information for logged in users retrieved from LoginRepository
 */

@Entity(tableName = "user_table")
data class LoggedInUser(
    @ColumnInfo(name = "user_name") val userName: String,
    @ColumnInfo(name = "password") val password: String
) {
    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name = "id")
    var userId: Int = 0
}
