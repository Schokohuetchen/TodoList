package com.example.rries.sampleapp.dagger

import androidx.room.Room
import android.content.Context
import com.example.rries.sampleapp.data.TodoDao
import com.example.rries.sampleapp.data.TodoListDatabase
import com.example.rries.sampleapp.data.TodoRepository
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class RoomModule(private val context: Context) {

    @Provides
    @Singleton
    fun providesTodoListDatabase() = Room.databaseBuilder(context, TodoListDatabase::class.java, "todo_database").build()

    @Provides
    @Singleton
    fun provideTodoDao(todoListDatabase: TodoListDatabase) = todoListDatabase.todoDao()

    @Provides
    @Singleton
    fun providesTodoRepository(todoDao: TodoDao) = TodoRepository(todoDao)
}

