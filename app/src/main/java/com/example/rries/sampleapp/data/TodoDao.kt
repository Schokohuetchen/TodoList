package com.example.rries.sampleapp.data

import android.arch.lifecycle.LiveData
import android.arch.persistence.room.*
import android.arch.persistence.room.OnConflictStrategy.REPLACE

@Dao
interface TodoDao {

    @Insert(onConflict = REPLACE)
    fun addTodo(todo: Todo)

    @Update(onConflict = REPLACE)
    fun updateTodo(todo: Todo)

    @Delete
    fun deleteTodo(todo: Todo)

    @Query("DELETE FROM todo_table")
    fun deleteAll()

    @Query("SELECT * FROM todo_table ORDER BY todoId ASC")
    fun getAllTodos(): LiveData<List<Todo>>
}