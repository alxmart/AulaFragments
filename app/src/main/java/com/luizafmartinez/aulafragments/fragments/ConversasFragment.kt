package com.luizafmartinez.aulafragments.fragments

import android.content.Context
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.fragment.app.Fragment
import com.luizafmartinez.aulafragments.R

//class ConversasFragment : Fragment(R.layout.fragment_conversas) {

class ConversasFragment : Fragment() {

    private lateinit var btnExecutar : Button
    private lateinit var textNome    : TextView
    private lateinit var textCategoria    : TextView
    private lateinit var editNome    : EditText

    private var categoria : String? = null
    private var usuario : String? = null

    override fun onAttach(context: Context) {
        super.onAttach(context)
        Log.i("Ciclo de Vida", "Fragment - onAttach")
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        Log.i("Ciclo de Vida", "Fragment - onCreate")

        categoria = arguments?.getString("categoria")
        usuario = arguments?.getString("usuario")
    }

    // Deprecated (Usar onViewCreated)
    /*
    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
    }
    */
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        Log.i("Ciclo de Vida", "Fragment - onViewCreated")
    }

    override fun onStart() {
        super.onStart()
        Log.i("Ciclo de Vida", "Fragment - onStart")
    }

    override fun onResume() {
        super.onResume()
        Log.i("Ciclo de Vida", "Fragment - onResume")
    }

    override fun onPause() {
        super.onPause()
        Log.i("Ciclo de Vida", "Fragment - onPause")
    }

    override fun onStop() {
        super.onStop()
        Log.i("Ciclo de Vida", "Fragment - onStop")
    }

    override fun onDestroyView() {
        super.onDestroyView()
        Log.i("Ciclo de Vida", "Fragment - onDestroyView")
    }

    override fun onDestroy() {
        super.onDestroy()
        Log.i("Ciclo de Vida", "Fragment - onDestroy")
    }

    override fun onDetach() {
        super.onDetach()
        Log.i("Ciclo de Vida", "Fragment - onDetach")
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        Log.i("Ciclo de Vida", "Fragment - onCreateView")
        //return super.onCreateView(inflater, container, savedInstanceState)
        val view = inflater.inflate(
            R.layout.fragment_conversas,
            container,
            false
        )

        //Processamento de Visualização
        //view.findViewById<TextView>(R.id.textConversas)
        //OBS.: No caso do Fragmente, tem que usar view.findViewByID...
            btnExecutar   = view.findViewById( R.id.btn_executar )
            editNome      = view.findViewById( R.id.edit_nome )
            textNome      = view.findViewById( R.id.text_nome )
            textCategoria = view.findViewById( R.id.text_categoria )

        textCategoria.text = categoria
        textNome.text = usuario

        btnExecutar.setOnClickListener {
            textNome.text = editNome.text.toString()
        }

        return view
    }

}
