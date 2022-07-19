package com.example.listaapp

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.listaapp.databinding.ItemBinding

/*
    O Adapter faz a ligação do nosso código (Activity/Fragment) onde estamos obtendo os dados,
    com a RecycleView. No Adapter iremos pegar uma lista de dadops e a cada um desses itens, iremos
    vincular ao ViewHolder.
 */
class ListAdapter(val listItens: MutableList<City> ,val listener: ListAdapterListener) : RecyclerView.Adapter<ListAdapter.MyViewHolder>() {


    /*
    Metodo que ira criar os itens da lista para o RecyclerView toda vez que for necessário
     */
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        return MyViewHolder(ItemBinding.inflate(LayoutInflater.from(parent.context), parent, false))

    }

    /*
    Metodo para Vincular os dados do nosso código(kotlin) a lista da RecyclerView
    Metodo onde devemos configurar os eventos de click dos itens do RecyclerView
     */
    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        val item = listItens[position]
        //Não é uma boa prática
        holder.posicao.text = item.state
        holder.conteudo.text = item.cityName

        holder.view.setOnClickListener {
            listener.onItemClicked(item.cityName)
        }
    }

    /*
    Metodo para definir o tamanho da RecyclerView
     */
    override fun getItemCount(): Int = listItens.size

    /*
    ViewHolder é responsável por fazer a ligação ou referenciar os componentes do XML ao
    código (Kotlin)
    */
    inner class MyViewHolder(binding: ItemBinding): RecyclerView.ViewHolder(binding.root){
        val view = binding.root
        var posicao = binding.posicao
        var conteudo = binding.conteudo
    }

    interface ListAdapterListener{
        fun onItemClicked(content: String)
    }

}