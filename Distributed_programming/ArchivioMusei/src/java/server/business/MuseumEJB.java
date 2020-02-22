/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package server.business;

import server.bean.Museum;
import java.util.List;
import javax.ejb.Stateless;
import javax.ejb.LocalBean;
import javax.inject.Inject;
import javax.jws.WebService;
import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import server.bean.Archivia;
import server.interception.Loggable;

/**
 *
 * @author andrea-claro
 */
@Stateless
@LocalBean
@Loggable
@WebService
public class MuseumEJB implements Archivia{

    @Inject
    private EntityManager em;

    @Override
    public void addMuseum(Museum m) {
        em.persist(m);
    }

    @Override
    public void removeMuseum(Museum m) {
        em.remove(m);
    }

    @Override
    public void updateMuseum(Museum m) {
        em.merge(m);
    }

    @Override
    public List<Museum> findAll() {
        TypedQuery<Museum> query = 
                em.createNamedQuery(Museum.FIND_ALL, Museum.class);
        return query.getResultList();
    }

    @Override
    public Museum findById(String id) {
        TypedQuery<Museum> query = 
                em.createNamedQuery(Museum.FIND_BYID, Museum.class);
        query.setParameter("id", id);
        return query.getSingleResult();
    }

    @Override
    public List<Museum> findByRegion(String region) {
        TypedQuery<Museum> query = 
                em.createNamedQuery(Museum.FIND_BYREGION, Museum.class);
        query.setParameter(1, region);
        return query.getResultList();
    }
}
