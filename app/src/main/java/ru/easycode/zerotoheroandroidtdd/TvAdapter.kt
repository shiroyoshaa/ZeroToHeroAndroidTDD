package ru.easycode.zerotoheroandroidtdd

import android.util.Log
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import ru.easycode.zerotoheroandroidtdd.databinding.TvForadapterBinding

class TvAdapter: RecyclerView.Adapter<TvHolder>() {

    private var example = ArrayList<CharSequence>()
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): TvHolder {
        return TvHolder(TvForadapterBinding.inflate(LayoutInflater.from(parent.context)))
    }

    override fun getItemCount(): Int {
        return example.size
    }

    override fun onBindViewHolder(holder: TvHolder, position: Int) {
        holder.setText(example[position])
    }
    fun set(newList: List<CharSequence>) {
        val diffUtil = DiffUtilCallBack(example,newList)
        val diff = DiffUtil.calculateDiff(diffUtil)

        example.clear()
        example.addAll(newList)
        diff.dispatchUpdatesTo(this)
    }
}

class TvHolder(private val binding: TvForadapterBinding): RecyclerView.ViewHolder(binding.root) {

    fun setText(text: CharSequence) {
        binding.elementTextView.text = text.toString()
    }
}

private class DiffUtilCallBack(
    private val old: List<CharSequence>,
    private val new: List<CharSequence>,
): DiffUtil.Callback() {
    override fun getOldListSize() = old.size

    override fun getNewListSize() = new.size

    override fun areItemsTheSame(oldItemPosition: Int, newItemPosition: Int): Boolean {
        if(old[oldItemPosition] == new[newItemPosition])
            return true
        else
            return false
    }

    override fun areContentsTheSame(oldItemPosition: Int, newItemPosition: Int): Boolean {
        if(old[oldItemPosition] == new[newItemPosition])
            return true
        else
            return false
    }

}