#!/usr/bin/env kotlin

    //Exercise 1: Modeling the "Web Response" (Data Classes)
data class WebResponse(
    val statusCode: Int,
    val statusMessage: String,
    val body: String?  //(A nullable string representing the JSON or HTML content).
)

    // Exercise 2: The "Status Code Interpreter" (When Expressions)
fun describeStatus(code: Int): String {
    return when(code) {
        in 200..299 ->"Success: The request was fulfilled."
        in 400..499 -> "Client Error:Check your URL or parameters."
        in 500..599 -> "Server Error: The Lehman Server is having trouble."
        else -> "Unknown status code."
    }
}

    // Exercise 3: Simple Request Router (Simulating Server Logic)
fun routeRequest(path: String, user: String?): String{
    return when(path) {

        "/home" -> "Welcome to the Lehman Homepage, ${user ?: "Guest"}!"
        "/grades" -> {
            if(user== null) {
                "Error: Unauthorized access to grades."
            } else {
                "Loading grades for $user..."
            }
        }
        else -> "404: Path $path not found."
    }
}


fun main() {

    // Exercise 1 Tests
    val successResponse = WebResponse(
        200,
        "OK",
        "<html>Welcome!</html>"
    )

    val notFoundResponse = WebResponse(
        404,
        "Not Found",
        null
    )

    println("Exercise 1 Output:")
    println(successResponse)
    println(notFoundResponse)

    println()

    // Exercise 2 Tests
    println("Exercise 2 Output:")
    println("201 -> " + describeStatus(201))
    println("404 -> " + describeStatus(404))
    println("503 -> " + describeStatus(503))

    println()

    // Exercise 3 Tests
    println("Exercise 3 Output:")
    println(routeRequest("/home", "Maria"))
    println(routeRequest("/home", null))

    println(routeRequest("/grades", "Carlos"))
    println(routeRequest("/grades", null))

    println(routeRequest("/profile", "Anna"))
}