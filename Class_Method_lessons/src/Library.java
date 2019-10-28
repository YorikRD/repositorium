import java.util.Arrays;

public class Library {

    private Book[] books = new Book[10];
    // В библиотеку можно добавить одну книгу
//    private void addBooks( Book newBooks) {

    //    }
    public void addBook(Book newBook) { // только одну книгу
        for (int i = 0; i < this.books.length; i++) {
            if (this.books[i] == null) {
                this.books[i] = newBook;
                System.out.println(this.books[i]);
                return;  // return
            }
            System.out.println("Библиотека полностью заполнена");
        }
    }

    public void addBook(Book... newBooks) {
        int freeSp = 0;
        for (int i = 0; i < this.books.length; i++) {
            if (this.books[i] == null) {
                freeSp = freeSp + 1;
                System.out.println(freeSp);
            }
        }
            System.out.println(freeSp);
            if (newBooks.length > freeSp) {
                System.out.println("К сожалению в библиотеке не хватает места для добавления " + (newBooks.length - freeSp) + " Книг");
                return;
            }
               for (int i = 0; i < this.books.length; i++) {
//            System.out.println(this.books.length);

            if (this.books[i] == null) {
                System.arraycopy(newBooks, 0, this.books,
                        i, newBooks.length);
                break;
            }
        }
    }

    public  boolean checkByTitle(String title) {
        System.out.println(this.books.length);
        for (int i = 0; i <= this.books.length; i++) {//
            Book forSurch = new Book();
            forSurch = this.books[i];
            if (this.books[i] == null) {
                break;
            }
            if (forSurch.getTitle().equals(title)) {
                System.out.println("Step");
                System.out.println("Книга есть в каталоге библиотеки");
                System.out.println(forSurch);
                return true;
            }
        }
        System.out.println("Книга в каталоге библиотеки отсутсвует");
        return false;
    }

    public boolean takeHomeBytitle(String title) {
        for (int i = 0; i <= this.books.length; i++) {
            if (this.books[i] == null) {
                System.out.println(title + " - Книга с таким названием в библиотеке остуствует");
                break;
            }
            Book forTakinghome = new Book();
            forTakinghome = books[i];
            if (forTakinghome.getTitle().equals(title)) {
                if (forTakinghome.isIsforHome()) {
                    System.out.println(forTakinghome.getTitle() + " - Книга доступна для взятия домой");
                    if (forTakinghome.isAvaileble()) {
                        System.out.println(forTakinghome.getTitle() + " - И вы получаете её прямо сейчас");
                        books[i].setAvaileble(false);
                        return true;
                    } else System.out.println(forTakinghome.getTitle() + " - К сожалению книга уже на руках");
                    return false;
                } else if (!forTakinghome.isIsforHome()) {
                    System.out.println(forTakinghome.getTitle() + " - К сожаление книга доступна только в читальном зале");
                    return false;
                }
            }
        } return false;
    }

    public boolean readhearByTitle(String title) {
        for (int i = 0; i <= this.books.length; i++) {
            if (this.books[i] == null) {
                System.out.println(title + " - Книга с таким названием в библиотеке остуствует");
                break;
            }
            if (books[i].getTitle().equals(title)) {
                if (books[i].isAvaileble()) {
                    System.out.println(books[i].getTitle() + " - доступная в читальном зале. И вы получаете её прямо сейчас");
                    books[i].setAvaileble(false);
                    return true;
                } else
                    System.out.println(books[i].getTitle() + " - К сожалению книга уже на руках, вы можете поискать её в читальном зале");
                return false;
            }
        } return false;
    }

    public void returnBookByTitle(String title) {
        for (int i = 0; i <= this.books.length; i++) {
            if (this.books[i] == null) {
                System.out.println(title + " - Книга с таким названием в библиотеке не значится желаете добавить новую?");
                break;
            }
            if (books[i].getTitle().equals(title)) {
                if (!books[i].isAvaileble()) {
                    System.out.println(books[i].getTitle() + " Благодарим за возврат книни");
                    books[i].setAvaileble(true);
                    return;
                }
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
