/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package client;

import java.util.List;
import javax.xml.ws.WebServiceRef;

/**
 *
 * @author andrea-claro
 */
public class CDWSClient {

    @WebServiceRef(wsdlLocation = "META-INF/wsdl/localhost_8080/CDBeanEJBService/CDBeanEJB.wsdl")
    private static CDBeanEJBService service;
    
    public static void main(String[] args) {
        
        System.out.println(findById("1"));
        
        List<CdBean> cds = findAll();
        for(CdBean cd: cds) 
            System.out.println(cd.getTitolo() + " " + cd.getAutore()); 
    }

    private static java.util.List<client.CdBean> findById(java.lang.String arg0) {
        // Note that the injected javax.xml.ws.Service reference as well as port objects are not thread safe.
        // If the calling of port operations may lead to race condition some synchronization is required.
        client.CDBeanEJB port = service.getCDBeanEJBPort();
        return port.findById(arg0);
    }

    private static java.util.List<client.CdBean> findAll() {
        // Note that the injected javax.xml.ws.Service reference as well as port objects are not thread safe.
        // If the calling of port operations may lead to race condition some synchronization is required.
        client.CDBeanEJB port = service.getCDBeanEJBPort();
        return port.findAll();
    }
}
