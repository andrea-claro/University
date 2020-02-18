
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

    private final static QName _AddMuseum_QNAME = new QName("http://business.server/", "addMuseum");
    private final static QName _AddMuseumResponse_QNAME = new QName("http://business.server/", "addMuseumResponse");
    private final static QName _FindAll_QNAME = new QName("http://business.server/", "findAll");
    private final static QName _FindAllResponse_QNAME = new QName("http://business.server/", "findAllResponse");
    private final static QName _FindById_QNAME = new QName("http://business.server/", "findById");
    private final static QName _FindByIdResponse_QNAME = new QName("http://business.server/", "findByIdResponse");
    private final static QName _FindByRegion_QNAME = new QName("http://business.server/", "findByRegion");
    private final static QName _FindByRegionResponse_QNAME = new QName("http://business.server/", "findByRegionResponse");
    private final static QName _Museum_QNAME = new QName("http://business.server/", "museum");
    private final static QName _RemoveMuseum_QNAME = new QName("http://business.server/", "removeMuseum");
    private final static QName _RemoveMuseumResponse_QNAME = new QName("http://business.server/", "removeMuseumResponse");
    private final static QName _UpdateMuseum_QNAME = new QName("http://business.server/", "updateMuseum");
    private final static QName _UpdateMuseumResponse_QNAME = new QName("http://business.server/", "updateMuseumResponse");

    /**
     * Create a new ObjectFactory that can be used to create new instances of schema derived classes for package: client
     * 
     */
    public ObjectFactory() {
    }

    /**
     * Create an instance of {@link AddMuseum }
     * 
     */
    public AddMuseum createAddMuseum() {
        return new AddMuseum();
    }

    /**
     * Create an instance of {@link AddMuseumResponse }
     * 
     */
    public AddMuseumResponse createAddMuseumResponse() {
        return new AddMuseumResponse();
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
     * Create an instance of {@link FindByRegion }
     * 
     */
    public FindByRegion createFindByRegion() {
        return new FindByRegion();
    }

    /**
     * Create an instance of {@link FindByRegionResponse }
     * 
     */
    public FindByRegionResponse createFindByRegionResponse() {
        return new FindByRegionResponse();
    }

    /**
     * Create an instance of {@link Museum }
     * 
     */
    public Museum createMuseum() {
        return new Museum();
    }

    /**
     * Create an instance of {@link RemoveMuseum }
     * 
     */
    public RemoveMuseum createRemoveMuseum() {
        return new RemoveMuseum();
    }

    /**
     * Create an instance of {@link RemoveMuseumResponse }
     * 
     */
    public RemoveMuseumResponse createRemoveMuseumResponse() {
        return new RemoveMuseumResponse();
    }

    /**
     * Create an instance of {@link UpdateMuseum }
     * 
     */
    public UpdateMuseum createUpdateMuseum() {
        return new UpdateMuseum();
    }

    /**
     * Create an instance of {@link UpdateMuseumResponse }
     * 
     */
    public UpdateMuseumResponse createUpdateMuseumResponse() {
        return new UpdateMuseumResponse();
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link AddMuseum }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link AddMuseum }{@code >}
     */
    @XmlElementDecl(namespace = "http://business.server/", name = "addMuseum")
    public JAXBElement<AddMuseum> createAddMuseum(AddMuseum value) {
        return new JAXBElement<AddMuseum>(_AddMuseum_QNAME, AddMuseum.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link AddMuseumResponse }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link AddMuseumResponse }{@code >}
     */
    @XmlElementDecl(namespace = "http://business.server/", name = "addMuseumResponse")
    public JAXBElement<AddMuseumResponse> createAddMuseumResponse(AddMuseumResponse value) {
        return new JAXBElement<AddMuseumResponse>(_AddMuseumResponse_QNAME, AddMuseumResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link FindAll }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link FindAll }{@code >}
     */
    @XmlElementDecl(namespace = "http://business.server/", name = "findAll")
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
    @XmlElementDecl(namespace = "http://business.server/", name = "findAllResponse")
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
    @XmlElementDecl(namespace = "http://business.server/", name = "findById")
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
    @XmlElementDecl(namespace = "http://business.server/", name = "findByIdResponse")
    public JAXBElement<FindByIdResponse> createFindByIdResponse(FindByIdResponse value) {
        return new JAXBElement<FindByIdResponse>(_FindByIdResponse_QNAME, FindByIdResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link FindByRegion }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link FindByRegion }{@code >}
     */
    @XmlElementDecl(namespace = "http://business.server/", name = "findByRegion")
    public JAXBElement<FindByRegion> createFindByRegion(FindByRegion value) {
        return new JAXBElement<FindByRegion>(_FindByRegion_QNAME, FindByRegion.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link FindByRegionResponse }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link FindByRegionResponse }{@code >}
     */
    @XmlElementDecl(namespace = "http://business.server/", name = "findByRegionResponse")
    public JAXBElement<FindByRegionResponse> createFindByRegionResponse(FindByRegionResponse value) {
        return new JAXBElement<FindByRegionResponse>(_FindByRegionResponse_QNAME, FindByRegionResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link Museum }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link Museum }{@code >}
     */
    @XmlElementDecl(namespace = "http://business.server/", name = "museum")
    public JAXBElement<Museum> createMuseum(Museum value) {
        return new JAXBElement<Museum>(_Museum_QNAME, Museum.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link RemoveMuseum }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link RemoveMuseum }{@code >}
     */
    @XmlElementDecl(namespace = "http://business.server/", name = "removeMuseum")
    public JAXBElement<RemoveMuseum> createRemoveMuseum(RemoveMuseum value) {
        return new JAXBElement<RemoveMuseum>(_RemoveMuseum_QNAME, RemoveMuseum.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link RemoveMuseumResponse }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link RemoveMuseumResponse }{@code >}
     */
    @XmlElementDecl(namespace = "http://business.server/", name = "removeMuseumResponse")
    public JAXBElement<RemoveMuseumResponse> createRemoveMuseumResponse(RemoveMuseumResponse value) {
        return new JAXBElement<RemoveMuseumResponse>(_RemoveMuseumResponse_QNAME, RemoveMuseumResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link UpdateMuseum }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link UpdateMuseum }{@code >}
     */
    @XmlElementDecl(namespace = "http://business.server/", name = "updateMuseum")
    public JAXBElement<UpdateMuseum> createUpdateMuseum(UpdateMuseum value) {
        return new JAXBElement<UpdateMuseum>(_UpdateMuseum_QNAME, UpdateMuseum.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link UpdateMuseumResponse }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link UpdateMuseumResponse }{@code >}
     */
    @XmlElementDecl(namespace = "http://business.server/", name = "updateMuseumResponse")
    public JAXBElement<UpdateMuseumResponse> createUpdateMuseumResponse(UpdateMuseumResponse value) {
        return new JAXBElement<UpdateMuseumResponse>(_UpdateMuseumResponse_QNAME, UpdateMuseumResponse.class, null, value);
    }

}
