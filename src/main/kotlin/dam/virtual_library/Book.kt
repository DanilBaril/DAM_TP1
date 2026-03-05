package org.example.dam.virtual_library

abstract class Book(
    val title: String,
    val author: String,
    private val _publicationYear: Int,
    availableCopies: Int
) {
    var availableCopies: Int = availableCopies
        set(value) {
            if (value < 0) return
            field = value
        }

    val publicationYear: String
        get() = when {
            _publicationYear < 1980 -> "Classic"
            _publicationYear <= 2010 -> "Modern"
            else -> "Contemporary"
        }

    init {
        println("Book '${title}' by ${author} has been added to the library.")
    }

    override fun toString(): String {
        return "Title: $title, Author: $author, Era: $publicationYear, Available: $availableCopies copies"
    }

    abstract fun getStorageInfo(): String
}