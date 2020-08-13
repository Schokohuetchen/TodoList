package com.example.rries.sampleapp.data

import androidx.lifecycle.LiveData
import androidx.annotation.WorkerThread

class TodoRepository(private val todoDao: TodoDao) {

    val allTodos: LiveData<List<Todo>> = todoDao.getAllTodos()

    fun getTodoById(todoId: Int): Todo? =
        allTodos.value?.find {
            it.todoId == todoId
        }

    fun addTodo(todo: Todo) {
        todoDao.addTodo(todo)
    }

    fun updateTodo(todo: Todo) {
        todoDao.updateTodo(todo)
    }

    fun deleteTodo(todo: Todo) {
        todoDao.deleteTodo(todo)
    }

    fun deleteAll() {
        todoDao.deleteAll()
    }
}