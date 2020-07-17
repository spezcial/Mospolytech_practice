import com.github.doyaaaaaken.kotlincsv.dsl.*
import java.io.File

fun main() {
    val srcPath = "src/main/resources"
    val students = mutableListOf<Student>()
    val students2 = mutableListOf<Student>()

    val doc1 = csvReader().readAllWithHeader(File("$srcPath/test.csv")).filter { it["Фамилия"] != "" }.sortedBy { it["Фамилия"] }
    val doc2 = csvReader().readAllWithHeader(File("$srcPath/test2.csv")).filter { it["Фамилия"] != "" }.sortedBy { it["Фамилия"] }

    doc1.forEach {
        students.add(Student(surname = it["Фамилия"]!!, name = it["Имя"]!!, middlename = it["Отчество"]!!))
    }

    doc2.forEach {
        students2.add(Student(surname = it["Фамилия"]!!, name = it["Имя"]!!, middlename = it["Отчество"]!!))
    }

    val comed = mutableListOf<Student>()
    val loss = mutableListOf<Student>()

    students.forEach {
        if (!students2.contains(it)) {
            comed.add(it)
        }
    }

    students2.forEach {
        if (!students.contains(it)) {
            loss.add(it)
        }
    }

    println("Убывшие:")
    loss.forEach {
        println(it.toString())
    }
    println("\n")

    println("Прибывшие:")
    comed.forEach {
        println(it.toString())
    }

}

data class Student(val surname: String, val name: String, val middlename: String) {
    override fun toString(): String {
        return "$surname $name $middlename"
    }
}