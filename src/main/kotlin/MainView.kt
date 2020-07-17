import javafx.collections.ObservableList
import javafx.scene.Parent
import javafx.scene.layout.BorderPane
import tornadofx.*

class MainView : View("My View") {
    override val root = borderpane {
        left = vbox {
            button("REFRESH")
            button("COMMIT")
        }

        center = tableview<Student> {
            items = listOf(
                Student("Joe Thompson", "33", "13"),
                Student("Sam Smith", "29", "123"),
                Student("Nancy Reams", "41", "!@#")
            ).asObservable()
        }
    }
}