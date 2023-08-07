package com.yssierra.fundamentoskotlin.Reto2


class Album(
    val cantidadCanciones: Int,
    val tipoMusica: String
) {
    class Cancion(
        val titulo: String,
        val artista: String,
        val año: Int,
        var reproducciones: Int
    )

    val canciones = mutableListOf<Cancion>()

    fun reproducirCancion(Cancion: Int) {
        if (Cancion in 0 until canciones.size) {
            val cancion = canciones[Cancion]
            cancion.reproducciones++
            println("Reproduciendo: ${cancion.titulo}")
        } else {
            println("Índice de canción inválido.")
        }
    }


    fun mostrarCancionMasPopular() {
        var cancionMasPopular: Cancion? = null

        for (cancion in canciones) {
            if (cancionMasPopular == null || cancion.reproducciones > (cancionMasPopular.reproducciones ?: 0)) {
                cancionMasPopular = cancion
            }
        }

        if (cancionMasPopular != null) {
            println("La canción más popular del álbum es: ${cancionMasPopular.titulo}")
        } else {
            println("No se han reproducido canciones aún.")
        }
    }

    fun evaluarPopularidadCanciones() {
        println("Evaluación de popularidad de canciones:")
        for (cancion in canciones) {
            val popularidad = if (cancion.reproducciones < 5) "poco popular" else "más popular"
            println("- Canción: ${cancion.titulo} / Popularidad: $popularidad / Reproducciones: ${cancion.reproducciones}")
        }
    }

    fun mostrarCanciones() {
        println("Canciones del álbum:")
        for (i in 1..canciones.size) {
            val cancion = canciones[i - 1]
            println("Canción $i: ${cancion.titulo} - ${cancion.artista} (${cancion.año}) - Reproducciones: ${cancion.reproducciones}")
        }
    }
}

fun main() {

        println("Cuantas canciones tiene el album?")
        val cantidadCanciones = readLine()?.toIntOrNull() ?: 0
        println("Que tipo de música tiene este álbum?")
        val tipoMusica = readLine() ?: ""

        val album = Album(cantidadCanciones, tipoMusica)

        for (i in 1..cantidadCanciones) {
            println("Canción $i:")
            println("Título:")
            val titulo = readLine() ?: ""
            println("Artista:")
            val artista = readLine() ?: ""
            println("Año de publicación:")
            val año = readLine()?.toIntOrNull() ?: 0
            album.canciones.add(Album.Cancion(titulo, artista, año, 0))
        }

        println("Álbum creado")
        album.mostrarCanciones()

        println(" Reproducir canciones ")
        while (true) {
            println("Ingrese el número de la canción a reproducir (1 - ${album.canciones.size}), o cualquier otro valor para salir:")
            val opcion = readLine()?.toIntOrNull() ?: 0

            if (opcion > 0 && opcion <= album.canciones.size) {
                album.reproducirCancion(opcion - 1)
            } else {
                println("Saliendo del reproductor.")
                break
            }
        }

        album.mostrarCancionMasPopular()
        album.evaluarPopularidadCanciones()
    }
