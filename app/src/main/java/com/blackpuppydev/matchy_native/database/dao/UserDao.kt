package com.blackpuppydev.matchy_native.database.dao

import androidx.room.*
import com.blackpuppydev.matchy_native.database.entity.UsersEntity

@Dao
interface UserDao {

    @Insert
    fun insertUser(userEntity: UsersEntity)

    @Update()
    fun updateUser(userEntity: UsersEntity)

    @Delete
    fun deleteUser(userEntity: UsersEntity)

    @Query("SELECT * FROM user")
    fun getUserAll(): List<UsersEntity>


    @Query("DELETE FROM user")
    fun deleteTable()

}