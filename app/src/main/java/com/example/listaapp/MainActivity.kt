package com.example.listaapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.listaapp.databinding.ActivityMainBinding
import com.google.android.material.snackbar.Snackbar

class MainActivity : AppCompatActivity(), ListAdapter.ListAdapterListener {

    private lateinit var binding: ActivityMainBinding
    private val itemList: MutableList<City> = mutableListOf()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        supportActionBar?.hide()

        val listView = binding.lista

        creatMockData()

        //Definindo o layout da RecyclerView(UI)
        listView.layoutManager = LinearLayoutManager(this)

        //Vinculando toda a classe Adapter e seus metodos a RecyclerView(UI)
        listView.adapter = ListAdapter(itemList, this)

    }

    fun creatMockData(){
        itemList.add(City("Manaus", "AM"))
        itemList.add(City("Belém", "PA"))
        itemList.add(City("Fortaleza", "CE"))
        itemList.add(City("Florianópolis", "SC"))
        itemList.add(City("Curitiba", "PR"))
        itemList.add(City("São Paulo", "SP"))
        itemList.add(City("Rio de Janeiro", "RJ"))
        itemList.add(City("Belo Horizonte", "MG"))
        itemList.add(City("Salvador", "BA"))
        itemList.add(City("Porto Alegre", "RS"))
    }

    override fun onItemClicked(content: String) {
        Snackbar.make(binding.root, content, Snackbar.LENGTH_SHORT).show()
    }
}