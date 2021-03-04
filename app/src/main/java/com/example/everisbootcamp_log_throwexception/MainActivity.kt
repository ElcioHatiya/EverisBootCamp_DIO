package com.example.everisbootcamp_log_throwexception

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.graphics.Color
import android.util.Log
import kotlinx.android.synthetic.main.activity_main.*
import java.lang.Exception

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val btCalc = btn_Calc
        val resultado = txt_Result
        val btLog = btn_Log
        val btErro = btn_Erro
        val btTest = btn_tryCatch
        val list = listOf(2,1,4)

        val currentThread = Thread.currentThread()
        currentThread.setUncaughtExceptionHandler{_,throwable ->
            val x = throwable.message
            val cause = throwable.cause
        }

        btTest.setOnClickListener {
            var msg:String=""
            try {
                val a = list[6]
            } catch (e: IndexOutOfBoundsException){
                val x =0
                msg = "Catch IndexOutOfBounds"
            } catch (i: NullPointerException) {
                msg = "Catch NullPointer"
            } finally {
                resultado.setText(msg)
            }
        }
        btErro.setOnClickListener {
            //throw Exception()
            val b = list[6]
        }
        btLog.setOnClickListener {  Log.d("btn_Log","Clickei no Log!")
                                    btLog.setText("Clicado")
                                    btLog.setBackgroundColor(Color.GRAY)
        }
        btCalc.setOnClickListener{
            val nota1 = Integer.parseInt(txt_notaUm.text.toString())
            val nota2 = Integer.parseInt(txt_notaDois.text.toString())
            val faltas = Integer.parseInt(txt_faltas.text.toString())
            val media = (nota1 + nota2)/2

            if (media >= 6 && faltas <=10) {
                resultado.setText("Aluno aprovado!" + "\n" + "Média: " + media + "\n" + "Faltas: " + faltas)
                resultado.setTextColor(Color.GREEN)
            }
            else{resultado.setText("Aluno reprovado!" + "\n" + "Média: " + media + "\n" + "Faltas: " + faltas)
                resultado.setTextColor(Color.RED)
            }
        }
    }
}