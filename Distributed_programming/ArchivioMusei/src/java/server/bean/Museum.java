package server.bean;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author andrea-claro
 */
@XmlRootElement
@Entity
@NamedQueries({
        @NamedQuery(name = Museum.FIND_ALL, query = "SELECT m FROM Museum m"),
        @NamedQuery(name = Museum.FIND_BYREGION, query = "SELECT m FROM Museum m WHERE m.region = ?1"),
        @NamedQuery(name = Museum.FIND_BYID, query = "SELECT m FROM Museum m WHERE m.id = :id")
})
public class Museum implements Serializable{
    public static final String FIND_ALL = "Museum.findAll";
    public static final String FIND_BYID = "Museum.findById";
    public static final String FIND_BYREGION = "Museum.findByRegion";

    @Id
    @GeneratedValue
    private String id;
    
    private String name;
    private String manager;
    private int annualVisitors;
    private String city;
    private String province;
    private String region;

    public Museum() {
    }

    public Museum(String name, String manager, int annualVisitors, String city, String province, String region) {
        this.name = name;
        this.manager = manager;
        this.annualVisitors = annualVisitors;
        this.city = city;
        this.province = province;
        this.region = region;
    }

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getManager() {
        return manager;
    }

    public int getAnnualVisitors() {
        return annualVisitors;
    }

    public String getCity() {
        return city;
    }

    public String getProvince() {
        return province;
    }

    public String getRegion() {
        return region;
    }

    public void setId(String id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setManager(String manager) {
        this.manager = manager;
    }

    public void setAnnualVisitors(int annualVisitors) {
        this.annualVisitors = annualVisitors;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public void setProvince(String province) {
        this.province = province;
    }

    public void setRegion(String region) {
        this.region = region;
    }
    
    @Override
    public String toString() {
        return "Museum{" + "id=" + id + ", name=" + name + ", manager=" + manager + ", annualVisitors=" + annualVisitors + ", city=" + city + ", province=" + province + ", region=" + region + '}';
    }
}
