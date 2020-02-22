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
import server.bean.Pezzo;

/**
 *
 * @author andrea-claro
 */
public class ClientJMS {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws NamingException {

        Context ctx = new InitialContext();
        
        ConnectionFactory connFact = (ConnectionFactory)
                ctx.lookup("jms/javaee7/ConnectionFactory");
        
        Destination topic = (Destination)
                ctx.lookup("jms/javaee7/Topic");
        
        Pezzo p = new Pezzo();
        p.setId("1");
        p.setPezziVenduti(55);
        
        try(JMSContext jmsContext = connFact.createContext()){
            jmsContext.createProducer().send(topic, p);
        }
    }
    
}
