package pl.javastart.springjpaboot.model;

import javax.persistence.*;
import java.io.Serializable;

@Entity
public class Book implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    /*AUTO - provider JPA samodzielnie dobiera strategię
IDENTITY - klucz generowany jest po stronie bazy danych na podstawie kolumny o automatycznej inkrementacji wartości. W przypadku MySQL kolumna taka posiada własność auto_increment.
SEQUENCE - klucz generowany jest po stronie bazy danych z wykorzystaniem sekwencji
TABLE - klucz generowany z pomocą dodatkowej tabeli zarządzaną przez providera JPA. W przypadku Hibernate tabela ta nazywa się domyślnie hibernate_sequence*/
    private Long id;
    private String isbn;
    @Transient
    private String title;
    private String author;

    public Book(){}

    public Book(String isbn, String title, String author) {
        this.isbn = isbn;
        this.title = title;
        this.author = author;
    }

    public Long getId() {
        System.out.println(">>>>>>>>>Get Id");
        return id;
    }

    public void setId(Long id) {
        System.out.println("<<<<<<<<<<<<<<<<<<<<<Set id");
        this.id = id;
    }

    public String getIsbn() {
        return isbn;
    }

    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    @Override
    public String toString() {
        return "Book [id=" + id + ", isbn="
                + isbn + ", title=" + title + ", author=" + author + "]";
    }
}
