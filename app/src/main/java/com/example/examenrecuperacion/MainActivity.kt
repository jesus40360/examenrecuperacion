package com.example.examenrecuperacion

import android.content.Intent
import android.os.Bundle
import android.widget.*
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {

    private lateinit var txtUsuario: EditText
    private lateinit var txtContraseña: EditText
    private lateinit var btnIngresar: Button
    private lateinit var btnSalir: Button
    private lateinit var lblCalculadora: TextView
    private lateinit var lblUsuario: TextView
    private lateinit var lblContraseña: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        lblCalculadora = findViewById(R.id.lblCalculadora)
        lblUsuario = findViewById(R.id.lblUsuario)
        lblContraseña = findViewById(R.id.lblContraseña)
        txtUsuario = findViewById(R.id.txtUsuario)
        txtContraseña = findViewById(R.id.txtContraseña)
        btnIngresar = findViewById(R.id.btnIngresar)
        btnSalir = findViewById(R.id.btnSalir)

        btnIngresar.setOnClickListener {
            val usuario = txtUsuario.text.toString()
            val pass = txtContraseña.text.toString()

            if (usuario == getString(R.string.user) && pass == getString(R.string.pass)) {
                val intent = Intent(this, CalculadoraActivity::class.java)
                intent.putExtra("nombreUsuario", getString(R.string.nombre))
                startActivity(intent)
            } else {
                Toast.makeText(this, "Usuario o contraseña incorrectos", Toast.LENGTH_SHORT).show()
            }
        }

        btnSalir.setOnClickListener {
            AlertDialog.Builder(this)
                .setTitle("Salir")
                .setMessage("¿Deseas cerrar la app?")
                .setPositiveButton("Sí") { _, _ -> finish() }
                .setNegativeButton("No", null)
                .show()
        }
    }
}
