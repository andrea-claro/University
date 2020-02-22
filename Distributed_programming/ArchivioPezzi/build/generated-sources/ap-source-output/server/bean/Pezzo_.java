package server.bean;

import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;
import server.bean.Categoria;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2020-02-18T16:01:04")
@StaticMetamodel(Pezzo.class)
public class Pezzo_ { 

    public static volatile SingularAttribute<Pezzo, String> nomePezzo;
    public static volatile SingularAttribute<Pezzo, Boolean> disponibilita;
    public static volatile SingularAttribute<Pezzo, Categoria> categoria;
    public static volatile SingularAttribute<Pezzo, Integer> prezzo;
    public static volatile SingularAttribute<Pezzo, Integer> pezziVenduti;
    public static volatile SingularAttribute<Pezzo, String> id;

}