package ru.easycode.zerotoheroandroidtdd.dataBase

import android.widget.TextView
import ru.easycode.zerotoheroandroidtdd.delete.ItemUiDelete

data class ItemUi(
    val id: Long,
    val text: String,
) {
    fun areItemTheSame(other: ItemUi) = id == other.id

    fun delete(itemUiDelete: ItemUiDelete) = itemUiDelete.delete(id)

    fun show(textView: TextView) = textView.setText(text)
}
