package com.example.rries.sampleapp.data

import android.arch.persistence.room.Entity
import android.arch.persistence.room.Ignore
import android.arch.persistence.room.PrimaryKey

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