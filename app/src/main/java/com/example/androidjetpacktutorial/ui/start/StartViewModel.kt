package com.example.androidjetpacktutorial.ui.start

import android.arch.lifecycle.LiveData
import android.arch.lifecycle.MutableLiveData
import android.arch.lifecycle.ViewModel
import android.arch.lifecycle.ViewModelProvider
import javax.inject.Inject
import javax.inject.Singleton

class StartViewModel : ViewModel() {

    private val count = MutableLiveData<Int>().apply { postValue(0) }

    fun getCount(): LiveData<Int> = count

    fun increaseCount() = count.postValue(count.value?.plus(1))
}

@Singleton
class StartViewModelFactory @Inject constructor() : ViewModelProvider.NewInstanceFactory() {

    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        return StartViewModel() as T
    }
}
