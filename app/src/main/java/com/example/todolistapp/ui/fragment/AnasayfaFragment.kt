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


class AnasayfaFragment : Fragment() {
    private lateinit var binding: FragmentAnasayfaBinding
    private lateinit var viewModel: AnasayfaViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        binding = FragmentAnasayfaBinding.inflate(inflater,container,false)


        binding.fab.setOnClickListener {
            Navigation.findNavController(it).navigate(R.id.todoKayitGecis)
        }


//        val todolarListesi = ArrayList<ToDos>()
//        val t1 = ToDos(1,"First ToDo","Deneme1")
//        val t2 = ToDos(2,"Second ToDo","Deneme2")
//        val t3 = ToDos(1,"Third ToDo","Deneme3")
//        val t4 = ToDos(1,"Fourth ToDo","Deneme4")
//        todolarListesi.add(t1)
//        todolarListesi.add(t2)
//        todolarListesi.add(t3)
//        todolarListesi.add(t4)
//
//        val todoAdapter = ToDosAdapter(requireContext(),todolarListesi,viewModel)
//        binding.todosRv.adapter = todoAdapter
        //viewModel.to

        //alt alta sirala
        binding.todosRv.layoutManager = LinearLayoutManager(requireContext())

        binding.searchView.setOnQueryTextListener(object : SearchView.OnQueryTextListener{
            override fun onQueryTextChange(newText: String): Boolean {
                ara(newText)
                return true
            }

            override fun onQueryTextSubmit(query: String): Boolean {
                ara(query)
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
        Log.e("ToDo Anasayfaya","Dönüldü")
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val tempViewModel: AnasayfaViewModel by viewModels()
        viewModel=tempViewModel
    }
}