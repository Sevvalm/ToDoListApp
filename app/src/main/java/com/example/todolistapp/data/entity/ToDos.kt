package com.example.todolistapp.data.entity

import java.io.Serializable

data class ToDos(var todo_id: Int,
                 var todo_name: String,
                 var todo_detay: String) : Serializable{
}