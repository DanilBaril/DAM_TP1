package org.example.dam.virtual_library

class DigitalBook(
    title: String,
    author: String,
    publicationYear: Int,
    availableCopies: Int,
    val fileSize: Double,
    val format: String
) : Book(title, author, publicationYear, availableCopies) {}