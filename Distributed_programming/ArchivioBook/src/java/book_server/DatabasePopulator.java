/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package book_server;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import javax.annotation.sql.DataSourceDefinition;
import javax.ejb.Singleton;
import javax.ejb.Startup;
import javax.inject.Inject;

/**
 *
 * @author andrea-claro
 */
@Singleton
@Startup
@DataSourceDefinition(
    className = "org.apache.derby.jdbc.EmbeddedDataSource",
    name = "java:global/jdbc/BookDB",
    user = "app",
    password = "app",
    databaseName = "ArchivioBookPU",
    properties = {"connectionAttributes=; create=true"}) 
public class DatabasePopulator {
       
    @Inject
    private BookEJB bookEJB;
    
    private Book first, second;
    
    @PostConstruct
    private void populateDB(){
        first = new Book("HarryPotter & la pietra filosofale", "J.K.Rowling", 17);
        bookEJB.addBook(first);
        
        second = new Book("The lord of the rings", "J.R.R. Tolkien", 22);
        bookEJB.addBook(second);
    }
    
    @PreDestroy
    private void clearDB(){
        bookEJB.removeBook(first);
        bookEJB.removeBook(second);
    } 

}
