package com.example.todolistapp.data.entity

import java.io.Serializable
import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import org.jetbrains.annotations.NotNull

@Entity(tableName = "todos")
data class ToDos(@PrimaryKey(autoGenerate = true) @ColumnInfo(name = "id") @NotNull var todo_id: Int,
                 @ColumnInfo(name = "todoName") @NotNull var todo_name: String,
                 @ColumnInfo(name = "todoDetay") @NotNull var todo_detay: String) : Serializable{
}