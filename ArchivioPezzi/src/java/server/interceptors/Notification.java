/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package server.interceptors;

import javax.enterprise.event.Observes;
import server.bean.Pezzo;
/**
 *
 * @author andrea-claro
 */
public class Notification {
    
    public void notify(@Observes Pezzo p){
        System.out.println("Pezzo modificato: "+p.toString());
    }
}
