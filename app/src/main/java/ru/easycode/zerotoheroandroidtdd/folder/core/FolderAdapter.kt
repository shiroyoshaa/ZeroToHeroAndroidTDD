package ru.easycode.zerotoheroandroidtdd.folder.core

import android.util.Log
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import ru.easycode.zerotoheroandroidtdd.databinding.FolderForAdaptBinding
import ru.easycode.zerotoheroandroidtdd.folder.list.FolderUi

class FolderAdapter(
    private val onItemClick: (FolderUi) -> Unit
): RecyclerView.Adapter<FolderViewHolder>() {
    private val oldList: ArrayList<FolderUi> = ArrayList()
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): FolderViewHolder {

        return FolderViewHolder(FolderForAdaptBinding.inflate(LayoutInflater.from(parent.context)))
    }
    override fun onBindViewHolder(holder: FolderViewHolder, position: Int) {
        holder.itemView.setOnClickListener {
            onItemClick(oldList[position])
            holder.setFolders(oldList[position])
        }
    }

    override fun getItemCount(): Int {
        return oldList.size
    }

    fun setFolders(newList: List<FolderUi>) {
        oldList.clear()
        oldList.addAll(newList)
        notifyDataSetChanged() //временно, позже написать DiffUtl
    }
}

class FolderViewHolder(private val binding: FolderForAdaptBinding): RecyclerView.ViewHolder(binding.root) {

    fun setFolders(folderUi: FolderUi) {
        binding.folderTitleTextView.text = folderUi.title
        binding.folderCountTextView.text = folderUi.notesCount.toString()
    }
}