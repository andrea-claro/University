/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package server.bussiness;

import java.util.List;
import javax.ejb.Remote;
import server.bean.Pezzo;
import server.bean.Categoria;
/**
 *
 * @author andrea-claro
 */
@Remote
public interface PezzoEJBRemote {
    
    public boolean addPezzo(Pezzo p);
    public boolean removePezzo(Pezzo p);
    public boolean updatePezzo(Pezzo p);
    
    public Pezzo findById(String id);
    public List<Pezzo> findByCategory(Categoria cat);
    public List<Pezzo> findAll();
}
