/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package server;

import java.util.List;
import javax.ejb.Stateless;
import javax.ejb.LocalBean;
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
public class CDBeanEJB implements CDBeanEJBRemote{

    @Inject
    private EntityManager em;
    
    public CDBeanEJB(){
        
    }

    @Override
    public List<CDBean> findById(String id) {
        TypedQuery<CDBean> query = em.createNamedQuery(CDBean.FIND_BYID, CDBean.class);
        query.setParameter(1, id);
        return query.getResultList();
    }

    @Override
    public List<CDBean> findAll() {
        TypedQuery<CDBean> query = em.createNamedQuery(CDBean.FIND_ALL, CDBean.class);
        return query.getResultList();
    }

    @Override
    public void addCD(CDBean cd) {
        em.persist(cd);
    }

    @Override
    public void removeCD(CDBean cd) {
        em.remove(cd);
    }

    @Override
    public void updateCD(CDBean cd) {
        em.merge(cd);
    }
    
    
}
