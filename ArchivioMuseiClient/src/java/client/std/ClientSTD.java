/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package client.std;

import java.util.List;
import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import server.bean.Archivia;
import server.bean.Museum;

/**
 *
 * @author andrea-claro
 */
public class ClientSTD {
    
    private static Archivia museumEJB;
    
    public static void main(String[] args) throws NamingException {
        
        Context ctx = new InitialContext();
        
        museumEJB = (Archivia) 
                ctx.lookup("java:global/ArchivioMusei/MuseumEJB!server.bean.Archivia");
        
        printByRegion("Campania");
        System.out.println("DIOCANE");
    }
    
    private static void printByRegion(String region){
        List<Museum> musei = museumEJB.findByRegion(region);
        for (Museum m: musei)
            System.out.println(m.toString());
    }
}
