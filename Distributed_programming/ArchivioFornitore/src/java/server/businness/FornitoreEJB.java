/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package server.businness;

import server.bean.Fornisce;
import server.bean.Fornitore;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.jws.WebService;
import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

/**
 *
 * @author andrea-claro
 */
@WebService
@Stateless
@LocalBean
@Loggable
public class FornitoreEJB implements Fornisce{

    @Inject
    private EntityManager em;
    
    @Inject
    private Logger logger;

    @Override
    public void addFornitore(Fornitore f) {
        logger.log(Level.INFO, "persisting: {0}", f.toString());
        em.persist(f);
    }

    @Override
    public void removeFornitore(Fornitore f) {
        logger.log(Level.INFO, "removing: {0}", f.toString());
        em.remove(f);
    }

    @Override
    public void updateFornitore(Fornitore f) {
        logger.log(Level.INFO, "updating: {0}", f.toString());
        em.merge(f);
    }

    @Override
    public List<Fornitore> findAll() {
        TypedQuery<Fornitore> query = em.createNamedQuery(Fornitore.FIND_ALL, Fornitore.class);
        logger.info("getting every fornitore");
        return query.getResultList();
    }

    @Override
    public Fornitore findById(String id) {
        TypedQuery<Fornitore> query = em.createNamedQuery(Fornitore.FIND_BY_ID, Fornitore.class);
        query.setParameter("id", id);
        logger.log(Level.INFO, "getting fornitore with id: {0}", id);
        return query.getSingleResult();
    }

    @Override
    public List<Fornitore> findBySurname(String surname) {
        TypedQuery<Fornitore> query = em.createNamedQuery(Fornitore.FIND_BY_SURNAME, Fornitore.class);
        query.setParameter("cognome", surname);
        logger.log(Level.INFO, "getting fornitore with surname: {0}", surname);
        return query.getResultList();
    }

    @Override
    public List<Fornitore> findByMaxOrd(int max) {
        TypedQuery<Fornitore> query = em.createNamedQuery(Fornitore.FIND_BY_MAXORD, Fornitore.class);
        query.setParameter("max", max);
        logger.log(Level.INFO, "getting fornitore with order more then: {0}", max);
        return query.getResultList();
    }
}
