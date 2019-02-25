package com.example.androidjetpacktutorial.di

import com.example.androidjetpacktutorial.config.TutorialApplication
import dagger.BindsInstance
import dagger.Component
import dagger.android.AndroidInjectionModule
import dagger.android.support.AndroidSupportInjectionModule
import javax.inject.Singleton

@Singleton
@Component(
    modules = arrayOf(
        AndroidInjectionModule::class,
        AndroidSupportInjectionModule::class,
        TutorialModule::class,
        ActivityModule::class
    )
)
interface TutorialComponent {

    @Component.Builder
    interface Builder {

        @BindsInstance
        fun application(app: TutorialApplication): Builder

        fun build(): TutorialComponent
    }

    fun inject(app: TutorialApplication)
}
