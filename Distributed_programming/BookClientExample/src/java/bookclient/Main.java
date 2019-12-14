
package bookclient;

import bookejb.Book;
import bookejb.BookEJBRemote;
import java.util.List;
import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;


public class Main {
    
    public static void main(String[] args) throws NamingException{
        Context ctx;
        ctx = new InitialContext();
        BookEJBRemote bookEJB = (BookEJBRemote) ctx.lookup("java:global/BookEJBExample/BookEJB!bookejb.BookEJBRemote");
        List<Book> books = bookEJB.findBooks();
        books.forEach((aBook) -> {
            System.out.println("--- "+aBook);
        });
        Book book = new Book("The Hitchhiker’s Guide ..", 12.5F, "Science fiction by Douglas Adams.", "1-24561-799-0", 354, false);
        book = bookEJB.createBook(book);
        System.out.println("### Book created: "+book);
        book.setTitle("Schifoso");
        book = bookEJB.updateBook(book);
        System.out.println("### Book updated: "+book);
        bookEJB.deleteBook(book);
        System.out.println("### Book deleted");
    }
}
