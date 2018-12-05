package com.example.rries.sampleapp.utils.dagger

import com.example.rries.sampleapp.cucumbertests.AddTodoFeaturesTest
import com.example.rries.sampleapp.dagger.components.ApplicationComponent
import dagger.Component

@TestScope
@Component(dependencies = [ApplicationComponent::class])
interface TestComponent {
    fun inject(addTodoFeaturesTest: AddTodoFeaturesTest)
}