package com.example.rries.sampleapp.data

import android.arch.persistence.room.Database
import android.arch.persistence.room.RoomDatabase

@Database(entities = [Todo::class], version = 1, exportSchema = false)
abstract class TodoListDatabase: RoomDatabase() {

    abstract fun todoDao(): TodoDao
}