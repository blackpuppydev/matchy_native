package com.blackpuppydev.matchy_native.database.entity

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey



    @Entity(tableName = "user")
    data class UsersEntity(

        @PrimaryKey(autoGenerate = true)
        var id: Int?,

//        @ColumnInfo(name = "first_name")
//        var firstName: String? = null,
//
//        @ColumnInfo(name = "last_name")
//        var lastName: String? = null,

        var username: String? = null,
        var password: String? = null

    )


