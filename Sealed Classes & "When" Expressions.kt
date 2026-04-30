sealed class EnrollmentStatus

data class Success(val courseCode:String) : EnrollmentStatus()
data class Error(val message: String):EnrollmentStatus()
object Loading : EnrollmentStatus()
//object Isuccess : EnrollmentStatus()

fun printStatus(status: EnrollmentStatus) {
    when (status) {
        //is Isuccess ->println("S
        is Success -> println("Enrolled in: ${status.courseCode}")
        is Error -> println("Error:${status.message}")
        is Loading -> println("Loading...")
    }
}

fun main() {

    val successStatus = Success("CMP269")
    val errorStatus = Error("Course is full")

    printStatus(successStatus)
    printStatus(errorStatus)
}
