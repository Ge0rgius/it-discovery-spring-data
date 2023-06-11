package it.discovery.persistence.repository;

import it.discovery.persistence.model.*;
import it.discovery.persistence.model.tuple.BookInfo;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.data.domain.Window;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.NONE)
@Transactional
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
    void findAll_booksExist_success() {
        Book book = createBook();
        bookRepository.save(book);

        List<Book> books = bookRepository.findAll();
        assertEquals(1, books.size());
    }

    @Test
    void findBy_booksExist_success() {
        Book book = createBook();
        bookRepository.save(book);

        List<BookInfo> books = bookRepository.findBy();
        assertEquals(1, books.size());
        assertEquals("Spring Data JPA 3", books.get(0).name());
        assertEquals(1, books.get(0).id());
    }

    @Test
    void findWithHits_booksExist_success() {
        for (int i = 1; i <= 100; i++) {
            Book book = createBook("Spring Data JPA. Book #" + i);
            bookRepository.save(book);
        }

        Window<Book> books = bookRepository.findBy(PageRequest.of(5, 20,
                Sort.by("created")).toScrollPosition());
        while (!books.isEmpty() && books.hasNext()) {
            books = bookRepository.findBy(books.positionAt(books.size() - 1));
        }
        //assertEquals(100, books.getTotalElements());
        //assertEquals(20, books.getContent().size());
        //assertEquals(5, books.getTotalPages());
        //assertEquals(1, books.getContent().get(0).getHits().size());
        //assertEquals("Spring Data JPA. Book #21", books.getContent().get(0).getName());
    }

    @ParameterizedTest
    @ValueSource(strings = {"R", "Relational", "RELATIONAL", "Relational Databases"})
    void findByNameLikeIgnoreCase_booksExist_success(String name) {
        Book book = createBook("Relational Databases");
        bookRepository.save(book);

        List<Book> books = bookRepository.findByNameLikeIgnoreCase("%" + name + "%");
        assertEquals(1, books.size());
        assertTrue(books.get(0).getName().toUpperCase().contains(name.toUpperCase()));
    }

    @Test
    void findTotalPage_bookExists_success() {
        Book book = createBook();
        bookRepository.save(book);

        int total = bookRepository.findTotalPages();
        assertEquals(100, total);
    }

    private Book createBook() {
        return createBook("Spring Data JPA 3");
    }

    private Book createBook(String bookName) {
        Book book = new Book();
        book.setName(bookName);
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