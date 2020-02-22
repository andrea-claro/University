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

    @WebServiceRef(wsdlLocation = "META-INF/wsdl/localhost_8080/FornitoreEJBService/FornitoreEJB.wsdl")
    private static FornitoreEJBService service;

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
        List<Fornitore> fornitori = findAll(); 
        
        for(Fornitore f: fornitori)
            System.out.println(f.getCognome() + " della " + f.getNomeSocieta());
    }

    private static java.util.List<client.Fornitore> findAll() {
        // Note that the injected javax.xml.ws.Service reference as well as port objects are not thread safe.
        // If the calling of port operations may lead to race condition some synchronization is required.
        client.FornitoreEJB port = service.getFornitoreEJBPort();
        return port.findAll();
    }
    
}
