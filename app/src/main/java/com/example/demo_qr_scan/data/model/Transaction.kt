package com.example.demo_qr_scan.data.model

import androidx.room.*
import java.sql.Date

@Entity(
    tableName = "transaction_table", foreignKeys = [ForeignKey(
        entity = LoggedInUser::class, parentColumns = ["id"],
        childColumns = ["user_id"]
    )], indices = [Index(value = ["user_id"], unique = true)]
)
data class Transaction(
    @PrimaryKey(autoGenerate = true) @ColumnInfo(name = "id") val id: Int,
    @ColumnInfo(name = "title") val title: String,
    @ColumnInfo(name = "description") val des: String,
    @ColumnInfo(name = "value") val value: Double,
    @ColumnInfo(name = "created_date") val date: Long,
    @ColumnInfo(name = "avatar_url") val ava: String,
    @ColumnInfo(name = "user_id") val userId: Int
)