package ru.easycode.zerotoheroandroidtdd

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import ru.easycode.zerotoheroandroidtdd.databinding.TvForAdaptBinding

class TvAdapter(private val deleteItemUi: DeleteItemUi): RecyclerView.Adapter<TvHolder>() {

    private val oldList: ArrayList<ItemUi> = ArrayList()

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): TvHolder {
        return TvHolder(deleteItemUi = deleteItemUi,TvForAdaptBinding.inflate(LayoutInflater.from(parent.context)))
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

    fun addOnList(newList: List<ItemUi>) {
        val diffUtl = DiffUtil(oldList, newList)
        val calculate = DiffUtil.calculateDiff(diffUtl)
        oldList.clear()
        oldList.addAll(newList)

        calculate.dispatchUpdatesTo(this)
    }

}

class TvHolder(private val deleteItemUi: DeleteItemUi
,private val binding: TvForAdaptBinding):
    RecyclerView.ViewHolder(binding.root) {
    fun setText(itemUi: ItemUi) {

        itemUi.setTextTextView(binding.elementTextView)

        binding.elementTextView.setOnClickListener {
            itemUi.delete(deleteItemUi,itemUi)
        }
    }
}

class DiffUtil (

    private val oldList: List<ItemUi>,
    private val newList: List<ItemUi>
): DiffUtil.Callback() {

    override fun getOldListSize(): Int = oldList.size

    override fun getNewListSize(): Int = newList.size

    override fun areItemsTheSame(
        oldItemPosition: Int,
        newItemPosition: Int
    ): Boolean {
        return oldList[oldItemPosition].areItemsSame(newList[newItemPosition])
    }

    override fun areContentsTheSame(

        oldItemPosition: Int,
        newItemPosition: Int

    ): Boolean {
        return oldList[oldItemPosition] == newList[newItemPosition]
    }

}