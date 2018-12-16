package io.romadata.bkk

import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import android.content.Context

import io.romadata.bkk.db.dao.CategoryDao
import io.romadata.bkk.db.entity.CategoryEntity
import io.romadata.bkk.db.entity.CategoryItemEntity
import io.romadata.bkk.db.converter.Converters

/**
 * @see https://github.com/irontec/android-room-example
 * @see https://medium.com/google-developers/7-pro-tips-for-room-fbadea4bfbd1
 */
@Database(entities = arrayOf(CategoryEntity::class, CategoryItemEntity::class), version = 1, exportSchema = false)
@TypeConverters(Converters::class)
abstract class AppDatabase : RoomDatabase() {

    abstract fun categoryDao(): CategoryDao

    companion object {

        /**
         * The only instance
         */
        @Volatile
        private var INSTANCE: AppDatabase? = null

        fun getInstance(context: Context): AppDatabase =
                INSTANCE ?: synchronized(this) {
                    INSTANCE ?: buildDatabase(context).also { INSTANCE = it }
                }

        private fun buildDatabase(context: Context) =
                Room.databaseBuilder(context.applicationContext,
                        AppDatabase::class.java, "roma.db")
                        .allowMainThreadQueries()
                        .fallbackToDestructiveMigration()
                        .build()
//        @Synchronized
//        fun getInstance(context: Context): AppDatabase {
//            if (INSTANCE == null) {
//                INSTANCE = Room
//                        .databaseBuilder(context.applicationContext, AppDatabase::class.java, "example")
//                        .fallbackToDestructiveMigration()
//                        .build()
//            }
//            return INSTANCE!!
//        }
    }

}