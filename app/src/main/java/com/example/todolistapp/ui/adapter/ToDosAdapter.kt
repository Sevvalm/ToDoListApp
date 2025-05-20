package com.example.todolistapp.ui.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.navigation.Navigation
import androidx.recyclerview.widget.RecyclerView
import com.example.todolistapp.data.entity.ToDos
import com.example.todolistapp.databinding.CardTasarimBinding
import com.example.todolistapp.ui.fragment.AnasayfaFragmentDirections
import com.example.todolistapp.ui.viewmodel.AnasayfaViewModel

class ToDosAdapter (var mContext: Context, var todolarListesi: List<ToDos>, var viewModel: AnasayfaViewModel)
    : RecyclerView.Adapter<ToDosAdapter.CardTasarimTutucu>(){

    inner class CardTasarimTutucu(var tasarim : CardTasarimBinding) : RecyclerView.ViewHolder(tasarim.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CardTasarimTutucu {
        val tasarim  = CardTasarimBinding.inflate(LayoutInflater.from(mContext),parent,false)
        return CardTasarimTutucu(tasarim)
    }

    override fun onBindViewHolder(holder: CardTasarimTutucu, position: Int) {
        val toDos = todolarListesi.get(position)
        val t = holder.tasarim

        t.textViewToDoName.text = toDos.todo_name
        t.textViewTodoDetay.text = toDos.todo_detay

        t.cardViewSatir.setOnClickListener {
            val gecis = AnasayfaFragmentDirections.todoDetayGecis(todo = toDos)
            Navigation.findNavController(it).navigate(gecis)
        }

        t.imageViewSil.setOnClickListener {

        }


    }
    override fun getItemCount(): Int {
        return todolarListesi.size
    }


    }