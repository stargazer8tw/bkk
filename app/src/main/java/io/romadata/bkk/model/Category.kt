package io.romadata.bkk.model

import android.arch.persistence.room.ColumnInfo
import android.arch.persistence.room.Entity
import android.arch.persistence.room.PrimaryKey

@Entity
data class Category(
    @PrimaryKey
    @ColumnInfo(name = "uid")
    val uid: String,

    @ColumnInfo(name = "name")
    var name: String = "",

    @ColumnInfo(name = "seq")
    var seq: Long
)
