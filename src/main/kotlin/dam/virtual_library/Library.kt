package org.example.dam.virtual_library

class Library(val name: String) {
    private val books = mutableListOf<Book>()

    fun addBook(book: Book) {
        books.add(book)
    }

    fun borrowBook(title: String) {
        val book = books.find { it.title == title }
        if (book == null) {
            println("Sorry, '$title' was not found in the library.")
            return
        }
        if (book.availableCopies == 0) {
            println("Sorry, '$title' has no available copies.")
            return
        }
        book.availableCopies--
        println("Successfully borrowed '$title'. Copies remaining: ${book.availableCopies}")
    }

    fun returnBook(title: String) {
        val book = books.find { it.title == title }
        if (book == null) {
            println("Sorry, '$title' was not found in the library.")
            return
        }
        book.availableCopies++
        println("Book '$title' returned successfully. Copies available: ${book.availableCopies}")
    }

    fun showBooks() {
        println("--- Library Catalog ---")
        for (book in books) {
            println(book)
        }
    }

    fun searchByAuthor(author: String) {
        println("Books by $author:")
        val results = books.filter { it.author == author }
        if (results.isEmpty()) {
            println("No books found by $author.")
            return
        }
        for (book in results) {
            println("- ${book.title} (${book.publicationYear}, ${book.availableCopies} copy available)")
        }
    }

}