package com.example.rries.sampleapp.ui

import android.app.Application
import android.arch.lifecycle.AndroidViewModel
import android.arch.lifecycle.LiveData
import com.example.rries.sampleapp.data.Todo
import com.example.rries.sampleapp.data.TodoListDatabase
import com.example.rries.sampleapp.data.TodoRepository
import kotlinx.coroutines.*
import kotlinx.coroutines.android.Main
import kotlin.coroutines.CoroutineContext


class TodoViewModel(application: Application): AndroidViewModel(application) {

    private var todoRepository: TodoRepository? = null
    var allTodos: LiveData<List<Todo>>? = null

    private var parentJob = Job()
    private val coroutineContext: CoroutineContext
        get() = parentJob + Dispatchers.Main

    private val scope = CoroutineScope(coroutineContext)

    init {
        val todoDao = TodoListDatabase.getDatabase(application).todoDao()
        todoRepository = TodoRepository(todoDao)

        allTodos = todoRepository?.allTodos
    }

    fun addTodo(todo: Todo) = scope.launch(Dispatchers.IO) {
        todoRepository?.addTodo(todo)
    }

    override fun onCleared() {
        super.onCleared()
        parentJob.cancel()
    }
}