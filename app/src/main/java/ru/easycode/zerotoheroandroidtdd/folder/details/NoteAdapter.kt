package ru.easycode.zerotoheroandroidtdd.folder.details

import android.util.Log
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import ru.easycode.zerotoheroandroidtdd.databinding.NoteTitleTvForAdaptBinding
import ru.easycode.zerotoheroandroidtdd.folder.list.FolderUi

class NoteAdapter(private var onItemClick: (NoteUi) -> Unit): RecyclerView.Adapter<NoteHolder>(){

    private val oldList: ArrayList<NoteUi> = ArrayList()

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): NoteHolder {
        return NoteHolder(NoteTitleTvForAdaptBinding.inflate(LayoutInflater.from(parent.context)))
    }

    override fun onBindViewHolder(
        holder: NoteHolder,
        position: Int
    ) {
        holder.setText(oldList[position])
        holder.itemView.setOnClickListener {
            onItemClick(oldList[position])
        }
    }

    override fun getItemCount(): Int {
        return oldList.size
    }
    fun getNoteUi(newList: List<NoteUi>) {
        oldList.clear()
        oldList.addAll(newList)
        notifyDataSetChanged() // TODO: lately please write DiffUtil for all adapters in this project

    }
}

class NoteHolder(private val binding: NoteTitleTvForAdaptBinding): RecyclerView.ViewHolder(binding.root) {
    fun setText(noteUi: NoteUi) {
        binding.noteTitleTextView.text = noteUi.title
    }
}