package com.example.todolistapp.ui.fragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import com.example.todolistapp.R
import com.example.todolistapp.databinding.FragmentAnasayfaBinding
import com.example.todolistapp.databinding.FragmentTodoDetayBinding
import com.example.todolistapp.ui.viewmodel.ToDoDetayViewModel


class TodoDetayFragment : Fragment() {
private lateinit var binding: FragmentTodoDetayBinding
    private lateinit var viewModel: ToDoDetayViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentTodoDetayBinding.inflate(inflater,container,false)


        return binding.root
    }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val tempViewModel: ToDoDetayViewModel by viewModels()
        viewModel=tempViewModel
    }
}