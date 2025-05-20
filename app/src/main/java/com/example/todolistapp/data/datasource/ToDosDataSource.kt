package com.example.todolistapp.data.datasource

import android.util.Log
import com.example.todolistapp.data.entity.ToDos
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

class ToDosDataSource {

    suspend fun kaydet(todo_name: String,todo_detay: String){
        Log.e("Kişi kaydet","${todo_name} - ${todo_detay}")
    }

    suspend fun guncelle(todo_id: Int, todo_name: String, todo_detay: String){
        Log.e("Kişi güncelle","$todo_id - $todo_name - $todo_detay ")
    }

    suspend fun sil(todo_id: Int){
        Log.e("todo sil",todo_id.toString())
    }

    suspend fun todoYukle() : List<ToDos> = withContext(Dispatchers.IO) {

        val todolarListesi = ArrayList<ToDos>()
        val t1 = ToDos(1,"First ToDo","Deneme1")
        val t2 = ToDos(2,"Second ToDo","Deneme2")
        val t3 = ToDos(1,"Third ToDo","Deneme3")
        val t4 = ToDos(1,"Fourth ToDo","Deneme4")
        todolarListesi.add(t1)
        todolarListesi.add(t2)
        todolarListesi.add(t3)
        todolarListesi.add(t4)

        return@withContext todolarListesi

    }

    suspend fun ara(aramaKelimesi:String)  : List<ToDos> = withContext(Dispatchers.IO) {
        val liste = ArrayList<ToDos>()
        val t1 = ToDos(1,"First ToDo","Deneme1")

        liste.add(t1)
        return@withContext liste
    }

}