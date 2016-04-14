package popKornTime

import javafx.collections.*
import javafx.geometry.*
import javafx.scene.*
import javafx.scene.control.*
import javafx.scene.layout.*
import javafx.util.*
import org.controlsfx.control.*
import tornadofx.*
import java.time.*
import java.time.temporal.*

/**
 * Created by voddan on 13/04/16.
 */

data class Person(val id: Int, val name: String, val birthday: LocalDate) {
    val age = Period.between(birthday, LocalDate.now()).years

    override fun toString() = "[$name]"
}

class MainScreen() : View() {


    val table = TableView<Person>().apply {
        items = persons
        column("ID", Person::id)
        column("Name", Person::name)
        column("Birthday", Person::birthday)
        column("Age", Person::age)
    }

    val list = ListView<Person>().apply {
        items = persons
    }

    val gridView = GridView<Person>().apply {
        items = persons
    }

    val tile = TilePane().apply {
        children.addAll(personLabels.toList())
    }

    val scrollTile = ScrollPane().apply {
        isFitToWidth = true
        content = TilePane().apply {
            children.addAll(personLabels.toList())
        }
    }

    override val root = VBox().apply {
        tabpane {
            this.tabClosingPolicy = TabPane.TabClosingPolicy.UNAVAILABLE
            tab(" t1 ", table)
            tab(" t2 ", list)
            tab(" t3 ", gridView)
            tab(" t4 ", tile)
            tab(" t5 ", scrollTile)
        }
    }

    init {
        //        persons.sortBy { it.age }
        personLabels.sorted()
    }
}


val persons = FXCollections.observableArrayList<Person>(
        Person(1,"Samantha Stuart",LocalDate.of(1981,12,4)),
        Person(2,"Tom Marks",LocalDate.of(2001,1,23)),
        Person(3,"Stuart Gills",LocalDate.of(1989,5,23)),
        Person(4,"Nicole Williams",LocalDate.of(1998,8,11))
).apply {
    addAll(this.toList())
    addAll(this.toList())
}

val personLabels = FXCollections.observableArrayList(persons.map {Label("$it")})
