package it.discovery.persistence.repository;

import it.discovery.persistence.model.*;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

class BookRepositoryTest {

    @Autowired
    BookRepository bookRepository;

    @Test
    void save_bookWithPublisher_success() {
    }

    @Test
    void findAll_bookExists_success() {
    }

    @Test
    void findTotalPage_bookExists_success() {
    }

    private Book createBook() {
        Book book = new Book();
        book.setName("Hibernate with JPA 3");
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