package com.example.examenrecuperacion

class Calculadora(private val num1: Float, private val num2: Float) {

    fun suma(): Float {
        return num1 + num2
    }

    fun resta(): Float {
        return num1 - num2
    }

    fun multiplicacion(): Float {
        return num1 * num2
    }

    fun division(): Float {
        return if (num2 != 0f) num1 / num2 else Float.NaN
    }
}
