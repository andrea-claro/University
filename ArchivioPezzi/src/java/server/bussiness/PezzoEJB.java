/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package server.bussiness;

import java.util.List;
import javax.ejb.Stateless;
import javax.ejb.LocalBean;
import javax.inject.Inject;
import javax.jws.WebService;
import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import server.bean.Categoria;
import server.bean.Pezzo;
import server.interceptors.Counter;

/**
 *
 * @author andrea-claro
 */
@Stateless
@LocalBean
@WebService
@Counter
public class PezzoEJB implements PezzoEJBRemote{

    @Inject
    private EntityManager em;
    
    @Override
    public boolean addPezzo(Pezzo p) {
        try{
            em.persist(p);
            return true;
        } catch (Exception e){
            return false;
        }
    }

    @Override
    public boolean removePezzo(Pezzo p) {
        try{
            em.remove(p);
            return true;
        } catch (Exception e){
            return false;
        }    }

    @Override
    public boolean updatePezzo(Pezzo p) {
        try{
            em.merge(p);
            return true;
        } catch (Exception e){
            return false;
        }    }

    @Override
    public Pezzo findById(String id) {
        TypedQuery<Pezzo> query = 
                em.createNamedQuery(Pezzo.FIND_BY_ID, Pezzo.class);
        query.setParameter("id", id);
        return query.getSingleResult();
    }

    @Override
    public List<Pezzo> findByCategory(Categoria cat) {
        TypedQuery<Pezzo> query = 
                em.createNamedQuery(Pezzo.FIND_BY_CATEGORY, Pezzo.class);
        query.setParameter(1, cat);
        return query.getResultList();    
    }

    @Override
    public List<Pezzo> findAll() {
        TypedQuery<Pezzo> query = 
                em.createNamedQuery(Pezzo.FIND_ALL, Pezzo.class);
        return query.getResultList();    
    }
    
    
}
