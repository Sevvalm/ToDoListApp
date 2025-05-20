package com.example.todolistapp.ui.fragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.navArgs
import com.example.todolistapp.R
import com.example.todolistapp.databinding.FragmentAnasayfaBinding
import com.example.todolistapp.databinding.FragmentTodoDetayBinding
import com.example.todolistapp.ui.viewmodel.ToDoDetayViewModel
import dagger.hilt.android.AndroidEntryPoint


@AndroidEntryPoint
class TodoDetayFragment : Fragment() {
private lateinit var binding: FragmentTodoDetayBinding
    private lateinit var viewModel: ToDoDetayViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentTodoDetayBinding.inflate(inflater,container,false)

        val bundle : TodoDetayFragmentArgs by navArgs()
        val gelenTodo = bundle.todo

        binding.editTextTodoName.setText(gelenTodo.todo_name)
        binding.editTextToDoIcerikDetay.setText(gelenTodo.todo_detay)

        binding.buttonGuncelle.setOnClickListener {
            val todo_name = binding.editTextTodoName.text.toString()
            val todo_detay = binding.editTextToDoIcerikDetay.text.toString()
            viewModel.guncelle(gelenTodo.todo_id,todo_name,todo_detay)
        }

        return binding.root
    }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val tempViewModel: ToDoDetayViewModel by viewModels()
        viewModel=tempViewModel
    }
}