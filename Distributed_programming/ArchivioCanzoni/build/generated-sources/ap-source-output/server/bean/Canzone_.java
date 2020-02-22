package server.bean;

import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;
import server.bean.Categoria;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2020-02-20T17:56:20")
@StaticMetamodel(Canzone.class)
public class Canzone_ { 

    public static volatile SingularAttribute<Canzone, Integer> votiRicevuti;
    public static volatile SingularAttribute<Canzone, Categoria> categoria;
    public static volatile SingularAttribute<Canzone, String> incipit;
    public static volatile SingularAttribute<Canzone, Integer> id;
    public static volatile SingularAttribute<Canzone, Boolean> cantato;
    public static volatile SingularAttribute<Canzone, String> nomeCantante;

}