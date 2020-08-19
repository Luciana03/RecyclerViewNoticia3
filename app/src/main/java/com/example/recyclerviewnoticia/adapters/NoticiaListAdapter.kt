package com.example.recyclerviewnoticia.adapters

import android.service.autofill.OnClickAction
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.cardview.widget.CardView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.recyclerviewnoticia.R
import com.example.recyclerviewnoticia.entities.noticia

class NoticiaListAdapter (private var noticiaList : MutableList<noticia>,val onItemClick : (Int) -> Unit) : RecyclerView.Adapter<NoticiaListAdapter.NoticiaHolder>() {
//class NoticiaListAdapter (private var noticiaList: MutableList<noticia>) : RecyclerView.Adapter<NoticiaListAdapter.NoticiaHolder>(){ //relaciono la lista con el Recycler View

    class NoticiaHolder (v: View): RecyclerView.ViewHolder(v){ //se encargará de conectar el diseño de los items con la programación, acá lo creé
        private var v: View

        init {
            this.v = v
        }
        fun setName(name : String) {
            val txt_name_item : TextView = v.findViewById(R.id.txt_name_item)
            txt_name_item.text = name
        }
        fun setImage (image: String){
            val img_item : ImageView = v.findViewById(R.id.img_item)
            Glide
                .with(img_item)
                .load(image)
                .centerCrop()
                .into(getImageView())
        }
        fun getCardLayout (): CardView {
            return v.findViewById(R.id.card_package_item)
        }
        fun getImageView () : ImageView {
            return v.findViewById(R.id.img_item)
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): NoticiaHolder { //para que funcione el adaptador, relaciono la vista del item
        val view =  LayoutInflater.from(parent.context).inflate(R.layout.item_noticia,parent,false)
        return (NoticiaHolder(
            view
        ))
    }

    override fun getItemCount(): Int { //devuelve la cantidad de items que tiene la lista
        return noticiaList.size
    }

    override fun onBindViewHolder(holder: NoticiaHolder, position: Int) { // esto relacionará la información de nuestra lista con la visualización del item
        holder.setName(noticiaList[position].titulo)
        holder.setImage(noticiaList[position].urlImage)
        holder.getCardLayout().setOnClickListener {
            onItemClick(position)
        }
    }

    fun setData(newData: ArrayList<noticia>) { //setData
        this.noticiaList = newData
        this.notifyDataSetChanged()
    }
}