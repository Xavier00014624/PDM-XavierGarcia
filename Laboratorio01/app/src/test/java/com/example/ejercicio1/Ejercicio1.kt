package com.example.ejercicio1

import org.junit.Test

class Computadora(
    var ram: Int,
    var almacenamiento: Int,
    var sistemaOperativo: String,
    var programasInstalados: MutableList<String>
) {
    // ram y almacenamiento esta en GB
    fun encender() {
        println("La computadora esta encendida")
    }

    fun apagar() {
        println("La computadora esta apagada")
    }

    fun mostrarEspecificaciones() {
        println("=== ESPECIFICACIONES ===")
        println("RAM: $ram GB")
        println("Almacenamiento: $almacenamiento GB")
        println("Sistema Operativo: $sistemaOperativo")
    }
    fun actualizarRAM(nuevaRAM: Int) {
        ram = nuevaRAM
        println("RAM actualizada a $ram GB")
    }

    fun actualizarAlmacenamiento(nuevoAlmacenamiento: Int) {
        almacenamiento = nuevoAlmacenamiento
        println("Almacenamiento actualizado a $almacenamiento GB")
    }

    fun cambiarSistemaOperativo(nuevoSO: String) {
        sistemaOperativo = nuevoSO
        println("Sistema operativo cambiado a $sistemaOperativo")
    }
    fun programasDel2026(): List<String> {
        return programasInstalados.filter { it.contains("2026") }
    }
}

// Tests
class ejercicios {

    @Test
    fun pruebaComputadora() {

        val programas = mutableListOf(
            "Notion 2026",
            "Facebook 2024",
            "VSCode 2026",
            "Chrome 2023"
        )

        val pc = Computadora(
            ram = 8,
            almacenamiento = 256,
            sistemaOperativo = "Windows 10",
            programasInstalados = programas
        )
        pc.mostrarEspecificaciones()
        pc.encender()

        pc.actualizarRAM(16)
        pc.actualizarAlmacenamiento(512)
        pc.cambiarSistemaOperativo("Windows 11")

        println("Programas instalados en 2026:")
        pc.programasDel2026().forEach {
            println(it)
        }

        pc.apagar()
    }
}