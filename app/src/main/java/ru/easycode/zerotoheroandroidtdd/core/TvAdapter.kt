package ru.easycode.zerotoheroandroidtdd.core

import android.view.LayoutInflater
import android.view.ViewGroup
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
    fun addText(text: String) {
        list.add(text)
        notifyDataSetChanged() //на время, потом написать DiffUtilCallBAckk!
    }

}

class TvHodlder(private val binding: TvForadapterBinding): ViewHolder(binding.root) {

    fun setText(text: String) {
        binding.elementTextView.text = text
    }
}




