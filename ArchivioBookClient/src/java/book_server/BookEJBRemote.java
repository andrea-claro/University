/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package book_server;

import java.util.List;
import javax.ejb.Remote;

/**
 *
 * @author andrea-claro
 */
@Remote
public interface BookEJBRemote {
    public void addBook(Book book);
    public void removeBook(Book book);
    public List<Book> findAll();
    public Book findById(String id);
}
