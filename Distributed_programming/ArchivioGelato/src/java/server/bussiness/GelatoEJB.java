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
import server.for_client.LavoraGelato;
import server.for_client.Gelato;
/**
 *
 * @author andrea-claro
 */
@Stateless
@LocalBean
@Loggable
@WebService
public class GelatoEJB implements LavoraGelato{

    @Inject
    private EntityManager em;
    
    @Override
    public boolean addGelato(Gelato g){
        try{
            em.persist(g);
            return true;
        } catch(Exception e){
            return false;
        }
    }
    
    @Override
    public boolean removeGelato(Gelato g){
        try{
            em.remove(g);
            return true;
        } catch(Exception e){
            return false;
        }
    }
    
    @Override
    public boolean updateGelato(Gelato g){
        try{
            em.merge(g);
            return true;
        } catch(Exception e){
            return false;
        }
    }
    
    @Override
    public List<Gelato> findAll(){
        TypedQuery<Gelato> query =
                em.createNamedQuery(Gelato.FIND_ALL, Gelato.class);
        return query.getResultList();
    }
    
    @Override
    public List<Gelato> findByPrice(int p){
        TypedQuery<Gelato> query =
                em.createNamedQuery(Gelato.FIND_BY_PRICE, Gelato.class);
        query.setParameter(1, p);
        return query.getResultList();
    }
    
    @Override
    public Gelato findByName(String n){
        TypedQuery<Gelato> query =
                em.createNamedQuery(Gelato.FIND_BY_NAME, Gelato.class);
        query.setParameter("nome", n);
        return query.getSingleResult();
    }
}
