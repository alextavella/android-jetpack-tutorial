package com.example.androidjetpacktutorial.config

import android.app.Activity
import android.app.Application
import android.support.v4.app.Fragment
import com.example.androidjetpacktutorial.di.DaggerTutorialComponent
import dagger.android.DispatchingAndroidInjector
import dagger.android.HasActivityInjector
import dagger.android.support.HasSupportFragmentInjector
import javax.inject.Inject

class TutorialApplication : Application(),
    HasActivityInjector,
    HasSupportFragmentInjector {

    @Inject
    lateinit var activityDispatchingInjector: DispatchingAndroidInjector<Activity>

    @Inject
    lateinit var fragmentDispatchingInjector: DispatchingAndroidInjector<Fragment>

    override fun activityInjector() = activityDispatchingInjector

    override fun supportFragmentInjector() = fragmentDispatchingInjector

    override fun onCreate() {
        super.onCreate()
        setupDagger()
    }

    private fun setupDagger() {
        DaggerTutorialComponent.builder()
            .application(this)
            .build()
            .inject(this)
    }
}