package pl.javastart.springjpaboot.dao;

import org.springframework.stereotype.Repository;
import pl.javastart.springjpaboot.model.Book;

import javax.persistence.*;
import javax.transaction.Transactional;

// to samo co component - spring dodaje go do
// konteneru i mozemy go pobierac do zaleznosci
@Repository
public class BookDaoImpl implements BookDao{

    // automatycznie wstrzykiwana zależność
    @PersistenceContext
    private EntityManager entityManager;

    public BookDaoImpl() {
    }

    @Override
    @Transactional
    public void save(Book book) {
        EntityTransaction transaction = entityManager.getTransaction();
        transaction.begin();
        entityManager.persist(book);
        transaction.commit();
    }

    @Override
    public Book get(Long id) {
        Book book = entityManager.find(Book.class, id);
        return book;
    }
}
