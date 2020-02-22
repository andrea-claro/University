/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package client;

import java.util.List;
import java.util.Scanner;
import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import server.bussiness.*;
import server.bean.*;
/**
 *
 * @author andrea-claro
 */
public class CliestSTD {

    private static CanzoneRemote cnz;
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws NamingException{
        
        Context ctx = new InitialContext();
        
        cnz = (CanzoneRemote) 
                ctx.lookup("java:global/ArchivioCanzoni/CanzoneEJB!server.bussiness.CanzoneRemote");
        
        printAll();
        printByCategory();
        printByVotes();
    }
    
    private static void printAll(){
        List<Canzone> canzoni = cnz.findAll();
        for(Canzone c: canzoni)
            System.out.println(c.toString());
    }
    
    private static void printByCategory(){
        List<Canzone> canzoni = cnz.findByCat(Categoria.RAP);
        for(Canzone c: canzoni)
            System.out.println(c.toString());
    }
    
    private static void printByVotes(){
        System.out.println("Inserire voti: ");
        Scanner in = new Scanner(System.in);
        List<Canzone> canzoni = cnz.findByVotes(in.nextInt());
        for(Canzone c: canzoni)
            System.out.println(c.toString());
    }
}
