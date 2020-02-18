
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

    private final static QName _AddPezzo_QNAME = new QName("http://bussiness.server/", "addPezzo");
    private final static QName _AddPezzoResponse_QNAME = new QName("http://bussiness.server/", "addPezzoResponse");
    private final static QName _FindAll_QNAME = new QName("http://bussiness.server/", "findAll");
    private final static QName _FindAllResponse_QNAME = new QName("http://bussiness.server/", "findAllResponse");
    private final static QName _FindByCategory_QNAME = new QName("http://bussiness.server/", "findByCategory");
    private final static QName _FindByCategoryResponse_QNAME = new QName("http://bussiness.server/", "findByCategoryResponse");
    private final static QName _FindById_QNAME = new QName("http://bussiness.server/", "findById");
    private final static QName _FindByIdResponse_QNAME = new QName("http://bussiness.server/", "findByIdResponse");
    private final static QName _Pezzo_QNAME = new QName("http://bussiness.server/", "pezzo");
    private final static QName _RemovePezzo_QNAME = new QName("http://bussiness.server/", "removePezzo");
    private final static QName _RemovePezzoResponse_QNAME = new QName("http://bussiness.server/", "removePezzoResponse");
    private final static QName _UpdatePezzo_QNAME = new QName("http://bussiness.server/", "updatePezzo");
    private final static QName _UpdatePezzoResponse_QNAME = new QName("http://bussiness.server/", "updatePezzoResponse");

    /**
     * Create a new ObjectFactory that can be used to create new instances of schema derived classes for package: client
     * 
     */
    public ObjectFactory() {
    }

    /**
     * Create an instance of {@link AddPezzo }
     * 
     */
    public AddPezzo createAddPezzo() {
        return new AddPezzo();
    }

    /**
     * Create an instance of {@link AddPezzoResponse }
     * 
     */
    public AddPezzoResponse createAddPezzoResponse() {
        return new AddPezzoResponse();
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
     * Create an instance of {@link FindByCategory }
     * 
     */
    public FindByCategory createFindByCategory() {
        return new FindByCategory();
    }

    /**
     * Create an instance of {@link FindByCategoryResponse }
     * 
     */
    public FindByCategoryResponse createFindByCategoryResponse() {
        return new FindByCategoryResponse();
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
     * Create an instance of {@link Pezzo }
     * 
     */
    public Pezzo createPezzo() {
        return new Pezzo();
    }

    /**
     * Create an instance of {@link RemovePezzo }
     * 
     */
    public RemovePezzo createRemovePezzo() {
        return new RemovePezzo();
    }

    /**
     * Create an instance of {@link RemovePezzoResponse }
     * 
     */
    public RemovePezzoResponse createRemovePezzoResponse() {
        return new RemovePezzoResponse();
    }

    /**
     * Create an instance of {@link UpdatePezzo }
     * 
     */
    public UpdatePezzo createUpdatePezzo() {
        return new UpdatePezzo();
    }

    /**
     * Create an instance of {@link UpdatePezzoResponse }
     * 
     */
    public UpdatePezzoResponse createUpdatePezzoResponse() {
        return new UpdatePezzoResponse();
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link AddPezzo }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link AddPezzo }{@code >}
     */
    @XmlElementDecl(namespace = "http://bussiness.server/", name = "addPezzo")
    public JAXBElement<AddPezzo> createAddPezzo(AddPezzo value) {
        return new JAXBElement<AddPezzo>(_AddPezzo_QNAME, AddPezzo.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link AddPezzoResponse }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link AddPezzoResponse }{@code >}
     */
    @XmlElementDecl(namespace = "http://bussiness.server/", name = "addPezzoResponse")
    public JAXBElement<AddPezzoResponse> createAddPezzoResponse(AddPezzoResponse value) {
        return new JAXBElement<AddPezzoResponse>(_AddPezzoResponse_QNAME, AddPezzoResponse.class, null, value);
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
     * Create an instance of {@link JAXBElement }{@code <}{@link FindByCategory }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link FindByCategory }{@code >}
     */
    @XmlElementDecl(namespace = "http://bussiness.server/", name = "findByCategory")
    public JAXBElement<FindByCategory> createFindByCategory(FindByCategory value) {
        return new JAXBElement<FindByCategory>(_FindByCategory_QNAME, FindByCategory.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link FindByCategoryResponse }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link FindByCategoryResponse }{@code >}
     */
    @XmlElementDecl(namespace = "http://bussiness.server/", name = "findByCategoryResponse")
    public JAXBElement<FindByCategoryResponse> createFindByCategoryResponse(FindByCategoryResponse value) {
        return new JAXBElement<FindByCategoryResponse>(_FindByCategoryResponse_QNAME, FindByCategoryResponse.class, null, value);
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
     * Create an instance of {@link JAXBElement }{@code <}{@link Pezzo }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link Pezzo }{@code >}
     */
    @XmlElementDecl(namespace = "http://bussiness.server/", name = "pezzo")
    public JAXBElement<Pezzo> createPezzo(Pezzo value) {
        return new JAXBElement<Pezzo>(_Pezzo_QNAME, Pezzo.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link RemovePezzo }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link RemovePezzo }{@code >}
     */
    @XmlElementDecl(namespace = "http://bussiness.server/", name = "removePezzo")
    public JAXBElement<RemovePezzo> createRemovePezzo(RemovePezzo value) {
        return new JAXBElement<RemovePezzo>(_RemovePezzo_QNAME, RemovePezzo.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link RemovePezzoResponse }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link RemovePezzoResponse }{@code >}
     */
    @XmlElementDecl(namespace = "http://bussiness.server/", name = "removePezzoResponse")
    public JAXBElement<RemovePezzoResponse> createRemovePezzoResponse(RemovePezzoResponse value) {
        return new JAXBElement<RemovePezzoResponse>(_RemovePezzoResponse_QNAME, RemovePezzoResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link UpdatePezzo }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link UpdatePezzo }{@code >}
     */
    @XmlElementDecl(namespace = "http://bussiness.server/", name = "updatePezzo")
    public JAXBElement<UpdatePezzo> createUpdatePezzo(UpdatePezzo value) {
        return new JAXBElement<UpdatePezzo>(_UpdatePezzo_QNAME, UpdatePezzo.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link UpdatePezzoResponse }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link UpdatePezzoResponse }{@code >}
     */
    @XmlElementDecl(namespace = "http://bussiness.server/", name = "updatePezzoResponse")
    public JAXBElement<UpdatePezzoResponse> createUpdatePezzoResponse(UpdatePezzoResponse value) {
        return new JAXBElement<UpdatePezzoResponse>(_UpdatePezzoResponse_QNAME, UpdatePezzoResponse.class, null, value);
    }

}
