
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

    private final static QName _AddCanzone_QNAME = new QName("http://bussiness.server/", "addCanzone");
    private final static QName _AddCanzoneResponse_QNAME = new QName("http://bussiness.server/", "addCanzoneResponse");
    private final static QName _Canzone_QNAME = new QName("http://bussiness.server/", "canzone");
    private final static QName _FindAll_QNAME = new QName("http://bussiness.server/", "findAll");
    private final static QName _FindAllResponse_QNAME = new QName("http://bussiness.server/", "findAllResponse");
    private final static QName _FindByCat_QNAME = new QName("http://bussiness.server/", "findByCat");
    private final static QName _FindByCatResponse_QNAME = new QName("http://bussiness.server/", "findByCatResponse");
    private final static QName _FindById_QNAME = new QName("http://bussiness.server/", "findById");
    private final static QName _FindByIdResponse_QNAME = new QName("http://bussiness.server/", "findByIdResponse");
    private final static QName _FindByVotes_QNAME = new QName("http://bussiness.server/", "findByVotes");
    private final static QName _FindByVotesResponse_QNAME = new QName("http://bussiness.server/", "findByVotesResponse");
    private final static QName _RemoveCanzone_QNAME = new QName("http://bussiness.server/", "removeCanzone");
    private final static QName _RemoveCanzoneResponse_QNAME = new QName("http://bussiness.server/", "removeCanzoneResponse");
    private final static QName _UpdateCanzone_QNAME = new QName("http://bussiness.server/", "updateCanzone");
    private final static QName _UpdateCanzoneResponse_QNAME = new QName("http://bussiness.server/", "updateCanzoneResponse");

    /**
     * Create a new ObjectFactory that can be used to create new instances of schema derived classes for package: client
     * 
     */
    public ObjectFactory() {
    }

    /**
     * Create an instance of {@link AddCanzone }
     * 
     */
    public AddCanzone createAddCanzone() {
        return new AddCanzone();
    }

    /**
     * Create an instance of {@link AddCanzoneResponse }
     * 
     */
    public AddCanzoneResponse createAddCanzoneResponse() {
        return new AddCanzoneResponse();
    }

    /**
     * Create an instance of {@link Canzone }
     * 
     */
    public Canzone createCanzone() {
        return new Canzone();
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
     * Create an instance of {@link FindByCat }
     * 
     */
    public FindByCat createFindByCat() {
        return new FindByCat();
    }

    /**
     * Create an instance of {@link FindByCatResponse }
     * 
     */
    public FindByCatResponse createFindByCatResponse() {
        return new FindByCatResponse();
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
     * Create an instance of {@link FindByVotes }
     * 
     */
    public FindByVotes createFindByVotes() {
        return new FindByVotes();
    }

    /**
     * Create an instance of {@link FindByVotesResponse }
     * 
     */
    public FindByVotesResponse createFindByVotesResponse() {
        return new FindByVotesResponse();
    }

    /**
     * Create an instance of {@link RemoveCanzone }
     * 
     */
    public RemoveCanzone createRemoveCanzone() {
        return new RemoveCanzone();
    }

    /**
     * Create an instance of {@link RemoveCanzoneResponse }
     * 
     */
    public RemoveCanzoneResponse createRemoveCanzoneResponse() {
        return new RemoveCanzoneResponse();
    }

    /**
     * Create an instance of {@link UpdateCanzone }
     * 
     */
    public UpdateCanzone createUpdateCanzone() {
        return new UpdateCanzone();
    }

    /**
     * Create an instance of {@link UpdateCanzoneResponse }
     * 
     */
    public UpdateCanzoneResponse createUpdateCanzoneResponse() {
        return new UpdateCanzoneResponse();
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link AddCanzone }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link AddCanzone }{@code >}
     */
    @XmlElementDecl(namespace = "http://bussiness.server/", name = "addCanzone")
    public JAXBElement<AddCanzone> createAddCanzone(AddCanzone value) {
        return new JAXBElement<AddCanzone>(_AddCanzone_QNAME, AddCanzone.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link AddCanzoneResponse }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link AddCanzoneResponse }{@code >}
     */
    @XmlElementDecl(namespace = "http://bussiness.server/", name = "addCanzoneResponse")
    public JAXBElement<AddCanzoneResponse> createAddCanzoneResponse(AddCanzoneResponse value) {
        return new JAXBElement<AddCanzoneResponse>(_AddCanzoneResponse_QNAME, AddCanzoneResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link Canzone }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link Canzone }{@code >}
     */
    @XmlElementDecl(namespace = "http://bussiness.server/", name = "canzone")
    public JAXBElement<Canzone> createCanzone(Canzone value) {
        return new JAXBElement<Canzone>(_Canzone_QNAME, Canzone.class, null, value);
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
     * Create an instance of {@link JAXBElement }{@code <}{@link FindByCat }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link FindByCat }{@code >}
     */
    @XmlElementDecl(namespace = "http://bussiness.server/", name = "findByCat")
    public JAXBElement<FindByCat> createFindByCat(FindByCat value) {
        return new JAXBElement<FindByCat>(_FindByCat_QNAME, FindByCat.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link FindByCatResponse }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link FindByCatResponse }{@code >}
     */
    @XmlElementDecl(namespace = "http://bussiness.server/", name = "findByCatResponse")
    public JAXBElement<FindByCatResponse> createFindByCatResponse(FindByCatResponse value) {
        return new JAXBElement<FindByCatResponse>(_FindByCatResponse_QNAME, FindByCatResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link FindById }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link FindById }{@code >}
     */
    @XmlElementDecl(namespace = "http://bussiness.server/", name = "findById")
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
    @XmlElementDecl(namespace = "http://bussiness.server/", name = "findByIdResponse")
    public JAXBElement<FindByIdResponse> createFindByIdResponse(FindByIdResponse value) {
        return new JAXBElement<FindByIdResponse>(_FindByIdResponse_QNAME, FindByIdResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link FindByVotes }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link FindByVotes }{@code >}
     */
    @XmlElementDecl(namespace = "http://bussiness.server/", name = "findByVotes")
    public JAXBElement<FindByVotes> createFindByVotes(FindByVotes value) {
        return new JAXBElement<FindByVotes>(_FindByVotes_QNAME, FindByVotes.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link FindByVotesResponse }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link FindByVotesResponse }{@code >}
     */
    @XmlElementDecl(namespace = "http://bussiness.server/", name = "findByVotesResponse")
    public JAXBElement<FindByVotesResponse> createFindByVotesResponse(FindByVotesResponse value) {
        return new JAXBElement<FindByVotesResponse>(_FindByVotesResponse_QNAME, FindByVotesResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link RemoveCanzone }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link RemoveCanzone }{@code >}
     */
    @XmlElementDecl(namespace = "http://bussiness.server/", name = "removeCanzone")
    public JAXBElement<RemoveCanzone> createRemoveCanzone(RemoveCanzone value) {
        return new JAXBElement<RemoveCanzone>(_RemoveCanzone_QNAME, RemoveCanzone.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link RemoveCanzoneResponse }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link RemoveCanzoneResponse }{@code >}
     */
    @XmlElementDecl(namespace = "http://bussiness.server/", name = "removeCanzoneResponse")
    public JAXBElement<RemoveCanzoneResponse> createRemoveCanzoneResponse(RemoveCanzoneResponse value) {
        return new JAXBElement<RemoveCanzoneResponse>(_RemoveCanzoneResponse_QNAME, RemoveCanzoneResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link UpdateCanzone }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link UpdateCanzone }{@code >}
     */
    @XmlElementDecl(namespace = "http://bussiness.server/", name = "updateCanzone")
    public JAXBElement<UpdateCanzone> createUpdateCanzone(UpdateCanzone value) {
        return new JAXBElement<UpdateCanzone>(_UpdateCanzone_QNAME, UpdateCanzone.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link UpdateCanzoneResponse }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link UpdateCanzoneResponse }{@code >}
     */
    @XmlElementDecl(namespace = "http://bussiness.server/", name = "updateCanzoneResponse")
    public JAXBElement<UpdateCanzoneResponse> createUpdateCanzoneResponse(UpdateCanzoneResponse value) {
        return new JAXBElement<UpdateCanzoneResponse>(_UpdateCanzoneResponse_QNAME, UpdateCanzoneResponse.class, null, value);
    }

}
