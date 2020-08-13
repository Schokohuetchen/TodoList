package com.example.rries.sampleapp.data

import androidx.room.Entity
import androidx.room.Ignore
import androidx.room.PrimaryKey

@Entity(tableName = "todo_table")
data class Todo (var description: String) {
    @PrimaryKey(autoGenerate = true)
    var todoId: Int = 0

    @Ignore
    constructor(todoId: Int, description: String) : this(description) {
        this.todoId = todoId
        this.description = description
    }
}