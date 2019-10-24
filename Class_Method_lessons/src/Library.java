import java.util.Arrays;

public class Library {

    private Book[] books = new Book[10];
    // В библиотеку можно добавить одну книгу
//    private void addBooks( Book newBooks) {

    //    }
    public void addBook (Book newBook) { // только одну книгу
        for (int i =0; i <this.books.length; i++){
            if (this.books[i] ==null){
                this.books[i] = newBook;
                System.out.println(this.books[i]);
                return;  // return
            }
        }
    }
    public void addBook(Book ...newBooks) {
        for (int i = 0; i < this.books.length; i++) {
            if (this.books[i] == null) {
                System.arraycopy(newBooks, 0, this.books,
                        i, newBooks.length);
                break;
            }
        }
    }
    public Book[] getBooks() {
        return books;
    }

    public void setBooks(Book[] books) {
        this.books = books;
    }

    @Override
    public String toString() {
        return "Library{" +
                "books=" + Arrays.toString(books) +
                '}';
    }
}
