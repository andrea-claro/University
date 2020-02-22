package book_server;

import java.util.List;
import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.jws.WebService;
import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

@WebService
@Stateless
@LocalBean
public class BookEJB implements BookEJBRemote{
    
    @Inject
    private EntityManager em;
    
    public BookEJB(){
 
    }

    @Override
    public void addBook(Book book) {
        em.persist(book);
    }

    @Override
    public void removeBook(Book book) {
        em.remove(book);
    }

    @Override
    public List<Book> findAll() {
        TypedQuery<Book> query = em.createNamedQuery(Book.FIND_ALL, Book.class);
        return query.getResultList();
    }

    @Override
    public Book findById(String id) {
        TypedQuery<Book> query = em.createNamedQuery(Book.FIND_BYID, Book.class);
        query.setParameter(1, id);
        return query.getSingleResult();
    }

    @Override
    public void updateBook(Book book) {
        em.merge(book);
    }
}