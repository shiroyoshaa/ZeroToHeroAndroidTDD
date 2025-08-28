package ru.easycode.zerotoheroandroidtdd.core

import android.util.Log
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import ru.easycode.zerotoheroandroidtdd.databinding.TvForAdaptBinding

class TvAdapter: RecyclerView.Adapter<TvHolder>() {
    val oldList: ArrayList<String> = ArrayList()
    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): TvHolder {
        return TvHolder(binding = TvForAdaptBinding.inflate(LayoutInflater.from(parent.context)))
    }

    override fun onBindViewHolder(
        holder: TvHolder,
        position: Int
    ) {
        holder.setText(oldList[position])
    }

    override fun getItemCount(): Int {
        return oldList.size
    }

    fun setValue(newList: List<String>) {
        val diffUtl = DiffUtil(newList,oldList)
        val diff = DiffUtil.calculateDiff(diffUtl)
        oldList.clear()
        oldList.addAll(newList)
        diff.dispatchUpdatesTo(this)
        Log.d("fatal","setValue in adapter $oldList")
    }
}

class TvHolder(private val binding: TvForAdaptBinding): RecyclerView.ViewHolder(binding.root) {
    fun setText(text: String) {
        binding.elementTextView.text = text
    }
}


class DiffUtil(
    private val new: List<String>,
    private val old: List<String>,
): DiffUtil.Callback(
){
    override fun getOldListSize(): Int = old.size


    override fun getNewListSize(): Int = new.size

    override fun areItemsTheSame(
        oldItemPosition: Int,
        newItemPosition: Int
    ): Boolean {
        return if (old[oldItemPosition] == new[newItemPosition])
                        true
            else {
                        false
            }
    }

    override fun areContentsTheSame(
        oldItemPosition: Int,
        newItemPosition: Int
    ): Boolean {
        return if (old[oldItemPosition] == new[newItemPosition])
            true
        else {
            false
        }
    }

}


