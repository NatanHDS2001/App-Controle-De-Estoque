package com.example.controledeestoquev1

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button

class telaSobreApp : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_tela_sobre_app)
        supportActionBar!!.hide()

        val bntVoltar: Button = findViewById(R.id.bntSobreApp_Voltar)

        bntVoltar.setOnClickListener {
            val telHome = Intent(this, Home::class.java)
            startActivity(telHome)
        }

    }
}