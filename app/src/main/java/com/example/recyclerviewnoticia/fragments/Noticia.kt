package com.example.recyclerviewnoticia.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView
import androidx.navigation.findNavController

import com.example.recyclerviewnoticia.R

/**
 * A simple [Fragment] subclass.
 */
class Noticia : Fragment() {

    lateinit var v: View

    lateinit var txtFecha: TextView
    lateinit var txtTitulo: TextView
    lateinit var txtCuerpo: TextView
    lateinit var txtAutor: TextView
    lateinit var btnVolver: Button

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        v = inflater.inflate(R.layout.fragment_noticia, container, false)

        txtFecha = v.findViewById(R.id.txtFecha)
        txtTitulo = v.findViewById(R.id.txtTitulo)
        txtCuerpo = v.findViewById(R.id.txtCuerpo)
        txtAutor = v.findViewById(R.id.txtAutor)
        btnVolver = v.findViewById(R.id.btnVolver)
        return v
    }

    override fun onStart() {
        super.onStart()

        val Fecha = NoticiaArgs.fromBundle(requireArguments()).Fecha
        val Titulo = NoticiaArgs.fromBundle(requireArguments()).Titulo
        val Cuerpo = NoticiaArgs.fromBundle(requireArguments()).Cuerpo
        val Autor = NoticiaArgs.fromBundle(requireArguments()).Autor

        txtFecha.text = Fecha
        txtTitulo.text = Titulo
        txtCuerpo.text = Cuerpo
        txtAutor.text = Autor

        btnVolver.setOnClickListener {
            val a21 = NoticiaDirections.actionNoticiaToFragmentNoticias()
            v.findNavController().navigate(a21)
        }
    }
}
