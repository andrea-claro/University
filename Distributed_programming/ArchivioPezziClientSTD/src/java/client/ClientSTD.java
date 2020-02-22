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
import server.bean.Categoria;
import server.bussiness.PezzoEJBRemote;
import server.bean.Pezzo;
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
        
        PezzoEJBRemote p = (PezzoEJBRemote)
                ctx.lookup("java:global/ArchivioPezzi/PezzoEJB!server.bussiness.PezzoEJBRemote");
        
        List<Pezzo> tuttiPezzi = p.findAll();
        List<Pezzo> pezziCat = p.findByCategory(Categoria.MOTORE);
        Pezzo pezzo = p.findById("1");
        
        System.out.println("Pezzo: "+pezzo.toString()+"\n");
        
        for(Pezzo pz: pezziCat)
            System.out.println("Pezzo cat: "+pz.toString());
        
        System.out.println("\n");
        
        for(Pezzo pz: tuttiPezzi)
            System.out.println("Pezzi: "+pz.toString());
    }
    
}
