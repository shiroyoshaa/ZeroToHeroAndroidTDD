package ru.easycode.zerotoheroandroidtdd.core

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.fragment.app.FragmentManager
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import ru.easycode.zerotoheroandroidtdd.dataBase.ItemUi
import ru.easycode.zerotoheroandroidtdd.databinding.TvForAdaptBinding
import ru.easycode.zerotoheroandroidtdd.delete.DeleteBottomSheet

class TvAdapter(private val fragmentManager: FragmentManager): RecyclerView.Adapter<TvHolder>() {
    val oldList: ArrayList<ItemUi> = ArrayList()
    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int,
    ): TvHolder {
        return TvHolder(fragmentManager,binding = TvForAdaptBinding.inflate(LayoutInflater.from(parent.context)))
    }

    override fun onBindViewHolder(
        holder: TvHolder,
        position: Int,
    ) {
        val itemUiCopy = oldList[position]
        holder.setText( itemUiCopy.id,itemUiCopy.text)
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

class TvHolder(private val fragmentManager: FragmentManager,
               private val binding: TvForAdaptBinding): RecyclerView.ViewHolder(binding.root) {
    fun setText(id: Long, text: String) {

        binding.elementTextView.text = text
        binding.elementTextView.setOnClickListener {
            val deleteBottomSheet = DeleteBottomSheet(id,text)
            deleteBottomSheet.show(fragmentManager,"deleteBottomSheet")
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