/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package client;

import java.util.logging.Logger;
import javax.jms.ConnectionFactory;
import javax.jms.Destination;
import javax.jms.JMSContext;
import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import server.bean.Ordine;

/**
 *
 * @author andrea-claro
 */
public class ClientJMS {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws NamingException {
        Context ctx;
        ctx = new InitialContext();
        
        Logger logger = Logger.getLogger("global");
        
        ConnectionFactory connectionFactory = (ConnectionFactory) 
                ctx.lookup("jms/javaee7/ConnectionFactory");
        
        Destination topic = (Destination) 
                ctx.lookup("jms/javaee7/Topic");
        
        Ordine ord = new Ordine(1, 1);
        try(JMSContext jmsContext = connectionFactory.createContext()){
            jmsContext.createProducer().setProperty("id", "1").send(topic, ord);
            System.out.println("ord sent: "+ord.toString());
        }
    }
    
}
