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
import javax.ejb.Startup;
import javax.inject.Inject;
import server.bussiness.CanzoneEJB;
import server.bean.*;
/**
 *
 * @author andrea-claro
 */
@Singleton
@Startup
@DataSourceDefinition(
        className = "org.apache.derby.jdbc.EmbeddedDataSource",
        name= "java:global/jdbc/EsameDS",
        databaseName = "EsamePU",
        user = "app",
        password = "app",
        properties = {"connectionAttributes=; create=true"}
)
public class DatabasePopulator {

    @Inject
    private CanzoneEJB canzoneEJB;
    
    private Canzone c1, c2, c3;
    
    @PostConstruct
    public void populateDB(){
        c1 = new Canzone("Diodato", Categoria.POP, "Sai che cosa penso, che non dovrei pensare, che se poi penso sono "
                + "un animale. E se ti penso tu sei un'anima,", false, 1000);
        c2 = new Canzone("Piero pelù", Categoria.ROCK, "Spingi forte spingi salta fuori da quel buio. Crescerai aprendo"
                + " porte tutti i giorni stare pronti", false, 13);
        c3 = new Canzone("Morgan e Bugo", Categoria.POP, "Le brutte intenzioni, la maleducazione, la tua brutta figura "
                + "di ieri sera, la tua ingratitudine, la tua arroganza, fai ciò che vuoi mettendo i piedi in testa",
                true, 0);
        
        if(!canzoneEJB.addCanzone(c1)  ||  !canzoneEJB.addCanzone(c2)  ||  !canzoneEJB.addCanzone(c3))
            System.out.println("Database non inizializzato");
    }
    
    @PreDestroy
    public void clearDB(){
        if(!canzoneEJB.removeCanzone(c1)  ||  !canzoneEJB.removeCanzone(c2)  ||  !canzoneEJB.removeCanzone(c3))
            System.out.println("Database non liberato");
    }
}
