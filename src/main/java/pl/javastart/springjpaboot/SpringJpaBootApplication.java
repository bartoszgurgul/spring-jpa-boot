package pl.javastart.springjpaboot;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import pl.javastart.springjpaboot.dao.BookDao;
import pl.javastart.springjpaboot.model.Book;

@SpringBootApplication
public class SpringJpaBootApplication {

    public static void main(String[] args) throws InterruptedException {

        ConfigurableApplicationContext context = SpringApplication.run(SpringJpaBootApplication.class, args);

        // CREATE
        BookDao dao = context.getBean(BookDao.class);
        Book book = new Book("1234567890468", "Spring is so cool", "Javastart");
        dao.save(book);

        // UPDATE
        Book book2 = new Book("987654321", "Spring is NOT so cool", "Javastart");
        book2.setId(1L);
        dao.update(book2);

        //READ
        Book book1 = dao.get(1L);
        System.out.println(book1);

        //DELETE
        dao.remove(1L);

    }

}
