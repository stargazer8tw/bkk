package io.romadata.bkk.db.entity

import android.arch.persistence.room.TypeConverter
import java.util.Date
import java.math.BigDecimal


class Converters {

    @TypeConverter
    fun fromTimestamp(value: Long?): Date? {
//        return if (value == null) null else Date(value)
        return value?.let { Date(it) }
    }

    @TypeConverter
    fun dateToTimestamp(date: Date?): Long? {
        return date?.time
    }

    @TypeConverter
    fun fromString(value: String?): BigDecimal? {
        return value?.let { BigDecimal(it) }
    }

    @TypeConverter
    fun amountToString(bigDecimal: BigDecimal?): Double? {
        return bigDecimal!!.setScale(2, BigDecimal.ROUND_HALF_UP).toDouble()
    }
}