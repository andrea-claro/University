/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package server.businness;

import java.util.logging.Logger;
import javax.ejb.LocalBean;
import javax.enterprise.inject.Produces;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author andrea-claro
 */
@LocalBean
public class Producer {
    
    @Produces
    @PersistenceContext(unitName = "ArchivioFornitorePU")
    private EntityManager em;
    
    @Produces
    private Logger logger = Logger.getLogger("global");
}
