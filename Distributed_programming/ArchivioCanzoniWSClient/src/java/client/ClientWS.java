/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package client;

import java.util.Scanner;
import javax.xml.ws.WebServiceRef;

/**
 *
 * @author andrea-claro
 */
public class ClientWS {

    @WebServiceRef(wsdlLocation = "META-INF/wsdl/localhost_8080/CanzoneEJBService/CanzoneEJB.wsdl")
    private static CanzoneEJBService service;

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        
        System.out.println("\nId canzone da scegliere: ");
        Canzone cnz = findById(in.nextInt());
        System.out.println("\nVoti ricevuti: ");
        cnz.setVotiRicevuti(in.nextInt());
        
        updateCanzone(cnz);
        
    }

    private static boolean updateCanzone(client.Canzone arg0) {
        // Note that the injected javax.xml.ws.Service reference as well as port objects are not thread safe.
        // If the calling of port operations may lead to race condition some synchronization is required.
        client.CanzoneEJB port = service.getCanzoneEJBPort();
        return port.updateCanzone(arg0);
    }

    private static Canzone findById(int arg0) {
        // Note that the injected javax.xml.ws.Service reference as well as port objects are not thread safe.
        // If the calling of port operations may lead to race condition some synchronization is required.
        client.CanzoneEJB port = service.getCanzoneEJBPort();
        return port.findById(arg0);
    }
    
}
