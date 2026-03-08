package org.example.dam.virtual_library

fun main() {
    val library = Library("Central Library")

    val digitalBook = DigitalBook(
        "Kotlin in Action",
        "Dmitry Jemerov",
        2017,
        5,
        4.5,
        "PDF"
    )

    val physicalBook = PhysicalBook(
        "Clean Code",
        "Robert C. Martin",
        2008,
        3,
        650,
        true
    )

    val classicBook = PhysicalBook(
        "1984",
        "George Orwell",
        1949,
        2,
        400,
        false
    )

    library.addBook(digitalBook)
    library.addBook(physicalBook)
    library.addBook(classicBook)

    library.showBooks()

    println("\n--- Borrowing Books ---")
    library.borrowBook("Clean Code")
    library.borrowBook("1984")
    library.borrowBook("1984")
    library.borrowBook("1984")

    println("\n--- Returning Books ---")
    library.returnBook("1984")

    println("\n--- Search by Author ---")
    library.searchByAuthor("George Orwell")

    println("\nTotal books created: ${Library.getTotalBooksCreated()}")

    val member = LibraryMember("Benjamin Salgado", "M001")
    member.borrowedBooks.add("Clean Code")
    member.borrowedBooks.add("1984")
    println("\n--- Library Member ---")
    println("Name: ${member.name}, ID: ${member.membershipId}, Borrowed: ${member.borrowedBooks}")
}