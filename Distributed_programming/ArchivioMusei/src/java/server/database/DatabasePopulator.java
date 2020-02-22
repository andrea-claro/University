package server.database;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import server.business.MuseumEJB;
import server.bean.Museum;
import java.util.logging.Logger;
import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import javax.annotation.sql.DataSourceDefinition;
import javax.ejb.Singleton;
import javax.ejb.Startup;
import javax.inject.Inject;

/**
 *
 * @author andrea-claro
 */
@Singleton
@Startup
@DataSourceDefinition(
        className = "org.apache.derby.jdbc.EmbeddedDataSource",
        name = "java:global/jdbc/ArchivioMuseiDB",
        user = "app",
        password = "app",
        databaseName = "ArchivioMuseiPU",
        properties = {"connectionAttributes=; create=true"})
public class DatabasePopulator {
    
    @Inject
    private MuseumEJB museumEJB;
   
    @Inject
    private Logger logger;
    
    private Museum m1, m2, m3;
    
    
    @PostConstruct
    private void populateDB(){
        m1 = new Museum("città della scienza", "Gerardo Gullo", 222, "Napoli", "Napoli", "Campania");
        m2 = new Museum("zoo quark", "Biagio Boi", 333, "Ricchione", "Ricchione", "Marche");
        m3 = new Museum("Acqua park", "Fischiao", 444, "Marvellao", "gigius", "balenao");
        
        museumEJB.addMuseum(m1);
        museumEJB.addMuseum(m2);
        museumEJB.addMuseum(m3);
        
        logger.info("# # # # # # # # # # \nDB populated");
    }
    
    @PreDestroy
    private void clearDB(){
        museumEJB.removeMuseum(m1);
        museumEJB.removeMuseum(m2);
        museumEJB.removeMuseum(m3);
        
        logger.info("# # # # # # # # # # \nDB cleared");
    }
}
