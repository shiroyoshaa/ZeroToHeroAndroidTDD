package ru.easycode.zerotoheroandroidtdd

import android.hardware.biometrics.BiometricManager.Strings
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import ru.easycode.zerotoheroandroidtdd.databinding.TxtBinding

class TextViewAdapter: RecyclerView.Adapter<TextViewAdapter.StringHolder>() {

    var example = ArrayList<String>()

    class StringHolder(textView: View): RecyclerView.ViewHolder(textView) {

        val binding = TxtBinding.bind(textView)

        fun bind(txt: String)  {
            binding.elementTextView.text = txt

        }

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): StringHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.txt,parent,false)
        return StringHolder(view)
    }

    override fun onBindViewHolder(holder: StringHolder, position: Int) {

        holder.bind(example[position])
    }

    override fun getItemCount(): Int {

        return example.size

    }
    fun addString(text: String) {
        example.add(text)
        notifyDataSetChanged()
    }
}
