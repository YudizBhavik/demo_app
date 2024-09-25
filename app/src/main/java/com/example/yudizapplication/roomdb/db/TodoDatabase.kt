package com.example.yudizapplication.roomdb.db

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.example.yudizapplication.roomdb.TodoEntity


@Database(entities = [TodoEntity::class], version = 1)
abstract class TodoDatabase: RoomDatabase() {
    abstract fun TodoDao() : TodoDao


    companion object {
        @Volatile
        private var INSTANCE: TodoDatabase? = null

        fun getDatabase(context: Context): TodoDatabase {
            return INSTANCE ?: synchronized(this) {
                val instance = Room.databaseBuilder(
                    context.applicationContext,
                    TodoDatabase::class.java,
                    "note_database"
                ).build()
                INSTANCE = instance
                instance
            }
        }
    }
}