package com.example.controledeestoquev1

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        supportActionBar!!.hide()

//----------------------------------------------PARTE DE LOGIN----------------------------------------------------------------------------------------------------------
        val bdUsuarios = HashMap<String, String>()
        bdUsuarios["natan"] = "natan|Natan Hora|123456"
        bdUsuarios["kawa"] = "kawa|Kawa Ribeiro|123456"
        bdUsuarios["caio"] = "caio|Caio Fernandes|123456"
        bdUsuarios["gabriel"] = "gabriel|Gabriel Araujo|123456"
        bdUsuarios["matheus"] = "matheus|Matheus Gomes|123456"
        bdUsuarios["melissa"] = "melissa|Melissa da Silva|123456"
        bdUsuarios["bruno"] = "bruno|Bruno Menin|123456"
        bdUsuarios["lucas"] = "lucas|Lucas Alencar|123456"
        bdUsuarios["leticia"] = "leticia|Leticia Moura|123456"


        val bntConectar:Button = findViewById(R.id.btnConectar)
        val edtUsuario: EditText = findViewById(R.id.edtUsuario)
        val edtSenha: EditText = findViewById(R.id.edtSenha)


        bntConectar.setOnClickListener {

            val sUsuario: String = edtUsuario.text.toString()
            val sSenha: String = edtSenha.text.toString()
            val usuario = bdUsuarios[sUsuario]?.split("|")

            if (usuario?.get(0)?.compareTo(sUsuario) !=0 || usuario?.get(2)?.compareTo(sSenha) !=0){
                Toast.makeText(applicationContext, "Usuario ou senha incorreto. Tente novamente", Toast.LENGTH_LONG).show()
                edtUsuario.setText("")
                edtSenha.setText("")
                edtUsuario.requestFocus()

            } /*else if (usuario?.get(2)?.compareTo(sSenha) !=0){
                Toast.makeText(applicationContext, "Senha incorreta. Tente novamente", Toast.LENGTH_LONG).show()
            }*/
            else{
                Toast.makeText(applicationContext, "Seja Bem Vindo " + usuario.get(1).toString() + ".", Toast.LENGTH_LONG).show()
                val telHome = Intent(this, Home::class.java)
                startActivity(telHome)

                //

            }

        }

    }

//----------------------------------------------PARTE DOS PRODUTOS NA HOME----------------------------------------------------------------------------------------------



}




