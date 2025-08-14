package ru.easycode.zerotoheroandroidtdd

import android.util.Log
import android.view.LayoutInflater
import android.view.ViewGroup
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
    fun set(list: List<CharSequence>) {
        example.clear()
        example.addAll(list)
        Log.d("fatal", "its set from tvadapter")
        notifyDataSetChanged()
    }
}

class TvHolder(private val binding: TvForadapterBinding): RecyclerView.ViewHolder(binding.root) {

    fun setText(text: CharSequence) {
        binding.elementTextView.text = text.toString()
    }
}