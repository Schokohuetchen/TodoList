package com.example.rries.sampleapp.ui

import android.content.Context
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.MenuItem
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.PopupMenu
import android.widget.TextView
import com.example.rries.sampleapp.R
import com.example.rries.sampleapp.data.Todo

class TodoListAdapter constructor(private var context: Context)
    : RecyclerView.Adapter<TodoListAdapter.TodoListViewHolder>(), PopupMenu.OnMenuItemClickListener {

    private val inflater: LayoutInflater = LayoutInflater.from(context)
    private var todos = emptyList<Todo>()

    private val actions = context as TodoListAdapterActions
    private var lastClickedItemPosition = -1
    private var lastClickedOverflowMenu: View? = null

    override fun onBindViewHolder(holder: TodoListViewHolder, position: Int) {
        val current = todos[position]
        holder.todoItemView.text = current.description

        holder.openContextMenu.setOnClickListener {
            lastClickedItemPosition = holder.adapterPosition
            lastClickedOverflowMenu = it
            showPopUpMenu(it)
        }
    }

    override fun getItemCount() = todos.size

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): TodoListViewHolder {
        val itemView = inflater.inflate(R.layout.recyclerview_item, parent, false)
        return TodoListViewHolder(itemView)
    }

    fun setTodos(todos: List<Todo>) {
        this.todos = todos
        notifyDataSetChanged()
    }

    private fun showPopUpMenu(view: View) {
        val popUp = PopupMenu(view.context, view)
        popUp.setOnMenuItemClickListener(this)
        popUp.inflate(R.menu.popup_menu)
        popUp.show()
    }

    override fun onMenuItemClick(item: MenuItem?): Boolean {
       when(item!!.itemId) {
           R.id.edit -> {
               openEditTodoActivity()
               return true
           }
           R.id.delete -> {
               deleteTodo()
               return true
           }
       }
        return false
    }

    private fun openEditTodoActivity() {
        if (lastClickedOverflowMenu != null && lastClickedItemPosition >= 0)
            actions.requestEditTodoActivity(todos[lastClickedItemPosition].todoId)
    }

    private fun deleteTodo() {
        if (lastClickedOverflowMenu != null && lastClickedItemPosition >= 0) {
            actions.requestDeleteTodo(todos[lastClickedItemPosition].todoId)
        }
    }

    interface TodoListAdapterActions {
        fun requestEditTodoActivity(todoId: Int)
        fun requestDeleteTodo(todoId: Int)
    }

    inner class TodoListViewHolder(itemView: View): RecyclerView.ViewHolder(itemView) {
        val todoItemView: TextView = itemView.findViewById(R.id.textView)
        val openContextMenu: ImageView = itemView.findViewById(R.id.openContextMenu)
    }
}