package com.example.civilitationkotlin

data class Unidad(val nombre : String , val imagen: String, var vida: Int, var seleccionada : Boolean = false) {

    companion object {
        fun crearCaballero(): Unidad {
            return Unidad("Caballero", "src\\main\\resources\\images\\Warrior.png", 100,)
        }

        fun crearGuerrero(): Unidad {
            return Unidad("Guerrero", "src\\main\\resources\\images\\Knight.png", 100,)
        }

        fun crearLancero(): Unidad {
            return Unidad("Lancero", "src\\main\\resources\\images\\Lancer.png", 100,)
        }

        fun crearVacio(): Unidad {
            return Unidad("", "", 0,false)
        }
    }
}