/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package client;

import java.util.List;
import javax.xml.ws.WebServiceRef;

/**
 *
 * @author andrea-claro
 */
public class ClientWS {

    @WebServiceRef(wsdlLocation = "META-INF/wsdl/localhost_8080/GelatoEJBService/GelatoEJB.wsdl")
    private static GelatoEJBService service;

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        List<Gelato> gelati = findAll();
        for(Gelato g: gelati)
            System.out.println(g.toString());
        System.out.println("\n");
        
        gelati = findByPrice(2);
        for(Gelato g: gelati)
            System.out.println(g.toString());
        System.out.println("\n");
        
        Gelato g = findByName("pistacchio");
        System.out.println(g.toString());
    }

    private static java.util.List<client.Gelato> findAll() {
        // Note that the injected javax.xml.ws.Service reference as well as port objects are not thread safe.
        // If the calling of port operations may lead to race condition some synchronization is required.
        client.GelatoEJB port = service.getGelatoEJBPort();
        return port.findAll();
    }

    private static Gelato findByName(java.lang.String arg0) {
        // Note that the injected javax.xml.ws.Service reference as well as port objects are not thread safe.
        // If the calling of port operations may lead to race condition some synchronization is required.
        client.GelatoEJB port = service.getGelatoEJBPort();
        return port.findByName(arg0);
    }

    private static java.util.List<client.Gelato> findByPrice(int arg0) {
        // Note that the injected javax.xml.ws.Service reference as well as port objects are not thread safe.
        // If the calling of port operations may lead to race condition some synchronization is required.
        client.GelatoEJB port = service.getGelatoEJBPort();
        return port.findByPrice(arg0);
    }
    
}
