import java.util.Scanner
import kotlin.math.cos
import kotlin.math.pow
import kotlin.math.sin
import kotlin.math.sqrt

class Triangle(private var A: Point, private var B: Point, private var C: Point) {
    data class Point (var x: Double = 0.0, var y: Double = 0.0) {
        fun isCollinear(A: Point, B: Point): Boolean {
            return (x - A.x) * (A.y - B.y) == (A.x - B.x) * (y - A.y)
        }
    }

    constructor(): this(Point(), Point(), Point())
    fun getA(): Point = Point(A.x, A.y)
    fun getC(): Point = Point(C.x, C.y)
    fun getB(): Point = Point(B.x, B.y)
    fun enterPoints() {
        val scan = Scanner(System.`in`)
        val newA: Point
        val newB: Point
        val newC: Point

        println("Enter the coordinates for point A (x, y):")
        val aCoordinates = scan.nextLine().split(" ")
        newA = Point(aCoordinates[0].toDouble(), aCoordinates[1].toDouble())

        println("Enter the coordinates for point B (x, y):")
        val bCoordinates = scan.nextLine().split(" ")
        newB = Point(bCoordinates[0].toDouble(), bCoordinates[1].toDouble())

        println("Enter the coordinates for point C (x, y):")
        val cCoordinates = scan.nextLine().split(" ")
        newC = Point(cCoordinates[0].toDouble(), cCoordinates[1].toDouble())

        if (newC.isCollinear(newA, newB)) {
            throw Exception("The points are collinear")
        }

        A.x = newA.x
        A.y = newA.y
        B.x = newB.x
        B.y = newB.y
        C.x = newC.x
        C.y = newC.y
    }

    fun print(){
        println("Triangle: A(${A.x}, ${A.y}), B(${B.x}, ${B.y}), C(${C.x}, ${C.y})")
    }

    private fun getSides(): DoubleArray {
        val sides = DoubleArray(3)
        sides[0] = sqrt((A.x - B.x).pow(2) + (A.y - B.y).pow(2))
        sides[1] = sqrt((A.x - C.x).pow(2) + (A.y - C.y).pow(2))
        sides[2] = sqrt((C.x - B.x).pow(2) + (C.y - B.y).pow(2))

        return sides
    }
    fun getPerimeter(): Double {
        val sides = getSides()
        val a = sides[0]
        val b = sides[1]
        val c = sides[2]

        return a + b + c
    }

    fun getArea(): Double {
        val p = getPerimeter() / 2
        val sides = getSides()
        val a = sides[0]
        val b = sides[1]
        val c = sides[2]

        return sqrt(p*(p-a)*(p-b)*(p-c))
    }

    fun rotate(deg: Double) {
        val rad: Double
        val cos: Double
        val sin: Double
        if(deg == 90.0) {
            cos = 0.0;
            sin = 1.0;
        } else {
            rad = deg*Math.PI/180;
            cos = cos(rad);
            sin = sin(rad);
        }
        val newAx = A.x*cos-A.y*sin;
        val newAy = A.x*sin-A.y*cos;
        val newBx = B.x*cos-B.y*sin;
        val newBy = B.x*sin-B.y*cos;
        val newCx = C.x*cos-C.y*sin;
        val newCy = C.x*sin-C.y*cos;

        A.x = newAx;
        A.y = newAy;
        B.x = newBx;
        B.y = newBy;
        C.x = newCx;
        C.y = newCy;
    }
}