package com.yssierra.fundamentoskotlin.Reto5

class Nequi{
    var saldoDis=4500

    fun iniciarSesion(){
        println("Nequi Colombia")
        var intentosValidos=3
        while (intentosValidos>0){
            println("Ingrese su numero de telefono:")
            val numTelefono= readLine()
            println("Ingrese su clave de 4 digitos:")
            val clave= readLine()
            if (numTelefono=="3128201623" && clave=="0825"){
                print("!Incio de sesion exitoso!")
                mostrarSaldo()
                mostrarMenu()
                break
            }else{
                intentosValidos--
                if (intentosValidos>0){
                    println("!Upps!Parece que tus datos de acceso no son correctos ,Tienes tres intentos mas")
                } else {
                    println("Lo siento intentalo mas tarde")
                }
            }
        }
    }
    fun mostrarSaldo(){
        println("Saldo disponible:$saldoDis")

    }
    fun mostrarMenu(){
        var opcion: Int
        do {
            println("Elige una opcion:")
            println("1.Saca")
            println("2.Envia")
            println("3.Recarga")
            println("4.Salir")
            opcion = readLine()?.toIntOrNull() ?: 0

            when(opcion){
                1->saca()
                2->Envia()
                3->Recarga()
                4-> println("Saliendo de Nequi Colombia")
                else-> println("Opcion invalida ingrese un numero del 1 al 4")
            }

        }while (opcion!=4)

    }
    fun saca(){
        println("Elige una opcion:")
        println("1. Cajero")
        println("2.Punto Fisico")
        val opcion= readLine()?.toIntOrNull()?:0
        if(saldoDis<2000){
            println("Saldo insuficiente para hacer el retiro")
        }else{
            println("Ingrese el monto que desea retirar:")
            val monto= readLine()?.toIntOrNull()?:0
            if (monto <= saldoDis) {
                println("Retiro exitoso. Generando código de 6 dígitos...")
                saldoDis -= monto
            } else {
                println("No tienes suficiente saldo para hacer el retiro.")
        }
    }

}
    fun Envia() {
        println("Ingrese el número de teléfono al que desea enviar dinero:")
        val numeroDestino = readLine()
        println("Ingrese el valor a enviar:")
        val valorEnviar = readLine()?.toIntOrNull() ?: 0

        if (valorEnviar <= saldoDis) {
            saldoDis -= valorEnviar
            println("Envío exitoso. Saldo disponible: $saldoDis")
        } else {
            println("No tienes suficiente saldo para hacer el envío.")
        }
    }
    private fun Recarga() {
        println("Ingrese el valor a recargar:")
        val valorRecarga = readLine()?.toIntOrNull() ?: 0

        println("¿Está seguro que desea realizar la recarga? (S/N)")
        val confirmacion = readLine()?.toUpperCase()

        if (confirmacion == "S") {
            saldoDis += valorRecarga
            println("Recarga exitosa. Saldo disponible: $saldoDis")
        } else {
            println("Recarga cancelada.")
        }
    }
}

fun main() {
    val nequi = Nequi()
    nequi.iniciarSesion()
}