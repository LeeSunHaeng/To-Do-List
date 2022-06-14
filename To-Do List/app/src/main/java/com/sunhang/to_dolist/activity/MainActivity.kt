package com.sunhang.to_dolist.activity

import android.content.DialogInterface
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.LayoutInflater
import androidx.appcompat.app.AlertDialog
import com.sunhang.to_dolist.adapter.TodoAdapter
import com.sunhang.to_dolist.database.TodoDatabase
import com.sunhang.to_dolist.databinding.ActivityMainBinding
import com.sunhang.to_dolist.databinding.DialogEditBinding
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import model.TodoInfo
import java.text.SimpleDateFormat
import java.util.*
import kotlin.collections.ArrayList

class MainActivity : AppCompatActivity() {

    private lateinit var binding : ActivityMainBinding
    private lateinit var todoAdapter: TodoAdapter
    private lateinit var roomDatabase: TodoDatabase
    private lateinit var  TodoList : ArrayList<TodoInfo>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        //어댑터 인스턴스 생성
        todoAdapter = TodoAdapter()

        // 룸 데이터베이스 초기화
        roomDatabase = TodoDatabase.getInstance(applicationContext)!!

        //전체 데이터 load (비동기) -> 순서대로 실행되지 않고 다른 코드들을 실행시키면서 완료됨과 상관 없이 코드를 실행시키는것
        //코루틴 스코프는 데이터처리 스레드
        CoroutineScope(Dispatchers.IO).launch {
            TodoList = roomDatabase.todoDao().getAllReadData() as ArrayList<TodoInfo>
            todoAdapter.submitList(TodoList)

            //UI 처리는 UI스레드에서 처리를 해야함
            runOnUiThread {

            }
        }


/*
        //샘플 리스트 임의 생성1
        val todoitem1 = TodoInfo()
        todoitem1.todoContent = "컴퓨터 사용시간 줄이기"
        todoitem1.todoDate = "2021-05-06 17:15"
        TodoList.add(todoitem1)

        //샘플 리스트 임의 생성2
        val todoitem2 = TodoInfo()
        todoitem2.todoContent = "핸드폰 사용시간 줄이기"
        todoitem2.todoDate = "2021-07-06 12:15"
        TodoList.add(todoitem2)

        //샘플 리스트 임의 생성3
        val todoitem3 = TodoInfo()
        todoitem3.todoContent = "노래방 사용시간 줄이기"
        todoitem3.todoDate = "2021-02-06 14:15"
        TodoList.add(todoitem3)*/


        //리사이클러 뷰 어댑터 셋팅
        binding.rvTodo.adapter = todoAdapter

        //작성하기
        binding.btnWrite.setOnClickListener{
            val bindingDialog = DialogEditBinding.inflate(LayoutInflater.from(binding.root.context),binding.root,false)
            AlertDialog.Builder(this)
                .setTitle("To-Do 남기기")
                .setView(bindingDialog.root)
                .setPositiveButton("작성 완료", DialogInterface.OnClickListener { dialogInterface, i ->
                    val todoitem = TodoInfo()
                    todoitem.todoContent= bindingDialog.etMemo.text.toString()
                    todoitem.todoDate = SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(Date())
                    roomDatabase.todoDao().insertTodoData(todoitem)
                    TodoList.add(todoitem) // 데이터베이스 또한 클래스 데이터 삽입
                    todoAdapter.submitList(TodoList)
                })
                .setNeutralButton("취소",DialogInterface.OnClickListener { dialogInterface, i ->

                })
                .show()
        }





    }

}