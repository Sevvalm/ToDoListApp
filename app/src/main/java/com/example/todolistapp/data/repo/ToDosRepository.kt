package com.example.todolistapp.data.repo

import com.example.todolistapp.data.datasource.ToDosDataSource
import com.example.todolistapp.data.entity.ToDos

class ToDosRepository(var todosDataSource : ToDosDataSource) {


    suspend fun kaydet(todo_name: String,todo_detay: String) = todosDataSource.kaydet(todo_name,todo_detay)

    suspend fun guncelle(todo_id: Int, todo_name: String, todo_detay: String) = todosDataSource.guncelle(todo_id,todo_name,todo_detay)

    suspend fun sil(todo_id:Int) = todosDataSource.sil(todo_id)

    suspend fun todoYukle() : List<ToDos> = todosDataSource.todoYukle()

    suspend fun ara(aramaKleimesi : String) : List<ToDos> = todosDataSource.ara(aramaKleimesi)
}