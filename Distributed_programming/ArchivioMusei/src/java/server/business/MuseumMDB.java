/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package server.business;

import java.util.logging.Level;
import server.bean.Museum;
import java.util.logging.Logger;
import javax.ejb.ActivationConfigProperty;
import javax.ejb.MessageDriven;
import javax.inject.Inject;
import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.MessageListener;

/**
 *
 * @author andrea-claro
 */
@MessageDriven(mappedName = "jms/javaee7/Topic",activationConfig = {
    @ActivationConfigProperty(propertyName = "clientId", propertyValue = "jms/javaee7/Topic"),
    @ActivationConfigProperty(propertyName = "destinationLookup", propertyValue = "jms/javaee7/Topic"),
    @ActivationConfigProperty(propertyName = "subscriptionDurability", propertyValue = "Durable"),
    @ActivationConfigProperty(propertyName = "subscriptionName", propertyValue = "jms/javaee7/Topic"),
    @ActivationConfigProperty(propertyName = "destinationType", propertyValue = "javax.jms.Topic")
})
public class MuseumMDB implements MessageListener {
    
    @Inject
    private MuseumEJB museumEJB;
    
    @Inject
    private Logger logger;
    
    public MuseumMDB() {
    }
    
    @Override
    public void onMessage(Message message) {
        try{
            String id = message.getStringProperty("id");
            Museum mu = message.getBody(Museum.class);
            
            Museum m = museumEJB.findById(id);
            m.setAnnualVisitors(mu.getAnnualVisitors());
            
            museumEJB.updateMuseum(m);
            logger.info("Changes to: "+m.toString());
        } catch (JMSException e){
        }
    }
    
}
