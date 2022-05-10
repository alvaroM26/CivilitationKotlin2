package com.example.civilitationkotlin

import java.text.NumberFormat.Style

data class Terreno(val nombre : String, val imagen : String, val sePuedeAndarSobreEl : Boolean, val fondoPaisaje : String) {

    companion object {
        fun crearLLanura(): Terreno {
            return Terreno("Llanura", "src\\main\\resources\\images\\llanura.png", true, "-fx-background-color: #00D0FE;" )
        }

        fun crearColina(): Terreno {
            return Terreno("Colina", "src\\main\\resources\\images\\colina.png", true,"-fx-background-color: #91C7A2;")
        }

        fun crearBosque(): Terreno {
            return Terreno("Bosque", "src\\main\\resources\\images\\bosque.png", true,"-fx-background-color: #AB4E01;")
        }

        fun crearCiudad(): Terreno {
            return Terreno("Ciudad", "src\\main\\resources\\images\\pueblo.png", true,"-fx-background-color: #906548;")
        }

        fun crearMar(): Terreno {
            return Terreno("Mar", "src\\main\\resources\\images\\mar.png", false,"-fx-background-color: #6295D3;")
        }

        fun crearMontana(): Terreno {
            return Terreno("Montana", "src\\main\\resources\\images\\montana.png", false,"-fx-background-color: #5A7482;")
        }

        fun crearDesconocido(): Terreno {
            return Terreno("Terreno desconocido", "src\\main\\resources\\images\\desconocido.png", false,"-fx-background-color: #B4AAA2;")
        }
    }
}