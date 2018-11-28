package com.example.rries.sampleapp.ui

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import com.example.rries.sampleapp.R
import com.example.rries.sampleapp.TodoApplication
import com.example.rries.sampleapp.data.TodoRepository
import kotlinx.android.synthetic.main.activity_new_todo.*
import javax.inject.Inject

class EditTodoActivity: AppCompatActivity() {

    private var todoId: Int? = null

    @Inject
    lateinit var todoRepository: TodoRepository

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_new_todo)

        val intent = intent
        todoId = intent.getIntExtra("todoId", 0)

        (application as TodoApplication).component.inject(this)

        setTodoData()
    }

    private fun setTodoData() {
        val todo = todoId?.let{ todoRepository.getTodoById(it) }

        editTodo.setText(todo?.description)
    }
}