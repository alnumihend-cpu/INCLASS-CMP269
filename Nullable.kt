fun main() {

    val studentName: String = "Hend"
    val middleName: String? = null
    val displayMiddleName = middleName ?: "No Middle Name"

    println("Welcome, $studentName $displayMiddleName!")
}