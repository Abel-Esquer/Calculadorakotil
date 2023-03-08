package com.itson.calculadorakotlin

import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity(), View.OnClickListener {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        findViewById<View>(R.id.btnSumar).setOnClickListener(this)
        findViewById<View>(R.id.btnRestar).setOnClickListener(this)
        findViewById<View>(R.id.btnMultiplicar).setOnClickListener(this)
        findViewById<View>(R.id.btnDividir).setOnClickListener(this)
    }

    fun sumar(opcion1: Int, opcion2: Int): Int {
        return opcion1 + opcion2
    }

    fun restar(opcion1: Int, opcion2: Int): Int {
        return opcion1 - opcion2
    }

    fun multiplicar(opcion1: Int, opcion2: Int): Int {
        return opcion1 * opcion2
    }

    fun dividir(opcion1: Int, opcion2: Int): Int {
        return opcion1 / opcion2
    }

    override fun onClick(v: View?) {
        val numero1 = (findViewById<View>(R.id.numero1) as TextView)
        val numero2 = (findViewById<View>(R.id.numero2) as TextView)

        if (numero1.text.isEmpty() or numero2.text.isEmpty()) {
            Toast.makeText(application, ("Ambas cajas deben de tener un numero"), Toast.LENGTH_LONG).show()
        } else {
            when (v?.id) {
                (R.id.btnSumar) -> {
                    try {
                        Toast.makeText(
                            application,
                            Integer.toString(sumar(numero1.text.toString().toInt() , numero2.text.toString().toInt())),
                            Toast.LENGTH_SHORT
                        ).show()
                    } catch (ex: Exception) {
                        Log.e("Ocurrio un error al sumar", ex.toString())
                    }
                }
                (R.id.btnMultiplicar) -> {
                    try {
                        Toast.makeText(
                            application,
                            Integer.toString(multiplicar(numero1.text.toString().toInt() , numero2.text.toString().toInt() )),
                            Toast.LENGTH_SHORT
                        ).show()
                    } catch (ex: Exception) {
                        Log.e("Ocurrio un error al multiplicar", ex.toString())
                    }

                }
                (R.id.btnRestar) -> {
                    try {
                        Toast.makeText(
                            application,
                            Integer.toString(restar(numero1.text.toString().toInt() , numero2.text.toString().toInt() )),
                            Toast.LENGTH_SHORT
                        ).show()
                    } catch (ex: Exception) {
                        Log.e("Ocurrio un error al restar", ex.toString())
                    }
                }
                (R.id.btnDividir) -> {
                    if (numero2.text.toString().toInt()  == 0 || numero1.text.toString().toInt() == 0){
                        Toast.makeText(application, ("No se puede dividir entre 0"), Toast.LENGTH_LONG).show()
                    }else{
                    try {
                        Toast.makeText(
                            application,
                            Integer.toString(dividir(numero1.text.toString().toInt() , numero2.text.toString().toInt() )),
                            Toast.LENGTH_SHORT
                        ).show()
                    } catch (ex: Exception) {
                        Log.e("Ocurrio un error al restrar", ex.toString())
                    }
                    }
                }
            }
        }
    }
}