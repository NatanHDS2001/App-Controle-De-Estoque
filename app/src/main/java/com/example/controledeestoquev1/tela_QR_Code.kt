package com.example.controledeestoquev1

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ArrayAdapter
import android.widget.Button
import android.widget.EditText
import android.widget.ListView

class tela_QR_Code : AppCompatActivity() {

    private lateinit var listProduto: ListView
    private lateinit var adapter: ArrayAdapter<String>
    private var mapProdutos = ArrayList<String>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_tela_qr_code)
        supportActionBar!!.hide()

        // Define a lista como uma variavel
        listProduto = findViewById(R.id.listProduto)

        // Recupera o resultado do QR Code e joga em uma variavel
        val resultadoQRCode = intent.extras
        val listaProduto = resultadoQRCode?.getString("codigo_produto")

        if (listaProduto != null) {
            if (listaProduto.contains("|", ignoreCase = true)) {
                val aux = listaProduto.split("|")
                for (i in aux) {
                    mapProdutos.add(i)
                }
            }
        }

        atualizaListaTarefas();

        //Botão de voltar para a home
        val bntVoltar: Button = findViewById(R.id.bntQRCode_Voltar)
        bntVoltar.setOnClickListener {
            val telHome = Intent(this, Home::class.java)
            startActivity(telHome)
        }
    }

    //Função para gerenciar a lista de produtos à serem separados
    private fun atualizaListaTarefas() {
        adapter = ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, mapProdutos)
        listProduto.setAdapter(adapter);
    }


}



