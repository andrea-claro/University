/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package server.bussiness;

import java.util.List;
import javax.ejb.Remote;
import server.bean.*;

/**
 *
 * @author andrea-claro
 */
@Remote
public interface CanzoneRemote {
    
    public boolean addCanzone(Canzone c);
    public boolean removeCanzone(Canzone c);
    public boolean updateCanzone(Canzone c);
    
    public Canzone findById(int id);
    public List<Canzone> findByCat(Categoria cat);
    public List<Canzone> findAll();
    
    public List<Canzone> findByVotes(int voti);
}
