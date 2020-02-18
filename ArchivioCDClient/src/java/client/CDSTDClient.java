/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package client;

import server.*;
import java.util.List;
import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;

/**
 *
 * @author andrea-claro
 */
public class CDSTDClient {
    
    public static void main(String[] args) throws NamingException{
        
        Context ctx = new InitialContext();
        
        CDBeanEJBRemote bookEJB = (CDBeanEJBRemote) 
                ctx.lookup("java:global/ArchivioCD/CDBeanEJB!server.CDBeanEJBRemote");
        List<server.CDBean> books = bookEJB.findAll();
        for(server.CDBean b: books){
            System.out.println(b.toString()); 
        }
    }
}
