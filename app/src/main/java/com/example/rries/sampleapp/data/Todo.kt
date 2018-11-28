package com.example.rries.sampleapp.data

import android.arch.persistence.room.Entity
import android.arch.persistence.room.PrimaryKey

@Entity(tableName = "todo_table")
data class Todo (val description: String) {
    @PrimaryKey(autoGenerate = true)
    var todoId: Int = 0
}