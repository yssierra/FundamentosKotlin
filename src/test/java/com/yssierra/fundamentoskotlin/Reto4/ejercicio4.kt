package com.yssierra.fundamentoskotlin.Reto4

class ejercicio4 {

}

fun main() {

        var entrada = ""
        var platosFuertes = ""
        var postres = ""
        var bebidas = ""

        var opcion: Int
        do {
            println("Menu de restaurante")
            println("1. Agregar plato")
            println("2. Mostrar todos los platoss")
            println("3. Salir")
            println("Ingrese la opcion 1 para agregar su plato y añadirlo a la categoria segun su eleccion :")
            opcion = readLine()?.toIntOrNull() ?: 0
            when (opcion) {
                1 -> {
                    println("Categorias")
                    println("1. Entradas")
                    println("2. Platos Fuertes")
                    println("3. Postres")
                    println("4. Bebidas")
                    println("Seleccione la categoria del plato (1-4):")
                    val categoria = readLine()?.toIntOrNull() ?: continue
                    println("Ingrese el nombre del plato:")
                    val nombre = readLine() ?: continue
                    when (categoria) {
                        1 -> entrada = nombre
                        2 -> platosFuertes = nombre
                        3 -> postres = nombre
                        4 -> bebidas = nombre
                        else -> println("Categoría inválida.")
                    }
                    println("Plato agregado correctamente a la categoria $categoria")
                }
                2 -> {
                    mostrarPlatos(entrada, "Entradas")
                    mostrarPlatos(platosFuertes, "Platos Fuertes")
                    mostrarPlatos(postres, "Postres")
                    mostrarPlatos(bebidas, "Bebidas")
                }
                3 -> println("Menu de restaurante listo")
                else -> println("Opcion ivalida, ingrese un numero de 1 al 3")
            }
        } while (opcion != 3)
    }

    fun mostrarPlatos(platos: String, categoria: String) {
        println("$categoria")
        if (platos.isEmpty()) {
            println("No hay platos agregados a esta en esta categoría.")
        } else {
            println(platos)
        }
    }









