package ru.easycode.zerotoheroandroidtdd.main

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager

interface Screen {
    fun show(fragmentManager: FragmentManager,containerId: Int)

    abstract class Replace(private val fragment: Fragment): Screen {
        override fun show(fragmentManager: FragmentManager, containerId: Int) {
            fragmentManager.beginTransaction().apply {
                replace(containerId,fragment,"prev_tab")
                addToBackStack(null)
                commit()
            }
        }
    }

//    abstract class Add(private val fragment: Fragment,private val previousFragment: Fragment): Screen {
//
//        override fun show(fragmentManager: FragmentManager, containerId: Int) {
//
//            fragmentManager.beginTransaction()
//                .add(containerId,fragment)
//                .commit()
//        }
//    }
}