package com.sunhang.to_dolist.database

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import model.TodoInfo

//abstract class :  추상 클래스 -> 선언만 해 놓는것
@Database(entities = [TodoInfo::class], version = 1)
abstract class TodoDatabase : RoomDatabase() {
    abstract fun todoDao() : TodoDao

    //싱글톤 -> 고정 메모리로 메모리가 고정되어 있어 최초 한개의 인스턴스만 생성됨. 그래서 언제든지 꺼내서 쓸 수 있어 효율적
    companion object{
        private var instance: TodoDatabase? = null
        //@Syncronized -> 동시에 호출되어 내부 로직이 꼬이는걸 방지
        @Synchronized
        fun getInstance(context : Context) : TodoDatabase?{
            if(instance == null){
                synchronized(TodoDatabase::class){
                    instance = Room.databaseBuilder(
                        context.applicationContext,
                        TodoDatabase::class.java,
                        "todo-databse"
                    ).build()
                }
            }
            return instance
        }
    }
}