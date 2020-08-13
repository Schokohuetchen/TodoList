package com.example.rries.sampleapp.data

import androidx.room.Database
import androidx.room.RoomDatabase

@Database(entities = [Todo::class], version = 1, exportSchema = false)
abstract class TodoListDatabase: RoomDatabase() {

    abstract fun todoDao(): TodoDao
}