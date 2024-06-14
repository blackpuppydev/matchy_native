package com.blackpuppydev.matchy_native.database.dao

import androidx.room.*
import com.blackpuppydev.matchy_native.database.entity.UserEntity

@Dao
interface UserDao {
    @Insert
    fun insertUser(userEntity: UserEntity.UsersEntity)

    @Update()
    fun updateUser(userEntity: UserEntity)

    @Delete
    fun deleteUser(userEntity: UserEntity)

    @Query("SELECT * FROM user")
    fun getUserAll(): List<UserEntity>


    @Query("DELETE FROM user")
    fun deleteTable()

}