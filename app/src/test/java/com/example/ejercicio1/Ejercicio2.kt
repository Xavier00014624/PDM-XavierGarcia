package com.example.ejercicio1
import org.junit.Test
class Calculadora(
    val marca: String,        // inmutable
    val aniosDeVida: Int,     // inmutable
    var precio: Double        // mutable
) {

    fun sumar(a: Double, b: Double): Double {
        return a + b
    }

    fun restar(a: Double, b: Double): Double {
        return a - b
    }

    fun multiplicar(a: Double, b: Double): Double {
        return a * b
    }

    fun dividir(a: Double, b: Double): Double {
        if (b == 0.0) {
            println("Error: No se puede dividir entre 0")
            return Double.NaN
        }
        return a / b
    }

    fun mostrarInfo() {
        println("=== CALCULADORA ===")
        println("Marca: $marca")
        println("Años de vida: $aniosDeVida")
        println("Precio: $$precio")
    }
}

// Tests
class Ejercicio2Test {

    @Test
    fun pruebaCalculadora() {

        val calc = Calculadora(
            marca = "Casio",
            aniosDeVida = 5,
            precio = 25.99
        )

        calc.mostrarInfo()

        println("Suma: ${calc.sumar(10.0, 5.0)}")
        println("Resta: ${calc.restar(10.0, 5.0)}")
        println("Multiplicacion: ${calc.multiplicar(10.0, 5.0)}")
        println("Division: ${calc.dividir(10.0, 5.0)}")

        println("División entre 0: ${calc.dividir(10.0, 0.0)}")
    }
}
