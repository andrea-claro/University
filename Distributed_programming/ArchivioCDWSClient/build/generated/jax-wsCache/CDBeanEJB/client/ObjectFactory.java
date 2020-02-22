
package client;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlElementDecl;
import javax.xml.bind.annotation.XmlRegistry;
import javax.xml.namespace.QName;


/**
 * This object contains factory methods for each 
 * Java content interface and Java element interface 
 * generated in the client package. 
 * <p>An ObjectFactory allows you to programatically 
 * construct new instances of the Java representation 
 * for XML content. The Java representation of XML 
 * content can consist of schema derived interfaces 
 * and classes representing the binding of schema 
 * type definitions, element declarations and model 
 * groups.  Factory methods for each of these are 
 * provided in this class.
 * 
 */
@XmlRegistry
public class ObjectFactory {

    private final static QName _AddCD_QNAME = new QName("http://server/", "addCD");
    private final static QName _AddCDResponse_QNAME = new QName("http://server/", "addCDResponse");
    private final static QName _CdBean_QNAME = new QName("http://server/", "cdBean");
    private final static QName _FindAll_QNAME = new QName("http://server/", "findAll");
    private final static QName _FindAllResponse_QNAME = new QName("http://server/", "findAllResponse");
    private final static QName _FindById_QNAME = new QName("http://server/", "findById");
    private final static QName _FindByIdResponse_QNAME = new QName("http://server/", "findByIdResponse");
    private final static QName _RemoveCD_QNAME = new QName("http://server/", "removeCD");
    private final static QName _RemoveCDResponse_QNAME = new QName("http://server/", "removeCDResponse");
    private final static QName _UpdateCD_QNAME = new QName("http://server/", "updateCD");
    private final static QName _UpdateCDResponse_QNAME = new QName("http://server/", "updateCDResponse");

    /**
     * Create a new ObjectFactory that can be used to create new instances of schema derived classes for package: client
     * 
     */
    public ObjectFactory() {
    }

    /**
     * Create an instance of {@link AddCD }
     * 
     */
    public AddCD createAddCD() {
        return new AddCD();
    }

    /**
     * Create an instance of {@link AddCDResponse }
     * 
     */
    public AddCDResponse createAddCDResponse() {
        return new AddCDResponse();
    }

    /**
     * Create an instance of {@link CdBean }
     * 
     */
    public CdBean createCdBean() {
        return new CdBean();
    }

    /**
     * Create an instance of {@link FindAll }
     * 
     */
    public FindAll createFindAll() {
        return new FindAll();
    }

    /**
     * Create an instance of {@link FindAllResponse }
     * 
     */
    public FindAllResponse createFindAllResponse() {
        return new FindAllResponse();
    }

    /**
     * Create an instance of {@link FindById }
     * 
     */
    public FindById createFindById() {
        return new FindById();
    }

    /**
     * Create an instance of {@link FindByIdResponse }
     * 
     */
    public FindByIdResponse createFindByIdResponse() {
        return new FindByIdResponse();
    }

    /**
     * Create an instance of {@link RemoveCD }
     * 
     */
    public RemoveCD createRemoveCD() {
        return new RemoveCD();
    }

    /**
     * Create an instance of {@link RemoveCDResponse }
     * 
     */
    public RemoveCDResponse createRemoveCDResponse() {
        return new RemoveCDResponse();
    }

    /**
     * Create an instance of {@link UpdateCD }
     * 
     */
    public UpdateCD createUpdateCD() {
        return new UpdateCD();
    }

    /**
     * Create an instance of {@link UpdateCDResponse }
     * 
     */
    public UpdateCDResponse createUpdateCDResponse() {
        return new UpdateCDResponse();
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link AddCD }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link AddCD }{@code >}
     */
    @XmlElementDecl(namespace = "http://server/", name = "addCD")
    public JAXBElement<AddCD> createAddCD(AddCD value) {
        return new JAXBElement<AddCD>(_AddCD_QNAME, AddCD.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link AddCDResponse }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link AddCDResponse }{@code >}
     */
    @XmlElementDecl(namespace = "http://server/", name = "addCDResponse")
    public JAXBElement<AddCDResponse> createAddCDResponse(AddCDResponse value) {
        return new JAXBElement<AddCDResponse>(_AddCDResponse_QNAME, AddCDResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link CdBean }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link CdBean }{@code >}
     */
    @XmlElementDecl(namespace = "http://server/", name = "cdBean")
    public JAXBElement<CdBean> createCdBean(CdBean value) {
        return new JAXBElement<CdBean>(_CdBean_QNAME, CdBean.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link FindAll }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link FindAll }{@code >}
     */
    @XmlElementDecl(namespace = "http://server/", name = "findAll")
    public JAXBElement<FindAll> createFindAll(FindAll value) {
        return new JAXBElement<FindAll>(_FindAll_QNAME, FindAll.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link FindAllResponse }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link FindAllResponse }{@code >}
     */
    @XmlElementDecl(namespace = "http://server/", name = "findAllResponse")
    public JAXBElement<FindAllResponse> createFindAllResponse(FindAllResponse value) {
        return new JAXBElement<FindAllResponse>(_FindAllResponse_QNAME, FindAllResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link FindById }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link FindById }{@code >}
     */
    @XmlElementDecl(namespace = "http://server/", name = "findById")
    public JAXBElement<FindById> createFindById(FindById value) {
        return new JAXBElement<FindById>(_FindById_QNAME, FindById.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link FindByIdResponse }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link FindByIdResponse }{@code >}
     */
    @XmlElementDecl(namespace = "http://server/", name = "findByIdResponse")
    public JAXBElement<FindByIdResponse> createFindByIdResponse(FindByIdResponse value) {
        return new JAXBElement<FindByIdResponse>(_FindByIdResponse_QNAME, FindByIdResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link RemoveCD }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link RemoveCD }{@code >}
     */
    @XmlElementDecl(namespace = "http://server/", name = "removeCD")
    public JAXBElement<RemoveCD> createRemoveCD(RemoveCD value) {
        return new JAXBElement<RemoveCD>(_RemoveCD_QNAME, RemoveCD.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link RemoveCDResponse }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link RemoveCDResponse }{@code >}
     */
    @XmlElementDecl(namespace = "http://server/", name = "removeCDResponse")
    public JAXBElement<RemoveCDResponse> createRemoveCDResponse(RemoveCDResponse value) {
        return new JAXBElement<RemoveCDResponse>(_RemoveCDResponse_QNAME, RemoveCDResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link UpdateCD }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link UpdateCD }{@code >}
     */
    @XmlElementDecl(namespace = "http://server/", name = "updateCD")
    public JAXBElement<UpdateCD> createUpdateCD(UpdateCD value) {
        return new JAXBElement<UpdateCD>(_UpdateCD_QNAME, UpdateCD.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link UpdateCDResponse }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link UpdateCDResponse }{@code >}
     */
    @XmlElementDecl(namespace = "http://server/", name = "updateCDResponse")
    public JAXBElement<UpdateCDResponse> createUpdateCDResponse(UpdateCDResponse value) {
        return new JAXBElement<UpdateCDResponse>(_UpdateCDResponse_QNAME, UpdateCDResponse.class, null, value);
    }

}
