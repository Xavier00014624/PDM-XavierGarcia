package com.example.ejercicio1
import org.junit.Test
class Estudiante(
    val nombre: String,
    val carnet: String,
    val asignatura: String
)

// Tests
class Ejercicio3Test {

    @Test
    fun pasarLista() {

        val Ciclo01 = mutableListOf(
            Estudiante("Juan", "001", "Programación de Dispositivos Móviles"),
            Estudiante("Ana", "002", "Programación de Dispositivos Móviles"),
            Estudiante("Luis", "003", "Programación de Dispositivos Móviles"),

            Estudiante("Carlos", "004", "Análisis Numérico"),
            Estudiante("María", "005", "Análisis Numérico"),
            Estudiante("Pedro", "006", "Análisis Numérico"),
            Estudiante("Sofía", "007", "Análisis Numérico")
        )
        val dispositivosMoviles = Ciclo01.filter {
            it.asignatura == "Programación de Dispositivos Móviles"
        }

        println("=== Estudiantes de Programación de Dispositivos Móviles ===")

        dispositivosMoviles.forEach {
            println("Nombre: ${it.nombre} | Carnet: ${it.carnet}")
        }
    }
}
