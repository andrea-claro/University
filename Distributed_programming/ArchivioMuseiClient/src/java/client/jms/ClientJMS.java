/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package client.jms;

import java.util.logging.Logger;
import javax.jms.ConnectionFactory;
import javax.jms.Destination;
import javax.jms.JMSContext;
import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import server.bean.Museum;

/**
 *
 * @author andrea-claro
 */
public class ClientJMS {
    
    public static void main(String[] args) throws NamingException{
        
        Context ctx;
        ctx = new InitialContext();
        
        ConnectionFactory connectionFactory = (ConnectionFactory) 
                ctx.lookup("jms/javaee7/ConnectionFactory");
        
        Destination topic = (Destination) 
                ctx.lookup("jms/javaee7/Topic");
        
        Museum m = new Museum("", "", 1, "", "", "");
        
        try(JMSContext jmsContext = connectionFactory.createContext()){
            jmsContext.createProducer().setProperty("id", "1").send(topic, m);
            System.out.println("# visitors sent");
        }
    }
}
