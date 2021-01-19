package pl.javastart.springjpaboot.dao;

import org.springframework.stereotype.Repository;
import pl.javastart.springjpaboot.model.Book;

import javax.persistence.*;
import javax.transaction.Transactional;

// to samo co component - spring dodaje go do
// konteneru i mozemy go pobierac do zaleznosci
@Repository
public class BookDaoImpl implements BookDao{

    // automatycznie wstrzykiwana zależność co pozwala nam na brak powtarzalnego kodu - entityFactory
    @PersistenceContext
    private EntityManager entityManager;

    public BookDaoImpl() {
    }

    @Override
    @Transactional
    public void save(Book book) {
        entityManager.persist(book);
    }

    /*
    Metoda merge() w pierwszej kolejności odpytuje bazę danych sprawdzając,
    czy obiekt o wskazanym kluczu głównym na pewno w niej istnieje.
    Jeżeli tak jest wykonywana jest aktualizacja. Jeżeli obiekt o wskazanym kluczu
     nie został odnaleziony metoda merge() umieści w bazie nowy rekord (zachowanie podobne do metody persist())
     */
    @Override
    @Transactional
    public Book get(Long id) {
        return entityManager.find(Book.class, id);
    }

    @Override
    @Transactional
    public void update(Book book) {
        //przekazany obiekt book musi mieć ustawiony klucz główny
        //na jego podstawie następuje "scalenie" danych
        entityManager.merge(book);

//        // wyszukujemy obiekt w bazie
//        Book find = entityManager.find(Book.class, book.getId());
//        if (find != null) {
//            find.setTitle(book.getTitle());
//            find.setIsbn(book.getIsbn());
//            find.setAuthor(book.getAuthor());
//        }
    }

    @Override
    @Transactional
    public void remove(Long bookId) {
        Book book = entityManager.find(Book.class, bookId);
        entityManager.remove(book);
    }
}
