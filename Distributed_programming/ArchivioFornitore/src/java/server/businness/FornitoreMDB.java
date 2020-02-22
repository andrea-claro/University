/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package server.businness;

import java.util.logging.Level;
import java.util.logging.Logger;
import javax.ejb.ActivationConfigProperty;
import javax.ejb.MessageDriven;
import javax.inject.Inject;
import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.MessageListener;
import server.bean.Ordine;
import server.bean.Fornitore;

/**
 *
 * @author andrea-claro
 */
@MessageDriven(mappedName= "jms/javaee7/Topic", activationConfig = {
    @ActivationConfigProperty(propertyName = "clientId", propertyValue = "jms/javaee7/Topic"),
    @ActivationConfigProperty(propertyName = "destinationLookup", propertyValue = "jms/javaee7/Topic"),
    @ActivationConfigProperty(propertyName = "subscriptionDurability", propertyValue = "Durable"),
    @ActivationConfigProperty(propertyName = "subscriptionName", propertyValue = "jms/javaee7/Topic"),
    @ActivationConfigProperty(propertyName = "destinationType", propertyValue = "javax.jms.Topic")
})
public class FornitoreMDB implements MessageListener {
    
    @Inject
    private FornitoreEJB fornitoreEJB;
    
    @Inject
    private Logger logger;
    
    @Override
    public void onMessage(Message message) {
        try{
            String id = message.getStringProperty("id");
            Ordine ord = message.getBody(Ordine.class);
            
            Fornitore f = fornitoreEJB.findById(id);
            
            if(f.addOrd(ord.getQuantita(), ord.getValore())){ 
                fornitoreEJB.updateFornitore(f);
                System.out.println("Fornitore " + id + " aggiornato");
            } else
                System.out.println("Fornitore " + id + " non aggiornato");
        } catch (JMSException ex) { 
            logger.log(Level.SEVERE, null, ex);
        }
    }
    
}
