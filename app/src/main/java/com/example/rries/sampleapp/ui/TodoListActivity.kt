package com.example.rries.sampleapp.ui

import android.app.Activity
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import android.widget.Toast
import com.example.rries.sampleapp.R
import com.example.rries.sampleapp.data.Todo
import kotlinx.android.synthetic.main.activity_main.*

class TodoListActivity : AppCompatActivity(), TodoListAdapter.TodoListAdapterActions {

    private lateinit var todoViewModel: TodoViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val adapter = TodoListAdapter(this)
        recyclerview.adapter = adapter
        recyclerview.layoutManager =
            LinearLayoutManager(this)

        todoViewModel = ViewModelProviders.of(this).get(TodoViewModel::class.java)
        todoViewModel.allTodos?.observe(this, Observer { todos ->
            todos?.let { adapter.setTodos(it) }
        })

        fab.setOnClickListener {
            val intent = Intent(this@TodoListActivity, NewTodoActivity::class.java)
            startActivityForResult(intent, newTodoActivityRequestCode)
        }
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)

        if (requestCode == newTodoActivityRequestCode && resultCode == Activity.RESULT_OK) {
            data?.let {
                val todo = Todo(it.getStringExtra(NewTodoActivity.EXTRA_REPLY))
                todoViewModel.addTodo(todo)
            }
        } else if (requestCode == updateTodoActivityResult && resultCode == Activity.RESULT_OK) {
            data?.let {
                val stringExtra = it.getStringExtra(EditTodoActivity.EXTRA_DESCRIPTION)
                val todoId = it.getIntExtra(EditTodoActivity.EXTRA_ID, 0)

                val todo =
                    if (todoId != 0) {
                        Todo(todoId, stringExtra)
                    } else {
                        Todo(stringExtra)
                    }

                todoViewModel.updateTodo(todo)
            }
        } else {
            Toast.makeText(
                applicationContext,
                R.string.empty_not_saved,
                Toast.LENGTH_LONG).show()
        }
    }

    override fun requestEditTodoActivity(todoId: Int) {
        val intent = Intent(this@TodoListActivity, EditTodoActivity::class.java)
        intent.putExtra("todoId", todoId)
        startActivityForResult(intent, updateTodoActivityResult)
    }

    override fun requestDeleteTodo(todoId: Int) {
        todoViewModel.deleteTodo(todoId)
        recyclerview.adapter?.notifyDataSetChanged()
    }

    companion object {
        const val newTodoActivityRequestCode = 1
        const val updateTodoActivityResult = 2
    }
}
