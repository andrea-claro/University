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
import server.bean.Canzone;
import server.bean.Categoria;
/**
 *
 * @author andrea-claro
 *//**
 *
 * @author andrea-claro
 */
@Stateless
@LocalBean
@WebService
@Counter @Block
public class CanzoneEJB implements CanzoneRemote{
    
   @Inject
   private EntityManager em;
   
    @Override
    public boolean addCanzone(Canzone c) {
        try{
            em.persist(c);
            return true;
        } catch(Exception e){
            return false;
        }
    }

    @Override
    public boolean removeCanzone(Canzone c) {
        try{
            em.remove(c);
            return true;
        } catch(Exception e){
            return false;
        }    }

    @Override
    public boolean updateCanzone(Canzone c) {
        try{
            em.merge(c);
            return true;
        } catch(Exception e){
            return false;
        }    }

    @Override
    public Canzone findById(int id) {
        TypedQuery<Canzone> query =
                em.createNamedQuery(Canzone.FIND_BY_ID, Canzone.class);
        query.setParameter("id", id);
        return query.getSingleResult();
    }

    @Override
    public List<Canzone> findByCat(Categoria cat) {
        TypedQuery<Canzone> query =
                em.createNamedQuery(Canzone.FIND_BY_CAT, Canzone.class);
        query.setParameter(1, cat);
        return query.getResultList();    
    }

    @Override
    public List<Canzone> findAll() {
        TypedQuery<Canzone> query =
                em.createNamedQuery(Canzone.FIND_ALL, Canzone.class);
        return query.getResultList();     
    }

    @Override
    public List<Canzone> findByVotes(int voti) {
        TypedQuery<Canzone> query =
                (TypedQuery<Canzone>) em.createNativeQuery("SELECT * FROM Canzone WHERE votiRicevuti > ?1", Canzone.class);
        query.setParameter(1, voti);
        return query.getResultList();
    }
}
