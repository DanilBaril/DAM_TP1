package org.example.dam.exer_2

fun main() {
    var n1: Int?
    do{
        println("Primeiro numero:")
        n1 = readln().toIntOrNull()
    }while (n1 == null)

    var n2: Int?
    do{
        println("Segundo numero:")
        n2 = readln().toIntOrNull()
    }while (n2 == null)

    val ops = setOf("+", "-", "*", "/", "and", "or", "not", "shl", "shr")
    var op: String
    do{
        println("Operaçao (+, -, *, /, and, or, not, shl, shr):")
        op = readln()
    }while (op !in ops)

    try {
        val r: Int = when (op) {
            "+" -> n1 + n2
            "-" -> n1 - n2
            "*" -> n1 * n2
            "/" -> {
                if (n2 == 0) throw Exception("Divisao por 0")
                n1 / n2
            }
            "and" -> n1 and n2
            "or" -> n1 or n2
            "not" -> n1.inv()
            "shl" -> n1 shl n2
            "shr" -> n1 shr n2

            else -> throw Exception("Operador desconhecido")
        }

        println("Resultado em decimal: $r")
        println("Resultado em hexadecimal: ${r.toString(16)}")
        println("Resultado em booleano: ${r != 0}")

    }catch (e: Exception){
        println("Erro: ${e.message}")}
}