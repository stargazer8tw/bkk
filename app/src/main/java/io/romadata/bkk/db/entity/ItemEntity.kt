package io.romadata.bkk.db.entity

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

import java.util.Date
import java.util.UUID
import java.math.BigDecimal

@Entity(tableName = "items")
data class ItemEntity(
    @PrimaryKey
    @ColumnInfo(name = "uid")
    val uid: String = UUID.randomUUID().toString(),

    @ColumnInfo(name = "category_name")
    var name: String = "",

    @ColumnInfo(name = "category_item_name")
    var category_item_name: String,

    @ColumnInfo(name = "time")
    var time: Date,

    @ColumnInfo(name = "amount")
    var amount: BigDecimal,

    @ColumnInfo(name = "payment_type")
    var paymentType: String,

    @ColumnInfo(name = "bkk")
    val bkk: String = "default",

    @ColumnInfo(name = "comment")
    var comment: String
)