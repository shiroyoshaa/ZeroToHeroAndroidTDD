package ru.easycode.zerotoheroandroidtdd.main

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager

interface Screen {
    fun show(fragmentManager: FragmentManager,containerId: Int)

    abstract class Replace(private val fragment: Fragment): Screen {
        override fun show(fragmentManager: FragmentManager, containerId: Int) {
            val prevFragment = fragmentManager.findFragmentByTag("prev_tab")
            fragmentManager.beginTransaction().apply {
                if(prevFragment != null)
                    show(prevFragment)
                replace(containerId,fragment,"prev_tab")
                commit()
            }
        }
    }
    abstract class Add(private val fragment: Fragment,private val previousFragment: Fragment): Screen {
        override fun show(fragmentManager: FragmentManager, containerId: Int) {
            fragmentManager.beginTransaction()
                .hide(previousFragment)
                .add(containerId,fragment)
                .commit()
        }
    }
}