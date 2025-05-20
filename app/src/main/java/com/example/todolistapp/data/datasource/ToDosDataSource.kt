package com.example.todolistapp.data.datasource

import android.util.Log
import com.example.todolistapp.data.entity.ToDos
import com.example.todolistapp.room.ToDoDao
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

class ToDosDataSource(var todoDao: ToDoDao) {

    suspend fun kaydet(todo_name: String,todo_detay: String){
        val yeniTodo = ToDos(0,todo_name,todo_detay)
        todoDao.kaydet(yeniTodo)
    }

    suspend fun guncelle(todo_id: Int, todo_name: String, todo_detay: String){
        val guncellenenTodo = ToDos(todo_id,todo_name,todo_detay)
        todoDao.guncelle(guncellenenTodo)
    }

    suspend fun sil(todo_id: Int){
        val silinenTodo= ToDos(todo_id,"","")
        todoDao.sil(silinenTodo)
    }

    suspend fun todoYukle() : List<ToDos> = withContext(Dispatchers.IO) {
        return@withContext todoDao.todolariYukle()
    }

    suspend fun ara(aramaKelimesi:String)  : List<ToDos> = withContext(Dispatchers.IO) {
        return@withContext todoDao.ara(aramaKelimesi)
    }

}