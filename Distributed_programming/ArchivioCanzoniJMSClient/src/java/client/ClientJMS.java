/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package client;

import java.util.Scanner;
import javax.jms.ConnectionFactory;
import javax.jms.Destination;
import javax.jms.JMSContext;
import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import server.bean.*;
/**
 *
 * @author andrea-claro
 */
public class ClientJMS {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws NamingException{
        
        Context ctx = new InitialContext();
        
        ConnectionFactory connFact = (ConnectionFactory) 
                ctx.lookup("jms/javaee7/ConnectionFactory");
        
        Destination topic = (Destination)
                ctx.lookup("jms/javaee7/Topic");
        
        Scanner in = new Scanner(System.in);
        
        Canzone cnz = new Canzone();
        
        System.out.println("Introdurre nome cantante: ");
        cnz.setNomeCantante(in.nextLine());
        System.out.println("Introdurre incipit canzone: ");
        cnz.setIncipit(in.nextLine());
        
        try(JMSContext jmsContext = connFact.createContext()){
            jmsContext.createProducer().send(topic, cnz);
        }catch(Exception e){
            System.out.println("Messaggio non inviato");
        }
    }
    
}
