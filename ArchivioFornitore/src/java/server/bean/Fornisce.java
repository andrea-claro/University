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
public interface Fornisce {
    
    public void addFornitore(Fornitore f);
    public void removeFornitore(Fornitore f);
    public void updateFornitore(Fornitore f);
    
    public List<Fornitore> findAll();
    public Fornitore findById(String id);
    public List<Fornitore> findBySurname(String surname);
    public List<Fornitore> findByMaxOrd(int max);
}
