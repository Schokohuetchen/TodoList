package com.example.rries.sampleapp.ui

import android.os.Bundle
import com.example.rries.sampleapp.R

class EditTodoActivity: NewTodoActivity() {

    private var todoToEdit: String? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_new_todo)

        saveTodo()
    }
}