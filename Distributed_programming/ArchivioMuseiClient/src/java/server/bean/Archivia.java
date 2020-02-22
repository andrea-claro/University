/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package server.bean;

import java.util.List;
import javax.ejb.Remote;

/**
 *
 * @author andrea-claro
 */
@Remote
public interface Archivia {
    
    public void addMuseum(Museum m);
    public void removeMuseum(Museum m);
    public void updateMuseum(Museum m);
    
    public List<Museum> findAll();
    public Museum findById(String id);
    public List<Museum> findByRegion(String region);
}
