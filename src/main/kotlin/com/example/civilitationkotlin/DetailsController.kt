package com.example.civilitationkotlin

import javafx.fxml.FXML
import javafx.scene.control.Button
import javafx.scene.control.Label
import javafx.scene.image.Image
import javafx.scene.image.ImageView
import javafx.scene.input.MouseEvent
import javafx.scene.layout.AnchorPane
import java.io.File

class DetailsController {

    var mapaController = MapaController()
    var terreno : Terreno? = null

    @FXML
    private lateinit var nombre: Label
    @FXML
    private lateinit var imagen: ImageView
    @FXML
    private lateinit var andar: Label
    @FXML
    private lateinit var fondo: AnchorPane
    @FXML
    private lateinit var bt1: Button
    @FXML
    private lateinit var bt2: Button
    @FXML
    private lateinit var bt3: Button
    @FXML
    private lateinit var bt4: Button


    fun enviarTerreno(terreno: Terreno) {

        nombre.text = "El terreno seleccionado es: "+ terreno.nombre
        andar.text = terreno.sePuedeAndarSobreEl.toString()
        fondo.style = terreno.fondoPaisaje
        this.terreno = terreno

        val f = File(terreno.imagen)
        imagen.image = Image(f.toURI().toURL().toString())

        comprobacionDeEstado()

    }

    fun comprobacionDeEstado(){

        if (terreno?.nombre == "Ciudad"){
            bt1.isVisible = true
            bt2.isVisible = true
            bt3.isVisible = false
            bt4.isVisible = false
        }

        if (terreno?.nombre == "Colina"){
            bt1.isVisible = false
            bt2.isVisible = false
            bt3.isVisible = true
            bt4.isVisible = false
        }

        if (terreno?.nombre == "Llanura"){
            bt1.isVisible = false
            bt2.isVisible = false
            bt3.isVisible = false
            bt4.isVisible = true
        }

        if (terreno?.nombre == "Bosque"){
            bt1.isVisible = false
            bt2.isVisible = false
            bt3.isVisible = false
            bt4.isVisible = false
        }

        if (terreno?.nombre == "Mar"){
            bt1.isVisible = false
            bt2.isVisible = false
            bt3.isVisible = false
            bt4.isVisible = false
        }

        if (terreno?.nombre == "Montana"){
            bt1.isVisible = false
            bt2.isVisible = false
            bt3.isVisible = false
            bt4.isVisible = false
        }

        if (terreno?.nombre == "Terreno desconocido"){
            bt1.isVisible = false
            bt2.isVisible = false
            bt3.isVisible = false
            bt4.isVisible = false
        }

    }
    @FXML
    fun cambiarEstado1() {

        terreno?.estado = "Saqueado"

    }
    @FXML
    fun cambiarEstado2() {
        terreno?.estado = "Conquistado"
    }
    @FXML
    fun cambiarEstado3() {
        terreno?.estado = "Con Mina"
    }
    @FXML
    fun cambiarEstado4() {
        terreno?.estado = "Con Granja"
    }

    fun enviarDatos(mapaController: MapaController){
        this.mapaController=mapaController
    }

}