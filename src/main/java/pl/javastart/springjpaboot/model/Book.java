package pl.javastart.springjpaboot.model;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "books") // taka adnotacja pozwala nam na wrzucenie osobnej nazwy indywidaunej do DB. Ułatwia to prace z tabelami typu t_tds_vdi_t_cards_pl
public class Book implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    /*AUTO -    provider JPA samodzielnie dobiera strategię
    IDENTITY -  klucz generowany jest po stronie bazy danych na podstawie kolumny o automatycznej inkrementacji wartości. W przypadku MySQL kolumna taka posiada własność auto_increment.
    SEQUENCE -  klucz generowany jest po stronie bazy danych z wykorzystaniem sekwencji
    TABLE -     klucz generowany z pomocą dodatkowej tabeli zarządzaną przez providera JPA. W przypadku Hibernate tabela ta nazywa się domyślnie hibernate_sequence*/
    @Column(name = "book_id") // nadawanie indywudualnej nazwy na kolumny w celu unikniecia dbilnch nazw typu id_t_vds_column_I_pl
    private Long id;
    @Column(nullable = false, length = 13, unique = true)
    private String isbn;
    //@Transient to by nam oznaczało że ma nie być wrzucony do bazy danych a to juz zle
    @Column(nullable = false)
    private String title;
    @Column(nullable = false)
    private String author;

    @PrePersist
    public void prePersist(){
        System.out.println(">>>> Zapis obiektu " + this.toString());
    }
    @PostPersist
    public void postPersist(){
        System.out.println("<<<< Zapisano obiekt " + this.toString());
    }
    /* pozostałe adnotacje do używania wczasnie zycia encji
    @PrePersist, @PreUpdate, @PreRemove
    @PostLoad, @PostPersist, @PostUpdate, @PostRemove
     */

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
