package io.romadata.bkk.model

import androidx.room.Room
import androidx.test.InstrumentationRegistry
import androidx.test.runner.AndroidJUnit4
import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.Observer

import org.junit.After
import org.junit.Before
import org.junit.Assert.*
import org.junit.Test
import org.junit.runner.RunWith

import io.romadata.bkk.AppDatabase
import io.romadata.bkk.db.entity.CategoryEntity
import io.romadata.bkk.db.entity.CategoryItemEntity

/**
 * Test the implementation of [CategoryDao]
 */
@RunWith(AndroidJUnit4::class)
class CategoryEntityDaoTest {

    private lateinit var database: AppDatabase

    @Before
    fun setup() {
        // using an in-memory database because the information stored here disappears after test
        // see https://medium.com/@chandilsachin/room-with-unit-test-in-kotlin-4ad31a39a291
        database = AppDatabase.getInstance(InstrumentationRegistry.getTargetContext())
    }

    @After
    fun tearDown() {
        database.clearAllTables()
//        database.close()
    }

    @Test
    fun insertAndGetCategory() {
        // When inserting a new subcategory in the data source
        database.categoryDao().insert(CATEGORY)

        val list = database.categoryDao().all
        assertNotNull(list)
        assertEquals(CATEGORY.name, list.get(0).name)
    }

    @Test
    fun updateAndGetCategory() {
        // When inserting a new subcategory in the data source
        database.categoryDao().insert(CATEGORY)

        // When we are updating the name of the user
        val updatedCategory = database.categoryDao().all.get(0)
        Log.d("test", "id = " + updatedCategory.uid)
        updatedCategory.name = "new food"
        database.categoryDao().insert(updatedCategory)

        val list = database.categoryDao().all
        assertNotNull(list)
        assertEquals(updatedCategory.name, list.get(0).name)
    }

    @Test
    fun deleteAndGetCategory() {
        // When inserting a new subcategory in the data source
        database.categoryDao().insert(CATEGORY)

        //When we are deleting all subcategory
        database.categoryDao().delete(database.categoryDao().all.get(0))

        val list = database.categoryDao().all
        assertNotNull(list)
        assertEquals(0, list.size)
    }

    @Test
    fun insertSubCategory() {
        // When inserting a new subcategory in the data source
        database.categoryDao().insert(CATEGORY)

        val dCate = database.categoryDao().getCategory("food")
        val subCate = CategoryItemEntity("0001", dCate.uid, "meat", 0)
        database.categoryDao().insert(subCate)

        val list = database.categoryDao().categoryItemEntities
        assertNotNull(list)
        assertEquals(subCate.name, list.get(0).name)
    }

    @Test
    fun getCategoryAndSubCategory() {
        // When inserting a new subcategory in the data source
        database.categoryDao().insert(CATEGORY)

        val dCate = database.categoryDao().getCategory("food")
        val subCate = CategoryItemEntity("0001", dCate.uid, "meat", 0)
        database.categoryDao().insert(subCate)

        val list = database.categoryDao().getFullCategories()
        assertNotNull(list)
        list.getValueBlocking().let{it.get(0).let {
            assertEquals(CATEGORY.name, it.category.name)
            assertEquals(subCate.name, it.subCategoryList.get(0).name)
        }}

    }

    companion object {
        private val CATEGORY = CategoryEntity("0000", "food", 0)
    }

    @Throws(InterruptedException::class)
    fun <T> LiveData<T>.getValueBlocking(): T? {
        var value: T? = null
        val latch = CountDownLatch(1)
        val innerObserver = Observer<T> {
            value = it
            latch.countDown()
        }
        observeForever(innerObserver)
        latch.await(2, TimeUnit.SECONDS)
        return value
    }
}