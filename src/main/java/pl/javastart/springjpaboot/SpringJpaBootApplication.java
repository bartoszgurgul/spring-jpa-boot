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
        BookDao bookDao = context.getBean(BookDao.class);

        //zapis
        Book book = new Book("12345678", "Spring is ok", "Java start");
        bookDao.save(book);

        //odczyt
        Book book1 = bookDao.get(1L);
        System.out.println(book1);

        Thread.sleep(5000);
    }

}
