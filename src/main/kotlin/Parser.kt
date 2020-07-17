import com.github.doyaaaaaken.kotlincsv.dsl.csvReader
import java.io.File

object Parser {
    private val file = File("src/main/resources/test.csv")

    val rows = csvReader().readAll(file)
}