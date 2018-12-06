package com.example.rries.sampleapp.utils.dagger

import com.example.rries.sampleapp.test.steps.AddTodoSteps
import com.example.rries.sampleapp.dagger.components.ApplicationComponent
import dagger.Component

@TestScope
@Component(dependencies = [ApplicationComponent::class])
interface TestComponent {
    fun inject(addTodoSteps: AddTodoSteps)
}