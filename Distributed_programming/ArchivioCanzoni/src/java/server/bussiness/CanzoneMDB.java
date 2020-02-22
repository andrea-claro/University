/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package server.bussiness;

import java.util.List;
import javax.ejb.ActivationConfigProperty;
import javax.ejb.MessageDriven;
import javax.enterprise.event.Event;
import javax.inject.Inject;
import javax.jms.Message;
import javax.jms.MessageListener;
import server.bean.*;

/**
 *
 * @author andrea-claro
 */
@MessageDriven(mappedName = "jms/javaee7/Topic", activationConfig = {
    @ActivationConfigProperty(propertyName = "clientId", propertyValue = "jms/javaee7/Topic"),
    @ActivationConfigProperty(propertyName = "destinationLookup", propertyValue = "jms/javaee7/Topic"),
    @ActivationConfigProperty(propertyName = "subscriptionDurability", propertyValue = "Durable"),
    @ActivationConfigProperty(propertyName = "subscriptionName", propertyValue = "jms/javaee7/Topic"),
    @ActivationConfigProperty(propertyName = "destinationType", propertyValue = "javax.jms.Topic")
})
public class CanzoneMDB implements MessageListener {
    
    @Inject
    private CanzoneEJB canzoneEJB;
    
    @Inject
    private Event<Canzone> cantato;
    
    public CanzoneMDB() {
    }
    
    @Override
    public void onMessage(Message message) {
        try{
            Canzone cnz = message.getBody(Canzone.class);
            
            List<Canzone> canzoni = canzoneEJB.findAll();
            
            for(Canzone c: canzoni){
                if(c.getNomeCantante().equals(cnz.getNomeCantante())  &&  
                        c.getIncipit().equals(cnz.getIncipit())){
                    c.setCantato(true);
                    if(canzoneEJB.updateCanzone(c))
                        cantato.fire(c);
                }
            }
        }catch (Exception e){
            System.out.println("Errore sul messaggio");
        }
    }
    
}
