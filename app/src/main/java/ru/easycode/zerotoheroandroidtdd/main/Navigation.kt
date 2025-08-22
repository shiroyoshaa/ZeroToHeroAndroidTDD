package ru.easycode.zerotoheroandroidtdd.main

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.google.android.material.animation.AnimationUtils
import ru.easycode.zerotoheroandroidtdd.core.SingleLiveEvent
import ru.easycode.zerotoheroandroidtdd.list.LiveDataWrapper

interface Navigation: LiveDataWrapper {

    interface Read: LiveDataWrapper.Read<Screen>

    interface Update: LiveDataWrapper.Update<Screen>



    interface Mutable: Read, Update

    class Base: Mutable, LiveDataWrapper.Abstract<Screen>()

}



