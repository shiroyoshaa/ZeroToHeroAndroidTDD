package ru.easycode.zerotoheroandroidtdd.list

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.RecyclerView.ViewHolder
import ru.easycode.zerotoheroandroidtdd.databinding.TvForadapterBinding

class TvAdapter: RecyclerView.Adapter<TvHodlder>() {

    var list = ArrayList<CharSequence>()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): TvHodlder {
        return TvHodlder(TvForadapterBinding.inflate(LayoutInflater.from(parent.context)))

    }

    override fun getItemCount(): Int {

        return list.size

    }

    override fun onBindViewHolder(holder: TvHodlder, position: Int) {
       holder.setText(list[position].toString())
    }
    fun addText(newList: List<CharSequence>) {
        val diffUtil = DiffUtilCallBack(list,newList)
        val diff = DiffUtil.calculateDiff(diffUtil)

        list.clear()
        list.addAll(newList)

        diff.dispatchUpdatesTo(this)
    //на время, потом написать DiffUtilCallBAckk!
    }

}

class TvHodlder(private val binding: TvForadapterBinding): ViewHolder(binding.root) {

    fun setText(text: CharSequence) {
        binding.elementTextView.text = text.toString()
    }
}

private class DiffUtilCallBack(
    private val oldList: List<CharSequence>,
    private val newList: List<CharSequence>,
): DiffUtil.Callback() {
    override fun getOldListSize(): Int {
        return oldList.size
    }

    override fun getNewListSize(): Int {
        return newList.size
    }

    override fun areItemsTheSame(oldItemPosition: Int, newItemPosition: Int): Boolean {
        if (oldList[oldItemPosition] == newList[newItemPosition]) {
            return true
        } else {
            return false
        }
    }

    override fun areContentsTheSame(oldItemPosition: Int, newItemPosition: Int): Boolean {
        if (oldList[oldItemPosition] == newList[newItemPosition]) {
            return true
        } else {
            return false
        }
    }
}

