package com.example.civilitationkotlin

import javafx.fxml.FXML
import javafx.scene.control.Label
import javafx.scene.image.Image
import javafx.scene.image.ImageView
import javafx.scene.layout.AnchorPane
import java.io.File

class DetailsController {

    @FXML
    private lateinit var nombre: Label
    @FXML
    private lateinit var imagen: ImageView
    @FXML
    private lateinit var andar: Label
    @FXML
    private lateinit var fondo: AnchorPane


    fun enviarTerreno(terreno: Terreno) {

        nombre.text = "El terreno seleccionado es: "+ terreno.nombre
        andar.text = terreno.sePuedeAndarSobreEl.toString()
        fondo.style = terreno.fondoPaisaje

        val f = File(terreno.imagen)
        imagen.image = Image(f.toURI().toURL().toString())

    }
}