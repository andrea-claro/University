/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package book_client;

import java.util.List;
import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;

/**
 *
 * @author andrea-claro
 */
public class BookStdClient {
    
    public static void main(String[] args) throws NamingException{
        
        Context ctx = new InitialContext();
        
        book_server.BookEJBRemote bookEJB = (book_server.BookEJBRemote) 
                ctx.lookup("java:global/ArchivioBook/BookEJB!book_server.BookEJBRemote");
        List<book_server.Book> books = bookEJB.findAll();
        for(book_server.Book b: books){
            System.out.println(b.toString()); 
        }
    }
}
