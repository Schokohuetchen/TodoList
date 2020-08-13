package com.example.rries.sampleapp.ui

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import android.text.TextUtils
import com.example.rries.sampleapp.R
import kotlinx.android.synthetic.main.activity_new_todo.*

open class NewTodoActivity: AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_new_todo)

        saveTodo()
    }

    fun saveTodo() {
        saveTodoButton.setOnClickListener {
            val replyIntent = Intent()

            if (TextUtils.isEmpty(editTodo.text)) {
                setResult(Activity.RESULT_CANCELED, replyIntent)
            } else {
                val todo = editTodo.text.toString()
                replyIntent.putExtra(EXTRA_REPLY, todo)
                setResult(Activity.RESULT_OK, replyIntent)
            }
            finish()
        }
    }

    companion object {
        const val EXTRA_REPLY = "com.examples.rries.sampleapp.REPLY"
    }
}
