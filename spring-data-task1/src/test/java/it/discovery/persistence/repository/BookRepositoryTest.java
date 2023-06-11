package it.discovery.persistence.repository;

import io.zonky.test.db.AutoConfigureEmbeddedDatabase;
import it.discovery.persistence.model.*;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

@DataJpaTest
@AutoConfigureEmbeddedDatabase
class BookRepositoryTest {

    @Autowired
    BookRepository bookRepository;

    @Test
    void save_bookWithPublisher_success() {
        Book book = createBook();
        bookRepository.save(book);

        List<Book> books = bookRepository.findAll();
        assertEquals(1, books.size());
        assertEquals("Spring Data JPA 3", books.get(0).getName());
    }

    @Test
    void findAll_bookExists_success() {
    }

    @Test
    void findTotalPage_bookExists_success() {
    }

    private Book createBook() {
        Book book = new Book();
        book.setName("Spring Data JPA 3");
        book.setPages(100);

        Publisher publisher = new Publisher();
        publisher.setName("Packt");
        publisher.setAddress(Address.builder().apartment(100).build());
        book.setPublisher(publisher);

        Person author = new Person();
        author.setName("Gavin King");
        book.setAuthor(author);

        Hit hit = new Hit();
        hit.setBrowser("Chrome");
        hit.setIp("127.0.0.1");
        book.addHit(hit);

        return book;
    }

    @Test
    void save_bookWithoutName_error() {
    }


}