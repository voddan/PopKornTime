package popKornTime

import javafx.application.*
import javafx.fxml.*
import javafx.scene.*
import javafx.scene.layout.*
import javafx.stage.*
import tornadofx.*

/*
* https://popcorntime-online.io/
*
* https://www.themoviedb.org/
*
* https://github.com/Omertron/api-themoviedb/
* https://github.com/holgerbrandl/themoviedbapi/
**/

class Main : App() {
    override val primaryView = MainScreen::class

    companion object {
        @JvmStatic fun main(args: Array<String>) {
            Application.launch(Main::class.java, *args)
        }
    }
}

