package io.romadata.bkk.db.entity

import android.arch.persistence.room.ColumnInfo
import android.arch.persistence.room.Entity
import android.arch.persistence.room.PrimaryKey

@Entity
data class CategoryEntity(
    @PrimaryKey
    @ColumnInfo(name = "uid")
    val uid: String,

    @ColumnInfo(name = "name")
    var name: String = "",

    @ColumnInfo(name = "ordinal")
    var ordinal: Long
)
