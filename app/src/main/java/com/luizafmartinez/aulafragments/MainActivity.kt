package com.luizafmartinez.aulafragments

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.TextUtils.replace
import android.util.Log
import android.widget.Button
import androidx.core.os.bundleOf
import androidx.fragment.app.commit
import androidx.fragment.app.replace
import com.luizafmartinez.aulafragments.fragments.ChamadasFragment
import com.luizafmartinez.aulafragments.fragments.ConversasFragment

class MainActivity : AppCompatActivity() {

    private lateinit var btnMercado: Button
    private lateinit var btnChamadas: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        btnMercado = findViewById(R.id.btn_mercado)
        btnChamadas = findViewById(R.id.btn_chamadas)

        /*
        val fragmentManager = supportFragmentManager.beginTransaction()
        // Diversas alterações em fragments. (Usando objeto fragmentManager)
        fragmentManager.add(R.id.fragment_conteudo, ConversasFragment())
        fragmentManager.commit()
        */

        // ou então desta forma:
        /*supportFragmentManager
            .beginTransaction()
            .add(R.id.fragment_conteudo, ConversasFragment())   //Carregou o Conversas
            .commit()*/

        btnMercado.setOnClickListener {

            //val conversasFragment = ConversasFragment()

            /*  val bundle = bundleOf(
                "categoria" to "mercado",
                "usuario" to "jamilton"
            )*/

            //conversasFragment.arguments = bundle

            /*supportFragmentManager
                .beginTransaction()
                .replace(R.id.fragment_conteudo, conversasFragment ) //Carrega ConversasFragment
                .commit()*/

            val bundle = bundleOf(
                "categoria" to "mercado",
                "usuario" to "jamilton"
            )
            supportFragmentManager.commit {
                replace<ConversasFragment>(
                    R.id.fragment_conteudo,
                    args = bundle
                )
            }

        }

        btnChamadas.setOnClickListener {
            supportFragmentManager
                .beginTransaction()
                .replace(R.id.fragment_conteudo, ChamadasFragment()) //Carrega ChamadasFragment
                .commit()
        }

        // Para remover um Fragment: Remove instânica específica de um objeto
        //val conversasFragment = ConversasFragment()
        // No btnCoversas.setOnClickListener,
        // altera de ChamadasFragment() p/ chamadasFragment (Usa o objeto criado)
        // No btnChamads.setOnClickListener,
        // comenta:   .replace(R.id.fragment_conteudo, ChamadasFragment())
        // Adiciona:  .remove(conversasFragment)  (Usa o objeto criado)
    }

    override fun onStart() {
        super.onStart()
        Log.i("Ciclo de Vida", "Activity - onStart")
    }

    override fun onResume() {
        super.onResume()
        Log.i("Ciclo de Vida", "Activity - onResume")
    }

    override fun onPause() {
        super.onPause()
        Log.i("Ciclo de Vida", "Activity - onPause")
    }

    override fun onStop() {
        super.onStop()
        Log.i("Ciclo de Vida", "Activity - onStop")
    }

    override fun onDestroy() {
        Log.i("Ciclo de Vida", "Activity - onDestroy")
        super.onDestroy()
    }

}