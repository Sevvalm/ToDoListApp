package com.example.todolistapp.ui.fragment

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import androidx.navigation.Navigation
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.todolistapp.R
import com.example.todolistapp.data.entity.ToDos
import com.example.todolistapp.databinding.FragmentAnasayfaBinding
import com.example.todolistapp.ui.adapter.ToDosAdapter
import com.example.todolistapp.ui.viewmodel.AnasayfaViewModel
import android.widget.SearchView
import com.example.todolistapp.utils.gecisYap
import dagger.hilt.android.AndroidEntryPoint


@AndroidEntryPoint
class AnasayfaFragment : Fragment() {
    private lateinit var binding: FragmentAnasayfaBinding
    private lateinit var viewModel: AnasayfaViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        binding = FragmentAnasayfaBinding.inflate(inflater,container,false)


        binding.fab.setOnClickListener {
            Navigation.gecisYap(it,R.id.todoKayitGecis)
        }

        viewModel.todoListesi.observe(viewLifecycleOwner) {
            val toDosAdapter = ToDosAdapter(requireContext(),it,viewModel)
            binding.todosRv.adapter = toDosAdapter
        }

        //alt alta sirala
        binding.todosRv.layoutManager = LinearLayoutManager(requireContext())

        binding.searchView.setOnQueryTextListener(object : SearchView.OnQueryTextListener{
            override fun onQueryTextChange(newText: String): Boolean {
                viewModel.ara(newText)
                return true
            }
            override fun onQueryTextSubmit(query: String): Boolean {
                viewModel.ara(query)
                return true
            }
        })
        return binding.root
    }
    fun ara(aramaKelimesi : String){
        Log.e("ToDo Ara",aramaKelimesi)
    }

    override fun onResume() {
        super.onResume()
        viewModel.todoYukle()
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val tempViewModel: AnasayfaViewModel by viewModels()
        viewModel=tempViewModel
    }
}