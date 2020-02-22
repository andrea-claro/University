/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package server.database;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import javax.annotation.sql.DataSourceDefinition;
import javax.ejb.Singleton;
import javax.ejb.LocalBean;
import javax.ejb.Startup;
import javax.inject.Inject;
import server.bean.Categoria;
import server.bussiness.PezzoEJB;
import server.bean.Pezzo;
/**
 *
 * @author andrea-claro
 */

@Singleton
@Startup
@DataSourceDefinition(
        className = "org.apache.derby.jdbc.EmbeddedDataSource",
        name = "java:global/jdbc/ArchivioPezziDB",
        databaseName = "ArchivioPezziPU",
        user = "app",
        password = "app",
        properties = {"connectionAttributes=; create=true"}
    )
public class DatabasePopulator {

    @Inject
    private PezzoEJB pezzoEJB;
    
    private Pezzo p1;
    private Pezzo p2;
    
    @PostConstruct
    private void populateDB() {
        p1 = new Pezzo("stronzo", 33, 11, true, Categoria.MOTORE);
        p2 = new Pezzo("merda", 12, 13, false, Categoria.ACCENSIONE);
        
        if(!pezzoEJB.addPezzo(p1)  ||  !pezzoEJB.addPezzo(p2))
            System.out.println("Non avviato il database");
    }
    
    @PreDestroy
    private void clearDB() {
        if(!pezzoEJB.removePezzo(p1)  ||  !pezzoEJB.removePezzo(p2))
            System.out.println("Non liberato il database");
    }
}
