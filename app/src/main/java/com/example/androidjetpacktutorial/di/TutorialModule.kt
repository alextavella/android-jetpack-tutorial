package com.example.androidjetpacktutorial.di

import com.example.androidjetpacktutorial.config.TutorialApplication
import com.example.androidjetpacktutorial.ui.start.StartViewModelFactory
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class TutorialModule {

    @Singleton
    @Provides
    fun providesAppContext(app: TutorialApplication) = app.applicationContext
}