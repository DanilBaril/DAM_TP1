package org.example.dam.exer_3

fun main() {
    val alturaIni = 100.0

    val bounces = generateSequence(alturaIni) {it * 0.6}
        .drop(1) // Remover o primeiro valor (100)
        .takeWhile {it >= 1.0} // Sequencia para qnd chega a valor menor que 1
        .take(15) // Limita a 15 valores
        .toList() // Meter a lista pa poder iterar

    println("Alturas:")
    for (i in bounces.indices) {println("Bounce ${i + 1}: ${(bounces[i])} metros")}
}