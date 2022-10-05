package com.example.controledeestoquev1

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.*
import androidx.activity.result.contract.ActivityResultContracts
import com.google.zxing.integration.android.IntentIntegrator

class Home : AppCompatActivity() {
    private val obterResultado =
        registerForActivityResult(ActivityResultContracts.StartActivityForResult()) {
            val intentResult = IntentIntegrator.parseActivityResult(it.resultCode, it.data)
            if (intentResult.contents != null) {
                Toast.makeText(this, intentResult.contents, Toast.LENGTH_LONG).show()
                val telaqrcod = Intent(this, tela_QR_Code::class.java)
                telaqrcod.putExtra("codigo_produto", intentResult.contents)
                startActivity(telaqrcod)
            }
        }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home)
        supportActionBar!!.hide()

        val bntQRCode: Button = findViewById(R.id.bntQRCode)
        //val bntNovoProd: Button = findViewById(R.id.bntNovoProd)
        val bntSobreApp: Button = findViewById(R.id.bntSobreApp)
/*
        mTabProdutos["7894900010015"] = "REFRIGERANTE COCA-COLA LATA 350ML|A|1|1|1000"
        mTabProdutos["7894900011517"] = "REFRIGERANTE COCA-COLA GARRAFA 2L|A|1|2|1000"
        mTabProdutos["7891991000833"] = "REFRIGERANTE SODA LIMONADA ANTARTIC LATA 350ML|A|1|3|1000"
        mTabProdutos["7891991011020"] = "REFRIGERANTE GUARANA ANTARCTICA LATA 350ML|A|2|1|1000"
        mTabProdutos["7898712836870"] = "REFRIGERANTE GUARANA ANTARCTICA 2L|A|2|2|1000"
        mTabProdutos["7894900039924"] = "REFRIGERANTE FANTA LARANJA 2L|A|2|3|1000"
        mTabProdutos["7894900031201"] = "REFRIGERANTE FANTA LARANJA LATA 350ML|A|2|4|1000"
        mTabProdutos["7892840800079"] = "REFRIGERANTE PEPSI LATA 350ML|A|3|1|1000"
        mTabProdutos["7892840813017"] = "REFRIGERANTE PEPSI 2L|A|3|2|1000"
        mTabProdutos["7896004000855"] = "SUCRILHOS KELLOGG'S ORIGINAL 250G|B|1|1|1000"
        mTabProdutos["7896004003979"] = "SUCRILHOS KELLOGG'S CHOCOLATE 320G|B|1|2|1000"
        mTabProdutos["7896110005140"] = "PAPEL HIGIÊNICO PERSONAL FOLHA SIMPLES NEUTRO 60 METROS 4 UNIDADES|B|2|1|1000"
        mTabProdutos["7896104998953"] = "PAPEL HIGIÊNICO MILI 4R|B|2|2|1000"
        mTabProdutos["7896076002146"] = "PAPEL HIGIENICO DAMA 60MTR|B|2|3|1000"
        mTabProdutos["7896276060021"] = "ARROZ AGULHINHA ARROZAL T1 5KG|C|1|1|1000"
        mTabProdutos["7898295150189"] = "ARROZ SABOROSO 5KG|C|1|2|1000"
        mTabProdutos["7896086423030"] = "ARROZ TRIMAIS 5KG|C|1|3|1000"
        mTabProdutos["7896864400192"] = "FEIJAO PICININ 1KG|C|2|1|1000"
        mTabProdutos["7897924800877"] = "FEIJAO PRETO VENEZA 1KG|C|2|2|1000"
        mTabProdutos["7898084090030"] = "FEIJÃO PEREIRA CARIOQUINHA 1KG|C|2|3|1000"
        mTabProdutos["7891959004415"] = "AÇUCAR REFINADO DOÇULA 1KG|D|1|1|1000"
        mTabProdutos["7896032501010"] = "AÇÚCAR REFINADO DA BARRA 1KG|D|1|2|1000"
        mTabProdutos["7896109801005"] = "AÇÚCAR REFINADO ESPECIAL GUARANI 1KG|D|1|3|1000"
        mTabProdutos["7896319420546"] = "ACUCAR REFINADO CLARION 1KG|D|2|1|1000"
        mTabProdutos["7896089028935"] = "CAFÉ TORRADO MOÍDO POUCHE CAFÉ DO PONTO 500G|D|2|2|1000"
        mTabProdutos["7898286200077"] = "CAFE MARATA 500G|D|2|3|1000"
        mTabProdutos["7891910010905"] = "CAFE CABOCLO 500G|D|3|1|1000"
        mTabProdutos["7898079250012"] = "CAFE FIORENZA 500G|D|3|2|1000"
        mTabProdutos["7891107000504"] = "OLEO DE SOJA SOYA 1L|E|1|1|1000"
        mTabProdutos["7896334200550"] = "OLEO DE SOJA GRANOL 1L|E|2|1|1000"
        mTabProdutos["7896036090107"] = "OLEO DE SOJA VELEIRO 1L|E|3|1|1000"*/


        bntQRCode.setOnClickListener {
            val integrator: IntentIntegrator = IntentIntegrator(this)
            integrator.setPrompt("Leitura de QRCode")
            obterResultado.launch(integrator.createScanIntent())
        }

/*
        bntNovoProd.setOnClickListener {
            val telQRCode = Intent(this, tela_QR_Code::class.java)
            startActivity(telQRCode)
        }*/

        bntSobreApp.setOnClickListener {
            val telQRCode = Intent(this, telaSobreApp::class.java)
            startActivity(telQRCode)
        }
    }
}