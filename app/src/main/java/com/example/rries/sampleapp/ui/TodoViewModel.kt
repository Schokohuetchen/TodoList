package com.example.rries.sampleapp.ui

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import com.example.rries.sampleapp.TodoApplication
import com.example.rries.sampleapp.data.Todo
import com.example.rries.sampleapp.data.TodoRepository
import kotlinx.coroutines.*
import kotlinx.coroutines.android.Main
import javax.inject.Inject
import kotlin.coroutines.CoroutineContext


class TodoViewModel(application: Application): AndroidViewModel(application) {

    @Inject
    lateinit var todoRepository: TodoRepository

    var allTodos: LiveData<List<Todo>>? = null

    private var parentJob = Job()
    private val coroutineContext: CoroutineContext
        get() = parentJob + Dispatchers.Main

    private val scope = CoroutineScope(coroutineContext)

    init {
        (application.applicationContext as TodoApplication).component.inject(this)
        allTodos = todoRepository.allTodos
    }

    fun addTodo(todo: Todo) = scope.launch(Dispatchers.IO) {
        todoRepository.addTodo(todo)
    }

    fun updateTodo(todo: Todo) = scope.launch(Dispatchers.IO) {
        todo.let{ todoRepository.updateTodo(todo) }
    }

    fun deleteTodo(todoId: Int) = scope.launch(Dispatchers.IO) {
        val todo = getTodoById(todoId)
        todo?.let { todoRepository.deleteTodo(it) }
    }

    fun getTodoById(todoId: Int): Todo? = todoRepository.getTodoById(todoId)

    override fun onCleared() {
        super.onCleared()
        parentJob.cancel()
    }
}