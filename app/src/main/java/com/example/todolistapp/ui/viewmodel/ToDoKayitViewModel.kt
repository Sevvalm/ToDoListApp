package com.example.todolistapp.ui.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.todolistapp.data.entity.ToDos
import com.example.todolistapp.data.repo.ToDosRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class ToDoKayitViewModel @Inject constructor(private val todoRepository: ToDosRepository) : ViewModel() {

    fun kaydet(todo_name: String,todo_detay: String){
        CoroutineScope(Dispatchers.Main).launch {
            todoRepository.kaydet(todo_name,todo_detay)
        }
    }
}