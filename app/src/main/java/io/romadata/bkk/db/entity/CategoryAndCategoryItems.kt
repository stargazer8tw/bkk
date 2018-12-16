package io.romadata.bkk.db.entity

import android.arch.persistence.room.Embedded
import android.arch.persistence.room.Relation
import io.romadata.bkk.db.entity.CategoryEntity
import io.romadata.bkk.db.entity.CategoryItemEntity

class CategoryAndCategoryItems() {

    @Embedded
    var categoryEntity: CategoryEntity? = null

    @Relation(
        parentColumn = "uid",
        entityColumn = "category_uid",
        entity = CategoryItemEntity::class
    )
    var categoryItemEntityList: List<CategoryItemEntity> = ArrayList()
}