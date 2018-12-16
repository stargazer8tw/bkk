package io.romadata.bkk.db.entity

/**
 * see https://android.jlelse.eu/setting-android-room-in-real-project-58a77469737c?gi=e64097fffe8f
 * see https://developer.android.com/training/data-storage/room/defining-data
 */
@Entity(
    tableName = "subcategory",
    indices = arrayOf(
        Index(value = arrayOf("category_uid")),
        Index(value = arrayOf("uid", "category_uid"), unique = true)
    ),
    foreignKeys = arrayOf(
        ForeignKey(
            entity = CategoryEntity::class,
            parentColumns = arrayOf("uid"),
            childColumns = arrayOf("category_uid"),
            onDelete = ForeignKey.CASCADE
        )
    )
)
data class CategoryItemEntity(
    @PrimaryKey
    @ColumnInfo(name = "uid")
    val uid: String,

    @ColumnInfo(name = "category_uid")
    val categoryUid: String,

    @ColumnInfo(name = "name")
    var name: String = "",

    @ColumnInfo(name = "ordinal")
    var seq: Long
)
