package com.yssierra.fundamentoskotlin.Reto1

class ejercicio1{

}
fun main() {


    val mensajes = ArrayList<String>()
    val cantidades = ArrayList<Int>()

    println("Ingrese el mensaje de resumen (o escriba 'salir' para terminar):")
    var mensaje = readLine() ?: ""

    while (mensaje != "salir") {
        mensajes.add(mensaje)
        println("Ingrese la cantidad de notificaciones:")
        val cantidadNotificacionesStr = readLine()
        val cantidadNotificaciones = cantidadNotificacionesStr?.toIntOrNull()

        if (cantidadNotificaciones != null) {
            cantidades.add(cantidadNotificaciones)
        } else {
            println("No existen mensajes disponibles")
        }

        println("Ingrese el mensaje de resumen (o escriba 'salir' para terminar):")
        mensaje = readLine() ?: ""
    }

    if (mensajes.isEmpty()) {
        println("No existen mensajes disponibles")
    } else {
        println("Mensajes almacenados:")
        for (i in 0.. mensajes.size) {
            val resumen = if (cantidades[i] < 100) {
                "La cantidad exacta de notificaciones es: ${cantidades[i]}"
            } else {
                "99+ como cantidad de notificaciones"
            }
            println("- Mensaje: ${mensajes[i]} / Resumen: $resumen")
        }
    }
}