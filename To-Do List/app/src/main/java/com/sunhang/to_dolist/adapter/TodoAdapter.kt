package com.sunhang.to_dolist.adapter

import android.annotation.SuppressLint
import android.content.DialogInterface
import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.sunhang.to_dolist.databinding.DialogEditBinding
import com.sunhang.to_dolist.databinding.ListItemTodoBinding
import model.TodoInfo
import java.text.SimpleDateFormat
import java.util.*


class TodoAdapter:ListAdapter<TodoInfo,TodoAdapter.ToDoViewHolder>(diffUtil) {

    //private var TodoList:ArrayList<TodoInfo> = ArrayList()


    //inner class로 생성하지 않으면 TodoAdapter에 접근할 수 없다.
   inner class ToDoViewHolder(private val binding: ListItemTodoBinding): RecyclerView.ViewHolder(binding.root) {
        fun bind(todoitem : TodoInfo) {
            //리스트뷰에 데이터 연동
            binding.tvContent.setText(todoitem.todoContent)
            binding.tvDate.setText(todoitem.todoDate)

            //리스트 삭제 연동
            binding.btnRemove.setOnClickListener{

                AlertDialog.Builder(binding.root.context)
                    .setTitle("[주의]")
                    .setMessage("제거하시면 데이터는 복구되지 않습니다! \n정말 삭제하시겠습니까?")
                    .setPositiveButton("제거",DialogInterface.OnClickListener { dialogInterface, i ->
                        val currentList = currentList.toMutableList()
                        currentList.removeAt(position)
                        submitList(currentList)
                        Toast.makeText(binding.root.context,"제거되었습니다!",Toast.LENGTH_SHORT)
                    })
                    .setNegativeButton("취소",DialogInterface.OnClickListener { dialogInterface, i ->

                    })
                    .show()
            }

            //리스트 수정 클릭 연동
            binding.root.setOnClickListener{
                val currentList = currentList.toMutableList()
                val bindingDialog = DialogEditBinding.inflate(LayoutInflater.from(binding.root.context),binding.root,false)
                bindingDialog.etMemo.setText(todoitem.todoContent)
                AlertDialog.Builder(binding.root.context)
                    .setTitle("To-Do 수정하기")
                    .setView(bindingDialog.root)
                    .setPositiveButton("작성 완료", DialogInterface.OnClickListener { dialogInterface, i ->
                        todoitem.todoContent= bindingDialog.etMemo.text.toString()
                        todoitem.todoDate = SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(Date())
                        currentList.set(adapterPosition,todoitem)
                        submitList(currentList)
                    })
                    .setNeutralButton("취소",DialogInterface.OnClickListener { dialogInterface, i ->

                    })
                    .show()

            }
        }
    }
    //뷰 홀더가 생성됨.(각 리스트 아이템 1개가 생성 될 때마다 이 오버라이드 메소드가 호출됨)
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): TodoAdapter.ToDoViewHolder {
        val binding = ListItemTodoBinding.inflate(LayoutInflater.from(parent.context),parent,false)
        return ToDoViewHolder(binding)
    }
    //뷰 홀더가 바인딩(결합)이 이루어질 때 해줘야 할 처리들을 구현.
    override fun onBindViewHolder(holder: TodoAdapter.ToDoViewHolder, position: Int) {
        holder.bind(getItem(position))
    }
    companion object{
        val diffUtil=object:DiffUtil.ItemCallback<TodoInfo>(){
            override fun areItemsTheSame(oldItem: TodoInfo, newItem: TodoInfo): Boolean {
                return oldItem.todoContent==newItem.todoContent
            }

            @SuppressLint("DiffUtilEquals")
            override fun areContentsTheSame(oldItem: TodoInfo, newItem: TodoInfo): Boolean {
                return oldItem == newItem
            }


        }
    }
    fun delete(position: Int){
        val currentList = getCurrentList().toMutableList()
        currentList.removeAt(position)
        submitList(currentList)
    }



}