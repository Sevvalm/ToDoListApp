package com.example.todolistapp.ui.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.todolistapp.data.entity.ToDos
import com.example.todolistapp.data.repo.ToDosRepository
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class AnasayfaViewModel : ViewModel() {

    var todoRepository = ToDosRepository()

    var todoListesi = MutableLiveData<List<ToDos>>()

    init {
        todoYukle()
    }


    fun sil(todo_id:Int){
        CoroutineScope(Dispatchers.Main).launch {
            todoRepository.sil(todo_id)
            todoYukle()
        }
    }

    fun todoYukle(){
        CoroutineScope(Dispatchers.Main).launch {
            todoListesi.value = todoRepository.todoYukle()
        }
    }

    fun ara(aramaKelimesi : String){
        CoroutineScope(Dispatchers.Main).launch {
            todoListesi.value = todoRepository.ara(aramaKelimesi)
        }
    }
}