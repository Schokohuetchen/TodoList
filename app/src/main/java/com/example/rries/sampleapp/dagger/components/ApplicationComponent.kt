package com.example.rries.sampleapp.dagger.components

import com.example.rries.sampleapp.TodoApplication
import com.example.rries.sampleapp.dagger.RoomModule
import com.example.rries.sampleapp.data.TodoRepository
import com.example.rries.sampleapp.ui.EditTodoActivity
import com.example.rries.sampleapp.ui.TodoViewModel
import dagger.Component
import javax.inject.Singleton

@Singleton
@Component(modules = [RoomModule::class])
interface ApplicationComponent {
    fun inject(todoApplication: TodoApplication)
    fun inject(editTodoActivity: EditTodoActivity)
    fun inject(todoViewModel: TodoViewModel)

    fun todoRepository(): TodoRepository
}