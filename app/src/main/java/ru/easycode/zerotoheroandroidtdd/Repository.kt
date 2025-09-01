package ru.easycode.zerotoheroandroidtdd

import android.util.Log
import javax.sql.DataSource

interface Repository {
    interface Read {
        fun list(): List<Item>
    }

    interface Add {
        fun add(value: String): Long
    }

    interface ChangeItem {
        fun update(id: Long, newText: String)
    }

    interface DeleteItem {
        fun delete(id: Long)
    }

    interface ReadItem{
        fun item(id: Long): ru.easycode.zerotoheroandroidtdd.Item
    }

    interface Mutable: Read, Add
    interface Change: ChangeItem, DeleteItem, ReadItem
    interface All: Mutable, Change

    class Base(private val dataSource: ItemsDao,
               private val now: Now): All {

        override fun list(): List<Item> {
            val list = dataSource.list()
            val item = list.map { Item(
                id = it.id,
                text = it.text,
            ) }
            return item
        }

        override fun add(value: String): Long {
            val id = now.nowMillis()
            val itemCache = ItemCache(id,value)
            dataSource.add(itemCache)
            return id
        }

        override fun update(id: Long, newText: String) {
            val newItemCache = ItemCache(id,newText)
            dataSource.add(newItemCache)

        }

        override fun delete(id: Long) {

            dataSource.delete(id)

        }

        override fun item(id: Long): Item {
            val itemCache = dataSource.item(id)
            val item = Item(itemCache.id,itemCache.text)
            return item
        }
    }
}
data class Item(
    val id: Long,
        val text: String
        )

