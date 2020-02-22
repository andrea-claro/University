/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package server.database;

import java.util.logging.Level;
import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import javax.annotation.sql.DataSourceDefinition;
import javax.ejb.Singleton;
import javax.ejb.Startup;
import javax.inject.Inject;
import server.bussiness.GelatoEJB;
import server.for_client.Gelato;

/**
 *
 * @author andrea-claro
 */
@Singleton
@Startup
@DataSourceDefinition(
        className = "org.apache.derby.jdbc.EmbeddedDataSource",
        name = "java:global/jdbc/GelatoDB",
        user = "app",
        password = "app",
        databaseName = "ArchivioGelatoPU",
        properties = {"connectionAttributes=; create=true"}
    )
public class DatabasePopulator {

    @Inject
    private GelatoEJB gelatoEJB;
    
    private Gelato g1, g2;
    
    @PostConstruct
    private void populateDB(){
        g1 = new Gelato("pistacchio", "di nonna", 2, 120);
        g2 = new Gelato("vaniglia", "di zia", 2, 110);
        
        if(!gelatoEJB.addGelato(g1)  ||  !gelatoEJB.addGelato(g2))
            return;
    }
    
    @PreDestroy
    public void clearDB(){
        gelatoEJB.removeGelato(g1);
        gelatoEJB.removeGelato(g2);
    }
}
