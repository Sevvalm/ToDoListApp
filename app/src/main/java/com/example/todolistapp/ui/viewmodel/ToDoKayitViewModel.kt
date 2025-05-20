package com.example.todolistapp.ui.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.todolistapp.data.entity.ToDos
import com.example.todolistapp.data.repo.ToDosRepository
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class ToDoKayitViewModel(var todoRepository : ToDosRepository) : ViewModel()  {
    //var todoRepository = ToDosRepository()

    //var todoListesi  = MutableLiveData<List<ToDos>>()
//    init{
//        todoYukle()
//    }

    fun kaydet(todo_name: String,todo_detay: String){
        CoroutineScope(Dispatchers.Main).launch {
            todoRepository.kaydet(todo_name,todo_detay)
        }
    }

//    fun sil(todo_id: Int){
//        CoroutineScope(Dispatchers.Main).launch {
//            todoRepository.sil(todo_id)
//
//        }
//    }
//
//    fun todoYukle(){
//        CoroutineScope(Dispatchers.Main).launch {
//            todoListesi.value = todoRepository.ki
//        }
//    }
}