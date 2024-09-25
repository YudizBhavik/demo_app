package com.example.yudizapplication.roomdb.db

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query
import androidx.room.Update
import com.example.yudizapplication.roomdb.TodoEntity

@Dao
interface TodoDao {

    @Insert
    fun insert_todo(todoEntity: TodoEntity)

    @Update
    fun update_todo(todoEntity: TodoEntity)

    @Delete
    fun delete_todo(todoEntity: TodoEntity)

    @Query("select * from todo")
   fun getAll() : List<TodoEntity>
 }
