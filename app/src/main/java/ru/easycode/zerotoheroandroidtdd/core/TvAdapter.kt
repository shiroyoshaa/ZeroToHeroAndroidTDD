package ru.easycode.zerotoheroandroidtdd.core

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.fragment.app.FragmentManager
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import ru.easycode.zerotoheroandroidtdd.dataBase.ItemUi
import ru.easycode.zerotoheroandroidtdd.databinding.TvForAdaptBinding
import ru.easycode.zerotoheroandroidtdd.delete.DeleteBottomSheet
import ru.easycode.zerotoheroandroidtdd.delete.ItemUiDelete

class TvAdapter(private val itemUiDelete: ItemUiDelete): RecyclerView.Adapter<TvHolder>() {
    val oldList: ArrayList<ItemUi> = ArrayList()
    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int,
    ): TvHolder {
        return TvHolder(itemUiDelete,binding = TvForAdaptBinding.inflate(LayoutInflater.from(parent.context)))
    }

    override fun onBindViewHolder(
        holder: TvHolder,
        position: Int,
    ) {
        holder.setText(oldList[position])
    }

    override fun getItemCount(): Int {
        return oldList.size
    }

    fun getText(list: List<ItemUi>) {
        val diffUtl = ru.easycode.zerotoheroandroidtdd.core.DiffUtil(oldList, new = list)

        val calulating = DiffUtil.calculateDiff(diffUtl)

        oldList.clear()
        oldList.addAll(list)

        calulating.dispatchUpdatesTo(this)

    }

}

class TvHolder(private val itemUiDelete: ItemUiDelete,
               private val binding: TvForAdaptBinding): RecyclerView.ViewHolder(binding.root) {
    fun setText(itemUi: ItemUi) {
        itemUi.show(binding.elementTextView)
        itemView.setOnClickListener {
            itemUi.delete(itemUiDelete)
        }
    }
}

class DiffUtil(private val old: List<ItemUi>,private val new: List<ItemUi>): DiffUtil.Callback() {
    override fun getOldListSize(): Int = old.size

    override fun getNewListSize(): Int = new.size

    override fun areItemsTheSame(
        oldItemPosition: Int,
        newItemPosition: Int,
    ): Boolean {
        if(old[oldItemPosition] == new[newItemPosition])
            return true
        else
            return false
    }

    override fun areContentsTheSame(
        oldItemPosition: Int,
        newItemPosition: Int,
    ): Boolean {
        if(old[oldItemPosition] == new[newItemPosition])
            return true
        else
            return false
    }

}