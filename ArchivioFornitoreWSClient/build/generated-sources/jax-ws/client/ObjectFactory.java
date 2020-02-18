
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

    private final static QName _AddFornitore_QNAME = new QName("http://businness.server/", "addFornitore");
    private final static QName _AddFornitoreResponse_QNAME = new QName("http://businness.server/", "addFornitoreResponse");
    private final static QName _FindAll_QNAME = new QName("http://businness.server/", "findAll");
    private final static QName _FindAllResponse_QNAME = new QName("http://businness.server/", "findAllResponse");
    private final static QName _FindById_QNAME = new QName("http://businness.server/", "findById");
    private final static QName _FindByIdResponse_QNAME = new QName("http://businness.server/", "findByIdResponse");
    private final static QName _FindByMaxOrd_QNAME = new QName("http://businness.server/", "findByMaxOrd");
    private final static QName _FindByMaxOrdResponse_QNAME = new QName("http://businness.server/", "findByMaxOrdResponse");
    private final static QName _FindBySurname_QNAME = new QName("http://businness.server/", "findBySurname");
    private final static QName _FindBySurnameResponse_QNAME = new QName("http://businness.server/", "findBySurnameResponse");
    private final static QName _RemoveFornitore_QNAME = new QName("http://businness.server/", "removeFornitore");
    private final static QName _RemoveFornitoreResponse_QNAME = new QName("http://businness.server/", "removeFornitoreResponse");
    private final static QName _UpdateFornitore_QNAME = new QName("http://businness.server/", "updateFornitore");
    private final static QName _UpdateFornitoreResponse_QNAME = new QName("http://businness.server/", "updateFornitoreResponse");

    /**
     * Create a new ObjectFactory that can be used to create new instances of schema derived classes for package: client
     * 
     */
    public ObjectFactory() {
    }

    /**
     * Create an instance of {@link AddFornitore }
     * 
     */
    public AddFornitore createAddFornitore() {
        return new AddFornitore();
    }

    /**
     * Create an instance of {@link AddFornitoreResponse }
     * 
     */
    public AddFornitoreResponse createAddFornitoreResponse() {
        return new AddFornitoreResponse();
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
     * Create an instance of {@link FindByMaxOrd }
     * 
     */
    public FindByMaxOrd createFindByMaxOrd() {
        return new FindByMaxOrd();
    }

    /**
     * Create an instance of {@link FindByMaxOrdResponse }
     * 
     */
    public FindByMaxOrdResponse createFindByMaxOrdResponse() {
        return new FindByMaxOrdResponse();
    }

    /**
     * Create an instance of {@link FindBySurname }
     * 
     */
    public FindBySurname createFindBySurname() {
        return new FindBySurname();
    }

    /**
     * Create an instance of {@link FindBySurnameResponse }
     * 
     */
    public FindBySurnameResponse createFindBySurnameResponse() {
        return new FindBySurnameResponse();
    }

    /**
     * Create an instance of {@link RemoveFornitore }
     * 
     */
    public RemoveFornitore createRemoveFornitore() {
        return new RemoveFornitore();
    }

    /**
     * Create an instance of {@link RemoveFornitoreResponse }
     * 
     */
    public RemoveFornitoreResponse createRemoveFornitoreResponse() {
        return new RemoveFornitoreResponse();
    }

    /**
     * Create an instance of {@link UpdateFornitore }
     * 
     */
    public UpdateFornitore createUpdateFornitore() {
        return new UpdateFornitore();
    }

    /**
     * Create an instance of {@link UpdateFornitoreResponse }
     * 
     */
    public UpdateFornitoreResponse createUpdateFornitoreResponse() {
        return new UpdateFornitoreResponse();
    }

    /**
     * Create an instance of {@link Fornitore }
     * 
     */
    public Fornitore createFornitore() {
        return new Fornitore();
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link AddFornitore }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link AddFornitore }{@code >}
     */
    @XmlElementDecl(namespace = "http://businness.server/", name = "addFornitore")
    public JAXBElement<AddFornitore> createAddFornitore(AddFornitore value) {
        return new JAXBElement<AddFornitore>(_AddFornitore_QNAME, AddFornitore.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link AddFornitoreResponse }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link AddFornitoreResponse }{@code >}
     */
    @XmlElementDecl(namespace = "http://businness.server/", name = "addFornitoreResponse")
    public JAXBElement<AddFornitoreResponse> createAddFornitoreResponse(AddFornitoreResponse value) {
        return new JAXBElement<AddFornitoreResponse>(_AddFornitoreResponse_QNAME, AddFornitoreResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link FindAll }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link FindAll }{@code >}
     */
    @XmlElementDecl(namespace = "http://businness.server/", name = "findAll")
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
    @XmlElementDecl(namespace = "http://businness.server/", name = "findAllResponse")
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
    @XmlElementDecl(namespace = "http://businness.server/", name = "findById")
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
    @XmlElementDecl(namespace = "http://businness.server/", name = "findByIdResponse")
    public JAXBElement<FindByIdResponse> createFindByIdResponse(FindByIdResponse value) {
        return new JAXBElement<FindByIdResponse>(_FindByIdResponse_QNAME, FindByIdResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link FindByMaxOrd }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link FindByMaxOrd }{@code >}
     */
    @XmlElementDecl(namespace = "http://businness.server/", name = "findByMaxOrd")
    public JAXBElement<FindByMaxOrd> createFindByMaxOrd(FindByMaxOrd value) {
        return new JAXBElement<FindByMaxOrd>(_FindByMaxOrd_QNAME, FindByMaxOrd.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link FindByMaxOrdResponse }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link FindByMaxOrdResponse }{@code >}
     */
    @XmlElementDecl(namespace = "http://businness.server/", name = "findByMaxOrdResponse")
    public JAXBElement<FindByMaxOrdResponse> createFindByMaxOrdResponse(FindByMaxOrdResponse value) {
        return new JAXBElement<FindByMaxOrdResponse>(_FindByMaxOrdResponse_QNAME, FindByMaxOrdResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link FindBySurname }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link FindBySurname }{@code >}
     */
    @XmlElementDecl(namespace = "http://businness.server/", name = "findBySurname")
    public JAXBElement<FindBySurname> createFindBySurname(FindBySurname value) {
        return new JAXBElement<FindBySurname>(_FindBySurname_QNAME, FindBySurname.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link FindBySurnameResponse }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link FindBySurnameResponse }{@code >}
     */
    @XmlElementDecl(namespace = "http://businness.server/", name = "findBySurnameResponse")
    public JAXBElement<FindBySurnameResponse> createFindBySurnameResponse(FindBySurnameResponse value) {
        return new JAXBElement<FindBySurnameResponse>(_FindBySurnameResponse_QNAME, FindBySurnameResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link RemoveFornitore }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link RemoveFornitore }{@code >}
     */
    @XmlElementDecl(namespace = "http://businness.server/", name = "removeFornitore")
    public JAXBElement<RemoveFornitore> createRemoveFornitore(RemoveFornitore value) {
        return new JAXBElement<RemoveFornitore>(_RemoveFornitore_QNAME, RemoveFornitore.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link RemoveFornitoreResponse }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link RemoveFornitoreResponse }{@code >}
     */
    @XmlElementDecl(namespace = "http://businness.server/", name = "removeFornitoreResponse")
    public JAXBElement<RemoveFornitoreResponse> createRemoveFornitoreResponse(RemoveFornitoreResponse value) {
        return new JAXBElement<RemoveFornitoreResponse>(_RemoveFornitoreResponse_QNAME, RemoveFornitoreResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link UpdateFornitore }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link UpdateFornitore }{@code >}
     */
    @XmlElementDecl(namespace = "http://businness.server/", name = "updateFornitore")
    public JAXBElement<UpdateFornitore> createUpdateFornitore(UpdateFornitore value) {
        return new JAXBElement<UpdateFornitore>(_UpdateFornitore_QNAME, UpdateFornitore.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link UpdateFornitoreResponse }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link UpdateFornitoreResponse }{@code >}
     */
    @XmlElementDecl(namespace = "http://businness.server/", name = "updateFornitoreResponse")
    public JAXBElement<UpdateFornitoreResponse> createUpdateFornitoreResponse(UpdateFornitoreResponse value) {
        return new JAXBElement<UpdateFornitoreResponse>(_UpdateFornitoreResponse_QNAME, UpdateFornitoreResponse.class, null, value);
    }

}
