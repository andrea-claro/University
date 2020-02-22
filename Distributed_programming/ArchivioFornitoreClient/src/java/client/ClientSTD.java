/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package client;

import java.util.List;
import java.util.logging.Logger;
import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import server.bean.Fornisce;
import server.bean.Fornitore;

/**
 *
 * @author andrea-claro
 */
public class ClientSTD {

    public static void main(String[] args) throws NamingException {
        
        Logger logger = Logger.getLogger("global"); 

        Context ctx;
        ctx = new InitialContext(); 
        Fornisce f = (Fornisce)
                ctx.lookup("java:global/ArchivioFornitore/FornitoreEJB!server.bean.Fornisce");

        List<Fornitore> lista = f.findByMaxOrd(1);

        for(Fornitore e: lista)
            System.out.println(e.getNomeSocieta());
    }
}
