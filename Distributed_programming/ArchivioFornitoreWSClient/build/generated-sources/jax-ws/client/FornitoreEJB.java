
package client;

import java.util.List;
import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebResult;
import javax.jws.WebService;
import javax.xml.bind.annotation.XmlSeeAlso;
import javax.xml.ws.Action;
import javax.xml.ws.RequestWrapper;
import javax.xml.ws.ResponseWrapper;


/**
 * This class was generated by the JAX-WS RI.
 * JAX-WS RI 2.3.2
 * Generated source version: 2.2
 * 
 */
@WebService(name = "FornitoreEJB", targetNamespace = "http://businness.server/")
@XmlSeeAlso({
    ObjectFactory.class
})
public interface FornitoreEJB {


    /**
     * 
     * @return
     *     returns java.util.List<client.Fornitore>
     */
    @WebMethod
    @WebResult(targetNamespace = "")
    @RequestWrapper(localName = "findAll", targetNamespace = "http://businness.server/", className = "client.FindAll")
    @ResponseWrapper(localName = "findAllResponse", targetNamespace = "http://businness.server/", className = "client.FindAllResponse")
    @Action(input = "http://businness.server/FornitoreEJB/findAllRequest", output = "http://businness.server/FornitoreEJB/findAllResponse")
    public List<Fornitore> findAll();

    /**
     * 
     * @param arg0
     * @return
     *     returns client.Fornitore
     */
    @WebMethod
    @WebResult(targetNamespace = "")
    @RequestWrapper(localName = "findById", targetNamespace = "http://businness.server/", className = "client.FindById")
    @ResponseWrapper(localName = "findByIdResponse", targetNamespace = "http://businness.server/", className = "client.FindByIdResponse")
    @Action(input = "http://businness.server/FornitoreEJB/findByIdRequest", output = "http://businness.server/FornitoreEJB/findByIdResponse")
    public Fornitore findById(
        @WebParam(name = "arg0", targetNamespace = "")
        String arg0);

    /**
     * 
     * @param arg0
     */
    @WebMethod
    @RequestWrapper(localName = "addFornitore", targetNamespace = "http://businness.server/", className = "client.AddFornitore")
    @ResponseWrapper(localName = "addFornitoreResponse", targetNamespace = "http://businness.server/", className = "client.AddFornitoreResponse")
    @Action(input = "http://businness.server/FornitoreEJB/addFornitoreRequest", output = "http://businness.server/FornitoreEJB/addFornitoreResponse")
    public void addFornitore(
        @WebParam(name = "arg0", targetNamespace = "")
        Fornitore arg0);

    /**
     * 
     * @param arg0
     */
    @WebMethod
    @RequestWrapper(localName = "removeFornitore", targetNamespace = "http://businness.server/", className = "client.RemoveFornitore")
    @ResponseWrapper(localName = "removeFornitoreResponse", targetNamespace = "http://businness.server/", className = "client.RemoveFornitoreResponse")
    @Action(input = "http://businness.server/FornitoreEJB/removeFornitoreRequest", output = "http://businness.server/FornitoreEJB/removeFornitoreResponse")
    public void removeFornitore(
        @WebParam(name = "arg0", targetNamespace = "")
        Fornitore arg0);

    /**
     * 
     * @param arg0
     * @return
     *     returns java.util.List<client.Fornitore>
     */
    @WebMethod
    @WebResult(targetNamespace = "")
    @RequestWrapper(localName = "findBySurname", targetNamespace = "http://businness.server/", className = "client.FindBySurname")
    @ResponseWrapper(localName = "findBySurnameResponse", targetNamespace = "http://businness.server/", className = "client.FindBySurnameResponse")
    @Action(input = "http://businness.server/FornitoreEJB/findBySurnameRequest", output = "http://businness.server/FornitoreEJB/findBySurnameResponse")
    public List<Fornitore> findBySurname(
        @WebParam(name = "arg0", targetNamespace = "")
        String arg0);

    /**
     * 
     * @param arg0
     * @return
     *     returns java.util.List<client.Fornitore>
     */
    @WebMethod
    @WebResult(targetNamespace = "")
    @RequestWrapper(localName = "findByMaxOrd", targetNamespace = "http://businness.server/", className = "client.FindByMaxOrd")
    @ResponseWrapper(localName = "findByMaxOrdResponse", targetNamespace = "http://businness.server/", className = "client.FindByMaxOrdResponse")
    @Action(input = "http://businness.server/FornitoreEJB/findByMaxOrdRequest", output = "http://businness.server/FornitoreEJB/findByMaxOrdResponse")
    public List<Fornitore> findByMaxOrd(
        @WebParam(name = "arg0", targetNamespace = "")
        int arg0);

    /**
     * 
     * @param arg0
     */
    @WebMethod
    @RequestWrapper(localName = "updateFornitore", targetNamespace = "http://businness.server/", className = "client.UpdateFornitore")
    @ResponseWrapper(localName = "updateFornitoreResponse", targetNamespace = "http://businness.server/", className = "client.UpdateFornitoreResponse")
    @Action(input = "http://businness.server/FornitoreEJB/updateFornitoreRequest", output = "http://businness.server/FornitoreEJB/updateFornitoreResponse")
    public void updateFornitore(
        @WebParam(name = "arg0", targetNamespace = "")
        Fornitore arg0);

}
