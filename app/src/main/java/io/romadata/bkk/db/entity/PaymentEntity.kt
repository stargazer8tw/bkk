package io.romadata.bkk.db.entity

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import java.util.*

@Entity(tableName = "payments")
data class PaymentEntity(
    @PrimaryKey
    @ColumnInfo(name = "uid")
    val uid: String = UUID.randomUUID().toString(),

    @ColumnInfo(name = "name")
    var name: String = "",

    @ColumnInfo(name = "ordinal")
    var ordinal: Long
)
