package com.example.todolistapp.ui.fragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import com.example.todolistapp.R
import com.example.todolistapp.databinding.FragmentTodoDetayBinding
import com.example.todolistapp.databinding.FragmentTodoKayitBinding
import com.example.todolistapp.ui.viewmodel.ToDoKayitViewModel


class TodoKayitFragment : Fragment() {
    private lateinit var binding: FragmentTodoKayitBinding
    private lateinit var viewModel: ToDoKayitViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentTodoKayitBinding.inflate(inflater,container,false)
        return binding.root
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val tempViewModel: ToDoKayitViewModel by viewModels()
        viewModel=tempViewModel
    }
}