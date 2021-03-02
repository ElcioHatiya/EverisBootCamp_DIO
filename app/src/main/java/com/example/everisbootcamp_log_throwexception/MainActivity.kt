package com.example.everisbootcamp_log_throwexception

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.graphics.Color
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val btCalc = btn_Calc
        val resultado = txt_Result

        btCalc.setOnClickListener{

            //Log.d("media","Clickei no botão!")
            //throw Exception()
            val nota1 = Integer.parseInt(txt_notaUm.text.toString())
            val nota2 = Integer.parseInt(txt_notaDois.text.toString())
            val faltas = Integer.parseInt(txt_faltas.text.toString())
            val media = (nota1 + nota2)/2

            if (media >= 6 && faltas <=10) {
                resultado.setText("Aluno aprovado!" + "\n" + "Média: " + media + "\n" + "Faltas: " + faltas)
                resultado.setTextColor(Color.GREEN)}

            else{resultado.setText("Aluno reprovado!" + "\n" + "Média: " + media + "\n" + "Faltas: " + faltas)
                resultado.setTextColor(Color.RED)}
        }
    }
}