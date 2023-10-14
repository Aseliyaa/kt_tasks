
import java.util.Scanner

fun main(args: Array<String>) {
    val scan = Scanner(System.`in`)
    val triangle = Triangle()
    triangle.enterPoints()
    triangle.print()
    println("Perimeter is: ${triangle.getPerimeter()}")
    println("Area is: ${(triangle.getArea())}")
    println("Enter the degrees value to rotate:")
    val deg = scan.nextDouble()
    println("The coordinates after rotation:")
    triangle.rotate(deg)
    triangle.print()

}