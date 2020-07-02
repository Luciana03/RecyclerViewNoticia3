package com.example.recyclerviewnoticia.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

import com.example.recyclerviewnoticia.R
import com.example.recyclerviewnoticia.adapters.NoticiaListAdapter
import com.example.recyclerviewnoticia.entities.noticia
import com.google.android.material.snackbar.Snackbar

/**
 * A simple [Fragment] subclass.
 */
class FragmentNoticias : Fragment() {

    lateinit var v: View

    lateinit var recNoticias : RecyclerView

    var noticias : MutableList<noticia> = ArrayList<noticia>()

    private lateinit var linearLayoutManager: LinearLayoutManager
    private lateinit var noticiaListAdapter: NoticiaListAdapter

    companion object {
        fun newInstance() = FragmentNoticias()
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        v = inflater.inflate(R.layout.fragment_noticias, container, false)
        recNoticias = v.findViewById(R.id.rec_noticias)
        return v
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        // TODO: Use the ViewModel
    }

    override fun onStart() {
        super.onStart()

        noticias.add(noticia("Titulo de la noticia1","edentarismo, una pandemia mundial de gran impacto en tiempos de Coronavirus\",\"El 2020 comenzó con una crisis en la salud de todo el mundo debido a la creciente expansión del COVID-19, hoy ya considerado una pandemia. Miles de muertes diarias son ocasionadas por este virus en todo el planeta y genera un colapso en el sistema sanitario de los países a los que afecta. La morbimortalidad de esta enfermedad no es para nada despreciable, por eso es tan importante poner atención y llevar a cabo las medidas necesarias para disminuir nuestro riesgo y el de nuestro entorno.\\n\" +\n" +
                "                \"\\n\" +\n" +
                "                \"Ahora bien, sin ir más lejos tenemos frente a nuestros ojos otra pandemia que afecta a más de la mitad de la población mundial (y de nuestro país), y que provoca más de 3.200.000 (si, millones) muertes al año, siendo el cuarto factor de riesgo de mortalidad generada por enfermedades no transmisibles (o prevenibles)[1].\\n\" +\n" +
                "                \"\\n\" +\n" +
                "                \"La pandemia del sedentarismo es bien conocida, y a pesar de que algunos países comenzaron a tomar medidas para estimular la actividad física, cada vez menos gente realiza el mínimo de actividad física recomendada para mantener un hábito saludable. Para lograr esto, la Organización Mundial de la Salud (OMS) sugiere realizar 30 minutos de actividad física al menos 5 días a la semana, ya sea en sesiones de 10 minutos o como nos resulte más cómodo; pero al menos alcanzar 150 minutos de movimiento físico por semana.\\n\" +\n" +
                "                \"\\n\" +\n" +
                "                \"Este 6 de abril, “Día Mundial de la Actividad Física”, nos encuentra en circunstancias muy particulares. Probablemente, en un entorno en el cual es muy difícil cumplir con estas metas mínimas para no aumentar nuestro riesgo cardiovascular. Sin embargo, para empezar, solo necesitamos ponernos unas zapatillas y apagar la TV un rato así arrancamos a movernos y cuidarnos aun dentro de casa.\\n\" +\n" +
                "                \"\\n\" +\n" +
                "                \"De esta manera, y sin mucho más, estaremos disminuyendo nuestro riesgo cardiovascular. Realizar actividad física regularmente disminuye alrededor del 30% el riesgo de tener problemas de corazón, y no es poco ya que hoy en día es la principal causa de mortalidad a nivel mundial[2].\\n\" +\n" +
                "                \"\\n\" +\n" +
                "                \"No necesitamos grandes espacios, ni pesas ni bancos de gimnasio; no necesitamos cintas o bicicletas (si la tenemos, es un buen momento para dejar de usarla de perchero); solo necesitamos un rato de nuestro tiempo para hacer algunos movimientos físicos. Podemos recurrir a algunas aplicaciones en el teléfono o videos de YouTube que nos guíen. Incluso hoy muchos gimnasios tienen en sus redes sociales guías gratuitas para continuar con los ejercicios en nuestras casas.\\n\" +\n" +
                "                \"\\n\" +\n" +
                "                \"Desde la Fundación Cardiológica Argentina (FCA) recomendamos fuertemente cuidar nuestra salud en todos sus aspectos, y realizar actividad física es uno de ellos. En cualquier contexto, con el mínimo espacio, y sin necesidad de tener un gimnasio en nuestro cuarto, nos va a permitir no solo disminuir nuestro riesgo cardiovascular sino también brindarnos mayor bienestar psico-físico, algo más que importante en los tiempos que corren.\\n\" +\n" +
                "                \"\\n\" +\n" +
                "                \"Encontrá aquí algunos ejercicios y consejos saludables para implementar en casa: http://www.fundacioncardiologica.org/155-Como-mantenernos-saludables-en-casa-en-epocas-del-Coronavirus.note.aspx\\n\" +\n" +
                "                \"\\n\" +\n" +
                "                \"Por la Fundación Cardiológica Argentina (FCA), con el asesoramiento del Dr. Gonzalo Diaz Babio, médico cardiólogo (MN 129.388) y","Yo1","30 de mayo1"))
        noticias.add(noticia("Titulo de la noticia2","Cuerpo de la noticia2","Yo2","30 de mayo2"))
        noticias.add(noticia("Titulo de la noticia3","Cuerpo de la noticia3","Yo3","30 de mayo3"))
        noticias.add(noticia("Titulo de la noticia4","Cuerpo de la noticia4","Yo4","30 de mayo4"))


        recNoticias.setHasFixedSize(true) //Marcar el Recycler View como de tamaño fijo

        //Indicar el tipo de layout que va a tener el Recycler View
        linearLayoutManager = LinearLayoutManager(context)
        recNoticias.layoutManager = linearLayoutManager

        noticiaListAdapter = NoticiaListAdapter(noticias){position -> onItemClick(position)}
        //noticiaListAdapter = NoticiaListAdapter(listaDenoticia) //Indicar el tipo de adaptador del item
        recNoticias.adapter = noticiaListAdapter
    }

    fun onItemClick ( position : Int ) {


        var Titulo = noticias[position].titulo
        var Cuerpo = noticias[position].cuerpo
        var Fecha = noticias[position].fecha
        var Autor = noticias[position].autor

        //Snackbar.make(v,Cuerpo, Snackbar.LENGTH_SHORT).show()

        val a12=FragmentNoticiasDirections.actionFragmentNoticiasToNoticia(Titulo,Cuerpo,Fecha,Autor)
        v.findNavController().navigate(a12)
    }
}
