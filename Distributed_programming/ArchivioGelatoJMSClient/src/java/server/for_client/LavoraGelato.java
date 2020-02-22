/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package server.for_client;

import java.util.List;
import javax.ejb.Remote;

/**
 *
 * @author andrea-claro
 */
@Remote
public interface LavoraGelato {
    
    public boolean addGelato(Gelato g);
    public boolean removeGelato(Gelato g);
    public boolean updateGelato(Gelato g);
    
    public List<Gelato> findAll();
    public List<Gelato> findByPrice(int p);
    public Gelato findByName(String n);
}
