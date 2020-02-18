/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package server;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import javax.annotation.sql.DataSourceDefinition;
import javax.ejb.Singleton;
import javax.ejb.LocalBean;
import javax.ejb.Startup;
import javax.inject.Inject;

/**
 *
 * @author andrea-claro
 */
@Singleton
@Startup
@LocalBean
@DataSourceDefinition(
    className = "org.apache.derby.jdbc.EmbeddedDataSource",
    name = "java:global/jdbc/ArchivioCDDB",
    user = "app",
    password = "app",
    databaseName = "ArchivioCDPU",
    properties = {"connectionAttributes=; create=true"}) 
public class CDDatabasePopulator {
    
    @Inject
    private CDBeanEJB cdBeanEJB;
    
    private CDBean cd1, cd2;
    
    @PostConstruct
    public void populateDB(){
        cd1 = new CDBean("Ricchione", "Gay", 7);
        cd2 = new CDBean("PostMalone", "coglione", 13);
        
        cdBeanEJB.addCD(cd1);
        cdBeanEJB.addCD(cd2);
    }
    
    @PreDestroy
    public void clearDB(){
        cdBeanEJB.removeCD(cd1);
        cdBeanEJB.removeCD(cd2);
    }
}
