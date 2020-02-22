/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package server.database;

import java.util.logging.Level;
import java.util.logging.Logger;
import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import javax.annotation.sql.DataSourceDefinition;
import javax.ejb.Singleton;
import javax.ejb.Startup;
import javax.inject.Inject;
import server.bean.Fornitore;
import server.businness.FornitoreEJB;

/**
 *
 * @author andrea-claro
 */
@Singleton
@Startup
@DataSourceDefinition(
        className = "org.apache.derby.jdbc.EmbeddedDataSource",
        name = "java:global/jdbc/ArchivioFornitoreDB",
        user = "app",
        password = "app",
        databaseName = "ArchivioFornitorePU",
        properties = {"connectionAttributes=; create=true"}
    )
public class DatabasePopulator {

    @Inject
    private FornitoreEJB fornitoreEJB;
    
    @Inject
    private Logger logger;
    
    private Fornitore bacco, malto;
    
    @PostConstruct
    public void populateDB(){        
        bacco = new Fornitore("Pierluigi", "Giangiacomi", "proseccoSRL", "3338786545", 66, 34, 33);
        fornitoreEJB.addFornitore(bacco);
        logger.log(Level.INFO, "create: {0}", bacco.toString());
        
        malto = new Fornitore("Salvatore", "Fasano", "magagnaSRL", "3456784534", 77, 34, 33);
        fornitoreEJB.addFornitore(malto);
        logger.log(Level.INFO, "create: {0}", malto.toString());
    }
    
    @PreDestroy
    public void clearDB(){
        fornitoreEJB.removeFornitore(bacco);
        logger.log(Level.INFO, "removed: {0}", bacco.toString());
        fornitoreEJB.removeFornitore(malto);
        logger.log(Level.INFO, "removed: {0}", malto.toString());
    }
}
