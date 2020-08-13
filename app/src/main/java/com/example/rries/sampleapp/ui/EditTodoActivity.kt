package com.example.rries.sampleapp.ui

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import android.text.TextUtils
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

        saveTodoButton.setOnClickListener {
            val replyIntent = Intent()

            if (TextUtils.isEmpty(editTodo.text)) {
                setResult(Activity.RESULT_CANCELED, replyIntent)
            } else {
                val todoDescription = editTodo.text.toString()
                replyIntent.putExtra(EXTRA_DESCRIPTION, todoDescription)
                replyIntent.putExtra(EXTRA_ID, todoId)
                setResult(Activity.RESULT_OK, replyIntent)
            }
            finish()
        }
    }

    companion object {
        const val EXTRA_DESCRIPTION = "com.examples.rries.sampleapp.DESCRIPTION"
        const val EXTRA_ID = "com.examples.rries.sampleapp.ID"
    }
}