package com.sunhang.to_dolist.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.sunhang.to_dolist.databinding.ListItemTodoBinding
import model.TodoInfo


class TodoAdapter:ListAdapter<TodoInfo,TodoAdapter.ToDoViewHolder>() {
    private var TodoList:ArrayList<TodoInfo> = ArrayList()

    class ToDoViewHolder(private val binding: ListItemTodoBinding): RecyclerView.ViewHolder(binding.root) {
        fun bind(todoitem : TodoInfo) {
            //리스트뷰에 데이터 연동
            binding.tvContent.setText(todoitem.todoContent)
            binding.tvDate.setText(todoitem.todoDate)
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): TodoAdapter.ToDoViewHolder {
        val binding = ListItemTodoBinding.inflate(LayoutInflater.from(parent.context),parent,false)
        return ToDoViewHolder(binding)
    }

    override fun onBindViewHolder(holder: TodoAdapter.ToDoViewHolder, position: Int) {
        TODO("Not yet implemented")
    }


}