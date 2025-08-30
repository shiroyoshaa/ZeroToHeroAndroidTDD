package ru.easycode.zerotoheroandroidtdd.delete

import android.widget.Button

interface ItemUiDelete {
    fun delete(id: Long)
}

class MyClass {
    companion object {
        const val TEXT = "add"
        fun setButtonText(button: Button,text: String) {
            button.text = text
        }
    }
}