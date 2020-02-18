
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

    private final static QName _AddGelato_QNAME = new QName("http://bussiness.server/", "addGelato");
    private final static QName _AddGelatoResponse_QNAME = new QName("http://bussiness.server/", "addGelatoResponse");
    private final static QName _FindAll_QNAME = new QName("http://bussiness.server/", "findAll");
    private final static QName _FindAllResponse_QNAME = new QName("http://bussiness.server/", "findAllResponse");
    private final static QName _FindByName_QNAME = new QName("http://bussiness.server/", "findByName");
    private final static QName _FindByNameResponse_QNAME = new QName("http://bussiness.server/", "findByNameResponse");
    private final static QName _FindByPrice_QNAME = new QName("http://bussiness.server/", "findByPrice");
    private final static QName _FindByPriceResponse_QNAME = new QName("http://bussiness.server/", "findByPriceResponse");
    private final static QName _Gelato_QNAME = new QName("http://bussiness.server/", "gelato");
    private final static QName _RemoveGelato_QNAME = new QName("http://bussiness.server/", "removeGelato");
    private final static QName _RemoveGelatoResponse_QNAME = new QName("http://bussiness.server/", "removeGelatoResponse");
    private final static QName _UpdateGelato_QNAME = new QName("http://bussiness.server/", "updateGelato");
    private final static QName _UpdateGelatoResponse_QNAME = new QName("http://bussiness.server/", "updateGelatoResponse");

    /**
     * Create a new ObjectFactory that can be used to create new instances of schema derived classes for package: client
     * 
     */
    public ObjectFactory() {
    }

    /**
     * Create an instance of {@link AddGelato }
     * 
     */
    public AddGelato createAddGelato() {
        return new AddGelato();
    }

    /**
     * Create an instance of {@link AddGelatoResponse }
     * 
     */
    public AddGelatoResponse createAddGelatoResponse() {
        return new AddGelatoResponse();
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
     * Create an instance of {@link FindByName }
     * 
     */
    public FindByName createFindByName() {
        return new FindByName();
    }

    /**
     * Create an instance of {@link FindByNameResponse }
     * 
     */
    public FindByNameResponse createFindByNameResponse() {
        return new FindByNameResponse();
    }

    /**
     * Create an instance of {@link FindByPrice }
     * 
     */
    public FindByPrice createFindByPrice() {
        return new FindByPrice();
    }

    /**
     * Create an instance of {@link FindByPriceResponse }
     * 
     */
    public FindByPriceResponse createFindByPriceResponse() {
        return new FindByPriceResponse();
    }

    /**
     * Create an instance of {@link Gelato }
     * 
     */
    public Gelato createGelato() {
        return new Gelato();
    }

    /**
     * Create an instance of {@link RemoveGelato }
     * 
     */
    public RemoveGelato createRemoveGelato() {
        return new RemoveGelato();
    }

    /**
     * Create an instance of {@link RemoveGelatoResponse }
     * 
     */
    public RemoveGelatoResponse createRemoveGelatoResponse() {
        return new RemoveGelatoResponse();
    }

    /**
     * Create an instance of {@link UpdateGelato }
     * 
     */
    public UpdateGelato createUpdateGelato() {
        return new UpdateGelato();
    }

    /**
     * Create an instance of {@link UpdateGelatoResponse }
     * 
     */
    public UpdateGelatoResponse createUpdateGelatoResponse() {
        return new UpdateGelatoResponse();
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link AddGelato }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link AddGelato }{@code >}
     */
    @XmlElementDecl(namespace = "http://bussiness.server/", name = "addGelato")
    public JAXBElement<AddGelato> createAddGelato(AddGelato value) {
        return new JAXBElement<AddGelato>(_AddGelato_QNAME, AddGelato.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link AddGelatoResponse }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link AddGelatoResponse }{@code >}
     */
    @XmlElementDecl(namespace = "http://bussiness.server/", name = "addGelatoResponse")
    public JAXBElement<AddGelatoResponse> createAddGelatoResponse(AddGelatoResponse value) {
        return new JAXBElement<AddGelatoResponse>(_AddGelatoResponse_QNAME, AddGelatoResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link FindAll }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link FindAll }{@code >}
     */
    @XmlElementDecl(namespace = "http://bussiness.server/", name = "findAll")
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
    @XmlElementDecl(namespace = "http://bussiness.server/", name = "findAllResponse")
    public JAXBElement<FindAllResponse> createFindAllResponse(FindAllResponse value) {
        return new JAXBElement<FindAllResponse>(_FindAllResponse_QNAME, FindAllResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link FindByName }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link FindByName }{@code >}
     */
    @XmlElementDecl(namespace = "http://bussiness.server/", name = "findByName")
    public JAXBElement<FindByName> createFindByName(FindByName value) {
        return new JAXBElement<FindByName>(_FindByName_QNAME, FindByName.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link FindByNameResponse }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link FindByNameResponse }{@code >}
     */
    @XmlElementDecl(namespace = "http://bussiness.server/", name = "findByNameResponse")
    public JAXBElement<FindByNameResponse> createFindByNameResponse(FindByNameResponse value) {
        return new JAXBElement<FindByNameResponse>(_FindByNameResponse_QNAME, FindByNameResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link FindByPrice }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link FindByPrice }{@code >}
     */
    @XmlElementDecl(namespace = "http://bussiness.server/", name = "findByPrice")
    public JAXBElement<FindByPrice> createFindByPrice(FindByPrice value) {
        return new JAXBElement<FindByPrice>(_FindByPrice_QNAME, FindByPrice.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link FindByPriceResponse }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link FindByPriceResponse }{@code >}
     */
    @XmlElementDecl(namespace = "http://bussiness.server/", name = "findByPriceResponse")
    public JAXBElement<FindByPriceResponse> createFindByPriceResponse(FindByPriceResponse value) {
        return new JAXBElement<FindByPriceResponse>(_FindByPriceResponse_QNAME, FindByPriceResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link Gelato }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link Gelato }{@code >}
     */
    @XmlElementDecl(namespace = "http://bussiness.server/", name = "gelato")
    public JAXBElement<Gelato> createGelato(Gelato value) {
        return new JAXBElement<Gelato>(_Gelato_QNAME, Gelato.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link RemoveGelato }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link RemoveGelato }{@code >}
     */
    @XmlElementDecl(namespace = "http://bussiness.server/", name = "removeGelato")
    public JAXBElement<RemoveGelato> createRemoveGelato(RemoveGelato value) {
        return new JAXBElement<RemoveGelato>(_RemoveGelato_QNAME, RemoveGelato.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link RemoveGelatoResponse }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link RemoveGelatoResponse }{@code >}
     */
    @XmlElementDecl(namespace = "http://bussiness.server/", name = "removeGelatoResponse")
    public JAXBElement<RemoveGelatoResponse> createRemoveGelatoResponse(RemoveGelatoResponse value) {
        return new JAXBElement<RemoveGelatoResponse>(_RemoveGelatoResponse_QNAME, RemoveGelatoResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link UpdateGelato }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link UpdateGelato }{@code >}
     */
    @XmlElementDecl(namespace = "http://bussiness.server/", name = "updateGelato")
    public JAXBElement<UpdateGelato> createUpdateGelato(UpdateGelato value) {
        return new JAXBElement<UpdateGelato>(_UpdateGelato_QNAME, UpdateGelato.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link UpdateGelatoResponse }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link UpdateGelatoResponse }{@code >}
     */
    @XmlElementDecl(namespace = "http://bussiness.server/", name = "updateGelatoResponse")
    public JAXBElement<UpdateGelatoResponse> createUpdateGelatoResponse(UpdateGelatoResponse value) {
        return new JAXBElement<UpdateGelatoResponse>(_UpdateGelatoResponse_QNAME, UpdateGelatoResponse.class, null, value);
    }

}
