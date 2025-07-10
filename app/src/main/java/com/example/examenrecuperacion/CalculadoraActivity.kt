package com.example.examenrecuperacion

import android.os.Bundle
import android.widget.*
import androidx.appcompat.app.AppCompatActivity
import com.example.examenrecuperacion.R

class CalculadoraActivity : AppCompatActivity() {

    private lateinit var lblCalculadora: TextView
    private lateinit var lblUsuario: TextView
    private lateinit var lblNum1: TextView
    private lateinit var lblNum2: TextView
    private lateinit var lblResultado: TextView
    private lateinit var txtNum1: EditText
    private lateinit var txtNum2: EditText
    private lateinit var btnSuma: Button
    private lateinit var btnResta: Button
    private lateinit var btnMult: Button
    private lateinit var btnDiv: Button
    private lateinit var btnLimpiar: Button
    private lateinit var btnRegresar: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_calculadora)

        lblCalculadora = findViewById(R.id.lblCalculadora)
        lblUsuario = findViewById(R.id.lblUsuario)
        lblNum1 = findViewById(R.id.lblNum1)
        lblNum2 = findViewById(R.id.lblNum2)
        lblResultado = findViewById(R.id.lblResultado)
        txtNum1 = findViewById(R.id.txtNum1)
        txtNum2 = findViewById(R.id.txtNum2)
        btnSuma = findViewById(R.id.btnSuma)
        btnResta = findViewById(R.id.btnResta)
        btnMult = findViewById(R.id.btnMult)
        btnDiv = findViewById(R.id.btnDiv)
        btnLimpiar = findViewById(R.id.btnLimpiar)
        btnRegresar = findViewById(R.id.btnRegresar)

        val nombreUsuario = intent.getStringExtra("nombreUsuario")
        lblUsuario.text = nombreUsuario

        btnSuma.setOnClickListener { calcularOperacion("+") }
        btnResta.setOnClickListener { calcularOperacion("-") }
        btnMult.setOnClickListener { calcularOperacion("*") }
        btnDiv.setOnClickListener { calcularOperacion("/") }

        btnLimpiar.setOnClickListener {
            txtNum1.text.clear()
            txtNum2.text.clear()
            lblResultado.text = "Resultado:"
        }

        btnRegresar.setOnClickListener {
            finish()
        }
    }

    private fun calcularOperacion(op: String) {
        val num1 = txtNum1.text.toString().toFloatOrNull()
        val num2 = txtNum2.text.toString().toFloatOrNull()

        if (num1 == null || num2 == null) {
            Toast.makeText(this, "Ingresa números válidos", Toast.LENGTH_SHORT).show()
            return
        }

        val calculadora = Calculadora(num1, num2)
        val resultado = when (op) {
            "+" -> calculadora.suma()
            "-" -> calculadora.resta()
            "*" -> calculadora.multiplicacion()
            "/" -> calculadora.division()
            else -> 0f
        }

        lblResultado.text = "Resultado: $resultado"
    }
}
