package com.example.todolistapp.ui.viewmodel

import androidx.lifecycle.ViewModel
import com.example.todolistapp.data.repo.ToDosRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class ToDoDetayViewModel @Inject constructor(var todoRepository: ToDosRepository) : ViewModel() {

    fun guncelle(todo_id: Int,todo_name: String,todo_detay: String){
        CoroutineScope(Dispatchers.Main).launch {
            todoRepository.guncelle(todo_id,todo_name,todo_detay)
        }
    }
}