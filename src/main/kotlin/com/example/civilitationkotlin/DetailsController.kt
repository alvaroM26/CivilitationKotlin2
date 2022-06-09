package com.example.civilitationkotlin

import javafx.fxml.FXML
import javafx.scene.control.Button
import javafx.scene.control.Label
import javafx.scene.image.Image
import javafx.scene.image.ImageView
import javafx.scene.layout.AnchorPane
import java.io.File

class DetailsController {

    var mapaController = MapaController()
    var terreno: Terreno? = null

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

    @FXML
    private lateinit var btCurar: Button

    @FXML
    private lateinit var imgSaquear: ImageView

    @FXML
    private lateinit var imgConquistar: ImageView

    @FXML
    private lateinit var imgMina: ImageView

    @FXML
    private lateinit var imgGranja: ImageView

    @FXML
    private lateinit var imaPerso: ImageView

    @FXML
    private lateinit var estado: Label

    fun enviarTerreno(terreno: Terreno) {

        this.terreno = terreno

        nombre.text = "El terreno seleccionado es: " + terreno.nombre
        andar.text = "¿El terreno puede ser transitable? " + terreno.sePuedeAndarSobreEl.toString()
        fondo.style = terreno.fondoPaisaje

        val f = File(terreno.imagen)
        imagen.image = Image(f.toURI().toURL().toString())

        val f2 = File (terreno.unidad?.imagen)
        imaPerso.image = Image(f2.toURI().toURL().toString())

        btCurar.isVisible = terreno.unidad?.seleccionada == true

        comprobacionDeEstado()

    }

    fun comprobacionDeEstado() {

        if (terreno?.nombre == "Ciudad") {
            bt1.isVisible = true
            bt2.isVisible = true
            bt3.isVisible = false
            bt4.isVisible = false
        }

        if (terreno?.nombre == "Colina") {
            bt1.isVisible = false
            bt2.isVisible = false
            bt3.isVisible = true
            bt4.isVisible = false
        }

        if (terreno?.nombre == "Llanura") {
            bt1.isVisible = false
            bt2.isVisible = false
            bt3.isVisible = false
            bt4.isVisible = true
        }

        if (terreno?.nombre == "Bosque") {
            bt1.isVisible = false
            bt2.isVisible = false
            bt3.isVisible = false
            bt4.isVisible = false
        }

        if (terreno?.nombre == "Mar") {
            bt1.isVisible = false
            bt2.isVisible = false
            bt3.isVisible = false
            bt4.isVisible = false
        }

        if (terreno?.nombre == "Montana") {
            bt1.isVisible = false
            bt2.isVisible = false
            bt3.isVisible = false
            bt4.isVisible = false
        }

        if (terreno?.nombre == "Terreno desconocido") {
            bt1.isVisible = false
            bt2.isVisible = false
            bt3.isVisible = false
            bt4.isVisible = false
        }

    }

    @FXML
    fun cambiarEstado1() {
        terreno?.estado = "Saqueado"
        estado.text = "El estado del lugar es " + terreno?.estado
        mapaController.reconstruir()
        imgSaquear.isVisible = true
        imgConquistar.isVisible = false
        imgMina.isVisible = false
        imgGranja.isVisible = false
    }

    @FXML
    fun cambiarEstado2() {
        terreno?.estado = "Conquistado"
        estado.text = "El estado del lugar es " + terreno?.estado
        mapaController.reconstruir()
        imgConquistar.isVisible = true
        imgSaquear.isVisible = false
        imgMina.isVisible = false
        imgGranja.isVisible = false
    }

    @FXML
    fun cambiarEstado3() {
        terreno?.estado = "Con Mina"
        estado.text = "El estado del lugar es " + terreno?.estado
        mapaController.reconstruir()
        imgConquistar.isVisible = false
        imgSaquear.isVisible = false
        imgMina.isVisible = true
        imgGranja.isVisible = false
    }

    @FXML
    fun cambiarEstado4() {
        terreno?.estado = "Con Granja"
        estado.text = "El estado del lugar es " + terreno?.estado
        mapaController.reconstruir()
        imgConquistar.isVisible = false
        imgSaquear.isVisible = false
        imgMina.isVisible = false
        imgGranja.isVisible = true
    }

    fun enviarDatos(mapaController: MapaController) {
        this.mapaController = mapaController
    }

    fun imagenesOcultas() {

        val f = File("src\\main\\resources\\images\\ic_corona.png")
        imgConquistar.image = Image(f.toURI().toURL().toString())
        imgConquistar.isVisible = false

        val f2 = File("src\\main\\resources\\images\\ic_granja.png")
        imgGranja.image = Image(f2.toURI().toURL().toString())
        imgGranja.isVisible = false

        val f3 = File("src\\main\\resources\\images\\ic_mina.png")
        imgMina.image = Image(f3.toURI().toURL().toString())
        imgMina.isVisible = false

        val f4 = File("src\\main\\resources\\images\\ic_saqueo.png")
        imgSaquear.image = Image(f4.toURI().toURL().toString())
        imgSaquear.isVisible = false

    }

}