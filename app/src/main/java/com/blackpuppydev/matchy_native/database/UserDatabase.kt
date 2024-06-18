package com.blackpuppydev.matchy_native.database

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.blackpuppydev.matchy_native.database.dao.UserDao
import com.blackpuppydev.matchy_native.database.entity.UsersEntity


@Database(entities = [UsersEntity::class],version = 1)
abstract class UserDatabase : RoomDatabase() {

    companion object {
        fun getUserDatabase(context: Context): UserDatabase =
            Room.databaseBuilder(context, UserDatabase::class.java, "db_app").build()
    }

    abstract fun userDao(): UserDao

}