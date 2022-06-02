package com.example.civilitationkotlin

import javafx.fxml.FXML
import javafx.fxml.FXMLLoader
import javafx.geometry.Pos
import javafx.scene.Scene
import javafx.scene.control.Label
import javafx.scene.image.Image
import javafx.scene.image.ImageView
import javafx.scene.layout.AnchorPane
import javafx.scene.layout.GridPane
import javafx.scene.layout.VBox
import javafx.stage.Stage
import java.io.File
import kotlin.random.Random

class MapaController {

    @FXML
    private lateinit var posi: Label
    @FXML
    private lateinit var psiciones: Label

    lateinit var map : GridPane

    var mapa = Mapa()
    var subMapa =  mapa.obtenerMapaPorPosiciones(2,5,Configuracion.vision)

    fun initialize() {
        iniciarGridPane()
        rellenarGirdPane(subMapa)
    }

    private fun iniciarGridPane() {

        for (columna in 0 until Configuracion.columnasCampoVision )

            for (fila in 0 until Configuracion.filasCampoVision) {

                val vBox = VBox()
                vBox.children.add(0, ImageView())
                vBox.children.add(1, ImageView())
                vBox.children.add(2, Label())
                map.add(vBox, columna, fila)

            }
        map.hgap= 5.0
        map.vgap = 5.0
    }

    private fun rellenarGirdPane(subMapa: MutableList<MutableList<Terreno>>) {

        var posicion = 0

        subMapa.forEach { terrenos ->

            terrenos.forEach {terreno2 ->

                val view = map.children[posicion]

                view as VBox
                var f2 = File("")

                val imageView = view.children[1] as ImageView
                val f = File(terreno2.imagen)

                val nombre = view.children[2] as Label

                val imageView2 = view.children[0] as ImageView
                terreno2.unidad?.let {
                    f2 = File(it.imagen)
                }

                if (terreno2.estado != ""){
                    nombre.text = terreno2.estado
                }else{
                    nombre.text = terreno2.nombre
                }

                nombre.maxWidth = 80.0
                nombre.style = terreno2.fondoPaisaje
                nombre.alignment = Pos.CENTER

                view.setOnMouseClicked {
                    posi.text = "El terreno es "+terreno2.nombre
                    abrirVentanaDetails(terreno2)
                }

                view.style = terreno2.fondoPaisaje

                imageView2.fitHeight = 30.0
                imageView2.fitWidth = 30.0
                imageView2.layoutY = 0.0
                imageView2.layoutX = 50.0
                imageView2.image = Image(f2.toURI().toURL().toString())

                imageView.fitHeight = 80.0
                imageView.fitWidth = 80.0
                imageView.image = Image(f.toURI().toURL().toString())

                posicion++
            }

            mostrarPosiconActual()
        }
    }

    fun moverArriba() {
        println("Arriba")
        mapa.moverArriba()
        rellenarGirdPane(mapa.obtenerMapaPorPosiciones())
        mostrarPosiconActual()
    }
    fun moverAbajo(){
        println("Abajo")
        mapa.moverAbajo()
        rellenarGirdPane(mapa.obtenerMapaPorPosiciones())
        mostrarPosiconActual()
    }
    fun moverDerecha(){
        println("Derecha")
        mapa.moverDerecha()
        rellenarGirdPane(mapa.obtenerMapaPorPosiciones())
        mostrarPosiconActual()
    }
    fun moverIzquierda(){
        println("Izquierda")
        mapa.moverIzquierda()
        rellenarGirdPane(mapa.obtenerMapaPorPosiciones())
        mostrarPosiconActual()
    }

    @FXML
    fun clickDeRestauracion() {
        rellenarGirdPane(mapa.obtenerMapaPorPosiciones(0,0, Configuracion.vision))
    }

    fun mostrarPosiconActual() {
        psiciones.text = "Posicion actual ( "+ mapa.obtenerColumnaActual() + "," +mapa.obtenerFilaActual() + ")"
    }

    fun reconstruir(){
        rellenarGirdPane(subMapa)
    }

    fun abrirVentanaDetails(terreno: Terreno){
        val stage = Stage()
        val loader = FXMLLoader(javaClass.getResource("details.fxml"))
        val root = loader.load<AnchorPane>()
        val scene = Scene(root,720.0,462.0)
        stage.scene = scene
        stage.show()
        val detailsController = loader.getController<DetailsController>()
        detailsController.enviarTerreno(terreno)
        detailsController.comprobacionDeEstado()
        detailsController.imagenesOcultas()
        detailsController.enviarDatos(this)
    }

}