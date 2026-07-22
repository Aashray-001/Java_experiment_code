class LibraryBook {

    final String isbn;    // Final variable
    String title;
    String author;
    double price;

    LibraryBook(String isbn, String title, String author, double price) {
        this.isbn = isbn;
        this.title = title;
        this.author = author;
        this.price = price;
    }

    void display() {
        System.out.println("ISBN   : " + isbn);
        System.out.println("Title  : " + title);
        System.out.println("Author : " + author);
        System.out.println("Price  : " + price);
    }

    public static void main(String[] args) {

        LibraryBook book = new LibraryBook(
                "978-81-123456-7",
                "alchamiest",
                "Paulo Coelo",
                599.0);

        book.display();

        // book.isbn = "12345"; // Error: Cannot change final variable
    }
}