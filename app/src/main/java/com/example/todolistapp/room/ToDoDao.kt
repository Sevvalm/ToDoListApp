package com.example.todolistapp.room

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query
import androidx.room.Update
import com.example.todolistapp.data.entity.ToDos

@Dao
interface ToDoDao {
    @Query("SELECT * FROM todos")
    suspend fun todolariYukle() : List<ToDos>

    @Insert
    suspend fun kaydet(todo: ToDos)

    @Update
    suspend fun guncelle(todo: ToDos)

    @Delete
    suspend fun sil(todo: ToDos)

    @Query("SELECT * FROM todos WHERE todoName LIKE '%' || :aramaKelimesi|| '%'")
    suspend fun ara(aramaKelimesi:String) : List<ToDos>
}