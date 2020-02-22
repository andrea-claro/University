/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package server;

import javax.ejb.LocalBean;
import javax.enterprise.inject.Produces;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author andrea-claro
 */

@LocalBean
public class CDDatabaseProducer {

    @Produces
    @PersistenceContext(unitName = "ArchivioCDPU")
    private EntityManager em;
}
