package pl.javastart.springjpaboot.dao;


import pl.javastart.springjpaboot.model.Book;

public interface BookDao {
    public void save(Book book);
    public Book get(Long id);
    public void update(Book book);
    public void remove(Long bookId);
}
