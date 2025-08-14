package ru.easycode.zerotoheroandroidtdd

import android.os.Bundle

interface BundleWrapper {
    interface Save {
        fun save(list: ArrayList<CharSequence>)
    }
    interface Restore {
        fun restore(): List<CharSequence>
    }
    interface Mutable: Save,Restore

    class Base(private val savingState: Bundle): Mutable {
        companion object {
            private const val KEY = "ListSavingKey"
        }
        override fun save(list: ArrayList<CharSequence>) {
            savingState.putCharSequenceArrayList(KEY,list)
        }

        override fun restore(): List<CharSequence> {
            val list: List<CharSequence>  = savingState.getCharSequenceArrayList(KEY)!!
            return list
        }
    }
}