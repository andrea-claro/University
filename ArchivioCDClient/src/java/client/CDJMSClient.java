/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package client;

import javax.jms.ConnectionFactory;
import javax.jms.Destination;
import javax.jms.JMSContext;
import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;

/**
 *
 * @author andrea-claro
 */
public class CDJMSClient {
    
    public static void main(String[] args) throws NamingException{
        Context ctx;
        ctx = new InitialContext();
        
        ConnectionFactory connectionFactory = (ConnectionFactory)
                ctx.lookup("jms/javaee7/ConnectionFactory");
        
        Destination topic = (Destination)
                ctx.lookup("jms/javaee7/Topic");
        
        server.CDBean cd = new server.CDBean("Eragon", "Christopher Paolini", 13); 
        
        try(JMSContext jmsContext = connectionFactory.createContext()){           
            jmsContext.createProducer().send(topic, cd);
            System.out.println("Send book by topic");
        }
    }
}
