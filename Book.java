/*Create a Java program by developing a user-define package named
Library that contains a class to store and display book details such as book
ID, title, author, and price. Import the package into the main program and
display the book information.*/

package Library;

public class Book {
    int book_id;
    String title;
    String author;
    float price;

    public Book(int book_id, String title, String author, float price) {
        this.book_id = book_id;
        this.title = title;
        this.author = author;
        this.price = price;
    }

    public void display() {
        System.out.println("Book ID = " + book_id);
        System.out.println("Title = " + title);
        System.out.println("Author = " + author);
        System.out.println("Price = " + price);
    }
}