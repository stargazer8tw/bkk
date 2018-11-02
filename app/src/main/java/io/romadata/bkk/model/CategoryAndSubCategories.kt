package io.romadata.bkk.model

import android.arch.persistence.room.Embedded
import android.arch.persistence.room.Relation

class CategoryAndSubCategories() {

    @Embedded
    var category: Category? = null

    @Relation(
        parentColumn = "uid",
        entityColumn = "category_uid",
        entity = SubCategory::class
    )
    var subCategoryList: List<SubCategory> = ArrayList()
}