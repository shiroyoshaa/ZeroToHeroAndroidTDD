package ru.easycode.zerotoheroandroidtdd.core

import android.util.Log
import javax.sql.DataSource

interface Repository {
    interface Read {
        fun list(): List<String>
    }
    interface Add {
        fun add(value: String)
    }
    interface Mutable: Read, Add
    class Base(private val dataSource: ItemsDao
    ,private val now: Now): Mutable {
        override fun list(): List<String> {
            val new = dataSource.list()
            val list: ArrayList<String> = ArrayList(new.map { it.text })
            return list
        }

        override fun add(value: String) {
            val a = now.nowMillis()
            dataSource.add(ItemCache(id = a,text = value))
        }
    }
}