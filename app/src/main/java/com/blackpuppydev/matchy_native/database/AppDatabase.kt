package com.blackpuppydev.matchy_native.database

import android.content.Context
import androidx.room.Room
import androidx.room.RoomDatabase
import com.blackpuppydev.matchy_native.database.dao.UserDao

abstract class AppDatabase : RoomDatabase() {

    companion object {
        fun getAppDatabase(context: Context): AppDatabase =
            Room.databaseBuilder(context, AppDatabase::class.java, "db_app").build()
    }

    abstract fun userDao(): UserDao

}