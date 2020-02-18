/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package server.bussiness;

import java.util.logging.Level;
import java.util.logging.Logger;
import javax.ejb.ActivationConfigProperty;
import javax.ejb.MessageDriven;
import javax.enterprise.event.Event;
import javax.inject.Inject;
import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.MessageListener;
import server.bean.Pezzo;
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
public class PezzoMDB implements MessageListener {
    
    @Inject
    private PezzoEJB pezzoEJB;
    
    @Inject
    private Event<Pezzo> pezzo;
    
    public PezzoMDB() {
    }
    
    @Override
    public void onMessage(Message message) {
        
        try {
            Pezzo p = message.getBody(Pezzo.class);
            
            Pezzo pz = pezzoEJB.findById(p.getId());
            pz.setPezziVenduti(p.getPezziVenduti());
            
            if(pezzoEJB.updatePezzo(pz)){
                pezzo.fire(pz);
            }
        } catch (JMSException ex) {
            Logger.getLogger(PezzoMDB.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }
    
}
