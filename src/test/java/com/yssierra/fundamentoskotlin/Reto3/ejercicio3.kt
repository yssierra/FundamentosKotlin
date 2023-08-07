package com.yssierra.fundamentoskotlin.Reto3



class ejercicio3{

}
fun main() {
    val nombreArticulo1 = "Televisor"
    val precioBase1 = 500.0
    var ofertaArticulo1: Double? = null

    val nombreArticulo2 = "Computadora"
    val precioBase2 = 800.0
    var ofertaArticulo2: Double? = null

    val nombreArticulo3 = "Teléfono"
    val precioBase3 = 300.0
    var ofertaArticulo3: Double? = null

    println("Subasta para $nombreArticulo1")
    ofertaArticulo1 = solicitarOferta()

    println("Subasta para $nombreArticulo2")
    ofertaArticulo2 = solicitarOferta()

    println("Subasta para $nombreArticulo3")
    ofertaArticulo3 = solicitarOferta()

    determinarGanador(nombreArticulo1, precioBase1, ofertaArticulo1)
    determinarGanador(nombreArticulo2, precioBase2, ofertaArticulo2)
    determinarGanador(nombreArticulo3, precioBase3, ofertaArticulo3)
}

fun solicitarOferta(): Double? {
    print("Ingresa tu oferta (o presiona Enter para no ofertar): ")
    val input = readLine()
    return if (input.isNullOrEmpty()) {
        null
    } else {
        input.toDouble()
    }
}

fun determinarGanador(nombreArticulo: String, precioBase: Double, oferta: Double?) {
    if (oferta != null && oferta >= precioBase) {
        println("El artículo $nombreArticulo se vende al ofertante con precio: $oferta")
    } else {
        println("No se recibieron ofertas suficientemente altas para el artículo $nombreArticulo. El artículo queda para la casa.")
    }
}






