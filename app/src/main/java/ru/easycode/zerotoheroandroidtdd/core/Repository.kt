package ru.easycode.zerotoheroandroidtdd.core

import android.util.Log
import ru.easycode.zerotoheroandroidtdd.dataBase.Item
import ru.easycode.zerotoheroandroidtdd.dataBase.ItemCache
import ru.easycode.zerotoheroandroidtdd.dataBase.ItemsDao

interface Repository {
    interface Read {
        fun list(): List<Item>
    }
    interface Add {
        fun add(value: String): Long
    }
    interface Delete{
        fun delete(id: Long)
        fun item(id: Long): Item
    }

    interface Mutable: Read, Add
    interface All: Mutable, Delete
    class Base(private val dataSource: ItemsDao, private val now: Now): All {

        override fun list(): List<Item> {
            val newList = dataSource.list()
            val itemList = newList.map { item ->
                Item(
                    id = item.id,
                    text = item.text,
                )
            }
            return itemList
        }

        override fun add(value: String): Long {
            val currentTime = now.nowMillis()
            dataSource.add(ItemCache(id = currentTime, text = value))
            return currentTime
        }

        override fun delete(id: Long) {
            dataSource.delete(id)
        }

        override fun item(id: Long): Item {
            val currentItem = dataSource.item(id)
            val newItem = Item(id = currentItem.id, text = currentItem.text)
            return newItem
        }
    }
}