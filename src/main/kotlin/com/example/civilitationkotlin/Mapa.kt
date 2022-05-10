package com.example.civilitationkotlin

import kotlin.random.Random

class Mapa {

    class PosicionActual(var fila: Int, var columna: Int)

    private var posicionActual = PosicionActual(0, 0)

    var matriz = MutableList(Configuracion.columnasMapa) {

        MutableList(Configuracion.filasMapa) {

            when (Random.nextInt(0,100)) {
                in 0..24 -> Terreno.crearLLanura()
                in 25..44 -> Terreno.crearColina()
                in 45..64 -> Terreno.crearBosque()
                in 65..69 -> Terreno.crearCiudad()
                in 70..89 -> Terreno.crearMar()
                in 90..100 -> Terreno.crearMontana()
                else -> {
                    Terreno.crearDesconocido()
                }

            }

        }

    }

    fun moverArriba() {
        posicionActual.fila--
    }

    fun moverAbajo() {
        posicionActual.fila++
    }

    fun moverIzquierda() {
        posicionActual.columna--
    }

    fun moverDerecha() {
        posicionActual.columna++
    }

    fun obtenerMapaPorPosiciones( fila : Int = posicionActual.fila,  columna : Int =posicionActual.columna, vision: Int = Configuracion.vision) : MutableList<MutableList<Terreno>>{
        posicionActual.fila = fila
        posicionActual.columna = columna

        val matriz2 = MutableList(Configuracion.columnasCampoVision) {
            MutableList(Configuracion.filasCampoVision) {
                Terreno.crearDesconocido()
            }
        }

        for ((columnaActual, columnaActualMapaGrande) in ((columna - vision)..(columna + vision)).withIndex()) {

            for ((filaActual, filaActualMapaGrande) in ((fila - vision) .. (fila + vision)).withIndex()) {

                if (!(columnaActualMapaGrande < 0 || filaActualMapaGrande < 0 || columnaActualMapaGrande >= Configuracion.columnasMapa || filaActualMapaGrande >= Configuracion.filasMapa)){
                    matriz2[columnaActual][filaActual] = matriz[columnaActualMapaGrande][filaActualMapaGrande]
                }
            }
        }

        println(matriz2)
        return matriz2
    }

    fun obtenerFilaActual(): Int {
        return posicionActual.fila
    }

    fun obtenerColumnaActual(): Int {
        return posicionActual.columna
    }

}