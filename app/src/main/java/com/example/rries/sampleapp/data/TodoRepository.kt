package com.example.rries.sampleapp.data

import android.arch.lifecycle.LiveData
import android.support.annotation.WorkerThread

class TodoRepository(private val todoDao: TodoDao) {

    val allTodos: LiveData<List<Todo>> = todoDao.getAllTodos()

    fun getTodoById(todoId: Int): Todo? =
        allTodos.value?.find {
            it.todoId == todoId
        }

    @WorkerThread
    fun addTodo(todo: Todo) {
        todoDao.addTodo(todo)
    }

    @WorkerThread
    fun updateTodo(todo: Todo) {
        todoDao.updateTodo(todo)
    }

    @WorkerThread
    fun deleteTodo(todo: Todo) {
        todoDao.deleteTodo(todo)
    }
}