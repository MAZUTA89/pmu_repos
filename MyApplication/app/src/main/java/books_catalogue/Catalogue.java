package books_catalogue;

import java.util.ArrayList;
import java.util.List;

public class Catalogue {
    ArrayList<Book> books;

    public Catalogue()
    {
        books = new ArrayList<>();
    }

    public ArrayList<Book> getBooks() {
        return books;
    }

    public void Add(Book book)
    {
        books.add(book);
    }
    public void Delete(Book book)
    {
        books.add(book);
    }

    public ArrayList<Book> findAuthor(String author)
    {
        ArrayList<Book> list = new ArrayList<>();
        for (Book book:
                books) {
            String str = book.getAuthor();
            if(str.equals(author))
            {
                list.add(book);
            }
        }
        return list;
    }
    public ArrayList<Book> findPublisher(String publisher)
    {
        ArrayList<Book> list = new ArrayList<>();

        for (Book book:
                books) {
            String str = book.getPublisher();
            if(str.equals(publisher))
            {
                list.add(book);
            }
        }
        return list;
    }

    public ArrayList<Book> findAfterYear(int year)
    {
        ArrayList<Book> list = new ArrayList<>();
        for (Book book:
                books) {
            if(book.getYear() >= year)
            {
                list.add(book);
            }
        }
        return list;
    }
}
