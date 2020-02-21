/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package server.bussiness;

import javax.enterprise.event.Observes;
import javax.inject.Inject;
import server.bean.*;
/**
 *
 * @author andrea-claro
 */
public class Notify {
    
    @Inject
    private CanzoneEJB canzoneEJB;
    
    private void notifyEvents(@Observes Canzone c){
        System.out.println("Cantando: "+c.toString());
    }
    
    private void notifyBugo(@Observes Canzone c){
        if(c.getNomeCantante().equals("Morgan e Bugo")  && c.getIncipit().equals(
        "Le brutte intenzioni, la maleducazione, la tua brutta figura di ieri sera, la tua ingratitudine, la tua "
                + "arroganza, fai ciò che vuoi mettendo i piedi in testa")){
            c.setNomeCantante("Morgan");
            if(canzoneEJB.updateCanzone(c))
                System.out.println("Dov'è andato Bugo?");
        }
    }
}
