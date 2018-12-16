package io.romadata.bkk.db.entity

import android.arch.persistence.room.ColumnInfo
import android.arch.persistence.room.Entity
import android.arch.persistence.room.PrimaryKey

import java.util.Date
import java.math.BigDecimal

@Entity
data class ItemEntity(
    @PrimaryKey
    @ColumnInfo(name = "uid")
    val uid: String,

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