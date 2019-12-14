package bookejb;

import java.util.List;
import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import javax.ejb.LocalBean;

@Stateless
@LocalBean
public class BookEJB implements BookEJBRemote {
    @Inject
    private EntityManager em;
    
    @Override
    public List<Book> findBooks() {
        TypedQuery<Book> query = em.createNamedQuery(Book.FIND_ALL,Book.class);
        return query.getResultList();
    }

    @Override
    public Book createBook( Book book) {
        em.persist(book);
        return book;
    }

    @Override
    public void deleteBook(Book book) {
        em.remove(em.merge(book));
    }

    @Override
    public Book updateBook(Book book) {
        return em.merge(book);
    }
}
