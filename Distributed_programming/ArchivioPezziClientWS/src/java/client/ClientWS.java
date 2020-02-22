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

    @WebServiceRef(wsdlLocation = "META-INF/wsdl/localhost_8080/PezzoEJBService/PezzoEJB.wsdl")
    private static PezzoEJBService service;

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        List<Pezzo> tuttiPezzi = findAll();
        List<Pezzo> pezziCat = findByCategory(Categoria.MOTORE);
        Pezzo pezzo = findById("1");
        
        System.out.println("Pezzo: "+pezzo.toString());
        
        for(Pezzo pz:tuttiPezzi)
            System.out.println("Pezzi: "+pz.toString());
        
        for(Pezzo pz:pezziCat)
            System.out.println("Pezzi cat: "+pz.toString());
    }

    private static java.util.List<client.Pezzo> findAll() {
        // Note that the injected javax.xml.ws.Service reference as well as port objects are not thread safe.
        // If the calling of port operations may lead to race condition some synchronization is required.
        client.PezzoEJB port = service.getPezzoEJBPort();
        return port.findAll();
    }

    private static java.util.List<client.Pezzo> findByCategory(client.Categoria arg0) {
        // Note that the injected javax.xml.ws.Service reference as well as port objects are not thread safe.
        // If the calling of port operations may lead to race condition some synchronization is required.
        client.PezzoEJB port = service.getPezzoEJBPort();
        return port.findByCategory(arg0);
    }

    private static Pezzo findById(java.lang.String arg0) {
        // Note that the injected javax.xml.ws.Service reference as well as port objects are not thread safe.
        // If the calling of port operations may lead to race condition some synchronization is required.
        client.PezzoEJB port = service.getPezzoEJBPort();
        return port.findById(arg0);
    }
    
}
