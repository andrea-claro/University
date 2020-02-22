/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package client;

import java.util.List;
import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import server.for_client.Gelato;
import server.for_client.LavoraGelato;

/**
 *
 * @author andrea-claro
 */
public class ClientSTD {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws NamingException {
        Context ctx = new InitialContext();
        
        LavoraGelato gelatoEJB = (LavoraGelato)
                ctx.lookup("java:global/ArchivioGelato/GelatoEJB!server.for_client.LavoraGelato");
        
        List<Gelato> gelati = gelatoEJB.findAll();
        for(Gelato g: gelati)
            System.out.println(g.toString());
        System.out.println("\n");
        
        gelati = gelatoEJB.findByPrice(2);
        for(Gelato g: gelati)
            System.out.println(g.toString());
        System.out.println("\n");
        
        Gelato g = gelatoEJB.findByName("pistacchio");
        System.out.println(g.toString());
    }
    
}
