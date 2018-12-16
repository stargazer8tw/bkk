package io.romadata.bkk.db.dao

import androidx.lifecycle.LiveData
import androidx.paging.DataSource
import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query
import androidx.room.OnConflictStrategy
import androidx.room.Update
import io.romadata.bkk.db.entity.CategoryEntity
import io.romadata.bkk.db.entity.CategoryItemEntity

@Dao
interface CategoryDao {

    companion object {
        const val COL_UID = "uid"
        const val COL_CATE_UID = "category_uid"
        const val COL_NAME = "name"
        const val COL_SEQ = "ordinal"

        const val TBL_CATEGORY = "categories"
        const val TBL_CATEGORY_ITEM = "category_items"
    }


    @Query("SELECT * FROM $TBL_CATEGORY ORDER BY $COL_SEQ ASC")
    fun getAllCategories(): LiveData<List<CategoryEntity>>

    @Query("SELECT * FROM $TBL_CATEGORY ORDER BY $COL_SEQ ASC")
    fun allCategories(): LiveData<List<CategoryEntity>>

    @Query("SELECT * FROM $TBL_CATEGORY_ITEM ORDER BY $COL_SEQ ASC")
    fun allCategoryItems(): LiveData<List<CategoryItemEntity>>

    @Query("SELECT * FROM $TBL_CATEGORY_ITEM WHERE $COL_CATE_UID=:uid ORDER BY $COL_SEQ ASC")
    fun getSubCategories(uid: String): LiveData<List<CategoryItemEntity>>

    @Query("SELECT * FROM $TBL_CATEGORY WHERE $COL_NAME=:name")
    fun getCategory(name: String): CategoryEntity

    /**
     * OnConflictStrategy.REPLACE will cause relation data deleted
     * @see https://codelabs.developers.google.com/codelabs/android-room-with-a-view/index.html?index=..%2F..%2Findex#4
     */
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insert(categoryEntity: CategoryEntity)

    @Delete
    fun delete(categoryEntity: CategoryEntity)

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insert(subcategory: CategoryItemEntity)

    @Delete
    fun delete(subcategory: CategoryItemEntity)

    @Update
    fun update(categoryEntity: CategoryEntity)

    @Update
    fun update(subcategory: CategoryItemEntity)
}