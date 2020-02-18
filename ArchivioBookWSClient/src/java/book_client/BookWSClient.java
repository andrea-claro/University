/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package book_client;

import java.util.List;
import javax.xml.ws.WebServiceRef;

/**
 *
 * @author andrea-claro
 */
public class BookWSClient {

    @WebServiceRef(wsdlLocation = "META-INF/wsdl/localhost_8080/BookEJBService/BookEJB.wsdl")
    private static BookEJBService service;

    @WebServiceRef(wsdlLocation = "META-INF/wsdl/localhost_8080/BookEJBService/BookEJB.wsdl")
    
    public static void main(String[] args) {
        
        System.out.println(findById("1"));
        
        List<book_client.Book> books = findAll();
        for(book_client.Book l: books) 
            System.out.println(l.getTitolo() + " " + l.getAutore()); 
    }

    private static book_client.Book findById(java.lang.String arg0) {
        // Note that the injected javax.xml.ws.Service reference as well as port objects are not thread safe.
        // If the calling of port operations may lead to race condition some synchronization is required.
        book_client.BookEJB port = service.getBookEJBPort();
        return port.findById(arg0);
    }

    private static java.util.List<book_client.Book> findAll() {
        // Note that the injected javax.xml.ws.Service reference as well as port objects are not thread safe.
        // If the calling of port operations may lead to race condition some synchronization is required.
        book_client.BookEJB port = service.getBookEJBPort();
        return port.findAll();
    }
}
