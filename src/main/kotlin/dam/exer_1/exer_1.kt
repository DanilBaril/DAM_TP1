package org.example.dam.exer_1

fun main() {
    println("a) IntArray constructor")
    ex1a()

    println("b) Range and map()")
    ex1b()

    println("c) Array with constructor")
    ex1c()
}

fun ex1a() {
    val perfsqrs = IntArray(50) {(it+1) * (it+1)}
    println(perfsqrs.toList())
}

fun ex1b() {
    val perfsqrs = (1..50).map {it * it}
    println(perfsqrs)
}

fun ex1c() {
    val perfsqrs = Array(50) {(it+1) * (it+1)}
    println(perfsqrs.toList())
}