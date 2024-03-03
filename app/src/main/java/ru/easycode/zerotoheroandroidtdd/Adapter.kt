package ru.easycode.zerotoheroandroidtdd

import android.annotation.SuppressLint
import android.os.Bundle
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import ru.easycode.zerotoheroandroidtdd.databinding.ItemElementTextviewBinding

class Adapter(private val list: ArrayList<String> = arrayListOf()) : RecyclerView.Adapter<TaskViewHolder>() {

    @SuppressLint("NotifyDataSetChanged")
    fun updateList(text:String) {
        list.add(text)
        notifyDataSetChanged()
    }

    fun save(bundle: Bundle) {
        bundle.putStringArrayList("key" , list)
    }

    fun init(bundle: Bundle?) {
        if (bundle != null) {
            val list = bundle.getStringArrayList("key") ?: ArrayList()
            this.list.addAll(list)
        }
    }


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): TaskViewHolder {
        val ss = ItemElementTextviewBinding.inflate(LayoutInflater.from(parent.context))
        return TaskViewHolder(ss)

    }

    override fun onBindViewHolder(holder: TaskViewHolder, position: Int) {
        holder.bind(list[position])
    }

    override fun getItemCount(): Int = list.size

}

class TaskViewHolder(private val binding: ItemElementTextviewBinding) :
    RecyclerView.ViewHolder(binding.root) {

    fun bind(string: String) {
        binding.elementTextView.text = string
    }
}