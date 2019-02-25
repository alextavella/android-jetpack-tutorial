package com.example.androidjetpacktutorial.di

import com.example.androidjetpacktutorial.StartActivity
import com.example.androidjetpacktutorial.config.TutorialApplication
import com.example.androidjetpacktutorial.ui.start.StartFragment
import dagger.Module
import dagger.android.ContributesAndroidInjector

@Module
abstract class ActivityModule {

    @ContributesAndroidInjector
    internal abstract fun contributeStartActivity(): StartActivity

    @ContributesAndroidInjector
    internal abstract fun contributeStartFragment(): StartFragment
}